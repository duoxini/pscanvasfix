package com.color.pscanvasfix.runtime;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public final class JavaReflectionBackendTest {
    private final JavaReflectionBackend backend = new JavaReflectionBackend();

    @Test
    public void resolvesHierarchyOverloadsBoxingNullsAndInterfaceMethods() {
        ChildFixture target = new ChildFixture();

        assertEquals("integer", backend.callMethod(target, "select", Integer.valueOf(7)));
        assertEquals("number", backend.callMethod(target, "select", Short.valueOf((short) 2)));
        assertEquals("string", backend.callMethod(target, "nullable", (Object) null));
        assertEquals("default:value", backend.callMethod(target, "defaultMethod", "value"));
        assertEquals("long:3", backend.callMethod(target, "widen", Integer.valueOf(3)));
        assertEquals("static:text",
                backend.callStaticMethod(ChildFixture.class, "staticCall", "text"));
    }

    @Test
    public void resolvesPrivateConstructorsAndInheritedFields() {
        ConstructorFixture created = (ConstructorFixture) backend.newInstance(
                ConstructorFixture.class, Integer.valueOf(4));
        assertEquals("integer:4", created.description);

        ChildFixture target = new ChildFixture();
        assertTrue(backend.getBooleanField(target, "enabled"));
        backend.setBooleanField(target, "enabled", false);
        assertFalse(backend.getBooleanField(target, "enabled"));

        assertEquals(7, backend.getIntField(target, "count"));
        backend.setIntField(target, "count", 11);
        assertEquals(11, backend.getIntField(target, "count"));
        assertEquals(1.5f, backend.getFloatField(target, "ratio"), 0f);

        Object value = new Object();
        backend.setObjectField(target, "value", value);
        assertSame(value, backend.getObjectField(target, "value"));

        backend.setStaticBooleanField(ChildFixture.class, "globalEnabled", false);
        assertFalse(backend.getStaticBooleanField(ChildFixture.class, "globalEnabled"));
        backend.setStaticBooleanField(ChildFixture.class, "globalEnabled", true);
    }

    @Test
    public void loadsOrdinaryPrimitiveAndCanonicalArrayClassesWithoutInitialization() {
        ClassLoader loader = getClass().getClassLoader();

        assertSame(String.class, backend.findClass("java.lang.String", loader));
        assertSame(int.class, backend.findClass("int", loader));
        assertSame(String[][].class, backend.findClass("java.lang.String[][]", loader));
        assertSame(int[].class, backend.findClass("int[]", loader));
    }

    @Test
    public void propagatesInvocationRootCauseAndLookupFailures() {
        CheckedFailure expected = new CheckedFailure("root");
        ThrowingFixture target = new ThrowingFixture(expected);

        CheckedFailure actual = assertThrows(
                CheckedFailure.class, () -> backend.callMethod(target, "fail"));
        assertSame(expected, actual);

        assertThrows(NoSuchMethodException.class,
                () -> backend.callMethod(target, "missing"));
        assertThrows(NoSuchFieldException.class,
                () -> backend.getObjectField(target, "missing"));
        assertThrows(ClassNotFoundException.class,
                () -> backend.findClass("missing.Type", getClass().getClassLoader()));
    }

    @Test
    public void rejectsStaticInstanceModeMismatch() {
        ChildFixture target = new ChildFixture();

        assertThrows(NoSuchMethodException.class,
                () -> backend.callMethod(target, "staticCall", "value"));
        assertThrows(NoSuchMethodException.class,
                () -> backend.callStaticMethod(ChildFixture.class, "select", Integer.valueOf(1)));
        assertThrows(NoSuchFieldException.class,
                () -> backend.getBooleanField(target, "globalEnabled"));
        assertThrows(NoSuchFieldException.class,
                () -> backend.getStaticBooleanField(ChildFixture.class, "enabled"));
    }

    private interface DefaultFixture {
        default String defaultMethod(String value) {
            return "default:" + value;
        }
    }

    private static class ParentFixture {
        private boolean enabled = true;
        private int count = 7;
        private float ratio = 1.5f;
        private Object value;
        private static boolean globalEnabled = true;

        private String select(Number ignored) {
            return "number";
        }

        private String select(Object ignored) {
            return "object";
        }

        private String nullable(CharSequence ignored) {
            return "chars";
        }

        private String nullable(String ignored) {
            return "string";
        }

        private String widen(long value) {
            return "long:" + value;
        }

        private static String staticCall(CharSequence value) {
            return "static:" + value;
        }
    }

    private static final class ChildFixture extends ParentFixture implements DefaultFixture {
        private String select(Integer ignored) {
            return "integer";
        }
    }

    private static final class ConstructorFixture {
        final String description;

        private ConstructorFixture(Number value) {
            description = "number:" + value;
        }

        private ConstructorFixture(Integer value) {
            description = "integer:" + value;
        }
    }

    private static final class ThrowingFixture {
        private final CheckedFailure failure;

        ThrowingFixture(CheckedFailure failure) {
            this.failure = failure;
        }

        private void fail() throws IOException {
            throw failure;
        }
    }

    private static final class CheckedFailure extends IOException {
        CheckedFailure(String message) {
            super(message);
        }
    }
}
