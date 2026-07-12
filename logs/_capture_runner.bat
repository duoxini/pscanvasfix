@echo off
adb wait-for-device
adb logcat -c
echo ===== PsCanvasFix background capture 20260621_124823 =====>> "E:\AndroidStudioProjects\color2\pscanvasfix\logs\pscanvas_20260621_124823.log"
adb logcat -v time PsCanvasFix:D SStoFlexible:D CanvasGestureManager:D FlexibleWindowUtil:D ThreeSplitAnimManager:D LSPosed-Bridge:I AndroidRuntime:E *:S >> "E:\AndroidStudioProjects\color2\pscanvasfix\logs\pscanvas_20260621_124823.log" 2>&1
