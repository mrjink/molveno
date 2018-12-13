$(document).ready(function ($) {
    $('#loginform').submit(function (event) {
        event.preventDefault();
        var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
        $.ajax({
            data: data,
            timeout: 1000,
            type: 'POST',
            url: '/login'
        }).done(function(data, textStatus, jqXHR) {
            alert(data + textStatus + jqXHR)
            alert(document.cookie);
            alert(window.location);
            //window.location = preLoginInfo.url;
        }).fail(function(jqXHR, textStatus, errorThrown) {
            alert('Incorrect username or password, please try again.');
        });
    });
});