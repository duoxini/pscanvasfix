package H2;

import java.util.NoSuchElementException;
import q2.AbstractC0520C;

/* loaded from: classes.dex */
public final class b extends AbstractC0520C {

    /* renamed from: a, reason: collision with root package name */
    private final int f886a;

    /* renamed from: b, reason: collision with root package name */
    private final int f887b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f888c;

    /* renamed from: d, reason: collision with root package name */
    private int f889d;

    public b(int i3, int i4, int i5) {
        this.f886a = i5;
        this.f887b = i4;
        boolean z3 = false;
        if (i5 <= 0 ? i3 >= i4 : i3 <= i4) {
            z3 = true;
        }
        this.f888c = z3;
        this.f889d = z3 ? i3 : i4;
    }

    @Override // q2.AbstractC0520C
    public int a() {
        int i3 = this.f889d;
        if (i3 != this.f887b) {
            this.f889d = this.f886a + i3;
        } else {
            if (!this.f888c) {
                throw new NoSuchElementException();
            }
            this.f888c = false;
        }
        return i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f888c;
    }
}
