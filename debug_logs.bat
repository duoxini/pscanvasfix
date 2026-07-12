@echo off
powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0scripts\test-session.ps1" -LogOnly
