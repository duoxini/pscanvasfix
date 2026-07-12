package u1;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import t1.h;

/* renamed from: u1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0598a extends RecyclerView.h {

    /* renamed from: a, reason: collision with root package name */
    private List f13766a;

    /* renamed from: b, reason: collision with root package name */
    private Context f13767b;

    /* renamed from: c, reason: collision with root package name */
    private e f13768c;

    /* renamed from: d, reason: collision with root package name */
    private int f13769d;

    /* renamed from: e, reason: collision with root package name */
    private int f13770e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f13771f = false;

    /* renamed from: u1.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0149a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f13772e;

        ViewOnClickListenerC0149a(int i3) {
            this.f13772e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C0598a.this.f13768c != null) {
                C0598a.this.f13768c.a(view, this.f13772e);
            }
        }
    }

    /* renamed from: u1.a$c */
    private static class c extends RecyclerView.E {

        /* renamed from: a, reason: collision with root package name */
        private View f13780a;

        public c(View view) {
            super(view);
            this.f13780a = view;
        }
    }

    /* renamed from: u1.a$d */
    private static class d extends RecyclerView.E {

        /* renamed from: a, reason: collision with root package name */
        private ImageView f13781a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f13782b;

        /* renamed from: c, reason: collision with root package name */
        private View f13783c;

        /* renamed from: d, reason: collision with root package name */
        private View f13784d;

        public d(View view) {
            super(view);
            this.f13781a = (ImageView) view.findViewById(t1.f.f13426F);
            this.f13782b = (TextView) view.findViewById(t1.f.f13436P);
            this.f13784d = view.findViewById(t1.f.f13457q);
            this.f13783c = view;
        }
    }

    /* renamed from: u1.a$e */
    public interface e {
        void a(View view, int i3);
    }

    /* renamed from: u1.a$f */
    private static class f extends RecyclerView.E {

        /* renamed from: a, reason: collision with root package name */
        private TextView f13785a;

        public f(View view) {
            super(view);
            this.f13785a = (TextView) view.findViewById(t1.f.f13437Q);
        }
    }

    public C0598a(List list, Context context) {
        this.f13767b = context;
        this.f13766a = list;
    }

    private void g(ImageView imageView) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(200L);
        imageView.startAnimation(alphaAnimation);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.f13766a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i3) {
        return ((b) this.f13766a.get(i3)).e();
    }

    public void h(int i3) {
        this.f13769d = i3;
    }

    public void i(boolean z3) {
        this.f13771f = z3;
    }

    public void j(e eVar) {
        this.f13768c = eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.E e3, int i3) {
        if (!(e3 instanceof d)) {
            if (e3 instanceof f) {
                ((f) e3).f13785a.setText(((b) this.f13766a.get(i3)).c());
                return;
            } else {
                if (e3 instanceof c) {
                    View view = ((c) e3).f13780a;
                    RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
                    ((ViewGroup.MarginLayoutParams) qVar).height = this.f13770e;
                    view.setLayoutParams(qVar);
                    return;
                }
                return;
            }
        }
        d dVar = (d) e3;
        Bitmap b3 = ((b) this.f13766a.get(i3)).b();
        if (b3 != null) {
            dVar.f13781a.setImageBitmap(b3);
            if (!((b) this.f13766a.get(i3)).a() && this.f13771f && ((b) this.f13766a.get(i3)).e() != 3) {
                g(dVar.f13781a);
                ((b) this.f13766a.get(i3)).g(true);
            }
        } else {
            dVar.f13781a.setImageBitmap(null);
        }
        String c3 = ((b) this.f13766a.get(i3)).c();
        if (c3 != null) {
            dVar.f13782b.setText(c3);
        }
        View view2 = dVar.f13783c;
        int i4 = this.f13769d;
        view2.setPadding(i4, 0, i4, 0);
        dVar.f13784d.setOnClickListener(new ViewOnClickListenerC0149a(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.E onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 2) {
            return new f(LayoutInflater.from(this.f13767b).inflate(h.f13473f, viewGroup, false));
        }
        if (i3 == 3 || i3 == 4) {
            return new d(LayoutInflater.from(this.f13767b).inflate(h.f13470c, viewGroup, false));
        }
        if (i3 == 1) {
            return new c(LayoutInflater.from(this.f13767b).inflate(h.f13471d, viewGroup, false));
        }
        return null;
    }

    /* renamed from: u1.a$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f13774a;

        /* renamed from: b, reason: collision with root package name */
        private String f13775b;

        /* renamed from: c, reason: collision with root package name */
        private int f13776c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f13777d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f13778e;

        /* renamed from: f, reason: collision with root package name */
        private int f13779f;

        public b(int i3) {
            this.f13774a = "";
            this.f13775b = "";
            this.f13776c = i3;
        }

        public boolean a() {
            return this.f13778e;
        }

        public Bitmap b() {
            return this.f13777d;
        }

        public String c() {
            return this.f13774a;
        }

        public String d() {
            return this.f13775b;
        }

        public int e() {
            return this.f13776c;
        }

        public int f() {
            return this.f13779f;
        }

        public void g(boolean z3) {
            this.f13778e = z3;
        }

        public void h(Bitmap bitmap) {
            this.f13777d = bitmap;
        }

        public b(String str, int i3) {
            this.f13775b = "";
            this.f13774a = str;
            this.f13776c = i3;
        }

        public b(String str, String str2, Bitmap bitmap, int i3, int i4) {
            this.f13774a = str;
            this.f13775b = str2;
            this.f13777d = bitmap;
            this.f13776c = i3;
            this.f13779f = i4;
        }
    }
}
