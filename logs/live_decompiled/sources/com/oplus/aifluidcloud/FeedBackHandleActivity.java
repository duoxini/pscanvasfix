package com.oplus.aifluidcloud;

import android.app.OplusNotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.customer.feedback.sdk.FeedbackHelper;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class FeedBackHandleActivity extends AppCompatActivity {
    private void k() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("fat://fb/home?target=FAQListPage&catalogueId=14&moduleId=36&menuId=189&directBack=1"));
            startActivity(intent);
        } catch (Exception e3) {
            AbstractC0652e.d("FeedBackHandleActivity", "launchFaqActivity error: " + e3.getMessage());
        }
    }

    private void l() {
        try {
            FeedbackHelper.setUserPrivacyBehaviorAgree(true, true);
            String stdid = new OplusNotificationManager().getStdid(getPackageName(), UserHandle.myUserId(), "AUID");
            AbstractC0652e.b("FeedBackHandleActivity", "launchFeedbackActivity duid: " + stdid);
            if (TextUtils.isEmpty(stdid)) {
                return;
            }
            FeedbackHelper.setId(stdid);
            FeedbackHelper feedbackHelper = FeedbackHelper.getInstance(this);
            FeedbackHelper.setCredentialProtectedStorageContext(createCredentialProtectedStorageContext());
            feedbackHelper.openFeedbackWithCode(this, "25072101");
        } catch (Exception e3) {
            AbstractC0652e.d("FeedBackHandleActivity", "launchFeedbackActivity error: " + e3.getMessage());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            AbstractC0652e.b("FeedBackHandleActivity", "launchFaqActivity targetAction: " + action);
            if ("com.oplus.aifluidcloud.action.OPEN_FAQ".equals(action)) {
                k();
            } else if ("com.oplus.aifluid.action.OPEN_FEEDBACK".equals(action)) {
                l();
            }
        }
        finish();
    }
}
