# Stop adb logcat processes started for PsCanvasFix (integrated terminal / no extra cmd window).
$procs = Get-CimInstance Win32_Process -Filter "Name='adb.exe'" -ErrorAction SilentlyContinue |
    Where-Object { $_.CommandLine -match 'logcat' }
foreach ($proc in $procs) {
    Stop-Process -Id $proc.ProcessId -Force -ErrorAction SilentlyContinue
}
if ($procs) {
    Write-Host "[PsCanvasFix] Stopped $($procs.Count) adb logcat process(es)."
} else {
    Write-Host "[PsCanvasFix] No adb logcat process running."
}
