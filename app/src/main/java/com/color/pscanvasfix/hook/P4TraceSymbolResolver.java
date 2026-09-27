package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.DexClassScanner.DexField;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Source;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Fail-closed resolver for the debug-only P4 append/bind/WM trace chain.
 *
 * <p>This is intentionally separate from the legacy {@code CANVAS_CONTROLLER}
 * proxy role. It starts from stable ContainerView/EmbeddedViewDecor contracts,
 * derives the per-build TaskData, adapter, and controller descriptors, then
 * accepts obfuscated method names only through {@link KnownSymbolHints}. No
 * result from this resolver enables four-window behavior by itself.</p>
 */
final class P4TraceSymbolResolver {
    private static final String CONTAINER_VIEW =
            "com.oplus.pscanvas.canvasmode.canvas.view.ContainerView";
    private static final String EMBEDDED_VIEW_DECOR =
            "com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor";
    private static final String TASK_CREATED_CALLBACK =
            EMBEDDED_VIEW_DECOR + "$FlexibleTaskViewCallback";
    private static final String FLEXIBLE_TASK_VIEW =
            "com.oplus.flexiblewindow.FlexibleTaskView";

    private P4TraceSymbolResolver() {
    }

    static void resolveInto(PsCanvasSymbols out, List<DexClass> dexClasses) {
        RoleSymbol symbol = out.role(Role.P4_TRACE_CHAIN);
        Map<String, DexClass> classes = index(dexClasses);
        DexClass container = classes.get(CONTAINER_VIEW);
        DexClass decor = classes.get(EMBEDDED_VIEW_DECOR);
        DexClass flexible = classes.get(FLEXIBLE_TASK_VIEW);
        DexClass callback = classes.get(TASK_CREATED_CALLBACK);
        if (container == null || decor == null || flexible == null || callback == null) {
            skip(symbol);
            return;
        }

        DexMethod taskDataGetter = uniqueMethod(decor,
                method -> "getTaskData".equals(method.name)
                        && method.paramDescriptors.isEmpty()
                        && isObjectDescriptor(method.returnDescriptor));
        DexMethod adapterGetter = uniqueMethod(container,
                method -> "getAdapter".equals(method.name)
                        && method.paramDescriptors.isEmpty()
                        && isObjectDescriptor(method.returnDescriptor)
                        && !method.returnDescriptor.startsWith("Landroid/widget/"));
        DexMethod controllerGetter = uniqueMethod(container,
                method -> "getContainerController".equals(method.name)
                        && method.paramDescriptors.isEmpty()
                        && isObjectDescriptor(method.returnDescriptor));
        DexMethod childListGetter = uniqueMethod(container,
                method -> "getChildEmbeddedViewList".equals(method.name)
                        && method.paramDescriptors.isEmpty()
                        && MethodMatcher.DESC_LIST.equals(method.returnDescriptor));
        if (taskDataGetter == null || adapterGetter == null || controllerGetter == null
                || childListGetter == null) {
            ambiguous(symbol, null, 0, "stable-getter-contract");
            return;
        }

        String taskDataDescriptor = taskDataGetter.returnDescriptor;
        String adapterDescriptor = adapterGetter.returnDescriptor;
        String controllerDescriptor = controllerGetter.returnDescriptor;
        DexClass adapter = classes.get(binaryName(adapterDescriptor));
        DexClass controller = classes.get(binaryName(controllerDescriptor));
        DexClass taskData = classes.get(binaryName(taskDataDescriptor));
        if (adapter == null || controller == null || taskData == null) {
            ambiguous(symbol, binaryName(controllerDescriptor), 10,
                    "derived-class-contract");
            return;
        }

        DexField controllerContainerField = uniqueField(controller,
                MethodMatcher.DESC_CONTAINER_VIEW);
        DexField controllerAdapterField = uniqueField(controller, adapterDescriptor);
        DexField decorTaskDataField = uniqueField(decor, taskDataDescriptor);
        DexField decorTaskViewField = uniqueField(decor,
                MethodMatcher.DESC_FLEXIBLE_TASK_VIEW);
        DexField decorListenerField = uniqueField(decor,
                MethodMatcher.DESC_FLEXIBLE_TASK_VIEW_LISTENER);

        DexMethod controllerAppend = uniqueHinted(controller,
                KnownSymbolHints.p4ControllerAppendMethods(),
                method -> MethodMatcher.isTaskDataVoid(method, taskDataDescriptor));
        DexMethod controllerRemove = uniqueHinted(controller,
                KnownSymbolHints.p4ControllerRemoveMethods(),
                method -> MethodMatcher.isTaskDataVoid(method, taskDataDescriptor));
        DexMethod controllerFocus = uniqueHinted(controller,
                KnownSymbolHints.p4ControllerFocusMethods(),
                method -> MethodMatcher.isTaskDataVoid(method, taskDataDescriptor));
        DexMethod controllerCount = uniqueHinted(controller,
                KnownSymbolHints.p4ControllerCountMethods(), MethodMatcher::isNoArgInt);
        DexMethod adapterAdd = uniqueHinted(adapter,
                KnownSymbolHints.p4AdapterAddMethods(),
                method -> MethodMatcher.isTaskDataVoid(method, taskDataDescriptor));
        DexMethod adapterRemove = uniqueHinted(adapter,
                KnownSymbolHints.p4AdapterDirectRemoveMethods(),
                method -> MethodMatcher.isTaskDataVoid(method, taskDataDescriptor));
        DexMethod adapterCount = uniqueMethod(adapter,
                method -> "getCount".equals(method.name)
                        && MethodMatcher.isNoArgInt(method));
        DexMethod adapterItem = uniqueMethod(adapter,
                method -> "getItem".equals(method.name)
                        && MethodMatcher.isTaskDataAtIndex(method, taskDataDescriptor));
        DexMethod taskDataIntent = uniqueMethod(taskData, MethodMatcher::isNoArgIntent);
        DexMethod taskDataComponent = uniqueMethod(taskData,
                MethodMatcher::isNoArgComponentName);
        DexMethod taskDataTaskId = taskDataComponent == null
                ? uniqueHinted(taskData, Arrays.asList("q"), MethodMatcher::isNoArgInt)
                : firstUniqueHinted(taskData, Arrays.asList("t", "s"),
                        MethodMatcher::isNoArgInt);
        DexMethod embeddedBind = uniqueMethod(decor,
                method -> MethodMatcher.isEmbeddedTaskBind(method, taskDataDescriptor));
        DexMethod embeddedAttached = uniqueMethod(decor,
                MethodMatcher::isOnAttachedToWindow);
        DexMethod taskCreated = uniqueMethod(callback, MethodMatcher::isOnTaskCreated);
        DexMethod flexibleResize = uniqueMethod(flexible,
                MethodMatcher::isFlexibleTaskResize);
        DexMethod flexibleRelease = uniqueMethod(flexible,
                MethodMatcher::isFlexibleTaskRelease);
        DexMethod flexibleTaskId = uniqueMethod(flexible,
                MethodMatcher::isFlexibleTaskId);

        boolean distinctControllerMethods = controllerAppend != null
                && controllerRemove != null
                && controllerFocus != null
                && !controllerAppend.name.equals(controllerRemove.name)
                && !controllerAppend.name.equals(controllerFocus.name)
                && !controllerRemove.name.equals(controllerFocus.name);
        boolean complete = controllerContainerField != null
                && controllerAdapterField != null
                && decorTaskDataField != null
                && decorTaskViewField != null
                && decorListenerField != null
                && distinctControllerMethods
                && controllerCount != null
                && adapterAdd != null
                && adapterRemove != null
                && adapterCount != null
                && adapterItem != null
                && taskDataIntent != null
                && taskDataTaskId != null
                && embeddedBind != null
                && embeddedAttached != null
                && taskCreated != null
                && flexibleResize != null;
        List<String> contract = new ArrayList<>(Arrays.asList(
                "controller=" + controller.name,
                "adapter=" + adapter.name,
                "taskData=" + taskDataDescriptor,
                "adapterItem=" + methodName(adapterItem),
                "taskDataIntent=" + methodName(taskDataIntent),
                "taskDataTaskId=" + methodName(taskDataTaskId),
                "flexibleRelease=" + methodName(flexibleRelease)));
        symbol.addCandidate(controller.name, complete ? 100 : 50, contract);
        if (!complete) {
            ambiguous(symbol, controller.name, 50, "incomplete-or-ambiguous-contract");
            return;
        }

        symbol.className = controller.name;
        symbol.score = 100;
        symbol.status = Status.FALLBACK;
        symbol.source = Source.KNOWN_SYMBOL;
        symbol.p4TaskDataDescriptor = taskDataDescriptor;
        symbol.p4AdapterClass = adapter.name;
        symbol.p4EmbeddedViewDecorClass = decor.name;
        symbol.p4TaskCreatedCallbackClass = callback.name;
        symbol.p4FlexibleTaskViewClass = flexible.name;
        symbol.p4ControllerAppendMethod = controllerAppend.name;
        symbol.p4ControllerRemoveMethod = controllerRemove.name;
        symbol.p4ControllerFocusMethod = controllerFocus.name;
        symbol.p4ControllerTaskCountMethod = controllerCount.name;
        symbol.p4ControllerContainerField = controllerContainerField.name;
        symbol.p4ControllerAdapterField = controllerAdapterField.name;
        symbol.p4ContainerAdapterGetter = adapterGetter.name;
        symbol.p4ContainerControllerGetter = controllerGetter.name;
        symbol.p4ContainerChildrenGetter = childListGetter.name;
        symbol.p4AdapterAddMethod = adapterAdd.name;
        symbol.p4AdapterRemoveMethod = adapterRemove.name;
        symbol.p4AdapterCountMethod = adapterCount.name;
        symbol.p4AdapterItemMethod = adapterItem.name;
        symbol.p4TaskDataTaskIdMethod = taskDataTaskId.name;
        symbol.p4TaskDataIntentMethod = taskDataIntent.name;
        symbol.p4EmbeddedBindMethod = embeddedBind.name;
        symbol.p4EmbeddedAttachedMethod = embeddedAttached.name;
        symbol.p4DecorTaskDataField = decorTaskDataField.name;
        symbol.p4TaskCreatedMethod = taskCreated.name;
        symbol.p4FlexibleResizeMethod = flexibleResize.name;
        symbol.p4FlexibleReleaseMethod = flexibleRelease == null
                ? null : flexibleRelease.name;
        symbol.p4FlexibleTaskIdMethod = flexibleTaskId == null
                ? null : flexibleTaskId.name;
    }

