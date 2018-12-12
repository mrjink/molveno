    var postData = function(){

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

        //boolean
        var newslettersubscribed = document.getElementById("checkbox1").checked;
        //boolean
        var accepttermsconditions = document.getElementById("checkbox2").checked;

        //vul eerst de variabele van java:vul dan de variabele van javascript
        $.ajax({
            url: "http://localhost:8080/api/guest",
            type: "post",
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
                ,newsletterSubscribed:newslettersubscribed
                ,accepttermsconditions:accepttermsconditions

                }),
            contentType: "application/json",
            success: function (result){
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
//                  window.alert("test "+result.responseText);
            }

        })
    };
