$(document).ready(function() {
    //Controleren of sessies worden ondersteund door de browser.
    var sessionAllowed = typeof(Storage) !== "undefined" ? true : false;

    if(sessionAllowed){
        //Zodra pagina is geladen velden vullen met eerder ingevulde waardes.
        $.each(sessionStorage, function(key, value){
            console.log("value found, " + key + " - " + value);
            $("#" + key).val(value);
        });

        //bij wijzigingen in een input veld deze lokaal bijwerken in de sessie.
        $("input, select").on( "change", function() {
            sessionStorage.setItem($(this).attr('id'), $(this).val());
        });
    }


    $("#startReservationProcressBtn").on( "click", function() {
        window.location.href = "/reservation/restaurant/index.html";
    });

    $("#submitReservationBtn").on( "click", function() {
        var amountOfPeople = $("#amountOfPeople").val();
        var date = $("#date").val();
        var time = $("#time").val();
        var name = $("#name").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var course = $("#course").val();

        var json = JSON.stringify("???");

        addReservation(json)
    });
});

function addReservation(json){
    $.ajax ({
        url: "/api/restaurant/reservation/add",
        type: "POST",
        data: json,
        dataType: "json",
        contentType: "application/json;",
        success: function(){
            console.log("Het is gelukt.., toch?");
        }
    });
}
