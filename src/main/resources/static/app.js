var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#history").show();
    }
    else {
        $("#history").hide();
    }
    $("#actions").html("");
}

function connect() {
    var socket = new SockJS('/demo-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/message/actions', function (action) {
            showAction(JSON.parse(action.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendPerson() {
	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();
	var age = $("#age").val();
    stompClient.send("/app/insert", {}, JSON.stringify({'firstName': firstName, 'lastName': lastName, 'age': age}));
}

function showAction(action) {
    $("#actions").append("<tr><td>" + action + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendPerson(); });
});