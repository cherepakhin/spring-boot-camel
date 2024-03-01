## Опыты с Camel со Spring-Boot

Похожий проект [https://github.com/cherepakhin/spring-boot-camel](https://github.com/cherepakhin/spring-boot-camel)

Запуск
````shell
./mvnw spring-boot:run
````

### Перемещение файлов из каталога в каталог.

[CopyCatalogRouteBuilder.java](https://github.com/cherepakhin/spring-boot-camel/blob/main/src/main/java/ru/perm/v/springbootcamel/route/CopyCatalogRouteBuilder.java)

Копируются файлы из __tmp/testarea/srcDir__ в __tmp/testarea/dstDir__.

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

### Перемещение файлов из каталога в НЕСКОЛЬКО каталогов (Multicast).

[MulicastCopyCatalogRouteBuilder.java](https://github.com/cherepakhin/spring-boot-camel/blob/main/src/main/java/ru/perm/v/springbootcamel/route/MulicastCopyCatalogRouteBuilder.java)

````shell
from("file:/tmp/testarea/multicast/srcDir")
				.multicast().to(baseDstDir+"/dstDir1", baseDstDir+"/dstDir2")
````

````text
INFO 13161 --- [ulticast/srcDir] route2                                   : headers: {CamelFileAbsolute=true, CamelFileAbsolutePath=/tmp/testarea/multicast/srcDir/Readme.md, CamelFileLastModified=1709276573100, CamelFileLength=918, CamelFileName=Readme.md, CamelFileNameConsumed=Readme.md, CamelFileNameOnly=Readme.md, CamelFileParent=/tmp/testarea/multicast/srcDir, CamelFilePath=/tmp/testarea/multicast/srcDir/Readme.md, CamelFileRelativePath=Readme.md}

````

Если каталоги не существуют, то ни создаются. __"srcDir"__ при старте приложения, __"dstDir*"__ при выполнении копирования.