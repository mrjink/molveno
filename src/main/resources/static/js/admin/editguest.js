window.onload = function getData(){

//            console.log(document.URL);
            var url = new URL(document.URL);
            var c = url.searchParams.get("id");
//            console.log(c);

        //eerst id html dan java
        $.ajax({
            url: c,
            type: "get",
            success: function(result){
                $('#firstname').val(result.firstName);
                $('#lastname').val(result.lastName);
                $('#dateofbirth').val(result.dateOfBirth);
                $('#street').val(result.street);
                $('#number').val(result.number);
                $('#numberextension').val(result.numberextension);
                $('#postalcode').val(result.postalCode);
                $('#city').val(result.city);
                $('#country').val(result.country);
                $('#phonenumber').val(result.phoneNumber);
                $('#email').val(result.email);
                $('#password').val(result.password);
//                $('#passwordcheck').val(result.additionalInformation);
                $('#checkbox1').prop('checked',result.catering);
                $('#checkbox2').prop('checked',result.catering);
            },
        error: function(result){
                      console.log(result);
                        window.alert("test "+result.responseText);
                  }
        })
};

    var patchData = function(){
    console.log("In de patchdata");

     console.log(document.URL);
                var url = new URL(document.URL);
                var c = url.searchParams.get("id");
                console.log(c);

        var firstname = $('#firstname').val();
        var lastname = $('#lastname').val();
        var dateofbirth = $('#dateofbirth').val();
        var street = $('#street').val();
        var number = $('#number').val();
        var numberextension = $('#numberextension').val();
        var postalcode = $('#postalcode').val();
        var city = $('#city').val();
        var country = $('#country').val();
        var phonenumber = $('#phonenumber').val();
        var email = $('#email').val();
        var password = $('#password').val();
        var passwordcheck = $('#passwordcheck').val();

//        //boolean
//        var newslettersubscribed = document.getElementById("checkbox1").checked;
//        //boolean
//        var accepttermsconditions = document.getElementById("checkbox2").checked;


        $.ajax({
            url: c,
            type: "patch",
            data: JSON.stringify({
                firstName:firstname
                ,lastName:lastname
                ,dateOfBirth:dateofbirth
                ,street:street
                ,number:number
                ,numberextension:numberextension
                ,postalCode:postalcode
                ,city:city
                ,country:country
                ,phoneNumber:phonenumber
                ,email:email
                ,phoneNumber:phonenumber
                ,password:password
//                ,newsletterSubscribed:newslettersubscribed
//                ,accepttermsconditions:accepttermsconditions

                }),
            contentType: "application/json",
            success: function (result){
                console.log("Patch gelukt");
                 $('#firstname').val("");
                 $('#lastname').val("");
                 $('#dateofbirth').val("");
                 $('#street').val("");
                 $('#number').val("");
                 $('#numberextension').val("");
                 $('#postalcode').val("");
                 $('#city').val("");
                 $('#country').val("");
                 $('#phonenumber').val("");
                 $('#email').val("");
                 $('#password').val("");
                 $('#passwordcheck').val("");
                 $("checkbox1").prop('checked',false);
                 $("checkbox2").prop('checked',false);
            },
            error: function(result){
                      console.log(result);
                        window.alert("test "+result.responseText);
                  }

        })
    };


