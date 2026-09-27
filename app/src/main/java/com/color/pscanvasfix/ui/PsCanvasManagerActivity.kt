package com.color.pscanvasfix.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.color.pscanvasfix.diagnostic.CompatibilityReadiness
import com.color.pscanvasfix.diagnostic.DiagnosticsFormatter
import com.color.pscanvasfix.diagnostic.DiagnosticsSnapshot
import com.color.pscanvasfix.diagnostic.ModuleRuntimeState
import java.io.Closeable

open class PsCanvasManagerActivity : ComponentActivity() {
    private lateinit var coordinator: ManagerUiCoordinator
    private var observer: Closeable? = null
    private var uiState by mutableStateOf(unavailableState())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
        )
        coordinator = (application as? ManagerUiCoordinatorOwner)?.managerUiCoordinator
            ?: UnavailableCoordinator
        uiState = coordinator.currentState()

        setContent {
            PsCanvasClassicTheme {
                PsCanvasManagerScreen(
                    state = uiState,
                    onAdjustableWindowSizeChange = { enabled ->
                        coordinator.setAdjustableWindowSize(enabled)
                    },
                    onCopyDiagnostics = ::copyDiagnostics,
                    onOpenCompatibilityReport = coordinator::openCompatibilityReport,
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        uiState = coordinator.currentState()
        observer = coordinator.observe { newState ->
            runOnUiThread { uiState = newState }
        }
    }

    override fun onStop() {
        observer?.close()
        observer = null
        super.onStop()
    }

    private fun copyDiagnostics() {
        val clipboard = getSystemService(ClipboardManager::class.java)
        clipboard.setPrimaryClip(
            ClipData.newPlainText("PsCanvas Classic diagnostics", coordinator.diagnosticsText()),
        )
        Toast.makeText(this, "诊断信息已复制", Toast.LENGTH_SHORT).show()
    }

    private companion object {
        fun unavailableState() = ManagerUiState(
            runtimeState = ModuleRuntimeState.SERVICE_UNAVAILABLE,
            runtimeDetail = "尚未连接到 LSPosed 模块服务",
            compatibilityReadiness = CompatibilityReadiness.UNVERIFIED,
            compatibilityDetail = "连接模块服务后读取目标版本与能力状态",
        )
    }

    private object UnavailableCoordinator : ManagerUiCoordinator {
        override fun currentState(): ManagerUiState = unavailableState()

        override fun observe(observer: (ManagerUiState) -> Unit): Closeable = Closeable { }

        override fun setAdjustableWindowSize(enabled: Boolean) = Unit

        override fun setFourTaskCanvas(enabled: Boolean) = Unit

        override fun diagnosticsText(): String = DiagnosticsFormatter.format(
            DiagnosticsSnapshot(
                runtimeState = ModuleRuntimeState.SERVICE_UNAVAILABLE,
                compatibilityReadiness = CompatibilityReadiness.UNVERIFIED,
            ),
        )

        override fun openCompatibilityReport() = Unit
    }
}
