<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 13.12.2015
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/Games/Shooter/style/shooter.css">


  <title>JsShooter</title>
</head>
<body>

<div id="info">
  <div id="countdown"></div>
  <ul id="scores">
    <li>hit:<span id="hit"></span></li>
  </ul>
  <input id="photo" type="file"></br>
  <button id="changePhoto" style="float: right"> changePhoto</button>

</div>
<div class="game_over">
  GAME OVER
  <p>press 'r' to restart</p>
</div>
<div class="win">
  WIN!!
  <p>press 'r' to restart</p>
</div>



<div id="canvas" style="height: 100%">

</div>

<div id="gun" style="position: fixed;
bottom: -15px;
left: 50%;
transform: translate(-50%, 0px);"><img id="gunImg" src="${pageContext.request.contextPath}/resources/Games/Shooter/shooterImg/gun.png"></div>
<script type="text/javascript">
  (function () {
    var win = false
    var move = true
    var numOfHits = 0
    var targets = []

    //constructor for targets
    function Target() {
      var interval
      var plusOrMinus = function(){
        return Math.random() < 0.5 ? -1 : 1};
      var targetVerticalSpeed = plusOrMinus()*(3  + Math.ceil(Math.random() * 2))
      var targetHorizontalSpeed = plusOrMinus() *(7  + Math.ceil(Math.random() * 2))
      var img = document.createElement("img")
      img.src = "${pageContext.request.contextPath}/resources/Games/Shooter/shooterImg/simple_target.png"
      var target = document.createElement("div")
      target.className = "target"
      target.style.left = (Math.random() *  window.innerWidth/1.5) + "px"
      target.style.top = (Math.random() * window.innerHeight/1.5) + "px"
      var canvas = document.getElementById("canvas")
      canvas.appendChild(target)
      target.appendChild(img)

      this.life = 100

      this.changePhoto = function () {
        var photo = document.getElementById("photo")
        var photoName = photo.value
        img.src = photoName.slice(12)
      }

      this.move = function () {
        interval = setInterval(function () {
          targetCollision()
          target.style.top = (parseInt(target.style.top) + targetVerticalSpeed) + "px"
          target.style.left = (parseInt(target.style.left) + targetHorizontalSpeed) + "px"
        }, 33)
      }

      this.stop = function () {
        clearInterval(interval);
      }

      this.hit = function (event) {
        var img = document.createElement("img")
        img.src = "${pageContext.request.contextPath}/resources/Games/Shooter/shooterImg/bullet_hole.png"
        var x = event.clientX;     // Get the horizontal coordinate
        var y = event.clientY;     // Get the vertical coordinate
        if (hitMiss(event)) {
          img.style.left = x - 25 - parseInt(target.style.left) + "px"
          img.style.top = y - 25 - parseInt(target.style.top) + "px"
          img.className = "hole"
          var src = target
          src.appendChild(img)
          this.life -= 10
          targetVerticalSpeed = plusOrMinus()*targetVerticalSpeed*1.1
          targetHorizontalSpeed = plusOrMinus()*targetHorizontalSpeed*1.1
          if (this.life == 0)
            target.style.display = "none";
        }
      }

      function targetCollision() {
        //vertical collision
        if (parseInt(target.style.top) + target.offsetHeight >  window.innerHeight || parseInt(target.style.top) < 0)
          targetVerticalSpeed = -targetVerticalSpeed
        //horizontal collision
        if (parseInt(target.style.left) + target.offsetWidth > window.innerWidth || parseInt(target.style.left) < 0)
          targetHorizontalSpeed = -targetHorizontalSpeed
      }

      function hitMiss(event) {
        var x = event.clientX;     // Get the horizontal coordinate
        var y = event.clientY;     // Get the vertical coordinate
        if (y < parseInt(target.style.top) + target.offsetHeight &&
                y > parseInt(target.style.top) && x > parseInt(target.style.left) && x < parseInt(target.style.left) + target.offsetWidth) {
          numOfHits++
          var hitEl = document.getElementById("hit")
          hitEl.innerHTML = numOfHits
          return true
        }
      }


    }

    //start game
    document.addEventListener("keydown", function () {
      document.getElementsByClassName('game_over')[0].style.display = "none"
      document.getElementsByClassName('win')[0].style.display = "none"
      if (event.keyCode == 82) {
        document.getElementById("canvas").innerHTML = ""
        for (var n = 0; n < 5; n++) {
          targets[n] = new Target()
          targets[n].move()
        }
        timing()
      }
    })

    //shoot
    document.addEventListener("click", function (event) {
      shot()

      var targetsLife=0
      for (var j = 0; j < targets.length; j++) {
        targets[j].hit(event)
        targetsLife+=targets[j].life
        win =( targetsLife == 0)
      }
      if(win)
        winLose()
      console.log(win)
      // winLose()
    })

    //stop - start target
    document.addEventListener("keydown", function (event) {
      if (event.keyCode == 80 && move == false) {
        for (var j = 0; j < targets.length; j++) {
          targets[j].move()
        }
        move = true
      }
      else if(event.keyCode == 80) {
        move = false
        for (var k = 0; k < targets.length; k++) {
          targets[k].stop()
        }
      }
    })

    //change photo
    document.querySelector('#changePhoto').addEventListener("click", function () {
      for (j = 0; j < targets.length; j++) {
        targets[j].changePhoto()
      }
    })


    //rotate gun
    document.onmousemove = function (event) {
      var x = event.clientX;     // Get the horizontal coordinate
      var y = event.clientY;// Get the vertical coordinate
      var newX = (window.innerWidth / 2) - x
      var newY = ( window.innerHeight) - y
      var rad = Math.atan2(newY, newX)
      var degrees = rad * (180 / Math.PI)
      var gun = document.getElementById("gunImg")
      gun.style.transform = 'rotate(' + (degrees - 90) + 'deg)';
    }


    function timing() {
      var t = 20
      var timer = setInterval(function () {
        var countdown = document.getElementById("countdown")
        countdown.textContent = t+"s"
        t -= 1
        if (t == 0) {
          clearInterval(timer)
          countdown.textContent = "time finished"
          winLose()
        }
        if (win){
          clearInterval(timer)
        }
      }, 1000)
    }


    function winLose() {
      //lose
      if (!win) {
        document.getElementsByClassName('game_over')[0].style.display = "block"
      }
      //win
      else {
        document.getElementsByClassName('win')[0].style.display = "block"
      }
    }


    function shot() {
      var audio = new Audio('${pageContext.request.contextPath}/resources/Games/Shooter/sounds/gun-gunshot-01.mp3')
      audio.play();
      var gun = document.getElementById("gun")
      gun.style.bottom = parseInt(gun.style.bottom) + 20 + "px"
      setTimeout(function () {
        gun.style.bottom = parseInt(gun.style.bottom) - 20 + "px"
      }, 100);
    }


  })();

</script>

</body>
</html>

