@echo off
title = Selenium HUB 3.14.0
export "PATH=$PATH:/path/to/your/driver/binaries"
java -jar selenium-server-standalone-3.14.0.jar -role hub -hubConfig hub.json
