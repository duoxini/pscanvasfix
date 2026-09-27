package com.color.pscanvasfix.ui;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Keeps paused Four Task research internal while Resize remains the visible product entry. */
public final class PsCanvasManagerScreenVisibilityContractTest {

    @Test
    public void showsResizeAndHidesFourTaskProductEntry() throws IOException {
        String screen = source("ui/PsCanvasManagerScreen.kt");
        String model = source("ui/ManagerUiModel.kt");
        String preferences = source("config/ModulePreferences.java");

        assertTrue(screen.contains("允许调整分屏窗口大小"));
        assertFalse(screen.contains("允许四窗口画布"));

        assertTrue(model.contains("val fourTaskCanvas: FeatureToggleUiState"));
        assertTrue(preferences.contains("KEY_FOUR_TASK_CANVAS"));
    }

    private static String source(String relative) throws IOException {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path source = root.resolve("app/src/main/java/com/color/pscanvasfix").resolve(relative);
        if (!Files.isRegularFile(source)) {
            source = root.resolve("src/main/java/com/color/pscanvasfix").resolve(relative);
        }
        return new String(Files.readAllBytes(source), StandardCharsets.UTF_8)
                .replace("\r\n", "\n");
    }
}
