@echo off
title = Selenium NODE 3.14.0
export "PATH=%PATH%;/home/jonatan/Documents/Informatorio/grid"
java -jar selenium-server-standalone-3.14.0.jar -role node -nodeConfig node.json
