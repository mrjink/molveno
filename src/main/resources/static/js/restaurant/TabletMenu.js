

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
                    var name = $("<td></td>").text(menuItem.name);
                    var description= $("<td></td>").text(menuItem.description);
                     var price= $("<td></td>").text("$"+menuItem.price);
                   
                    var amount = $("<td>").append("<input id=\"rowMenu\" type="+index+" min=\"0\" max=\"12\" class=\"form-control\"  name=\"amount\"></td>");
                    // var order = $("<td>").append("<button onclick=\"orderItem(menuItem);\" class=\"btn-primary\">Order</button></td>").click(orderItem(menuItem)  );
                    var order = $("<td>").append("<button  onclick=\"orderItem(this)\" class=\"iAddbutton\">Order</button></td>");

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



   function orderItem (menuItem) {
//   add item to orderlist

   alert('works '+menuItem.idMenuItem);


        // var orderAmount = $("#"+menuItem.idMenuItem).val()
        // orderList.push({"idMenuItem": menuItem.idMenuItem,"amount":orderAmount});
        // console.log(orderList);


//            $.ajax({
//                url: "http://localhost:8080/api/restaurant/order/add/",
//                type: "post",
//                data: ({
//                                id: id
//
//                            }),
//
//                success: function (result) {
//                    <!--getData();-->
//                },
//                error: function (result) {
//                    console.log(result);
//                    window.alert("Couldn't add order! " + result.responseText);
//                }
//            });

    };



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

//                   if(myFunctionTag == 1)
//                   {
//                    document.getElementById("header_title").innerHTML = "Inventory Orders1";
//                   }

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

