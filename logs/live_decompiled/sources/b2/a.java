package B2;

import D2.d;
import D2.k;
import D2.s;
import I2.b;

/* loaded from: classes.dex */
public abstract class a {
    public static final Class a(b bVar) {
        k.e(bVar, "<this>");
        Class c3 = ((d) bVar).c();
        k.c(c3, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return c3;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class b(b bVar) {
        k.e(bVar, "<this>");
        Class c3 = ((d) bVar).c();
        if (!c3.isPrimitive()) {
            k.c(c3, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return c3;
        }
        String name = c3.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    c3 = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    c3 = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    c3 = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    c3 = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    c3 = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    c3 = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    c3 = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    c3 = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    c3 = Short.class;
                    break;
                }
                break;
        }
        k.c(c3, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return c3;
    }

    public static final b c(Class cls) {
        k.e(cls, "<this>");
        return s.b(cls);
    }
}
