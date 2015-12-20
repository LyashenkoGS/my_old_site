<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>tests</title>

</head>
<body>

<div> ${testEntity.name}</div>
      <c:forEach var="question" items="${testEntity.questions}">
        <div>${question.key}</div>
        <ul>

          <li>
                  ${question.value.answeredRight}
          </li>

        </ul>

      </c:forEach>



</div>

</body>
</html>

