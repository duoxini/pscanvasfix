package com.color.pscanvasfix.module;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import com.color.pscanvasfix.ui.ManagerUiCoordinator;
import com.color.pscanvasfix.ui.ManagerUiCoordinatorOwner;

import io.github.libxposed.service.XposedService;
import io.github.libxposed.service.XposedServiceHelper;

/** Application-side connection to the modern libxposed manager service. */
public final class PsCanvasApplication extends Application
        implements XposedServiceHelper.OnServiceListener, ManagerUiCoordinatorOwner {
    public interface ServiceListener {
        void onServiceChanged(XposedService service);
    }

    private final CopyOnWriteArrayList<ServiceListener> listeners =
            new CopyOnWriteArrayList<>();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private volatile XposedService service;
    private ServiceBackedManagerCoordinator managerUiCoordinator;

    @Override
    public void onCreate() {
        super.onCreate();
        managerUiCoordinator = new ServiceBackedManagerCoordinator(this);
        XposedServiceHelper.registerListener(this);
    }

    @Override
    public ManagerUiCoordinator getManagerUiCoordinator() {
        return managerUiCoordinator;
    }

    @Override
    public void onServiceBind(XposedService boundService) {
        publishService(Objects.requireNonNull(boundService, "boundService"));
    }

    @Override
    public void onServiceDied(XposedService deadService) {
        if (service == deadService) {
            publishService(null);
        }
    }

    public XposedService currentService() {
        return service;
    }

    public void addServiceListener(ServiceListener listener) {
        ServiceListener checked = Objects.requireNonNull(listener, "listener");
        listeners.addIfAbsent(checked);
        XposedService current = service;
        mainHandler.post(() -> checked.onServiceChanged(current));
    }

    public void removeServiceListener(ServiceListener listener) {
        listeners.remove(listener);
    }

    private void publishService(XposedService next) {
        service = next;
        mainHandler.post(() -> {
            for (ServiceListener listener : listeners) {
                listener.onServiceChanged(next);
            }
        });
    }
}
