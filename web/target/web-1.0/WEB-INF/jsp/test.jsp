<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>tests</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/test.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="test">
    <c:forEach var="test" items="${allTests}">
        <form id="form" action="answer" method="post">
            <div>${test.name}:${test.id}</div>
            <input name="testName" type="hidden" value="${test.name}">
            <ol>
                <c:forEach var="question" items="${test.questions}">
                    <li>
                            ${question.key}:${question.value.id}
                        <ul>
                            <li>
                                <input name="${question.key}" type="radio"
                                       value="${question.value.rightAnswer}">${question.value.rightAnswer}
                            </li>
                            <c:forEach var="wrong_answer" items="${question.value.wrongAnswers}">
                                <li>
                                    <input name="${question.key}" type="radio" value="${wrong_answer}"> ${wrong_answer}
                                </li>
                            </c:forEach>
                        </ul>

                    </li>
                </c:forEach>
            </ol>
            <input class="json" type="hidden" name="json" value=""/>
            <input type="submit">
        </form>
    </c:forEach>
</div>
<div id="manager">
    TestManager

    <%--Add operations--%>

    <form action="addTest" method="POST">
        <input type="text" name="name" placeholder="name">
        <input type="submit" value="addTest">
    </form>

    <form action="addQuestion" method="POST">
        <input type="text" name="testName" placeholder="testId">
        <input type="text" name="question" placeholder="question">
        <input type="submit" value="addQuestion">
    </form>

    <form action="addRightAnswer" method="post">
        <input type="text" name="questionName" placeholder="questionId">
        <input type="text" name="rightAnswer" placeholder="rightAnswer">
        <input type="submit" value="addRightAnswer">
    </form>

    <form action="addWrongAnswer" method="post">
        <input type="text" name="questionName" placeholder="questionId">
        <input type="text" name="wrongAnswer" placeholder="wrongAnswer">
        <input type="submit" value="addWrongAnswer">
    </form>

    <%--Update operations--%>

    <form action="updateTest" method="POST">
        <input type="text" name="oldTestName" placeholder="oldTest">
        <input type="text" name="newTestName" placeholder="newTest">
        <input type="submit" value="updateTest">
    </form>

    <form action="updateQuestion" method="POST">
        <input type="text" name="oldQuestionName" placeholder="oldQuestionName">
        <input type="text" name="newQuestion" placeholder="newQuestion">
        <input type="submit" value="updateQuestion">
    </form>

    <form action="updateRightAnswer" method="post">
        <input type="text" name="oldRightName" placeholder="oldRightName">
        <input type="text" name="newRightAnswer" placeholder="newRightAnswer">
        <input type="submit" value="updateRightAnswer">
    </form>

    <form action="updateWrongAnswer" method="post">
        <input type="text" name="oldWrongAnswer" placeholder="oldWrongAnswer">
        <input type="text" name="newWrongAnswer" placeholder="newWrongAnswer">
        <input type="submit" value="updateWrongAnswer">
    </form>

    <%--Delete operations--%>

    <form action="deleteTest" method="POST">
        <input type="text" name="name" placeholder="nameTest">
        <input type="submit" value="deleteTest">
    </form>

    <form action="deleteQuestion" method="POST">
        <input type="text" name="name" placeholder="questionName">
        <input type="submit" value="deleteQuestion">
    </form>

    <form action="deleteRightAnswer" method="post">
        <input type="text" name="name" placeholder="rightAnswerName">
        <input type="submit" value="deleteRightAnswer">
    </form>

    <form action="deleteWrongAnswer" method="post">
        <input type="text" name="name" placeholder="wrongAnswerName">
        <input type="submit" value="deleteWrongAnswer">
    </form>

</div>
<div id="result"></div>
<script type="text/javascript">

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined && this.name != "json") {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else if (this.name != "json") {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    $(function () {
        $('form').click(function () {
            $(this).find(".json").val((JSON.stringify($(this).serializeObject())));
          //uncomment to debug javascript
            // return false
        });
    });

</script>
</body>
</html>
