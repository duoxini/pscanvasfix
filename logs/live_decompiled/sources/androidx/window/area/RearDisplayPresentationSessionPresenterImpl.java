package androidx.window.area;

import D2.k;
import android.content.Context;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.WindowAreaComponent;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class RearDisplayPresentationSessionPresenterImpl implements WindowAreaSessionPresenter {

    /* renamed from: a, reason: collision with root package name */
    private final WindowAreaComponent f6855a;

    /* renamed from: b, reason: collision with root package name */
    private final ExtensionWindowAreaPresentation f6856b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f6857c;

    public RearDisplayPresentationSessionPresenterImpl(WindowAreaComponent windowAreaComponent, ExtensionWindowAreaPresentation extensionWindowAreaPresentation) {
        k.e(windowAreaComponent, "windowAreaComponent");
        k.e(extensionWindowAreaPresentation, "presentation");
        this.f6855a = windowAreaComponent;
        this.f6856b = extensionWindowAreaPresentation;
        Context presentationContext = extensionWindowAreaPresentation.getPresentationContext();
        k.d(presentationContext, "presentation.presentationContext");
        this.f6857c = presentationContext;
    }
}
