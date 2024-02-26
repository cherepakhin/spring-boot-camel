## Опыты с Camel со Spring-Boot

Запуск
````shell
./mvnw spring-boot:run
````

### Перемещение файлов из каталога в каталог.

[CopyCatalogRouteBuilder.java](https://github.com/cherepakhin/spring-boot-camel/blob/main/src/main/java/com/codeusingjava/springbootcamel/route/CopyCatalogRouteBuilder.java)

Копируются файлы из tmp/testarea/srcDir в tmp/testarea/dstDir
Информация о выполненной операции выводится в лог:

````text
INFO 25344 --- [testarea/srcDir] route1 : headers: aaa.txt
INFO 25344 --- [testarea/srcDir] route1 : exchange: Exchange[]
INFO 25344 --- [testarea/srcDir] route1 : id: A4568FD9D9A06E8-0000000000000000
INFO 25344 --- [testarea/srcDir] route1 : route id: route1
INFO 25344 --- [testarea/srcDir] route1 : exchange id: A4568FD9D9A06E8-0000000000000000
INFO 25344 --- [testarea/srcDir] route1 : body: aaaaaaaaaaaaaa
INFO 25344 --- [testarea/srcDir] route1 : headers: {CamelFileAbsolute=true, CamelFileAbsolutePath=/tmp/testarea/srcDir/aaa.txt, CamelFileLastModified=1708935801149, CamelFileLength=15, CamelFileName=aaa.txt, CamelFileNameConsumed=aaa.txt, CamelFileNameOnly=aaa.txt, CamelFileNameProduced=/tmp/testarea/dstDir/aaa.txt, CamelFileParent=/tmp/testarea/srcDir, CamelFilePath=/tmp/testarea/srcDir/aaa.txt, CamelFileRelativePath=aaa.txt}

````