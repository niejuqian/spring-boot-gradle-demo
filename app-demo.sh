#!/bin/bash

appdemo="app-invest"
appversion="1.0.0"
appname="spring-boot-gradle-demo"
shpath="/home/demo/services"
gitpath="/home/demo/git"

echo "clone git"
cd $gitpath
apprmgitfile=$(rm -rf $appname)
appgit=$(git clone https://github.com/niejuqian/spring-boot-gradle-demo.git)

echo "package file......"
# build file
cd $gitpath/$appname/$appinvest
echo "current path is $gitpath/$appname/$appinvest"
var=$(gradle clean bootRepackage )
res=$(echo ${var} | grep  "BUILD SUCCESSFUL" )
if [ ${#res} -gt 0 ]
then
	cd $shpath
	echo "cd $shpath"
	PID=$(ps -ef | grep $appinvest-$appversion.jar | grep -v grep | awk '{ print $2 }')
	if [ -z "$PID" ]
	then
		echo "The $appinvest server is already stopped"
	else
		echo "The $appinvest stopping......"
		kill -9 $PID
	fi
	
	echo "moving $appinvest application......"
	rm -rf $appinvest*
	cp -r -f $gitpath/$appname/$appinvest/build/libs/$appinvest-$appversion.jar $shpath

	echo "$appinvest server starting......"
	nohup java -jar $appinvest-$appversion.jar --spring.profiles.active=dev > $appinvest.log &
	echo "$appinvest server started"
else
	echo "$appinvest  build is NOT SUCCESS ,exit"
	exit;
fi

exit
