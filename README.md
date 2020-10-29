# Test Project #
***
## SimbirSoft Java Backend-практикум онлайн
***
### Getting Started
This is my implementation of SibmirSoft online Backend workshop test task.

Technologies used:
  * Spring MVC
  * Spring ORM / Hibernate
  * JSP
  * H2
  * TomCat9 server
  * JSOUP
  ***
  Краткое описание задания:<br>
  Имеется входная строка с адресом web-страницы. Приложение должно скачать
  web-страницу, сохранить ее на жесткий диск. Затем текстовый контент, который есть
  на ней (который видит пользователь на странице браузера), разбивать на слова и
  подсчитывать количество нахождений на странице каждого уникального слова.
  Разделителями слов считать следующие символы: {' ', ',', '.', '!', '?','"', ';', ':', '[', ']', '(', ')', '\n',
  '\r', '\t'}.
  ***
  Гайд по запуску:
  1. Открыть исходный архив в среде разработки IntelliJ IDEA;
  2. Подключить базу данных H2 средствами IntelliJ IDEA с параметрами:<br>
  Connecttion-type: in-memory <br>
  URL: jdbc:h2:mem:test;
  3. Подключить локальный сервер Apache Tomcat средствами IntelliJ IDEA;
  4. Запустить приложение в Apache Tomcat средствами IntelliJ IDEA.