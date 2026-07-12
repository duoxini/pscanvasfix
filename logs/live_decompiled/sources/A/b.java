package A;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
abstract class b {

    public interface a {
        void a(Object obj, Rect rect);
    }

    /* renamed from: A.b$b, reason: collision with other inner class name */
    public interface InterfaceC0001b {
        int a(Object obj);

        Object b(Object obj, int i3);
    }

    private static class c implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f14a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        private final Rect f15b = new Rect();

        /* renamed from: c, reason: collision with root package name */
        private final boolean f16c;

        /* renamed from: d, reason: collision with root package name */
        private final a f17d;

        c(boolean z3, a aVar) {
            this.f16c = z3;
            this.f17d = aVar;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Rect rect = this.f14a;
            Rect rect2 = this.f15b;
            this.f17d.a(obj, rect);
            this.f17d.a(obj2, rect2);
            int i3 = rect.top;
            int i4 = rect2.top;
            if (i3 < i4) {
                return -1;
            }
            if (i3 > i4) {
                return 1;
            }
            int i5 = rect.left;
            int i6 = rect2.left;
            if (i5 < i6) {
                return this.f16c ? 1 : -1;
            }
            if (i5 > i6) {
                return this.f16c ? -1 : 1;
            }
            int i7 = rect.bottom;
            int i8 = rect2.bottom;
            if (i7 < i8) {
                return -1;
            }
            if (i7 > i8) {
                return 1;
            }
            int i9 = rect.right;
            int i10 = rect2.right;
            if (i9 < i10) {
                return this.f16c ? 1 : -1;
            }
            if (i9 > i10) {
                return this.f16c ? -1 : 1;
            }
            return 0;
        }
    }

    private static boolean a(int i3, Rect rect, Rect rect2, Rect rect3) {
        boolean b3 = b(i3, rect, rect2);
        if (b(i3, rect, rect3) || !b3) {
            return false;
        }
        return !j(i3, rect, rect3) || i3 == 17 || i3 == 66 || k(i3, rect, rect2) < m(i3, rect, rect3);
    }

    private static boolean b(int i3, Rect rect, Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static Object c(Object obj, InterfaceC0001b interfaceC0001b, a aVar, Object obj2, Rect rect, int i3) {
        Rect rect2 = new Rect(rect);
        if (i3 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i3 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i3 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int a3 = interfaceC0001b.a(obj);
        Rect rect3 = new Rect();
        Object obj3 = null;
        for (int i4 = 0; i4 < a3; i4++) {
            Object b3 = interfaceC0001b.b(obj, i4);
            if (b3 != obj2) {
                aVar.a(b3, rect3);
                if (h(i3, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    obj3 = b3;
                }
            }
        }
        return obj3;
    }

    public static Object d(Object obj, InterfaceC0001b interfaceC0001b, a aVar, Object obj2, int i3, boolean z3, boolean z4) {
        int a3 = interfaceC0001b.a(obj);
        ArrayList arrayList = new ArrayList(a3);
        for (int i4 = 0; i4 < a3; i4++) {
            arrayList.add(interfaceC0001b.b(obj, i4));
        }
        Collections.sort(arrayList, new c(z3, aVar));
        if (i3 == 1) {
            return f(obj2, arrayList, z4);
        }
        if (i3 == 2) {
            return e(obj2, arrayList, z4);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static Object e(Object obj, ArrayList arrayList, boolean z3) {
        int size = arrayList.size();
        int lastIndexOf = (obj == null ? -1 : arrayList.lastIndexOf(obj)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (!z3 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static Object f(Object obj, ArrayList arrayList, boolean z3) {
        int size = arrayList.size();
        int indexOf = (obj == null ? size : arrayList.indexOf(obj)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (!z3 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int g(int i3, int i4) {
        return (i3 * 13 * i3) + (i4 * i4);
    }

    private static boolean h(int i3, Rect rect, Rect rect2, Rect rect3) {
        if (!i(rect, rect2, i3)) {
            return false;
        }
        if (i(rect, rect3, i3) && !a(i3, rect, rect2, rect3)) {
            return !a(i3, rect, rect3, rect2) && g(k(i3, rect, rect2), o(i3, rect, rect2)) < g(k(i3, rect, rect3), o(i3, rect, rect3));
        }
        return true;
    }

    private static boolean i(Rect rect, Rect rect2, int i3) {
        if (i3 == 17) {
            int i4 = rect.right;
            int i5 = rect2.right;
            return (i4 > i5 || rect.left >= i5) && rect.left > rect2.left;
        }
        if (i3 == 33) {
            int i6 = rect.bottom;
            int i7 = rect2.bottom;
            return (i6 > i7 || rect.top >= i7) && rect.top > rect2.top;
        }
        if (i3 == 66) {
            int i8 = rect.left;
            int i9 = rect2.left;
            return (i8 < i9 || rect.right <= i9) && rect.right < rect2.right;
        }
        if (i3 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i10 = rect.top;
        int i11 = rect2.top;
        return (i10 < i11 || rect.bottom <= i11) && rect.bottom < rect2.bottom;
    }

    private static boolean j(int i3, Rect rect, Rect rect2) {
        if (i3 == 17) {
            return rect.left >= rect2.right;
        }
        if (i3 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i3 == 66) {
            return rect.right <= rect2.left;
        }
        if (i3 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int k(int i3, Rect rect, Rect rect2) {
        return Math.max(0, l(i3, rect, rect2));
    }

    private static int l(int i3, Rect rect, Rect rect2) {
        int i4;
        int i5;
        if (i3 == 17) {
            i4 = rect.left;
            i5 = rect2.right;
        } else if (i3 == 33) {
            i4 = rect.top;
            i5 = rect2.bottom;
        } else if (i3 == 66) {
            i4 = rect2.left;
            i5 = rect.right;
        } else {
            if (i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i4 = rect2.top;
            i5 = rect.bottom;
        }
        return i4 - i5;
    }

    private static int m(int i3, Rect rect, Rect rect2) {
        return Math.max(1, n(i3, rect, rect2));
    }

    private static int n(int i3, Rect rect, Rect rect2) {
        int i4;
        int i5;
        if (i3 == 17) {
            i4 = rect.left;
            i5 = rect2.left;
        } else if (i3 == 33) {
            i4 = rect.top;
            i5 = rect2.top;
        } else if (i3 == 66) {
            i4 = rect2.right;
            i5 = rect.right;
        } else {
            if (i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i4 = rect2.bottom;
            i5 = rect.bottom;
        }
        return i4 - i5;
    }

    private static int o(int i3, Rect rect, Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
