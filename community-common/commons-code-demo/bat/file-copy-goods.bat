@echo off
setlocal enabledelayedexpansion
rem for  %%m in (Address AddressUserRelation Cart CartGoodsRelation Category Goods GoodsPublicsRelation Gorder GorderGoodsRelation Provider ProviderPublicsRelation Tags TagsGoodsRelation TagsPublicsRelation) do ( 

for  %%m in (Gorder) do ( 
set model=%%m
set modelFile=!model!.java
echo modelFile is !modelFile!

set serviceFile=!model!Service.java
set clientFile=!model!SCAClient.java
set implFile=!model!ServiceImpl.java
set daoConfigFile=!model!_dao.xml
set testFile=!model!Test.java

set sourcePath=E:\java_web\workspace\wx-community\community-common\commons-code-demo
set coreProjectPath=E:\java_web\workspace\wx-community\community-app\app-goods-core
set serviceProjectPath=E:\java_web\workspace\wx-community\community-app\app-goods-service

set modelPath=src\main\java\com\qding\app\goods\model
set servicePath=src\main\java\com\qding\app\goods\service
set clientPath=src\main\java\com\qding\sca\app\goods\client
set implPath=src\main\java\com\qding\app\goods\service\impl
set daoConfigPath=src\main\resources
set testPath=src\test\java\com\qding\app\goods\service\impl

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