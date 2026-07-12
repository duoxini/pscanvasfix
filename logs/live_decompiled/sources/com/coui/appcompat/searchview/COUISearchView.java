package com.coui.appcompat.searchview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.WindowInsets;
import androidx.appcompat.widget.SearchView;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class COUISearchView extends SearchView {

    /* renamed from: d0, reason: collision with root package name */
    private SearchView.SearchAutoComplete f9184d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f9185e0;

    /* renamed from: f0, reason: collision with root package name */
    private COUIHintAnimationLayout f9186f0;

    public static class COUISearchAutoComplete extends SearchView.SearchAutoComplete {

        /* renamed from: m, reason: collision with root package name */
        private boolean f9187m;

        public COUISearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9187m = false;
        }

        @Override // androidx.appcompat.widget.SearchView.SearchAutoComplete, android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
            WindowInsets rootWindowInsets;
            boolean onKeyPreIme = super.onKeyPreIme(i3, keyEvent);
            if (Build.VERSION.SDK_INT < 34 || this.f9187m || (rootWindowInsets = getRootView().getRootWindowInsets()) == null || rootWindowInsets.isVisible(WindowInsets.Type.ime()) || i3 != 4) {
                return onKeyPreIme;
            }
            return false;
        }

        public void setEnableNativeKeyPreIme(boolean z3) {
            this.f9187m = z3;
        }
    }

    public COUISearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9185e0 = true;
    }

    public COUIHintAnimationLayout getHintAnimationLayout() {
        return this.f9186f0;
    }

    public SearchView.SearchAutoComplete getSearchAutoComplete() {
        SearchView.SearchAutoComplete searchAutoComplete = this.f9184d0;
        if (searchAutoComplete != null) {
            return searchAutoComplete;
        }
        try {
            Field declaredField = SearchView.class.getDeclaredField("mSearchSrcTextView");
            declaredField.setAccessible(true);
            SearchView.SearchAutoComplete searchAutoComplete2 = (SearchView.SearchAutoComplete) declaredField.get(this);
            this.f9184d0 = searchAutoComplete2;
            return searchAutoComplete2;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
