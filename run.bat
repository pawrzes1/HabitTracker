@echo off
chcp 65001 > nul
cd src
javac *.java
if %errorlevel% neq 0 (
    echo Błąd kompilacji!
    pause
    exit /b
)
java Main
pause
