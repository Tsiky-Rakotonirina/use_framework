@echo off
rem deploy-war.bat - copie le .war du projet use_framework/target vers Tomcat webapps
setlocal enabledelayedexpansion

rem dossier du script (se termine par backslash)
set SCRIPT_DIR=%~dp0

rem param 1 (optionnel) : chemin vers le dossier webapps de Tomcat
if "%~1"=="" (
    set TOMCAT_WEBAPPS=C:\Program Files\Apache Software Foundation\Tomcat 11.0\webapps
) else (
    set TOMCAT_WEBAPPS=%~1
)

call :norm "%TOMCAT_WEBAPPS%" TOMCAT_WEBAPPS

rem cherche le war dans target (pattern use-framework*.war)
set WAR=
for %%f in ("%SCRIPT_DIR%target\use-framework*.war") do (
    set WAR=%%~f
)

if "%WAR%"=="" (
    echo [deploy-war] Aucun .war trouve dans "%SCRIPT_DIR%target".
    echo -> Faites d'abord : mvn clean package
    pause
    exit /b 1
)

rem verifie que le dossier cible existe
if not exist "%TOMCAT_WEBAPPS%" (
    echo [deploy-war] Le dossier cible "%TOMCAT_WEBAPPS%" n'existe pas.
    echo Passez le chemin en parametre ou verifiez l'installation de Tomcat.
    echo Exemple: deploy-war.bat "C:\chemin\vers\Tomcat\webapps"
    pause
    exit /b 1
)

rem nom du fichier war (ex: use-framework.war)
for %%F in ("%WAR%") do set "WAR_FILE_NAME=%%~nxF"

rem sauvegarde l'ancien war s'il existe
if exist "%TOMCAT_WEBAPPS%\%WAR_FILE_NAME%" (
    echo [deploy-war] Sauvegarde de l'ancien %WAR_FILE_NAME% -> %WAR_FILE_NAME%.bak
    move /Y "%TOMCAT_WEBAPPS%\%WAR_FILE_NAME%" "%TOMCAT_WEBAPPS%\%WAR_FILE_NAME%.bak" >nul
)

rem nom du dossier exploded (nom du war sans .war)
set "APP_FOLDER_NAME=%WAR_FILE_NAME:.war=%"

if exist "%TOMCAT_WEBAPPS%\%APP_FOLDER_NAME%" (
    echo [deploy-war] Suppression de l'exploded folder "%APP_FOLDER_NAME%"
    rmdir /S /Q "%TOMCAT_WEBAPPS%\%APP_FOLDER_NAME%"
    if errorlevel 1 (
        echo [deploy-war] Attention : impossible de supprimer le dossier explode. Peut-etre Tomcat en cours.
    )
)

echo [deploy-war] Copie de "%WAR%" vers "%TOMCAT_WEBAPPS%\"
copy /Y "%WAR%" "%TOMCAT_WEBAPPS%\" >nul
if errorlevel 1 (
    echo [deploy-war] Echec de la copie. Lancez en tant qu'administrateur.
    pause
    exit /b 1
)

echo [deploy-war] Deploiement reussi.
pause
endlocal
exit /b 0

:norm
rem helper pour normaliser chemin (enleve eventuelles quotes)
set "%2=%~1"
goto :eof
