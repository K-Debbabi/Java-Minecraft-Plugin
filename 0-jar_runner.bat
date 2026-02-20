@echo off
setlocal

REM === Pfade anpassen ===
set PROJECT_DIR=%~dp0
set SERVER_PLUGINS_DIR=C:\Users\karim\Desktop\test_server\plugins

echo [1/3] Build Plugin (Gradle)...
cd /d "%PROJECT_DIR%"
call .\gradlew.bat :app:clean :app:jar
if errorlevel 1 (
  echo Build failed.
  pause
  exit /b 1
)

echo [2/3] Find jar...
set JAR_DIR=%PROJECT_DIR%app\build\libs

REM Nimm die neueste .jar in app\build\libs
for /f "delims=" %%F in ('dir /b /o:-d "%JAR_DIR%\*.jar"') do (
  set JAR_FILE=%%F
  goto :found
)

echo No jar found in %JAR_DIR%
pause
exit /b 1

:found
echo Found: %JAR_FILE%

echo [3/3] Copy to server plugins folder...
copy /y "%JAR_DIR%\%JAR_FILE%" "%SERVER_PLUGINS_DIR%\"
if errorlevel 1 (
  echo Copy failed. Check SERVER_PLUGINS_DIR path.
  pause
  exit /b 1
)

echo Done! Copied to: %SERVER_PLUGINS_DIR%
pause
endlocal