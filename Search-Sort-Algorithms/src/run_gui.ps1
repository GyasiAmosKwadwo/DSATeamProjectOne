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

# Create output directory if it doesn't exist
$outputDir = "out\production\Search-Sort-Algorithms"
if (-not (Test-Path $outputDir)) {
    Write-Host "Creating output directory: $outputDir" -ForegroundColor Yellow
    New-Item -ItemType Directory -Path $outputDir -Force | Out-Null
}

# Compile Java files to output directory
Write-Host "Compiling Java files to $outputDir..." -ForegroundColor Yellow
javac -d $outputDir *.java
if ($LASTEXITCODE -ne 0) {
    Write-Host "ERROR: Compilation failed!" -ForegroundColor Red
    Write-Host ""
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host "Compilation successful!" -ForegroundColor Green
Write-Host ""

# Run the GUI application from the output directory
Write-Host "Running DSA Algorithm Visualizer..." -ForegroundColor Green
java -cp $outputDir DSAGui

Write-Host ""
Read-Host "Press Enter to exit"
