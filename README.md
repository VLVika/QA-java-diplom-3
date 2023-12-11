# QA-java-diplom-3

QA Java Project stellarburgers

Проект UI тестирования Web site https://stellarburgers.nomoreparties.site/ 


В проекте используются следующие библиотеки и плагины:
1. Java 11
2. Junit 4.13.2
3. Maven-compiler-plugin 3.8.1
4. maven-surefire-plugin 2.22.2
5. aspectjweaver 1.9.7
6. allure-maven 2.10.0
7. allure-junit4 2.22.2
8. allure-rest-assured 2.22.2
9. jackson-databind 2.12.5
10. selenium-java 3.141.59
11. rest-assured 4.5.0
12. lombok 1.18.26


Запуск тестов:
1. В файле driver.properties:
 - в key: chromeBinary прописать путь к драйверу Chrome на своем ПК
 - в key: yandexBinary прописать путь к драйверу Yandex на своем ПК
2. Обязательно проверить соответствие Вашей ОС и используемыми драйверами в проекте:
 - В корневой папке проекта лежат exe файлы chromedriver.exe(версия 119.0.6045.105), yandexdriver.exe(версия 23.11.0.2383) для запуска на WIN64
 - Если у Вас другая ОС или 32рязрядный WIN, потребуются соответствующие Вашей ОС драйвера.
 - Либо в файле driver.properties в key: chromeDriver и yandexDriver прописать путь на вашем ПК к exe, установленным у Вас.


Для запуска тестов необходимо выполнить команду mvn clean test