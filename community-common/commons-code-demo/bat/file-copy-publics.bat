@echo off
setlocal enabledelayedexpansion
rem for  %%m in (Address AddressUserRelation Cart CartpublicsRelation Category publics publicsPublicsRelation Gorder GorderpublicsRelation Provider ProviderPublicsRelation Tags TagspublicsRelation TagsPublicsRelation) do ( 

for  %%m in ( AddressProjectRelation  PublicsProjectRelation) do ( 
set model=%%m
set modelFile=!model!.java
echo modelFile is !modelFile!

set serviceFile=!model!Service.java
set clientFile=!model!SCAClient.java
set implFile=!model!ServiceImpl.java
set daoConfigFile=!model!_dao.xml
set testFile=!model!Test.java

set sourcePath=E:\java_web\workspace\wx-community\community-common\commons-code-demo
set coreProjectPath=E:\java_web\workspace\wx-community\community-framework\framework-publics-core
set serviceProjectPath=E:\java_web\workspace\wx-community\community-framework\framework-publics-service

set modelPath=src\main\java\com\qding\framework\publics\model
set servicePath=src\main\java\com\qding\framework\publics\service
set clientPath=src\main\java\com\qding\sca\framework\publics\client
set implPath=src\main\java\com\qding\framework\publics\service\impl
set daoConfigPath=src\main\resources
set testPath=src\test\java\com\qding\framework\publics\service\impl

echo "model" !sourcePath!\!modelPath!\!modelFile! !coreProjectPath!\!modelPath!
copy !sourcePath!\!modelPath!\!modelFile! !coreProjectPath!\!modelPath! /y
echo "service"
copy !sourcePath!\!servicePath!\!serviceFile! !coreProjectPath!\!servicePath! /y
echo "client"
copy !sourcePath!\!clientPath!\!clientFile! !coreProjectPath!\!clientPath! /y
echo "impl"
copy !sourcePath!\!implPath!\!implFile! !serviceProjectPath!\!implPath! /y
echo "daoConfig"
copy !sourcePath!\!daoConfigPath!\!daoConfigFile! !serviceProjectPath!\!daoConfigPath! /y
echo "test" !sourcePath!\!testPath!\!testFile! !serviceProjectPath!\!testPath!
copy !sourcePath!\!testPath!\!testFile! !serviceProjectPath!\!testPath! /y



) 

echo "all copy over check it"
pause