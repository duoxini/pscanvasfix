param(
    [switch]$LogOnly,
    [switch]$NoBuild,
    [switch]$NoInstall
)

$ErrorActionPreference = "Stop"
$Root = Split-Path -Parent (Split-Path -Parent $MyInvocation.MyCommand.Path)
$LogDir = Join-Path $Root "logs"
$LatestLog = Join-Path $LogDir "pscanvas_latest.log"
$Apk = Join-Path $Root "app\build\outputs\apk\debug\app-debug.apk"

$LogTags = @(
    "PsCanvasFix:D",
    "SStoFlexible:D",
    "CanvasGestureManager:D",
    "FlexibleWindowUtil:D",
    "ThreeSplitAnimManager:D",
    "LSPosed-Bridge:I",
    "AndroidRuntime:E",
    "*:S"
)

function Wait-AdbDevice {
    Write-Host "[PsCanvasFix] Waiting for ADB device..."
    & adb wait-for-device
    for ($i = 0; $i -lt 120; $i++) {
        $state = (& adb get-state 2>$null | Select-Object -Last 1).Trim()
        if ($state -eq "device") { return }
        if ($state -eq "unauthorized") {
            Write-Host "[PsCanvasFix] Accept USB debugging on the phone..."
        }
        Start-Sleep -Seconds 1
    }
    throw "ADB device not ready (state=$state)"
}

function Stop-PsCanvasLogcat {
    & (Join-Path $Root "scripts\stop-logcat.ps1")
}

function Archive-LatestLog {
    if (-not (Test-Path $LatestLog)) { return }
    $info = Get-Item $LatestLog
    if ($info.Length -eq 0) { return }
    $stamp = Get-Date -Format "yyyyMMdd_HHmmss"
    $archive = Join-Path $LogDir ("pscanvas_{0}.log" -f $stamp)
    Copy-Item -Path $LatestLog -Destination $archive -Force
    Write-Host "[PsCanvasFix] Archived previous log -> $archive"
}

if (-not (Test-Path $LogDir)) {
    New-Item -ItemType Directory -Path $LogDir | Out-Null
}

Stop-PsCanvasLogcat
Archive-LatestLog

Wait-AdbDevice

$model = (& adb shell getprop ro.product.model 2>$null).Trim()
$colorOs = (& adb shell getprop ro.build.version.oplusrom 2>$null).Trim()
Write-Host "[PsCanvasFix] Device: $model  ColorOS: $colorOs"

if (-not $LogOnly) {
    if (-not $NoBuild) {
        Write-Host "[PsCanvasFix] Building debug APK..."
        Push-Location $Root
        try {
            & .\gradlew.bat :app:assembleDebug
            if ($LASTEXITCODE -ne 0) { throw "gradlew assembleDebug failed ($LASTEXITCODE)" }
        } finally {
            Pop-Location
        }
    }

    & adb shell settings put system screen_off_timeout 600000 | Out-Null
    & adb shell svc power stayon usb | Out-Null

    if (-not $NoInstall) {
        if (-not (Test-Path $Apk)) {
            throw "APK not found: $Apk (run build first)"
        }
        Write-Host "[PsCanvasFix] Installing module..."
        & adb install -r $Apk
        if ($LASTEXITCODE -ne 0) { throw "adb install failed ($LASTEXITCODE)" }
    }

    Write-Host "[PsCanvasFix] Force-stopping canvas (LSPosed reload: reopen canvas after first install)..."
    & adb shell am force-stop com.oplus.pscanvas | Out-Null
}

& adb logcat -c | Out-Null

$header = @(
    "===== PsCanvasFix integrated capture $(Get-Date -Format 'yyyy-MM-dd HH:mm:ss') =====",
    "Device: $model  ColorOS: $colorOs",
    "LogOnly=$LogOnly  NoBuild=$NoBuild  NoInstall=$NoInstall",
    ""
) -join [Environment]::NewLine

Set-Content -Path $LatestLog -Value $header -Encoding UTF8

Write-Host ""
Write-Host "[PsCanvasFix] Logging to: $LatestLog"
Write-Host "[PsCanvasFix] Reproduce pinch now. Press Ctrl+C in this terminal to stop."
Write-Host ""

& adb logcat -v time @LogTags 2>&1 | Tee-Object -FilePath $LatestLog -Append
