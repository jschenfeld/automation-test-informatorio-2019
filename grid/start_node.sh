#/bin/bash
echo Selenium NODE 3.14.0
#export "PATH=$PATH:/home/jonatan.schenfeld/projects/automation-test-informatorio-2019/grid"
java -jar selenium-server-standalone-3.14.0.jar -role node -nodeConfig node.json
