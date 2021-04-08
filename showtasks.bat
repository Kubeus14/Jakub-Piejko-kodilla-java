call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo Create script from m21.4.
goto fail


:browser
explorer  "http://localhost:8080/crud/v1/task/getTasks"
timeout 30
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Problem with creating script.
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished