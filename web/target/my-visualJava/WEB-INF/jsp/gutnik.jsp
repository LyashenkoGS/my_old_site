<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 03.12.2015
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
  <title>tests</title>
  <link href="${pageContext.request.contextPath}/resources/gutnikData/happy.jpg" rel="stylesheet" type="text/css">
</head>
<body>

<img class="happy" id="gutnik_image" src="${pageContext.request.contextPath}/resources/gutnikData/happy.jpg" onclick="myFunction()">
<img style="vertical-align: top" id="coackroach" src="">
<script>

  function myFunction() {
    var img=document.getElementById('gutnik_image')
    var coackroach=document.getElementById('coackroach')
    //alert("hi i'm Gutnik strongest man of the world!!")
    if(img.className=='happy'){
      img.src='${pageContext.request.contextPath}/resources/gutnikData/sad.jpg'
      img.className = 'sad'
      coackroach.src='${pageContext.request.contextPath}/resources/gutnikData/couckroach.jpg'
    }
    else{
      img.src='${pageContext.request.contextPath}/resources/gutnikData/happy.jpg'
      img.className = 'happy'
      coackroach.src=''
    }

    var img = null;
    var audio = new Audio;
    audio.src="${pageContext.request.contextPath}/resources/gutnikData/gutnik_happy.ogg"
    audio.autoplay=true

  }

</script>
