@echo off
REM Redirect to integrated test session (build + install + log in current terminal).
powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0scripts\test-session.ps1"
