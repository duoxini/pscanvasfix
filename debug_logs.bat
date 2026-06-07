@echo off
adb logcat -c
adb logcat -v time PsCanvasFix:D SStoFlexible:D CanvasGestureManager:D FlexibleWindowUtil:D AndroidRuntime:E *:S
