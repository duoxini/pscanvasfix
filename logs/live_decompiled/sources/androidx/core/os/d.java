package androidx.core.os;

import D2.k;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import p2.C0510j;

/* loaded from: classes.dex */
public abstract class d {
    public static final Bundle a(C0510j... c0510jArr) {
        k.e(c0510jArr, "pairs");
        Bundle bundle = new Bundle(c0510jArr.length);
        for (C0510j c0510j : c0510jArr) {
            String str = (String) c0510j.a();
            Object b3 = c0510j.b();
            if (b3 == null) {
                bundle.putString(str, null);
            } else if (b3 instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) b3).booleanValue());
            } else if (b3 instanceof Byte) {
                bundle.putByte(str, ((Number) b3).byteValue());
            } else if (b3 instanceof Character) {
                bundle.putChar(str, ((Character) b3).charValue());
            } else if (b3 instanceof Double) {
                bundle.putDouble(str, ((Number) b3).doubleValue());
            } else if (b3 instanceof Float) {
                bundle.putFloat(str, ((Number) b3).floatValue());
            } else if (b3 instanceof Integer) {
                bundle.putInt(str, ((Number) b3).intValue());
            } else if (b3 instanceof Long) {
                bundle.putLong(str, ((Number) b3).longValue());
            } else if (b3 instanceof Short) {
                bundle.putShort(str, ((Number) b3).shortValue());
            } else if (b3 instanceof Bundle) {
                bundle.putBundle(str, (Bundle) b3);
            } else if (b3 instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) b3);
            } else if (b3 instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) b3);
            } else if (b3 instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) b3);
            } else if (b3 instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) b3);
            } else if (b3 instanceof char[]) {
                bundle.putCharArray(str, (char[]) b3);
            } else if (b3 instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) b3);
            } else if (b3 instanceof float[]) {
                bundle.putFloatArray(str, (float[]) b3);
            } else if (b3 instanceof int[]) {
                bundle.putIntArray(str, (int[]) b3);
            } else if (b3 instanceof long[]) {
                bundle.putLongArray(str, (long[]) b3);
            } else if (b3 instanceof short[]) {
                bundle.putShortArray(str, (short[]) b3);
            } else if (b3 instanceof Object[]) {
                Class<?> componentType = b3.getClass().getComponentType();
                k.b(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    k.c(b3, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(str, (Parcelable[]) b3);
                } else if (String.class.isAssignableFrom(componentType)) {
                    k.c(b3, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(str, (String[]) b3);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    k.c(b3, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(str, (CharSequence[]) b3);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                    }
                    bundle.putSerializable(str, (Serializable) b3);
                }
            } else if (b3 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) b3);
            } else if (b3 instanceof IBinder) {
                b.a(bundle, str, (IBinder) b3);
            } else if (b3 instanceof Size) {
                c.a(bundle, str, (Size) b3);
            } else {
                if (!(b3 instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + b3.getClass().getCanonicalName() + " for key \"" + str + '\"');
                }
                c.b(bundle, str, (SizeF) b3);
            }
        }
        return bundle;
    }
}
