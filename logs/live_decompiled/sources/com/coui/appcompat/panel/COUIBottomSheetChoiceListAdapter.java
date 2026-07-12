package com.coui.appcompat.panel;

import M1.g;
import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.checkbox.COUICheckBox;
import java.util.HashSet;

/* loaded from: classes.dex */
public class COUIBottomSheetChoiceListAdapter extends RecyclerView.h {
    private HashSet<Integer> mCheckBoxStates;
    private int mCheckedItem;
    private Context mContext;
    private boolean mIsMultiChoice;
    private CharSequence[] mItems;
    private int mLayoutResId;
    private OnItemClickListener mOnItemClickListener;
    private CharSequence[] mSummaries;

    public interface OnItemClickListener {
        void onItemClick(View view, int i3, int i4);
    }

    class ViewHolder extends RecyclerView.E {
        COUICheckBox checkBox;
        TextView itemText;
        View mLayout;
        RadioButton radioButton;
        TextView summaryText;

        public ViewHolder(View view) {
            super(view);
            this.itemText = (TextView) view.findViewById(R.id.text1);
            this.summaryText = (TextView) view.findViewById(P1.d.f1825v);
            if (COUIBottomSheetChoiceListAdapter.this.mIsMultiChoice) {
                this.checkBox = (COUICheckBox) view.findViewById(P1.d.f1808e);
            } else {
                this.radioButton = (RadioButton) view.findViewById(P1.d.f1821r);
            }
            view.setBackground(COUIBottomSheetChoiceListAdapter.this.mContext.getDrawable(g.f1475i));
            this.mLayout = view;
        }
    }

    public COUIBottomSheetChoiceListAdapter(Context context, int i3, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int i4, boolean[] zArr, boolean z3) {
        this.mCheckedItem = -1;
        this.mContext = context;
        this.mLayoutResId = i3;
        this.mItems = charSequenceArr;
        this.mSummaries = charSequenceArr2;
        this.mIsMultiChoice = z3;
        this.mCheckBoxStates = new HashSet<>();
        this.mCheckedItem = i4;
        if (zArr != null) {
            initCheckboxStates(zArr);
        }
    }

    private void initCheckboxStates(boolean[] zArr) {
        for (int i3 = 0; i3 < zArr.length; i3++) {
            if (zArr[i3]) {
                this.mCheckBoxStates.add(Integer.valueOf(i3));
            }
        }
    }

    public CharSequence getItem(int i3) {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr == null || i3 >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[i3];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i3) {
        return i3;
    }

    public CharSequence getSummary(int i3) {
        CharSequence[] charSequenceArr = this.mSummaries;
        if (charSequenceArr == null || i3 >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[i3];
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(final ViewHolder viewHolder, final int i3) {
        if (this.mIsMultiChoice) {
            viewHolder.checkBox.setState(this.mCheckBoxStates.contains(Integer.valueOf(i3)) ? 2 : 0);
        } else {
            viewHolder.radioButton.setChecked(this.mCheckedItem == i3);
        }
        CharSequence item = getItem(i3);
        CharSequence summary = getSummary(i3);
        viewHolder.itemText.setText(item);
        if (TextUtils.isEmpty(summary)) {
            viewHolder.summaryText.setVisibility(8);
        } else {
            viewHolder.summaryText.setVisibility(0);
            viewHolder.summaryText.setText(summary);
        }
        if (this.mOnItemClickListener != null) {
            viewHolder.mLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetChoiceListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i4;
                    if (COUIBottomSheetChoiceListAdapter.this.mIsMultiChoice) {
                        if (viewHolder.checkBox.getState() != 2) {
                            COUIBottomSheetChoiceListAdapter.this.mCheckBoxStates.add(Integer.valueOf(i3));
                        } else {
                            COUIBottomSheetChoiceListAdapter.this.mCheckBoxStates.remove(Integer.valueOf(i3));
                        }
                        i4 = COUIBottomSheetChoiceListAdapter.this.mCheckBoxStates.contains(Integer.valueOf(i3)) ? 2 : 0;
                        viewHolder.checkBox.setState(i4);
                    } else {
                        if (i3 == COUIBottomSheetChoiceListAdapter.this.mCheckedItem) {
                            COUIBottomSheetChoiceListAdapter.this.mOnItemClickListener.onItemClick(view, i3, 0);
                            return;
                        }
                        boolean isChecked = viewHolder.radioButton.isChecked();
                        i4 = !isChecked ? 1 : 0;
                        viewHolder.radioButton.setChecked(!isChecked);
                        COUIBottomSheetChoiceListAdapter cOUIBottomSheetChoiceListAdapter = COUIBottomSheetChoiceListAdapter.this;
                        cOUIBottomSheetChoiceListAdapter.notifyItemChanged(cOUIBottomSheetChoiceListAdapter.mCheckedItem);
                        COUIBottomSheetChoiceListAdapter.this.mCheckedItem = i3;
                    }
                    COUIBottomSheetChoiceListAdapter.this.mOnItemClickListener.onItemClick(view, i3, i4);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(this.mLayoutResId, viewGroup, false));
    }

    public COUIBottomSheetChoiceListAdapter(Context context, int i3, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int i4) {
        this(context, i3, charSequenceArr, charSequenceArr2, i4, null, false);
    }
}
