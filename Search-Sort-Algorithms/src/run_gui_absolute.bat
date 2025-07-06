@echo off
echo Starting DSA Algorithm Visualizer...
echo.

REM Set the project directory
set PROJECT_DIR=c:\Users\kiba7\OneDrive\Documents\Projects\DSATeamProjectOne\Search-Sort-Algorithms\src

REM Change to project directory
cd /d "%PROJECT_DIR%"

REM Check if we're in the right directory
if not exist "DSAGui.java" (
    echo ERROR: Could not find DSAGui.java in %PROJECT_DIR%
    echo Please check if the project path is correct.
    echo.
    pause
    exit /b 1
)

echo Found Java files in: %cd%
echo.

REM Compile all Java files
echo Compiling Java files...
javac *.java
if %errorlevel% neq 0 (
    echo ERROR: Compilation failed!
    echo.
    pause
    exit /b 1
)

echo Compilation successful!
echo.

REM Run the GUI application
echo Running DSA Algorithm Visualizer...
java DSAGui

pause
