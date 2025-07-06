# PowerShell script to run DSA Algorithm Visualizer
Write-Host "Starting DSA Algorithm Visualizer..." -ForegroundColor Green
Write-Host ""

# Get the directory where this script is located
$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $scriptDir

# Check if DSAGui.java exists
if (-not (Test-Path "DSAGui.java")) {
    Write-Host "ERROR: DSAGui.java not found in current directory!" -ForegroundColor Red
    Write-Host "Current directory: $(Get-Location)" -ForegroundColor Yellow
    Write-Host "Please make sure this script is in the same directory as your Java files." -ForegroundColor Yellow
    Write-Host ""
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host "Found Java files in: $(Get-Location)" -ForegroundColor Green
Write-Host ""

# Compile Java files
Write-Host "Compiling Java files..." -ForegroundColor Yellow
javac *.java
if ($LASTEXITCODE -ne 0) {
    Write-Host "ERROR: Compilation failed!" -ForegroundColor Red
    Write-Host ""
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host "Compilation successful!" -ForegroundColor Green
Write-Host ""

# Run the GUI application
Write-Host "Running DSA Algorithm Visualizer..." -ForegroundColor Green
java DSAGui

Write-Host ""
Read-Host "Press Enter to exit"
