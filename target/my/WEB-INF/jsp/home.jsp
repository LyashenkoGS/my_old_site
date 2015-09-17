<!doctype html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>VirtualJava</title>

    <!--Material design bootstrap-->
    <link href="/resources/bootstrap.css" rel="stylesheet" type="text/css">

    <script src="<c:url value='http://code.jquery.com/jquery-2.1.4.min.js' />"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="<c:url value='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'/>"></script>

    <!--Custom style sheet-->
    <link href="/resources/custom_style.css" rel="stylesheet" type="text/css">
    <style>
        a {
            text-decoration: none; /* Отменяем подчеркивание у ссылки */
        }
    </style>
</head>

<body>
<div id="wrapper">

    <h2>VisualJava</h2>

    <p>студенческий проект об алгоритмах, структурах данных и программировании на java</p>


    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">TODO</h3>
        </div>
        <div class="panel-body">
            <table border="1" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>TODO</th>
                    <th>Исполнитель</th>
                </tr>
                <c:forEach items="${todo}" var="entry">
                    <tr>
                        <td>${entry.id}</td>
                        <td>${entry.todo}</td>
                        <td>${entry.name}</td>
                    </tr>
                </c:forEach>
            </table>

            <form method="post" ACTION="addTodo">
                <input type="text" name="TODO" placeholder="TODO">
                <input type="text" name="name" placeholder="Исполнитель">
                <input type="submit" value="ADD TODO">
            </form>

            <form method="post" ACTION="addTodo">
                <input type="text" name="id" placeholder="ID">
                <input type="text" name="TODO" placeholder="TODO">
                <input type="text" name="name" placeholder="Исполнитель">
                <input type="submit" value="UPDATE TODO">
            </form>


            <form method="post" ACTION="delTodo">
                <input type="text" name="ID" placeholder="Id">
                <input type="submit" value="DEL TODO">
            </form>
        </div>
    </div>

    <table class="table table-striped table-hover ">
        <thead>
        <caption><h1>Menu</h1></caption>
        <thead bgcolor="#99FFFF" align="center">
        <tr class="success">
            <th class=cell-1><h1>Java</h1></th>
            <th class="cell-1"><h1>Web</h1></th>
            <th class="cell-1"><h1>Frameworks</h1></th>
        </tr>
        </thead>
        </thead>
        <tbody>
        <tr class="active">
            <td class="column-1">
                <div><a href=""><h1><img src="/resources/img/17.jpg" width="40" height="40" align="left">Collection API
                </h1></a></div>
            </td>
            <td class="column-1">
                <div><a></a><a href=""><h1><img src="/resources/img/http.jpg" width="40" height="40" align="left">HTTP
                    протокол</h1></a></div>
            </td>
            <td class="column-1">
                <div><a href="">
                    <h1><h1><img src="/resources/img/hiber.png" width="40" height="40" align="left">Hibernate</h1>
                </a></div>
            </td>
        </tr>
        <tr class="active">
            <td class="column-1">
                <h1>
                    <div><a href=""><h1><img src="/resources/img/jdbc.jpg" width="40" height="40" align="left">JDBC</h1>
                    </a></div>
                </h1>
            </td>
            <td class="column-1">
                <div><a href=""><h1><img src="/resources/img/html.png" width="40" height="40" align="left">HTML/CSS</h1>
                </a></div>
            </td>
            <td class="column-1"><a href="">
                <h1><h1><img src="/resources/img/spring.png" width="40" height="40" align="left">Spring</h1>
            </a>
</div>
</td>
</tr>
<tr class="active">
    <td class="column-1">
        <h1>
            <div><a><h1><img src="/resources/img/17.jpg" width="40" height="40" align="left">String</h1></a></div>
        </h1>
    </td>
    <td class="column-1">
        <div><a href="">
            <h1><h1><img src="/resources/img/17.jpg" width="40" height="40" align="left">Servlet API</h1>
        </a></div>
    </td>
    <td class="column-1">
        <div><a href="">
            <h1><h1><img src="/resources/img/junit.jpg" width="40" height="40" align="left">Junit</h1>
        </a></div>
    </td>
</tr>
</tbody>
</table>

<div class="panel panel-default">
    <div class="panel-body">
        <h2 class="sub-title">Инструменты</h2>
        <ul>
            <li>работаем только через Intellije Idea Ultimate 14!!
            </li>
            <li>jdk1.7.0_79
                <a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html">http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html</a>
            </li>
            <li>макеты - Photoshop 2014CC и Illustrator 2014CC
            </li>
            <li>CSS для Bootstrap отсюда
                <a href="https://bootswatch.com/darkly/">https://bootswatch.com/darkly/</a>
            </li>
            <li>Здесь ,возможно, стоит написать что-то еще...</li>
            <li><a href="../../id_rsa.pub"> публичный ключ </a></li>
            <li><a href="../../id_rsa"> приватный ключ </a></li>
            <li>
                Git URL: ssh://55edf4792d527192a300014a@my-visualjava.rhcloud.com/~/git/my.git/
            </li>
        </ul>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-body">
        <h2> Концепция сайта -
            простой open-source студенческий проект</h2>

        <ul>
            <li>цель проекта :качественно освоить и визуализировать java core + enterpraise + БД + популярные
                фреймворки,ООП , алгоритмы и структуры данных
            </li>
            <li>создать базу тестов по самым популярным вопросам на собеседованиях на java junior за основу взять <a
                    href="http://www.quizful.net/test">http://www.quizful.net/test</a></li>
            <li>интерактивное отображение самых популярных алгоритмов и структур данных. За основу взят <a
                    href="http://visualgo.net/">http://visualgo.net/</a></li>
            <li>сайт должен быть минималистичным, интуитивно понятным и подозрительно похожим на <a
                    href="http://www.google.com.ua/design/spec/material-design/introduction.html">http://www.google.com.ua/design/spec/material-design/introduction.html</a>
            </li>

            <li> бекенд подозрительно похож на
                <a href="https://github.com/spring-projects/spring-petclinic">https://github.com/spring-projects/spring-petclinic></a>
            </li>

            <a href="http://www.google.com.ua/design/spec/material-design/introduction.html">http://www.google.com.ua/design/spec/material-design/introduction.html</a>
            </li>
            <li>освоить популярные web технологии и основы веб-дизайна\верстки</li>
            <li>сформировать матерую комманду девелоперов</li>
            <li>попробовать различные методологии разработки agile/scrum/xp и т.д</li>
            <li>увеличить продуктивность обучения и работы каждого члена комманды</li>
            <li>выработать навыки тайм-менеджмента</li>
            <li>научиться писать и поддерживать "чистый код" покрытый тестами</li>
            <li>получить первый практический опыт разработки</li>
            <li>указать ссылку на проект в резюме и увеличить вероятность успешного трудоустройства</li>
            <li>устроиться на java junior в кратчайшие сроки</li>
        </ul>
    </div>
</div>

<footer>


    2015
</footer>
</div>
<!--End wrapper-->
</body>

</html>
