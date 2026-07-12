@echo off
REM Use Cursor integrated terminal: Run Task "PsCanvas: Test" or "PsCanvas: Log only"
powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0scripts\test-session.ps1" -LogOnly
