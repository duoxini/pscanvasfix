package com.color.pscanvasfix.ui;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Protects the shared Material 3 switch and its single-toggle accessibility contract. */
public final class PsCanvasExpressiveSwitchContractTest {

    @Test
    public void usesMaterialSwitchWithExplicitStateIcons() throws IOException {
        String expressiveSwitch = source("ui/PsCanvasExpressiveSwitch.kt");

        assertTrue(expressiveSwitch.contains("Switch("));
        assertTrue(expressiveSwitch.contains("thumbContent"));
        assertTrue(expressiveSwitch.contains("Icons.Rounded.Check"));
        assertTrue(expressiveSwitch.contains("Icons.Rounded.Close"));
        assertTrue(expressiveSwitch.contains("SwitchDefaults.IconSize"));
        assertTrue(expressiveSwitch.contains("interactionSource = interactionSource"));
        assertFalse(expressiveSwitch.contains("Modifier.scale"));
        assertFalse(expressiveSwitch.contains(".scale("));
    }

    @Test
    public void settingRowOwnsTheOnlyToggleSemantics() throws IOException {
        String screen = source("ui/PsCanvasManagerScreen.kt");

        assertTrue(screen.contains("toggleable("));
        assertTrue(screen.contains("role = Role.Switch"));
        assertTrue(screen.contains("interactionSource = interactionSource"));
        assertTrue(screen.contains("onCheckedChange = null"));
        assertTrue(screen.contains("clearAndSetSemantics"));
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
