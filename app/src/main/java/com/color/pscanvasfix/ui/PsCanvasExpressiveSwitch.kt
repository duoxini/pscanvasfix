package com.color.pscanvasfix.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/** Material 3 switch with an explicit check/close state marker in the thumb. */
@Composable
internal fun PsCanvasExpressiveSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val colorScheme = MaterialTheme.colorScheme
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        thumbContent = {
            Icon(
                imageVector = if (checked) Icons.Rounded.Check else Icons.Rounded.Close,
                contentDescription = null,
                modifier = Modifier.size(SwitchDefaults.IconSize),
            )
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = colorScheme.surface,
            checkedTrackColor = colorScheme.primary,
            checkedBorderColor = Color.Transparent,
            checkedIconColor = colorScheme.primary,
            uncheckedThumbColor = colorScheme.onSurfaceVariant,
            uncheckedTrackColor = colorScheme.surfaceContainerHighest,
            uncheckedBorderColor = colorScheme.outline,
            uncheckedIconColor = colorScheme.surface,
            disabledCheckedThumbColor = colorScheme.surface.copy(alpha = 0.72f),
            disabledCheckedTrackColor = colorScheme.primary.copy(alpha = 0.32f),
            disabledCheckedBorderColor = Color.Transparent,
            disabledCheckedIconColor = colorScheme.primary.copy(alpha = 0.72f),
            disabledUncheckedThumbColor = colorScheme.onSurfaceVariant.copy(alpha = 0.48f),
            disabledUncheckedTrackColor = colorScheme.surfaceContainerHighest.copy(alpha = 0.48f),
            disabledUncheckedBorderColor = colorScheme.outline.copy(alpha = 0.38f),
            disabledUncheckedIconColor = colorScheme.surface.copy(alpha = 0.72f),
        ),
    )
}
