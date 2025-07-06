@echo off
cd /d "%~dp0"
echo Starting DSA Algorithm Visualizer...
echo Current directory: %cd%
echo.

REM Check if DSAGui.java exists
if not exist "DSAGui.java" (
    echo ERROR: DSAGui.java not found in current directory!
    echo Please make sure this batch file is in the same directory as your Java files.
    echo.
    pause
    exit /b 1
)

REM Compile the Java files
echo Compiling Java files...
javac *.java
if %errorlevel% neq 0 (
    echo ERROR: Compilation failed!
    echo.
    pause
    exit /b 1
)

REM Run the GUI application
echo Running DSA Algorithm Visualizer...
java DSAGui

pause
