@echo off
REM Arquivo batch para rodar a CLI
set JAR=target\FileManagerCLI.jar

if not exist %JAR% (
    echo Erro: %JAR% não encontrado. Compile o projeto antes de executar.
    exit /b 1
)

java -jar %JAR% %*
