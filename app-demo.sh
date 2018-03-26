#!/bin/bash

appdemo="app-demo"
appversion="1.0-SNAPSHOT"
appname="spring-boot-gradle-demo"
shpath="/home/demo/services"
gitpath="/home/demo/git"

echo "clone git"
cd $gitpath
apprmgitfile=$(rm -rf $appname)
appgit=$(git clone https://github.com/niejuqian/spring-boot-gradle-demo.git)

echo "package file......"
# build file
sourceDir=$(pwd)
echo "current path is $sourceDir"
echo "target path is $gitpath/$appname/$appdemo"
cd $gitpath/$appname/$appdemo
currentDir=$(pwd)
echo "current path is $gitpath/$appname/$appdemo"
echo "current path is $currentDir"
var=$(gradle clean bootRepackage )
res=$(echo ${var} | grep  "BUILD SUCCESSFUL" )
if [ ${#res} -gt 0 ]
then
	cd $shpath
	echo "cd $shpath"
	PID=$(ps -ef | grep $appdemo-$appversion.jar | grep -v grep | awk '{ print $2 }')
	if [ -z "$PID" ]
	then
		echo "The $appdemo server is already stopped"
	else
		echo "The $appdemo stopping......"
		kill -9 $PID
	fi
	
	echo "moving $appdemo application......"
	rm -rf $appdemo*
	cp -r -f $gitpath/$appname/$appdemo/build/libs/$appdemo-$appversion.jar $shpath

	echo "$appdemo server starting......"
	nohup java -jar $appdemo-$appversion.jar --spring.profiles.active=dev > $appdemo.log &
	echo "$appdemo server started"
else
	echo "$appdemo  build is NOT SUCCESS ,exit"
	exit;
fi

exit
