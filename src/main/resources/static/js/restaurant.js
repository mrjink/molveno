console.log("Restaurant reservation javascript loaded")
$(document).ready(function() {
	console.log("Works");
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
        //snelle fix. Probleem is dat DatePicker niet de on change function aanroept..
        sessionStorage.setItem("date", $("#date").val());
        sessionStorage.setItem("time", $("#time").val());
        window.location.href = "/restaurant/reservation/";
    });

    $("#submitReservationBtn").on( "click", function() {
        console.log("Submit reservation!");
        var resAmountOfPeople = $("#amountOfPeople").val();
        var resDate = $("#date").val();
        var resTime = $("#time").val();
        var resName = $("#name").val();
        var resPhone = $("#phone").val();
        var resEmail = $("#email").val();
        var resCourse = $("#course").val();

var form = document.getElementById('restaurantReservationForm');
    for(var i=0; i < form.elements.length; i++){
        if(form.elements[i].value === '' && form.elements[i].hasAttribute('required')){
            //console.log('Some fields are still empty');
            document.getElementById('errorMessage').innerHTML = "Some fields are still empty!";
            //alert('Some fields are still empty');
            return false;
        }
    }
        var json = JSON.stringify({
            amountOfPeople : resAmountOfPeople,
            date: resDate,
            time: resTime,
            user : {
                name: resName,
                phoneNumber: resPhone,
                email: resEmail
                //TODO: Check if there is a table available for that many people and assign it.
                /*
                if amount of people
                is less than max steats
                and table is not occupied at that date.
                compare reservations for that day.
                Get all tables that are insid eof a reservation
                See if there are any remaining tables
                count the amount of seats for each table.
                if seats is less than all max seats for each table combined
                THER is space.

                */
            },
            course: resCourse
        })
        addReservation(json);
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
            window.location.href = "/restaurant/reservation/confirm.html";
        },
        error: function(xhr,ajaxOptions,thrownError){
            console.log("Niet gelukt jammer joh");
            //TODO: fail state should not send to confirm
            window.location.href = "/restaurant/reservation/confirm.html";
//        	alert(xhr.status);
//        	alert(thrownError);
        }
    });
}

    /*
$('.date-picker-2').popover({
    html : true,
    content: function() {
      return $("#example-popover-2-content").html();
    },
    title: function() {
      return $("#example-popover-2-title").html();
    }
});*/
