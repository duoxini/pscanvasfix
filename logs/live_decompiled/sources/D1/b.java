package D1;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Region;
import android.hardware.display.DisplayManager;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.IWindow;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManagerGlobal;
import com.oplus.miragewindow.OplusMirageWindowManager;

/* loaded from: classes.dex */
public class b extends ViewGroup {

    /* renamed from: e, reason: collision with root package name */
    private final SurfaceView f299e;

    /* renamed from: f, reason: collision with root package name */
    private final a f300f;

    /* renamed from: g, reason: collision with root package name */
    private final float f301g;

    /* renamed from: h, reason: collision with root package name */
    private final int f302h;

    /* renamed from: i, reason: collision with root package name */
    private final int f303i;

    /* renamed from: j, reason: collision with root package name */
    private final int f304j;

    /* renamed from: k, reason: collision with root package name */
    private final Point f305k;

    /* renamed from: l, reason: collision with root package name */
    private final int[] f306l;

    /* renamed from: m, reason: collision with root package name */
    private final Region f307m;

    /* renamed from: n, reason: collision with root package name */
    public Matrix f308n;

    /* renamed from: o, reason: collision with root package name */
    public Matrix f309o;

    /* renamed from: p, reason: collision with root package name */
    public Matrix f310p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f311q;

    private class a implements SurfaceHolder.Callback {
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
            Log.d("SHARE_APP_VIEW", "surfaceChanged");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.d("SHARE_APP_VIEW", "surfaceCreated Surface: " + surfaceHolder.getSurface() + " DisplayId = " + b.this.f302h);
            b.this.d();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Log.d("SHARE_APP_VIEW", "surfaceDestroyed DisplayId = " + b.this.f302h);
        }

        private a() {
        }
    }

    public b(Context context, int i3) {
        super(context);
        this.f301g = 270.0f;
        this.f305k = new Point();
        this.f306l = new int[2];
        this.f307m = new Region();
        this.f311q = true;
        this.f302h = i3;
        DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        if (displayManager.getDisplay(i3) != null) {
            int orientation = displayManager.getDisplay(i3).getOrientation();
            Log.d("SHARE_APP_VIEW", "new  ShareAppView orientation = " + orientation);
            if (orientation == 1 || orientation == 3) {
                this.f311q = false;
            }
        }
        DisplayInfo displayInfo = new DisplayInfo();
        Display display = displayManager.getDisplay(i3);
        if (display != null) {
            Log.d("SHARE_APP_VIEW", "getDisplay displayId = " + i3 + " res = " + display.getDisplayInfo(displayInfo));
        }
        int i4 = displayInfo.logicalWidth;
        this.f303i = i4;
        int i5 = displayInfo.logicalHeight;
        this.f304j = i5;
        Log.d("SHARE_APP_VIEW", "DisplayWidth = " + i4 + " DisplayHeight = " + i5 + " displayId = " + i3);
        SurfaceView surfaceView = new SurfaceView(context, null, 0, 0);
        this.f299e = surfaceView;
        surfaceView.setAlpha(super.getAlpha());
        surfaceView.setUseAlpha();
        a aVar = new a();
        this.f300f = aVar;
        surfaceView.getHolder().addCallback(aVar);
        addView(surfaceView);
    }

    private void b(IWindow iWindow, Region region) {
        try {
            WindowManagerGlobal.getWindowSession().updateTapExcludeRegion(iWindow, region);
        } catch (RemoteException e3) {
            e3.rethrowAsRuntimeException();
        }
    }

    private void c() {
        float f3;
        float f4;
        this.f308n = new Matrix();
        Matrix matrix = new Matrix();
        this.f309o = matrix;
        matrix.setRotate(270.0f);
        Matrix matrix2 = new Matrix();
        this.f310p = matrix2;
        matrix2.setRotate(90.0f);
        int width = getWidth();
        int height = getHeight();
        Log.d("SHARE_APP_VIEW", "surfaceCreated width: " + width + " height: " + height + " DisplayWidth: " + this.f303i + " DisplayHeight: " + this.f304j + " mPortrait = " + this.f311q);
        if (this.f311q) {
            int i3 = this.f303i;
            f3 = i3 / width;
            f4 = this.f304j / height;
            this.f309o.postTranslate(0.0f, i3);
            this.f310p.postTranslate(this.f304j, 0.0f);
        } else {
            int i4 = this.f304j;
            f3 = i4 / width;
            f4 = this.f303i / height;
            this.f309o.postTranslate(0.0f, i4);
            this.f310p.postTranslate(this.f303i, 0.0f);
        }
        this.f308n.setScale(f3, f4);
        this.f309o.postScale(f3, f4);
        this.f310p.postScale(f3, f4);
        Log.d("SHARE_APP_VIEW", "calculateMatrix matrixPortrait: " + this.f308n.toString());
        Log.d("SHARE_APP_VIEW", "calculateMatrix matrixLandscape1: " + this.f309o.toString());
        Log.d("SHARE_APP_VIEW", "calculateMatrix matrixLandscape3: " + this.f310p.toString());
    }

    private Point getPositionInWindow() {
        getLocationInWindow(this.f306l);
        Point point = this.f305k;
        int[] iArr = this.f306l;
        point.set(iArr[0], iArr[1]);
        return this.f305k;
    }

    private Region getTapExcludeRegion() {
        if (isAttachedToWindow() && canReceivePointerEvents()) {
            Point positionInWindow = getPositionInWindow();
            Region region = this.f307m;
            int i3 = positionInWindow.x;
            region.set(i3, positionInWindow.y, getWidth() + i3, positionInWindow.y + getHeight());
            ViewParent parent = getParent();
            if (parent != null) {
                parent.subtractObscuredTouchableRegion(this.f307m, this);
            }
        } else {
            this.f307m.setEmpty();
        }
        Log.d("SHARE_APP_VIEW", "getTapExcludeRegion mTapExcludeRegion: " + this.f307m);
        return this.f307m;
    }

    public boolean d() {
        try {
            c();
            OplusMirageWindowManager oplusMirageWindowManager = OplusMirageWindowManager.getInstance();
            if (oplusMirageWindowManager != null) {
                oplusMirageWindowManager.setMirageDisplaySurfaceById(this.f302h, this.f299e.getHolder().getSurface());
            }
            Log.d("SHARE_APP_VIEW", "setMirageDisplaySurfaceById Surface: " + this.f299e.getHolder().getSurface() + " DisplayId = " + this.f302h);
            return true;
        } catch (Exception e3) {
            Log.e("SHARE_APP_VIEW", "initialize: ", e3);
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        b(getWindow(), region);
        return super.gatherTransparentRegion(region);
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.f299e.getAlpha();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append("onLayout ShareAppView left = ");
        sb.append(i3);
        sb.append(" top = ");
        sb.append(i4);
        sb.append(" right = ");
        int i7 = i5 - i3;
        sb.append(i7);
        sb.append(" bottom = ");
        int i8 = i6 - i4;
        sb.append(i8);
        Log.d("SHARE_APP_VIEW", sb.toString());
        this.f299e.layout(0, 0, i7, i8);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        this.f299e.setVisibility(i3);
    }

    @Override // android.view.View
    public void setAlpha(float f3) {
        super.setAlpha(f3);
        SurfaceView surfaceView = this.f299e;
        if (surfaceView != null) {
            surfaceView.setAlpha(f3);
        }
    }
}
