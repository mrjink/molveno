$(document).ready(function() {
    getIngredients();
});

        function getDataIngredient (ingredientSuppliers) {

            $.ajax({
            url: "http://localhost:8080/api/restaurant/.../all",
            type: "get",
            success: function (result) {
                console.log(result);
                //$('#').html("<tr><th>Breakfast</th><th>Description</th><th>Price</th></tr>");
                $.each(result, function (index, menuItem) {

                    var tr = $("<tr></tr>");
                    var supplier = $("<td></td>").text(menuItem.name);
                    var ingredient = $("<td></td>").text(menuItem.description);
                     var price= $("<td></td>").text(menuItem.price);
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