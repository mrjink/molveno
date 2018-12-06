$(document).ready(function() {
    getMenus();
});

function getMenus(){
    $.get("/api/restaurant/menu/all", function(data, status){
        console.log(data);
        $.each(data, function(index, menu){
            watched = movie.watched == true ? "Yes" : "No";
            output += "<tr id='+ count + '><td>" + movie.name + "</td><td>" + watched + "</td></tr>";
            count++;
        })
        output += "</tbody></table>";
        $("#moviesList").html(output);

    })
        .done(function() {
            // $('#movieTable').DataTable();
            // console.log("second success");
        })
        .fail(function() {
            alert("error");
        })
        .always(function() {
            // console.log("finished");
        });
}