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

REM Create output directory if it doesn't exist
set OUTPUT_DIR=out\production\Search-Sort-Algorithms
if not exist "%OUTPUT_DIR%" (
    echo Creating output directory: %OUTPUT_DIR%
    mkdir "%OUTPUT_DIR%"
)

REM Compile the Java files to the output directory
echo Compiling Java files to %OUTPUT_DIR%...
javac -d "%OUTPUT_DIR%" *.java
if %errorlevel% neq 0 (
    echo ERROR: Compilation failed!
    echo.
    pause
    exit /b 1
)

echo Compilation successful!
echo.

REM Run the GUI application from the output directory
echo Running DSA Algorithm Visualizer...
java -cp "%OUTPUT_DIR%" DSAGui

pause
