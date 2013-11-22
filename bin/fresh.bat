@echo off

call mvn clean
call mvn package
set PORT=5000
java -jar target\Kumalo-1.0-SNAPSHOT-jar-with-dependencies.jar
