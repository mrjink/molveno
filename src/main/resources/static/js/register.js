function confirmDelete() {
    var agreed = confirm("Are you sure you want to cancel your registration?");
    if(agreed){
        //CANCEL GUEST REGISTRATION
        alert("Your guest registration has been canceled");
    }
    else{
        alert("Please proceed your registration");
    }
}

function confirmRegistration() {
    var agreed = confirm("Are you sure you want to register?");
    if(agreed){
        //CONFIRM REGISTRATION
        return true;
    }
    else{
        return false;
    }
}

var validate = function()
{
    var canValidate = true;
    if($('#firstname').val() === null || $('#firstname').val() === "")
    {
        canValidate = false;
        $('#firstname').addClass("error");
    }
    else
    {
        $('#firstname').removeClass("error");
    }
    if($('#middlename').val() === null || $('#middlename').val() === "")
    {
        canValidate = false;
        $('#middlename').addClass("error");
    }
    else
    {
        $('#middlename').removeClass("error");
    }
    if($('#lastname').val() === null || $('#lastname').val() === "")
    {
        canValidate = false;
        $('#lastname').addClass("error");
    }
    else
    {
        $('#lastname').removeClass("error");
    }
    if($('#email').val() === null || $('#email').val() === "")
    {
        canValidate = false;
        $('#email').addClass("error");
    }
    else
    {
        $('#email').removeClass("error");
    }
    if($('#phonenumber').val() === null || $('#phonenumber').val() === "")
    {
        canValidate = false;
        $('#phonenumber').addClass("error");
    }
    else
    {
        $('#phonenumber').removeClass("error");
    }
    if($('#username').val() === null || $('#username').val() === "")
    {
        canValidate = false;
        $('#username').addClass("error");
    }
    else
    {
        $('#username').removeClass("error");
    }
    if($('#password').val() === null || $('#password').val() === "")
    {
        canValidate = false;
        $('#password').addClass("error");
    }
    else
    {
        $('#password').removeClass("error");
    }
    if($('#postalcode').val() === null || $('#postalcode').val() === "")
    {
        canValidate = false;
        $('#postalcode').addClass("error");
    }
    else
    {
        $('#postalcode').removeClass("error");
    }
    if($('#streetname').val() === null || $('#streetname').val() === "")
    {
        canValidate = false;
        $('#streetname').addClass("error");
    }
    else
    {
        $('#streetname').removeClass("error");
    }
    if($('#city').val() === null || $('#city').val() === "")
    {
        canValidate = false;
        $('#city').addClass("error");
    }
    else
    {
        $('#city').removeClass("error");
    }
    if($('#dateOfBirth').val() === null || $('#dateOfBirth').val() === "")
    {
        canValidate = false;
        $('#dateOfBirth').addClass("error");
    }
    else
    {
        $('#dateOfBirth').removeClass("error");
    }
    if($('#country').val() === null || $('#country').val() === "")
    {
        canValidate = false;
        $('#country').addClass("error");
    }
    else
    {
        $('#country').removeClass("error");
    }
    if($('#homenumber').val() === null || $('#homenumber').val() === "")
    {
        canValidate = false;
        $('#homenumber').addClass("error");
    }
    else
    {
        $('#homenumber').removeClass("error");
    }
    if($('#temsaccepted').val() === null || $('#temsaccepted').val() === "" || $('#temsaccepted').val() === false || $('#temsaccepted').checked === false)
    {
        canValidate = false;
        $('#temsaccepted').addClass("error");
    }
    else
    {
        $('#temsaccepted').removeClass("error");
    }
    // if($('#password').val() === $('#re_enter_password'))
    // {
    //     $('#passwordNotSame').removeClass("hidden");
    //     $('#passwordNotSame').removeClass("error");
    // }
    // else
    // {
    //     canValidate = false;
    //     $('#passwordNotSame').addClass("hidden");
    //     $('#password').addClass("error")
    // }

    console.log(canValidate);

    return canValidate;
};

var register = function () {
    var validated = validate();

    if(validated) {
        var data = {
            "firstName": $('#firstname').val(),
            "middleName": $('#middlename').val(),
            "lastName": $('#lastname').val(),
            "email": $('#email').val(),
            "phonenumber": $('#phonenumber').val(),
            "username": $('#username').val(),
            "password": $('#password').val(),
            "guestInformation":                {
                "dateOfBirth": $('#dateOfBirth').val(),
                "address" : {

                }
            }
        };
        $.ajax({
            data: data,
            timeout: 1000,
            type: 'POST',
            url: '/guest/register'
        }).done(function (data, textStatus, jqXHR) {
            alert(data + textStatus + jqXHR)
            alert(document.cookie);
            alert(window.location);
            //window.location = preLoginInfo.url;
        }).fail(function (jqXHR, textStatus, errorThrown) {
            alert('Incorrect username or password, please try again.');
        });
    }
};

$( document ).ready(function($) {
    $('#btnRegister').click(
        function() {
            if(confirmRegistration()){
                register();
            }
        }
    );
    $('#firstname')         .change(function() {validate()});
    $('#middlename')        .change(function() {validate()});
    $('#lastname')          .change(function() {validate()});
    $('#dateOfBirth')             .change(function() {validate()});
    $('#email')             .change(function() {validate()});
    $('#phonenumber')       .change(function() {validate()});
    $('#streetname')        .change(function() {validate()});
    $('#postalcode')        .change(function() {validate()});
    $('#homenumber')        .change(function() {validate()});
    $('#country')           .change(function() {validate()});
    $('#city')              .change(function() {validate()});
    $('#username')          .change(function() {validate()});
    $('#password')          .change(function() {validate()});
    $('#re_enter_password') .change(function() {validate()});
    $('#temsaccepted')      .change(function() {validate()});
});

validate();