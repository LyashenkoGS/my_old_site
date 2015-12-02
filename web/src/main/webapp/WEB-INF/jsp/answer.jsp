<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>tests</title>

</head>
<body>
<%--<c:forEach var="test" items="${allTests}">--%>
<form action="answer" method="post">
  <div>${checkedTest.name}</div>
  <ol>

    <li>

      <c:forEach var="question" items="${checkedTest.questions}">
        <div>${question.key}</div>
        <ul>

          <li>
                  ${question.value.answeredRight}
          </li>

        </ul>

      </c:forEach>
    </li>


  </ol>
 <%-- </c:forEach>--%>
  <input type="submit">
</form>

</div>

</body>
</html>

