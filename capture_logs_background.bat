@echo off
echo [PsCanvasFix] Background capture is deprecated.
echo [PsCanvasFix] Use Cursor: Terminal -^> Run Task -^> "PsCanvas: Test (build + install + log)"
echo [PsCanvasFix] Logs write to logs\pscanvas_latest.log (auto-cleared each run).
powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0scripts\test-session.ps1" -LogOnly
