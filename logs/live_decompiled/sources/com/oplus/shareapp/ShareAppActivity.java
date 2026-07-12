package com.oplus.shareapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class ShareAppActivity extends Activity {

    /* renamed from: f, reason: collision with root package name */
    private int f11001f;

    /* renamed from: h, reason: collision with root package name */
    private D1.b f11003h;

    /* renamed from: i, reason: collision with root package name */
    private int f11004i;

    /* renamed from: e, reason: collision with root package name */
    private final DisplayManager.DisplayListener f11000e = new a();

    /* renamed from: g, reason: collision with root package name */
    private boolean f11002g = true;

    /* renamed from: j, reason: collision with root package name */
    private BroadcastReceiver f11005j = new b();

    class a implements DisplayManager.DisplayListener {
        a() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i3) {
            Log.i("SHARE_APP_ACTIVITY", "onDisplayAdded, displayId: " + i3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i3) {
            Log.i("SHARE_APP_ACTIVITY", "onDisplayChanged, displayId: " + i3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i3) {
            Log.i("SHARE_APP_ACTIVITY", "onDisplayRemoved, displayId: " + i3);
            if (i3 == ShareAppActivity.this.f11001f) {
                ShareAppActivity.this.finish();
            }
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("oplus_mirage:landscape", false);
            Log.d("SHARE_APP_ACTIVITY", "onReceive landScape = " + booleanExtra);
            ShareAppActivity.this.e();
            ShareAppActivity.this.f11002g = booleanExtra ^ true;
        }
    }

    private static KeyEvent d(int i3, int i4, int i5) {
        long uptimeMillis = SystemClock.uptimeMillis();
        KeyEvent keyEvent = new KeyEvent(uptimeMillis, uptimeMillis, i3, i4, 0);
        keyEvent.setDisplayId(i5);
        keyEvent.setSource(134217728);
        return keyEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        DisplayManager displayManager = (DisplayManager) getSystemService(DisplayManager.class);
        if (displayManager.getDisplay(this.f11001f) != null) {
            this.f11004i = displayManager.getDisplay(this.f11001f).getOrientation();
            Log.d("SHARE_APP_ACTIVITY", "getDisplayRotation() mRotation = " + this.f11004i);
            int i3 = this.f11004i;
            if (i3 == 1 || i3 == 3) {
                this.f11002g = false;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11002g) {
            motionEvent.applyTransform(this.f11003h.f308n);
        } else if (this.f11004i == 1) {
            motionEvent.applyTransform(this.f11003h.f309o);
        } else {
            motionEvent.applyTransform(this.f11003h.f310p);
        }
        motionEvent.setDisplayId(this.f11001f);
        return f(motionEvent, 0);
    }

    public boolean f(InputEvent inputEvent, int i3) {
        return ((InputManager) getSystemService(InputManager.class)).injectInputEvent(inputEvent, i3);
    }

    public void g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.OPLUS_MIRAGE_APP_SHARE.ROTATION_CHANGE");
        registerReceiver(this.f11005j, intentFilter, 2);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Log.d("SHARE_APP_ACTIVITY", "onBackPressed displayId = " + this.f11001f);
        int i3 = this.f11001f;
        f(d(0, 4, i3), 0);
        f(d(1, 4, i3), 0);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActionBar().hide();
        this.f11001f = getIntent().getIntExtra("oplus_mirage:displayId", 0);
        D1.b bVar = new D1.b(this, this.f11001f);
        this.f11003h = bVar;
        setContentView(bVar);
        e();
        ((DisplayManager) getSystemService(DisplayManager.class)).registerDisplayListener(this.f11000e, new Handler());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        getWindow().getDecorView().setSystemUiVisibility(5894);
        g();
    }
}
