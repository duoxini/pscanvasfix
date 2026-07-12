package com.oplus.flexibletask.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.preference.PreferenceCategory;
import com.coui.appcompat.preference.COUIPreference;
import com.oplus.flexibletask.setting.bean.GameListInfo;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import t1.l;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class SupportGameListFragment extends com.coui.appcompat.preference.h {
    private static final String TAG = "SupportGameListActivity";
    private Context mContext;
    private List<GameListInfo> mGameList;
    private PreferenceCategory mPreferenceCategory;

    public SupportGameListFragment() {
        this.mGameList = new ArrayList();
    }

    private void addPreferenceList(List<GameListInfo> list) {
        this.mPreferenceCategory.r();
        list.sort(Comparator.comparing(new Function() { // from class: com.oplus.flexibletask.setting.fragment.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((GameListInfo) obj).getAppName();
            }
        }, Collator.getInstance(Locale.CHINA)));
        for (int i3 = 0; i3 < list.size(); i3++) {
            COUIPreference cOUIPreference = new COUIPreference(this.mContext);
            cOUIPreference.setTitle(list.get(i3).getAppName());
            cOUIPreference.setIcon(list.get(i3).getAppIcon());
            this.mPreferenceCategory.j(cOUIPreference);
        }
        AbstractC0652e.g("SupportGameListActivity", "show game list.");
    }

    @Override // androidx.lifecycle.InterfaceC0271g
    public /* bridge */ /* synthetic */ H.a getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(l.f13682c);
        com.coui.appcompat.theme.a.h().a(requireActivity());
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mPreferenceCategory = (PreferenceCategory) findPreference("support_game_list");
        addPreferenceList(this.mGameList);
        AbstractC0652e.g("SupportGameListActivity", "SupportGameListFragment onViewCreated");
    }

    public SupportGameListFragment(Context context, List<GameListInfo> list) {
        new ArrayList();
        this.mContext = context;
        this.mGameList = list;
    }
}
