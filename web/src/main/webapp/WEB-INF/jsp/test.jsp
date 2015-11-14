<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>tests</title>

</head>
<body>
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

</body>
</html>
