$(document).ready( function () {
    $('#myTable').DataTable();
} );
function goToRoomInfo(){
    var startDate = $('#startDate').val() + "T00:00:00";
    var endDate = $('#endDate').val() + "T00:00:00";
    var nrAdults = $('#nrAdults').val();
    var nrChildren = $('#nrChildren').val();
    var pet = $('#pet').val();
    var remarks = $('#remarks').val();

    $.ajax({
        url: "/api/reservation/add/1",
        type: "post",
        data: JSON.stringify({
            startDate: startDate,
            endDate: endDate,
            nrAdults: nrAdults,
            nrChildren: nrChildren,
            pet: pet,
            remarks: remarks
        }),
        contentType: "application/json",
        success: function (result) {
            window.location.replace("/hotel/guest-reservation-room-options-screen.html");
        },
        error: function(result){
            console.log(result);
        }
    });
}



