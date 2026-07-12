package W0;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class b {
    public a a() {
        if (d()) {
            return (a) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public e b() {
        if (f()) {
            return (e) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public h c() {
        if (g()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean d() {
        return this instanceof a;
    }

    public boolean e() {
        return this instanceof d;
    }

    public boolean f() {
        return this instanceof e;
    }

    public boolean g() {
        return this instanceof h;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            Z0.c cVar = new Z0.c(stringWriter);
            cVar.b0(true);
            X0.d.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}
