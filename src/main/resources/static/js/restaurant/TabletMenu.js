

function PlaceOrder() {
    confirm("Do you want to place this order?");
}
    
 
function AddToBill() {
    confirm("Do you want to add this receipt to your Hotel Bill?");
}

function Pay() {
    confirm("Do you want to pay the bill now?");
}

var orderList=[];
 function getDataTablet () {
 console.log(orderList)
            $.ajax({
            url: "http://localhost:8080/api/restaurant/menuitem/all",
            type: "get",
            success: function (result) {
                console.log(result);

                $.each(result, function (index, menuItem) {

                    var tr = $("<tr id=\"row\" ></tr>");
                    var name = $("<td id=\""+index+"1\"></td>").text(menuItem.name);
                    var description= $("<td></td>").text(menuItem.description);
                     var price= $("<td id=\""+index+"2\"></td>").text("$"+menuItem.price);
                   
                    var amount = $("<td>").append("<input id=\""+index+"\" type=\"number\" min=\"0\" max=\"12\" class=\"form-control\"  name=\"amount\"></td>");
                    // var order = $("<td>").append("<button onclick=\"orderItem(menuItem);\" class=\"btn-primary\">Order</button></td>").click(orderItem(menuItem)  );
                    var order = $("<td>").append("<button type='button' id=\"0"+index+"\" onclick=\"orderItem(this.id)\" class=\"iAddbutton\">Order</button></td>");

                    tr.append(name, description, price, amount, order );

                    ((menuItem.category=="BREAKFAST")? $('#Breakfast-menu').append(tr): '');
                    ((menuItem.category=="LUNCH")? $('#Lunch-menu').append(tr): '');
                    ((menuItem.category=="DINNER")? $('#Dinner-menu').append(tr): '');
                    ((menuItem.category=="DESERT")? $('#Desert-menu').append(tr): '');
                     ((menuItem.category=="DRINKS")? $('#Drinks-menu').append(tr): '');
                });
                $(function() {
                  $(document ).on("click","#rowMenu button.iAddbutton",function() {
                    let tr = $(this).closest('tr');
                    let a = tr.find('input[name="amount"]').val();

                    alert('Table 2: ' + a );
                  });
                })
            },
            error: function (result) {
                console.log(result);
                $('#menu').html(result.responseText);
            }
        });
        };


    var order_array = [];

   function orderItem (menuItemButtonID) {
    var name = "";
    var quantity = "";
    var price = "";

   if (menuItemButtonID == '00')
   {
      name = document.getElementById("01").textContent;
      quantity = document.getElementById("0").value;
      price = document.getElementById("02").textContent;

   }else{
       var index = menuItemButtonID.replace("0", "");

      name = document.getElementById(String(index)+"1").textContent;
      quantity = document.getElementById(String(index)).value;
      price = document.getElementById(String(index)+"2").textContent;   
   }

    var orderItem = {order_item_quantity:quantity,
    order_item_name:name,
    order_item_price:price};
    order_array.push(orderItem);

    };

    function createOrderList()
    {
        var table = "<table id=\"Order\" class=\"table\"><thead><tr><th>Amount</th><th>Item</th><th>Price per Item</th></tr></thead><tbody>";

        for (var i = 0; i < order_array.length; i++) {
            var orderItem = order_array[i];
            table += "<tr><td>"+orderItem.order_item_quantity+"</td><td id=\""+i+"\">"+orderItem.order_item_name+"</td><td>"+orderItem.order_item_price+"</td><td><button id= \"0"+i+"\" onclick=\"deleteOrderItem(this);\" class=\"btn btn-outline-primary\">Remove</button></td></tr>";
        }

        table += "</tbody>";
        document.getElementById('menu2').innerHTML = table;
    }

    function deleteOrderItem(delete_button_pressed)
    {
        var index = delete_button_pressed.id == '00' ? '0' : delete_button_pressed.id.replace("0", "");
        order_array.splice(index,1);
        createOrderList();
    }

    function loadOrderList(value, index, array)
    {
        var table = "<table id=\"Order\" class=\"table\"><thead><tr><th>Amount</th><th>Item</th><th>Price per Item</th></tr></thead><tbody>";

        order_array.forEach(value, index, array)
        {
            table.concat("<tr><td>"+value.order_item_quantity+"</td><td>"+value.order_item_name+"</td><td>"+value.order_item_price+"</td><td><button class=\"btn btn-outline-primary\">Remove</button></td></tr>")
        }

        table.concat("</tbody>"); 
    }



  function includeHTML() {
      var z, i, elmnt, file, xhttp;
      //Iterate through the collection of all HTML elements:
      z = document.getElementsByTagName("*");
      for (i = 0; i < z.length; i++) {
        elmnt = z[i];

        //Search for elements with a certain atrribute:
        file = elmnt.getAttribute("w3-include-html");
        if (file) {

          //Make an HTTP request using the attribute value as the file name:
          xhttp = new XMLHttpRequest();
          xhttp.onreadystatechange = function() {
            if (this.readyState == 4) {
              if (this.status == 200) {
                  elmnt.innerHTML = this.responseText;

                  //TODO: Make API call to get the authorized user that is logged in
                  document.getElementById("user").innerHTML = "<b>Guest</b>";
                  document.getElementById("header_title").innerHTML = "Order from menu";
                  }
              if (this.status == 404) {elmnt.innerHTML = "Page not found.";}
              //Remove the attribute, and call this function once more:
              elmnt.removeAttribute("w3-include-html");
              includeHTML();
            }
          }
          xhttp.open("GET", file, true);
          xhttp.send();
          return;
        }
      }
      };

