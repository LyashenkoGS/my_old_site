<%--
  Created by IntelliJ IDEA.
  User: Zheka
  Date: 19.12.2015
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/Games/Cross-Zero/style/style.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/Games/Cross-Zero/style/bootstrap.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/Games/Cross-Zero/images/icon.png">
    <title>Cross-Zero</title>
    <script src="${pageContext.request.contextPath}/resources/Games/Cross-Zero/js/myJSFile.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Games/Cross-Zero/js/jquery-2.1.4.js"></script>
</head>

<body>
<div align="center">

    <h1 id="gameName">Cross-Zero</h1>

    <h1 id="zero" hidden="false">Win Zeeeerooooo!!!</h1>

    <h1 id="cross" hidden="false">Win Croooosssss!!!</h1>

    <h1 id="deadHeat" hidden="false">Deadhead!!!</h1>

    <div id="1" class="btn btn-default">

        <p><a href="playFromComputer" class="btn btn-warning">New Game</a></p>

        <p><a href="vis-a-vis" class="btn btn-success">Vis-a-vis</a></p>

        <p><a href="/" class="btn btn-danger">Exit</a></p>

        <div id="outerIdFromTable">
            <table id="block" class="table table-striped table-hover">
                <tr>
                    <td><img class="emptyImage" name="field0" onClick="PlayFromCompute(0)"></td>
                    <td><img class="emptyImage" name="field1" onClick="PlayFromCompute(1)"></td>
                    <td><img class="emptyImage" name="field2" onClick="PlayFromCompute(2)"></td>
                </tr>
                <tr>
                    <td><img class="emptyImage" name="field3" onClick="PlayFromCompute(3)"></td>
                    <td><img class="emptyImage" name="field4" onClick="PlayFromCompute(4)"></td>
                    <td><img class="emptyImage" name="field5" onClick="PlayFromCompute(5)"></td>
                </tr>
                <tr>
                    <td><img class="emptyImage" name="field6" onClick="PlayFromCompute(6)"></td>
                    <td><img class="emptyImage" name="field7" onClick="PlayFromCompute(7)"></td>
                    <td><img class="emptyImage" name="field8" onClick="PlayFromCompute(8)"></td>
                </tr>
            </table>
        </div>
    </div>
    <p>

    <p style="font-style: italic">
        <img src="${pageContext.request.contextPath}/resources/Games/Cross-Zero/images/copyright_c_symbol.png"
             width="20" height="20"> By Zheka 2015
    </p>
</div>
</body>
</html>
