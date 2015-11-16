<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>tests</title>
    <link href="${pageContext.request.contextPath}/resources/test.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="test">
<c:forEach var="test" items="${allTests}">
<form action="answer" method="post">
    <div>${test.name}</div>
    <ol>

        <li>

            <c:forEach var="question" items="${test.questions}">
                <div>${question.key}</div>
                <ul>
                    <li>
                        <input name="${question.key}" type="radio"
                               value="${question.value.rightAnswer}">${question.value.rightAnswer}
                    </li>
                    <c:forEach var="wrong_answer" items="${question.value.answers}">
                        <li>
                            <input name="${question.key}" type="radio" value="${wrong_answer}"> ${wrong_answer}
                        </li>
                    </c:forEach>
                </ul>

            </c:forEach>
        </li>


    </ol>
    </c:forEach>
    <input type="submit">
</form>

</div>
<div id="manager">
    TestManager
    <form action="addTest">
        <input type="text" name="name" placeholder="name">
        <input type="submit" value="addTest">
    </form>

    <form action="addQuestion">
        <input type="text" name="testName" placeholder="testName">
        <input type="text" name="question" placeholder="question">
        <input type="submit" value="addQuestion" >
    </form>

    <form action="addRightAnswer">
        <input type="text" name="questionName" placeholder="questionName">
        <input type="text" name="rightAnswer" placeholder="rightAnswer">
        <input type="submit" value="addRightAnswer" >
    </form>

    <form action="addWrongAnswer">
        <input type="text" name="questionName" placeholder="questionName">
        <input type="text" name="wrongAnswer" placeholder="wrongAnswer">
        <input type="submit" value="addWrongAnswer" >
    </form>

</div>

</body>
</html>
