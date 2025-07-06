@echo off
cd /d "%~dp0"
echo Starting DSA Algorithms Console...
echo Current directory: %cd%
echo.

REM Check if Main.java exists
if not exist "Main.java" (
    echo ERROR: Main.java not found in current directory!
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

REM Run the console application from the output directory
echo Running DSA Algorithms Console...
java -cp "%OUTPUT_DIR%" Main

pause
