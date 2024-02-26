## Опыты с Camel со Spring-Boot

Запуск
````shell
./mvnw spring-boot:run
````

Настроен Router перемещения файлов из каталога в каталог.

Информация о выполненной опреции выводится в лог:

````text
INFO 25344 --- [testarea/srcDir] route1 : headers: aaa.txt
INFO 25344 --- [testarea/srcDir] route1 : exchange: Exchange[]
INFO 25344 --- [testarea/srcDir] route1 : id: A4568FD9D9A06E8-0000000000000000
INFO 25344 --- [testarea/srcDir] route1 : route id: route1
INFO 25344 --- [testarea/srcDir] route1 : exchange id: A4568FD9D9A06E8-0000000000000000
INFO 25344 --- [testarea/srcDir] route1 : body: aaaaaaaaaaaaaa
INFO 25344 --- [testarea/srcDir] route1 : headers: {CamelFileAbsolute=true, CamelFileAbsolutePath=/home/vasi/temp/testarea/srcDir/aaa.txt, CamelFileLastModified=1708935801149, CamelFileLength=15, CamelFileName=aaa.txt, CamelFileNameConsumed=aaa.txt, CamelFileNameOnly=aaa.txt, CamelFileNameProduced=/home/vasi/temp/testarea/dstDir/aaa.txt, CamelFileParent=/home/vasi/temp/testarea/srcDir, CamelFilePath=/home/vasi/temp/testarea/srcDir/aaa.txt, CamelFileRelativePath=aaa.txt}

````