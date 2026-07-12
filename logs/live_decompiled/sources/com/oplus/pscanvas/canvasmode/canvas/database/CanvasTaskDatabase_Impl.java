package com.oplus.pscanvas.canvasmode.canvas.database;

import J.f;
import J.o;
import J.u;
import J.w;
import L.b;
import L.d;
import N.g;
import N.h;
import androidx.appcompat.app.p;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w1.InterfaceC0624h;
import w1.i;

/* loaded from: classes.dex */
public final class CanvasTaskDatabase_Impl extends CanvasTaskDatabase {

    /* renamed from: r, reason: collision with root package name */
    private volatile InterfaceC0624h f10542r;

    class a extends w.b {
        a(int i3) {
            super(i3);
        }

        @Override // J.w.b
        public void a(g gVar) {
            gVar.w("CREATE TABLE IF NOT EXISTS `embedded_canvas` (`task_id` INTEGER NOT NULL, `canvas_user_id` INTEGER NOT NULL, `package_name1` TEXT, `class_name1` TEXT, `app_task_id1` INTEGER NOT NULL, `user_id1` INTEGER NOT NULL, `use_max1` INTEGER NOT NULL, `app_rect1` TEXT, `intent1` TEXT, `package_name2` TEXT, `class_name2` TEXT, `app_task_id2` INTEGER NOT NULL, `user_id2` INTEGER NOT NULL, `use_max2` INTEGER NOT NULL, `app_rect2` TEXT, `intent2` TEXT, `package_name3` TEXT, `class_name3` TEXT, `app_task_id3` INTEGER NOT NULL, `user_id3` INTEGER NOT NULL, `use_max3` INTEGER NOT NULL, `app_rect3` TEXT, `intent3` TEXT, `orientation` INTEGER NOT NULL, `focus` INTEGER NOT NULL, `layout_focus_side` INTEGER NOT NULL, `panorama` INTEGER NOT NULL, `landspace_layout` INTEGER NOT NULL, `portrait_layout` INTEGER NOT NULL, PRIMARY KEY(`task_id`))");
            gVar.w("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.w("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4dfa64d131670d9b87ffd9720bad2825')");
        }

        @Override // J.w.b
        public void b(g gVar) {
            gVar.w("DROP TABLE IF EXISTS `embedded_canvas`");
            if (((u) CanvasTaskDatabase_Impl.this).f1061h == null || ((u) CanvasTaskDatabase_Impl.this).f1061h.size() <= 0) {
                return;
            }
            p.a(((u) CanvasTaskDatabase_Impl.this).f1061h.get(0));
            throw null;
        }

        @Override // J.w.b
        public void c(g gVar) {
            if (((u) CanvasTaskDatabase_Impl.this).f1061h == null || ((u) CanvasTaskDatabase_Impl.this).f1061h.size() <= 0) {
                return;
            }
            p.a(((u) CanvasTaskDatabase_Impl.this).f1061h.get(0));
            throw null;
        }

        @Override // J.w.b
        public void d(g gVar) {
            ((u) CanvasTaskDatabase_Impl.this).f1054a = gVar;
            CanvasTaskDatabase_Impl.this.u(gVar);
            if (((u) CanvasTaskDatabase_Impl.this).f1061h == null || ((u) CanvasTaskDatabase_Impl.this).f1061h.size() <= 0) {
                return;
            }
            p.a(((u) CanvasTaskDatabase_Impl.this).f1061h.get(0));
            throw null;
        }

        @Override // J.w.b
        public void e(g gVar) {
        }

        @Override // J.w.b
        public void f(g gVar) {
            b.a(gVar);
        }

        @Override // J.w.b
        public w.c g(g gVar) {
            HashMap hashMap = new HashMap(29);
            hashMap.put("task_id", new d.a("task_id", "INTEGER", true, 1, null, 1));
            hashMap.put("canvas_user_id", new d.a("canvas_user_id", "INTEGER", true, 0, null, 1));
            hashMap.put("package_name1", new d.a("package_name1", "TEXT", false, 0, null, 1));
            hashMap.put("class_name1", new d.a("class_name1", "TEXT", false, 0, null, 1));
            hashMap.put("app_task_id1", new d.a("app_task_id1", "INTEGER", true, 0, null, 1));
            hashMap.put("user_id1", new d.a("user_id1", "INTEGER", true, 0, null, 1));
            hashMap.put("use_max1", new d.a("use_max1", "INTEGER", true, 0, null, 1));
            hashMap.put("app_rect1", new d.a("app_rect1", "TEXT", false, 0, null, 1));
            hashMap.put("intent1", new d.a("intent1", "TEXT", false, 0, null, 1));
            hashMap.put("package_name2", new d.a("package_name2", "TEXT", false, 0, null, 1));
            hashMap.put("class_name2", new d.a("class_name2", "TEXT", false, 0, null, 1));
            hashMap.put("app_task_id2", new d.a("app_task_id2", "INTEGER", true, 0, null, 1));
            hashMap.put("user_id2", new d.a("user_id2", "INTEGER", true, 0, null, 1));
            hashMap.put("use_max2", new d.a("use_max2", "INTEGER", true, 0, null, 1));
            hashMap.put("app_rect2", new d.a("app_rect2", "TEXT", false, 0, null, 1));
            hashMap.put("intent2", new d.a("intent2", "TEXT", false, 0, null, 1));
            hashMap.put("package_name3", new d.a("package_name3", "TEXT", false, 0, null, 1));
            hashMap.put("class_name3", new d.a("class_name3", "TEXT", false, 0, null, 1));
            hashMap.put("app_task_id3", new d.a("app_task_id3", "INTEGER", true, 0, null, 1));
            hashMap.put("user_id3", new d.a("user_id3", "INTEGER", true, 0, null, 1));
            hashMap.put("use_max3", new d.a("use_max3", "INTEGER", true, 0, null, 1));
            hashMap.put("app_rect3", new d.a("app_rect3", "TEXT", false, 0, null, 1));
            hashMap.put("intent3", new d.a("intent3", "TEXT", false, 0, null, 1));
            hashMap.put("orientation", new d.a("orientation", "INTEGER", true, 0, null, 1));
            hashMap.put("focus", new d.a("focus", "INTEGER", true, 0, null, 1));
            hashMap.put("layout_focus_side", new d.a("layout_focus_side", "INTEGER", true, 0, null, 1));
            hashMap.put("panorama", new d.a("panorama", "INTEGER", true, 0, null, 1));
            hashMap.put("landspace_layout", new d.a("landspace_layout", "INTEGER", true, 0, null, 1));
            hashMap.put("portrait_layout", new d.a("portrait_layout", "INTEGER", true, 0, null, 1));
            d dVar = new d("embedded_canvas", hashMap, new HashSet(0), new HashSet(0));
            d a3 = d.a(gVar, "embedded_canvas");
            if (dVar.equals(a3)) {
                return new w.c(true, null);
            }
            return new w.c(false, "embedded_canvas(com.oplus.pscanvas.canvasmode.canvas.database.EmbeddedCanvas).\n Expected:\n" + dVar + "\n Found:\n" + a3);
        }
    }

    @Override // com.oplus.pscanvas.canvasmode.canvas.database.CanvasTaskDatabase
    public InterfaceC0624h B() {
        InterfaceC0624h interfaceC0624h;
        if (this.f10542r != null) {
            return this.f10542r;
        }
        synchronized (this) {
            try {
                if (this.f10542r == null) {
                    this.f10542r = new i(this);
                }
                interfaceC0624h = this.f10542r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0624h;
    }

    @Override // J.u
    protected o g() {
        return new o(this, new HashMap(0), new HashMap(0), "embedded_canvas");
    }

    @Override // J.u
    protected h h(f fVar) {
        return fVar.f979c.a(h.b.a(fVar.f977a).c(fVar.f978b).b(new w(fVar, new a(5), "4dfa64d131670d9b87ffd9720bad2825", "1bd049d47e88629c33cab1cf1aea75f4")).a());
    }

    @Override // J.u
    public List j(Map map) {
        return Arrays.asList(new K.a[0]);
    }

    @Override // J.u
    public Set o() {
        return new HashSet();
    }

    @Override // J.u
    protected Map p() {
        HashMap hashMap = new HashMap();
        hashMap.put(InterfaceC0624h.class, i.e());
        return hashMap;
    }
}
