## Camel + Spring-Boot

Похожий проект [https://github.com/cherepakhin/spring-boot-camel](https://github.com/cherepakhin/spring-boot-camel)

Зависимости maven в pom.xml:

````xml
<dependency>
    <groupId>org.apache.camel.springboot</groupId>
    <artifactId>camel-spring-boot-starter</artifactId>
    <version>3.8.0</version>
</dependency>
<dependency>
    <groupId>org.apache.camel.springboot</groupId>
    <artifactId>camel-spring-boot-dependencies</artifactId>
    <version>4.3.0</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>

````

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

log при копировании:

````text
INFO 16908 --- [ulticast/srcDir] route2                                   : headers: testfile.txt
INFO 16908 --- [ulticast/srcDir] route2                                   : exchange: Exchange[]
INFO 16908 --- [ulticast/srcDir] route2                                   : id: 02C05B4CFB394DC-0000000000000001
INFO 16908 --- [ulticast/srcDir] route2                                   : route id: route2
INFO 16908 --- [ulticast/srcDir] route2                                   : exchange id: 02C05B4CFB394DC-0000000000000002
INFO 16908 --- [ulticast/srcDir] route2                                   : headers: {CamelFileAbsolute=true, CamelFileAbsolutePath=/tmp/testarea/multicast/srcDir/testfile.txt, CamelFileLastModified=1709278001061, CamelFileLength=5, CamelFileName=testfile.txt, CamelFileNameConsumed=testfile.txt, CamelFileNameOnly=testfile.txt, CamelFileParent=/tmp/testarea/multicast/srcDir, CamelFilePath=/tmp/testarea/multicast/srcDir/testfile.txt, CamelFileRelativePath=testfile.txt}
````

Если каталоги не существуют, то ни создаются. __"srcDir"__ при старте приложения, __"dstDir*"__ при выполнении копирования.