    private static Map<String, DexClass> index(List<DexClass> classes) {
        Map<String, DexClass> out = new LinkedHashMap<>();
        for (DexClass cls : classes) {
            out.put(cls.name, cls);
        }
        return out;
    }

    private static DexMethod uniqueMethod(DexClass cls, Predicate<DexMethod> match) {
        DexMethod result = null;
        for (DexMethod method : cls.methods) {
            if (!match.test(method)) {
                continue;
            }
            if (result != null) {
                return null;
            }
            result = method;
        }
        return result;
    }

    private static DexMethod uniqueHinted(DexClass cls, List<String> hints,
                                          Predicate<DexMethod> signature) {
        return uniqueMethod(cls,
                method -> hints.contains(method.name) && signature.test(method));
    }

    private static DexMethod firstUniqueHinted(DexClass cls, List<String> hints,
                                                Predicate<DexMethod> signature) {
        for (String hint : hints) {
            DexMethod result = uniqueMethod(cls,
                    method -> hint.equals(method.name) && signature.test(method));
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private static DexField uniqueField(DexClass cls, String descriptor) {
        DexField result = null;
        for (DexField field : cls.fields) {
            if (!descriptor.equals(field.typeDescriptor)) {
                continue;
            }
            if (result != null) {
                return null;
            }
            result = field;
        }
        return result;
    }

    private static boolean isObjectDescriptor(String descriptor) {
        return descriptor != null && descriptor.startsWith("L")
                && descriptor.endsWith(";");
    }

    private static String methodName(DexMethod method) {
        return method == null ? "missing" : method.name;
    }

    private static String binaryName(String descriptor) {
        if (!isObjectDescriptor(descriptor)) {
            return null;
        }
        return descriptor.substring(1, descriptor.length() - 1).replace('/', '.');
    }

    private static void skip(RoleSymbol symbol) {
        symbol.status = Status.SKIPPED;
        symbol.source = Source.NONE;
    }

    private static void ambiguous(RoleSymbol symbol, String className, int score,
                                  String reason) {
        symbol.className = className;
        symbol.score = score;
        symbol.status = Status.AMBIGUOUS;
        symbol.source = Source.KNOWN_SYMBOL;
        if (className != null && symbol.candidates.isEmpty()) {
            symbol.addCandidate(className, score, Arrays.asList(reason));
        }
    }
}
