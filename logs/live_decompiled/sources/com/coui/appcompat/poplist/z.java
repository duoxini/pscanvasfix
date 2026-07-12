package com.coui.appcompat.poplist;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import h0.AbstractC0371a;

/* loaded from: classes.dex */
final class z implements y0.f {

    /* renamed from: a, reason: collision with root package name */
    private final y0.f f8464a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final y0.f f8465b = new b();

    /* renamed from: c, reason: collision with root package name */
    private StringBuilder f8466c;

    class a implements y0.f {
        a() {
        }

        @Override // y0.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public y0.f a(u uVar, v vVar) {
            uVar.a(vVar);
            return this;
        }
    }

    class b implements y0.f {
        b() {
        }

        @Override // y0.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public y0.f a(t tVar, v vVar) {
            if (!tVar.getPopupMenuRuleEnabled()) {
                AbstractC0371a.d("PopupMenuRuleExecutor", "Skip disabled rule " + tVar);
                return this;
            }
            z.this.k(tVar, vVar);
            int type = tVar.getType();
            if (type == 0) {
                vVar.f8378a.set(tVar.getDisplayFrame());
            } else if (type == 1) {
                vVar.f8379b.set(tVar.getDisplayFrame());
                vVar.f8385h.set(tVar.getOutsets());
            } else if (type == 2) {
                Rect i3 = z.this.i(tVar.getDisplayFrame(), tVar.getOutsets());
                z.this.g(i3);
                int barrierDirection = tVar.getBarrierDirection();
                if (barrierDirection == 0) {
                    Rect rect = vVar.f8386i;
                    rect.left = Math.max(rect.left, i3.right - vVar.f8378a.left);
                } else if (barrierDirection == 1) {
                    Rect rect2 = vVar.f8386i;
                    rect2.top = Math.max(rect2.top, i3.bottom - vVar.f8378a.top);
                } else if (barrierDirection == 2) {
                    Rect rect3 = vVar.f8386i;
                    rect3.right = Math.max(rect3.right, vVar.f8378a.right - i3.left);
                } else if (barrierDirection == 3) {
                    Rect rect4 = vVar.f8386i;
                    rect4.bottom = Math.max(rect4.bottom, vVar.f8378a.bottom - i3.top);
                } else if (barrierDirection == 4) {
                    Rect rect5 = vVar.f8386i;
                    rect5.left = Math.max(rect5.left, i3.left - vVar.f8378a.left);
                    Rect rect6 = vVar.f8386i;
                    rect6.top = Math.max(rect6.top, i3.top - vVar.f8378a.top);
                    Rect rect7 = vVar.f8386i;
                    rect7.right = Math.max(rect7.right, vVar.f8378a.right - i3.right);
                    Rect rect8 = vVar.f8386i;
                    rect8.bottom = Math.max(rect8.bottom, vVar.f8378a.bottom - i3.bottom);
                }
            } else if (type == 3) {
                vVar.f8384g.set(tVar.getDisplayFrame());
            }
            return this;
        }
    }

    z() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect.left < 0) {
            Log.e("PopupMenuRuleExecutor", "barrier left < 0 !!");
            rect.left = 0;
        }
        if (rect.top < 0) {
            Log.e("PopupMenuRuleExecutor", "barrier top < 0 !!");
            rect.top = 0;
        }
        if (rect.right < 0) {
            Log.e("PopupMenuRuleExecutor", "barrier right < 0 !!");
            rect.right = 0;
        }
        if (rect.bottom < 0) {
            Log.e("PopupMenuRuleExecutor", "barrier bottom < 0 !!");
            rect.bottom = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect i(Rect rect, Rect rect2) {
        return new Rect(rect.left - rect2.left, rect.top - rect2.top, rect.right + rect2.right, rect.bottom + rect2.bottom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j(t tVar, v vVar) {
        Rect i3 = i(tVar.getDisplayFrame(), tVar.getOutsets());
        int barrierDirection = tVar.getBarrierDirection();
        if (barrierDirection == -1) {
            this.f8466c.append("#BARRIER_GONE:");
        } else if (barrierDirection == 0) {
            this.f8466c.append("#BARRIER_FROM_LEFT:");
        } else if (barrierDirection == 1) {
            this.f8466c.append("#BARRIER_FROM_TOP:");
        } else if (barrierDirection == 2) {
            this.f8466c.append("#BARRIER_FROM_RIGHT:");
        } else if (barrierDirection == 3) {
            this.f8466c.append("#BARRIER_FROM_BOTTOM:");
        } else if (barrierDirection == 4) {
            this.f8466c.append("#BARRIER_WINDOW:");
        }
        this.f8466c.append("old domain window barrier:");
        this.f8466c.append(vVar.f8386i);
        this.f8466c.append(" barrier:");
        this.f8466c.append(i3);
        this.f8466c.append(" domain window:");
        this.f8466c.append(vVar.f8378a);
        this.f8466c.append(" rule: ");
        this.f8466c.append(tVar);
        if (tVar instanceof View) {
            this.f8466c.append(" parent: ");
            this.f8466c.append(((View) tVar).getParent());
        }
        this.f8466c.append("\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void k(t tVar, v vVar) {
        if (this.f8466c == null) {
            this.f8466c = new StringBuilder();
        }
        int type = tVar.getType();
        if (type == 0) {
            this.f8466c.append("#TYPE_WINDOW: display frame: ");
            this.f8466c.append(tVar.getDisplayFrame());
            this.f8466c.append(" rule: ");
            this.f8466c.append(tVar);
            if (tVar instanceof View) {
                this.f8466c.append(" parent: ");
                this.f8466c.append(((View) tVar).getParent());
            }
            this.f8466c.append("\n");
            return;
        }
        if (type == 1) {
            this.f8466c.append("#TYPE_ANCHOR: display frame: ");
            this.f8466c.append(tVar.getDisplayFrame());
            this.f8466c.append(" outsets: ");
            this.f8466c.append(tVar.getOutsets());
            this.f8466c.append(" rule: ");
            this.f8466c.append(tVar);
            if (tVar instanceof View) {
                this.f8466c.append(" parent: ");
                this.f8466c.append(((View) tVar).getParent());
            }
            this.f8466c.append("\n");
            return;
        }
        if (type == 2) {
            j(tVar, vVar);
            return;
        }
        if (type != 3) {
            return;
        }
        this.f8466c.append("#TYPE_SUBMENU_ANCHOR: display frame: ");
        this.f8466c.append(tVar.getDisplayFrame());
        this.f8466c.append(" rule: ");
        this.f8466c.append(tVar);
        if (tVar instanceof View) {
            this.f8466c.append(" parent: ");
            this.f8466c.append(((View) tVar).getParent());
        }
        this.f8466c.append("\n");
    }

    void e() {
        this.f8466c = new StringBuilder();
    }

    void f() {
        StringBuilder sb = this.f8466c;
        if (sb != null) {
            AbstractC0371a.d("PopupMenuRuleExecutor", sb.toString());
        } else {
            AbstractC0371a.c("PopupMenuRuleExecutor", "No config rules record! Not initialized!");
        }
    }

    @Override // y0.f
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public y0.f a(y yVar, v vVar) {
        if (yVar instanceof u) {
            this.f8464a.a((u) yVar, vVar);
        } else if (yVar instanceof t) {
            this.f8465b.a((t) yVar, vVar);
        }
        return this;
    }
}
