@echo off
echo Limpando compilacao anterior...
if exist "bin" rmdir /s /q "bin"
mkdir "bin"

echo Compilando o projeto...
:: Ajuste o caminho do JAR se necessario.
set LIB_JAR="libs\mariadb-java-client-3.5.6.jar"

javac -d bin -cp %LIB_JAR%;src -sourcepath src src/br/unimontes/ccet/dcc/pg1/view/TelaPrincipal.java
if %errorlevel% neq 0 (
    echo.
    echo ERRO NA COMPILACAO!
    echo Verifique se o arquivo %LIB_JAR% existe.
    pause
    exit /b %errorlevel%
)

echo Copiando recursos (imagens)...
xcopy /s /y "src\br\unimontes\ccet\dcc\pg1\view\images" "bin\br\unimontes\ccet\dcc\pg1\view\images\"

echo.
echo Executando o projeto...
java -cp bin;%LIB_JAR% br.unimontes.ccet.dcc.pg1.view.TelaPrincipal
pause
