package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;

import org.junit.Assume;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class PsCanvasUpdatedContractTest {
    @Test
    public void factoryApkResolvesEveryActiveCanvasContract() {
        String path = System.getProperty("pscanvas.c17.apk", "");
        Assume.assumeTrue("set -Dpscanvas.c17.apk to the factory APK", !path.isEmpty());
        File apk = new File(path);
        assertTrue(apk.isFile());
        PsCanvasSymbols symbols = PsCanvasSymbolResolver.resolve(DexClassScanner.scanApk(apk));
        for (Role role : List.of(Role.SSTO_FLEXIBLE, Role.THREE_SPLIT_ANIM, Role.THREE_SPLIT_DRAG,
                Role.CANVAS_CONTROLLER, Role.CLASSIC_LAYOUT, Role.PANORAMA_MANAGER,
                Role.THREE_TASK_RESIZE, Role.SAVED_SPLIT_LAYOUT)) {
            assertTrue(role + " must resolve", symbols.role(role).available());
        }

        RoleSymbol transition = symbols.role(Role.SSTO_FLEXIBLE);
        assertEquals("f2.x", transition.className);
        assertEquals("t0", transition.scaleMethod);
        assertEquals("I", transition.intentListMethod);
        assertEquals("H", transition.launchBoundsMethod);
        assertEquals("Z", transition.maskAnimMethod);
        assertEquals("P", symbols.role(Role.PANORAMA_MANAGER).panoramaActiveMethod);
        assertEquals("C", symbols.role(Role.PANORAMA_MANAGER).panoramaExitMethod);
        assertEquals("V1", symbols.role(Role.CLASSIC_LAYOUT).layoutMethods.equalWidth());
        assertEquals("w0", symbols.role(Role.THREE_TASK_RESIZE).threeTaskResizeSpringDragMethod);
        assertEquals("g", symbols.role(Role.THREE_TASK_RESIZE)
                .resizeFocusMethods.calculateDragMode());
        assertTrue(symbols.role(Role.THREE_TASK_RESIZE).threeTaskResizeCanAlignThreshold);
        assertEquals("r2", symbols.role(Role.SAVED_SPLIT_LAYOUT).savedLayoutRestoreMethod);
    }
}
