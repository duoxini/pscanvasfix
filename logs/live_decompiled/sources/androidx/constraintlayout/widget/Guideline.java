package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Guideline extends View {

    /* renamed from: e, reason: collision with root package name */
    private boolean f4365e;

    public Guideline(Context context) {
        super(context);
        this.f4365e = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z3) {
        this.f4365e = z3;
    }

    public void setGuidelineBegin(int i3) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f4365e && bVar.guideBegin == i3) {
            return;
        }
        bVar.guideBegin = i3;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i3) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f4365e && bVar.guideEnd == i3) {
            return;
        }
        bVar.guideEnd = i3;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f3) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f4365e && bVar.guidePercent == f3) {
            return;
        }
        bVar.guidePercent = f3;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4365e = true;
        super.setVisibility(8);
    }
}
