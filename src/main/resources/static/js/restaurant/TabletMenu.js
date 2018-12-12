

function PlaceOrder() {
    confirm("Do you want to place this order?");
}
    
 
function AddToBill() {
    confirm("Do you want to add this receipt to your Hotel Bill?");
}

function Pay() {
    confirm("Do you want to pay the bill now?");
}

// https://cartjs.org/
//  add items to order
//$('.food-form').each(function() {
//      $(this).submit(function(event){
//
//        // Add an event handler that will trigger when all items are added.
//        $(document).on('cart.requestComplete', function() {
//          window.location.href = '/cart/';
//        });
//
//        $(this).closest('tr').find('.variant-add').each(function(){
//          var id = $(this).attr('data-variant-id');
//          var quantity = $(this).val();
//          if(quantity > 0){
//              CartJS.addItem(id, quantity);
//          };
//        });
//        event.preventDefault();
//      });
//  });

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

                   if(myFunctionTag == 1)
                   {
                    document.getElementById("header_title").innerHTML = "Inventory Orders1";
                   }

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

