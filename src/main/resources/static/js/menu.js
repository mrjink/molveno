//$(document).ready(function() {
//    getMenus();
//});

        function getDataWeb (menu) {

            $.ajax({
            url: "http://localhost:8080/api/restaurant/menuitem/all",
            type: "get",
            success: function (result) {
                console.log(result);
                $('#menu').html("<tr><th>Breakfast</th><th>Description</th><th>Price</th></tr>");
                $.each(result, function (index, menuItem) {

                    var tr = $("<tr></tr>");
                    var name = $("<td></td>").text(menuItem.name);
                    var description= $("<td></td>").text(menuItem.description);
                     var price= $("<td></td>").text("$"+menuItem.price);
                    var category= $("<td></td>").text(menuItem.category);
                    var order = $("<td></td>").text("Order").click(function () {
                        orderItem(menuItem.id)                    });
                    tr.append(name, description, price );
                    ((menuItem.category==menu)? $('#menu').append(tr): '')
                });
            },
            error: function (result) {
                console.log(result);
                $('#menu').html(result.responseText);
            }
        });
        };



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