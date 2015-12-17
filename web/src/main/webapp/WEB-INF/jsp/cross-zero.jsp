<%--
  Created by IntelliJ IDEA.
  User: Zheka
  Date: 15.12.2015
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
    <link rel="stylesheet" type="text/css" href="/resources/Games/Cross-Zero/style/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/Games/Cross-Zero/style/bootstrap.css">
    <link rel="shortcut icon" href="/resources/Games/Cross-Zero/images/icon.png">
    <title>Cross-Zero</title>
    <script src="/resources/Games/Cross-Zero/js/myJSFile.js"></script>
    <script src="/resources/Games/Cross-Zero/js/jquery-2.1.4.js"></script>
</head>

<body>
<div align="center">

    <h1 id="gameName">Cross-Zero</h1>

    <h1 id="zero" hidden="false">Win Zeeeerooooo!!!</h1>

    <h1 id="cross" hidden="false">Win Croooosssss!!!</h1>

    <h1 id="deadHeat" hidden="false">Deadhead!!!</h1>

    <div class="btn btn-default">
        <p><a href="cross-zero" class="btn btn-warning">New Game</a></p>

        <p><a href="http://my-visualjava.rhcloud.com/" class="btn btn-danger">Exit</a></p>
        <table id="block" class="table table-striped table-hover">
            <tr>
                <td><img class="emptyImage" name="field0" onClick="Play(0)"></td>
                <td><img class="emptyImage" name="field1" onClick="Play(1)"></td>
                <td><img class="emptyImage" name="field2" onClick="Play(2)"></td>
            </tr>
            <tr>
                <td><img class="emptyImage" name="field3" onClick="Play(3)"></td>
                <td><img class="emptyImage" name="field4" onClick="Play(4)"></td>
                <td><img class="emptyImage" name="field5" onClick="Play(5)"></td>
            </tr>
            <tr>
                <td><img class="emptyImage" name="field6" onClick="Play(6)"></td>
                <td><img class="emptyImage" name="field7" onClick="Play(7)"></td>
                <td><img class="emptyImage" name="field8" onClick="Play(8)"></td>
            </tr>
        </table>
    </div>
    <p>

    <p style="font-style: italic">
        <img src="/resources/Games/Cross-Zero/images/copyright_c_symbol.png" width="20" height="20"> By Zheka 2015
    </p>
</div>
</body>
</html>
