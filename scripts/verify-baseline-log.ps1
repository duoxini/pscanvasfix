# Grep pscanvas_latest.log against 502-700-diff-baseline.md acceptance criteria.
param(
    [string]$LogPath = (Join-Path (Split-Path -Parent $PSScriptRoot) "logs\pscanvas_latest.log")
)

if (-not (Test-Path $LogPath)) {
    Write-Error "Log not found: $LogPath"
    exit 1
}

$mustHave = @(
    "install v49",
    "hookPanoramaMaskAnimRectFix installed",
    "hook502ThreeSplitTouchRestore installed",
    "502 dummy prepare t0",
    "502 layout remap layout",
    "positionChangeToSplit onAnimationEnd result:true",
    "502-style finish",
    "hookScaleListener502 scale hooks",
    # P0: three-split-together blocking
    "P0: hookBlockThreeSplitTogether e3 installed",
    "blocked e3 three-split-together entry",
    "P0: hookBlockThreeSplitTogether f3 installed",
    "P0: hookBlockThreeSplitTogether E2 installed",
    "P0: hookBlockThreeSplitTogether i2 installed",
    # P1: SplitBar drag blocking
    "P1: hookBlockSplitBarThreeSplitDrag u0 installed",
    "P1: hookBlockSplitBarThreeSplitDrag R installed",
    # P2: getLaunchRect fix
    "P2: hookFixPanoramaLaunchRect installed",
    "blocked isThreeSplitTogether in calculateFlexibleWindowBounds"
)

$mustHaveOptional = @(
    # Only when user drags split bar
    "blocked E2 startScrollSplitBarInThreeSplit",
    "blocked E.R spring animation init",
    "blocked E.u0 three-split spring drag",
    # Only when adapter callback fires (field name may differ per device)
    "f() beforeHook: nulled three-split callback"
)

$mustNotHave = @(
    "ensureCanvasLayout3ForTransition",
    "M1 clamped layoutOrientation 4 -> 3",
    "notifyPrepare.*toggle returned false",
    "hookPanoramaMaskAnimRectFix failed",
    # P0: three-split-together must not appear
    "onEnterThreeSplitTogether",
    "onExitThreeSplitTogether",
    # P1: spring drag must not appear
    "SpringAnimation.*start",
    # P2: unblocked setLayerOrder sub-surface
    "setLayerOrder.*sub.*surface"
)

Write-Host "=== Baseline acceptance: $LogPath ===" -ForegroundColor Cyan
$ok = $true

Write-Host "`n-- Should have --"
foreach ($pattern in $mustHave) {
    $hits = Select-String -Path $LogPath -Pattern $pattern -AllMatches
    if ($hits) {
        Write-Host "[OK] $pattern ($($hits.Count) hit(s))" -ForegroundColor Green
    } else {
        Write-Host "[MISS] $pattern" -ForegroundColor Red
        $ok = $false
    }
}

Write-Host "`n-- Optional (OK if absent) --"
foreach ($pattern in $mustHaveOptional) {
    $hits = Select-String -Path $LogPath -Pattern $pattern -AllMatches
    if ($hits) {
        Write-Host "[OK] $pattern ($($hits.Count) hit(s))" -ForegroundColor Green
    } else {
        Write-Host "[--] $pattern (not triggered)" -ForegroundColor Yellow
    }
}

Write-Host "`n-- Should NOT have --"
foreach ($pattern in $mustNotHave) {
    $hits = Select-String -Path $LogPath -Pattern $pattern -AllMatches
    if ($hits) {
        Write-Host "[FAIL] $pattern ($($hits.Count) hit(s))" -ForegroundColor Red
        $ok = $false
    } else {
        Write-Host "[OK] absent: $pattern" -ForegroundColor Green
    }
}

Write-Host "`n-- Mask peek sizing (manual check) --"
$maskLines = Select-String -Path $LogPath -Pattern "createMaskLeash task:\d+ width:(\d+) height:(\d+)" -AllMatches
$oversized = $maskLines | Where-Object { $_.Line -match "width:3396 height:4837" }
if ($oversized) {
    $fixHits = Select-String -Path $LogPath -Pattern "fixPanoramaMaskAnimRect" -AllMatches
    if ($fixHits) {
        Write-Host "[WARN] createMaskLeash 3396x4837 still logged but fixPanoramaMaskAnimRect ran — verify visual sync" -ForegroundColor Yellow
    } else {
        Write-Host "[FAIL] createMaskLeash 3396x4837 without fixPanoramaMaskAnimRect" -ForegroundColor Red
        $ok = $false
    }
} else {
    Write-Host "[OK] no oversized peek mask (3396x4837)" -ForegroundColor Green
}

$resetDuringPinch = Select-String -Path $LogPath -Pattern "resetAll" -Context 0,5 |
    Where-Object { $_.Context.PostContext -match "onScaleBegin|mScaling:true|502 dummy prepare" }
if ($resetDuringPinch) {
    $blocked = Select-String -Path $LogPath -Pattern "blocked ThreeSplitAnimManager resetAll" -AllMatches
    if ($blocked) {
        Write-Host "[OK] resetAll during pinch was blocked" -ForegroundColor Green
    } else {
        Write-Host "[WARN] resetAll near pinch — check if mid-transition" -ForegroundColor Yellow
    }
} else {
    Write-Host "[OK] no resetAll adjacent to active pinch" -ForegroundColor Green
}

if (-not $ok) { exit 1 }
Write-Host "`nAll automated checks passed." -ForegroundColor Green
