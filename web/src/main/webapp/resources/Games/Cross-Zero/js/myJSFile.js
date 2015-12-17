var numOfClicks = 0;

var cross = new Image(64, 64);
cross.src = "/resources/Games/Cross-Zero/images/cross.png";
var zero = new Image(64, 64);
zero.src = "/resources/Games/Cross-Zero/images/zero.png";

var cell = new Array(9);
for (var i = 0; i < 9; i++) {
    cell[i] = 0;
}

function Play(value) {
    if (cell[value] == 0) {
        if (numOfClicks % 2 == 1) {
            numOfClicks++;
            Zero(value);
            cell[value] = 1;
            if (CheckVictoryZero() == true) {
                $("#zero").show();
                $("#outerIdFromTable").slideUp("slow");
            }
        } else if (numOfClicks % 2 == 0) {
            numOfClicks++;
            Cross(value);
            cell[value] = 1;
            if (CheckVictoryCross() == true) {
                $("#cross").show();
                $("#outerIdFromTable").slideUp("slow");
            }
        }
        $(DeadHead());
    }
}

function DeadHead() {
    var check = false;
    for (i = 0; i < 9; i++)
        if (cell[i] == 0)
            check = true;
    if (check == false && CheckVictoryCross() != true
        && CheckVictoryZero() != true) {
        $("#deadHeat").show();
    }
};

function Cross(value) {
    if (value == 0) document.field0.src = cross.src;
    if (value == 1) document.field1.src = cross.src;
    if (value == 2) document.field2.src = cross.src;
    if (value == 3) document.field3.src = cross.src;
    if (value == 4) document.field4.src = cross.src;
    if (value == 5) document.field5.src = cross.src;
    if (value == 6) document.field6.src = cross.src;
    if (value == 7) document.field7.src = cross.src;
    if (value == 8) document.field8.src = cross.src;
}

function Zero(value) {
    if (value == 0) document.field0.src = zero.src;
    if (value == 1) document.field1.src = zero.src;
    if (value == 2) document.field2.src = zero.src;
    if (value == 3) document.field3.src = zero.src;
    if (value == 4) document.field4.src = zero.src;
    if (value == 5) document.field5.src = zero.src;
    if (value == 6) document.field6.src = zero.src;
    if (value == 7) document.field7.src = zero.src;
    if (value == 8) document.field8.src = zero.src;
}

function CheckVictoryCross() {
    if (document.field0.src == cross.src && document.field1.src == cross.src
        && document.field2.src == cross.src) return true;
    if (document.field3.src == cross.src && document.field4.src == cross.src
        && document.field5.src == cross.src) return true;
    if (document.field6.src == cross.src && document.field7.src == cross.src
        && document.field8.src == cross.src) return true;
    if (document.field0.src == cross.src && document.field3.src == cross.src
        && document.field6.src == cross.src) return true;
    if (document.field1.src == cross.src && document.field4.src == cross.src
        && document.field7.src == cross.src) return true;
    if (document.field2.src == cross.src && document.field5.src == cross.src
        && document.field8.src == cross.src) return true;
    if (document.field0.src == cross.src && document.field4.src == cross.src
        && document.field8.src == cross.src) return true;
    if (document.field2.src == cross.src && document.field4.src == cross.src
        && document.field6.src == cross.src) return true;
}

function CheckVictoryZero() {
    if (document.field0.src == zero.src && document.field1.src == zero.src
        && document.field2.src == zero.src) return true;
    if (document.field3.src == zero.src && document.field4.src == zero.src
        && document.field5.src == zero.src) return true;
    if (document.field6.src == zero.src && document.field7.src == zero.src
        && document.field8.src == zero.src) return true;
    if (document.field0.src == zero.src && document.field3.src == zero.src
        && document.field6.src == zero.src) return true;
    if (document.field1.src == zero.src && document.field4.src == zero.src
        && document.field7.src == zero.src) return true;
    if (document.field2.src == zero.src && document.field5.src == zero.src
        && document.field8.src == zero.src) return true;
    if (document.field0.src == zero.src && document.field4.src == zero.src
        && document.field8.src == zero.src) return true;
    if (document.field2.src == zero.src && document.field4.src == zero.src
        && document.field6.src == zero.src) return true;
}