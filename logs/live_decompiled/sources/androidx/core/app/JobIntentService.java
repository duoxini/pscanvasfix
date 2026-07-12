package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: l, reason: collision with root package name */
    static final Object f4803l = new Object();

    /* renamed from: m, reason: collision with root package name */
    static final HashMap f4804m = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    b f4805e;

    /* renamed from: f, reason: collision with root package name */
    f f4806f;

    /* renamed from: g, reason: collision with root package name */
    a f4807g;

    /* renamed from: h, reason: collision with root package name */
    boolean f4808h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f4809i = false;

    /* renamed from: j, reason: collision with root package name */
    boolean f4810j = false;

    /* renamed from: k, reason: collision with root package name */
    final ArrayList f4811k = null;

    final class a extends AsyncTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                d a3 = JobIntentService.this.a();
                if (a3 == null) {
                    return null;
                }
                JobIntentService.this.d(a3.getIntent());
                a3.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.f();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.f();
        }
    }

    interface b {
        d a();

        IBinder b();
    }

    final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        final Intent f4813a;

        /* renamed from: b, reason: collision with root package name */
        final int f4814b;

        c(Intent intent, int i3) {
            this.f4813a = intent;
            this.f4814b = i3;
        }

        @Override // androidx.core.app.JobIntentService.d
        public void a() {
            JobIntentService.this.stopSelf(this.f4814b);
        }

        @Override // androidx.core.app.JobIntentService.d
        public Intent getIntent() {
            return this.f4813a;
        }
    }

    interface d {
        void a();

        Intent getIntent();
    }

    static final class e extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final JobIntentService f4816a;

        /* renamed from: b, reason: collision with root package name */
        final Object f4817b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f4818c;

        final class a implements d {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f4819a;

            a(JobWorkItem jobWorkItem) {
                this.f4819a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.d
            public void a() {
                synchronized (e.this.f4817b) {
                    try {
                        JobParameters jobParameters = e.this.f4818c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f4819a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.d
            public Intent getIntent() {
                return this.f4819a.getIntent();
            }
        }

        e(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f4817b = new Object();
            this.f4816a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public d a() {
            synchronized (this.f4817b) {
                try {
                    JobParameters jobParameters = this.f4818c;
                    if (jobParameters == null) {
                        return null;
                    }
                    JobWorkItem dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork == null) {
                        return null;
                    }
                    dequeueWork.getIntent().setExtrasClassLoader(this.f4816a.getClassLoader());
                    return new a(dequeueWork);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder b() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f4818c = jobParameters;
            this.f4816a.c(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b3 = this.f4816a.b();
            synchronized (this.f4817b) {
                this.f4818c = null;
            }
            return b3;
        }
    }

    static abstract class f {
        public abstract void a();

        public abstract void b();

        public abstract void c();
    }

    d a() {
        b bVar = this.f4805e;
        if (bVar != null) {
            return bVar.a();
        }
        synchronized (this.f4811k) {
            try {
                if (this.f4811k.size() <= 0) {
                    return null;
                }
                return (d) this.f4811k.remove(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean b() {
        a aVar = this.f4807g;
        if (aVar != null) {
            aVar.cancel(this.f4808h);
        }
        this.f4809i = true;
        return e();
    }

    void c(boolean z3) {
        if (this.f4807g == null) {
            this.f4807g = new a();
            this.f4807g.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void d(Intent intent);

    public boolean e() {
        return true;
    }

    void f() {
        ArrayList arrayList = this.f4811k;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f4807g = null;
                    ArrayList arrayList2 = this.f4811k;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f4810j) {
                        this.f4806f.a();
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f4805e;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f4805e = new e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f4811k;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f4810j = true;
                this.f4806f.a();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        if (this.f4811k == null) {
            return 2;
        }
        this.f4806f.c();
        synchronized (this.f4811k) {
            ArrayList arrayList = this.f4811k;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new c(intent, i4));
            c(true);
        }
        return 3;
    }
}
