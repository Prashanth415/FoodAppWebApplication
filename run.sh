#!/bin/bash

# Download Tomcat 10.1
wget https://archive.apache.org/dist/tomcat/tomcat-10/v10.1.28/bin/apache-tomcat-10.1.28.tar.gz
tar -xzf apache-tomcat-10.1.28.tar.gz
mv apache-tomcat-10.1.28 tomcat

# Remove default ROOT app
rm -rf tomcat/webapps/ROOT

# Copy your WAR file
cp target/FoodAppWebApplication.war tomcat/webapps/ROOT.war

# Start Tomcat
sh tomcat/bin/catalina.sh run



