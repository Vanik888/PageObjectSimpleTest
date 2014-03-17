
перед стартом тестов запустить хаб и ноды
использовался selenium-server-standalone-2.40.0.jar
1) java -jar selenium-server-standalone-2.40.0.jar -role hub
2) java -jar selenium-server-standalone-2.40.0.jar -role node  -hub http://localhost:4444/grid/register

