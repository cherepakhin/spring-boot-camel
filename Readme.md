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
[testarea/srcDir] route1 : headers: bbb.txt
[testarea/srcDir] route1 : exchange: Exchange[]
[testarea/srcDir] route1 : id: F51398C05B58DB8-0000000000000005
[testarea/srcDir] route1 : route id: route1
[testarea/srcDir] route1 : exchange id: F51398C05B58DB8-0000000000000005
[testarea/srcDir] route1 : body: aaaaa
[testarea/srcDir] route1 : headers: {CamelFileAbsolute=true, CamelFileAbsolutePath=/tmp/testarea/srcDir/bbb.txt, 
CamelFileLastModified=1708942640944, CamelFileLength=6, CamelFileName=bbb.txt, CamelFileNameConsumed=bbb.txt,
CamelFileNameOnly=bbb.txt, CamelFileNameProduced=/tmp/testarea/dstDir/bbb.txt,
CamelFileParent=/tmp/testarea/srcDir, CamelFilePath=/tmp/testarea/srcDir/bbb.txt, CamelFileRelativePath=bbb.txt}

````