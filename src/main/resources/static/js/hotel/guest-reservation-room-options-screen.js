/*$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});

$('button[rel=popover]').popover({
    html: true,
    trigger: 'hover',
    content: function () {
        return '<img src="' + $(this).data('img') + '" />';
    }

});*/

$('#btntiago').hover(function () {
        console.log("herroooo");
        $('#yoran').attr('src', '/img/kingsize.jpg')
    },
    function () {
        console.log("herroooo");
        $('#yoran').attr('src', '/img/kingsize.jpg')
    });

function printRoom(number) {

    if (number == 1) {
        console.log("HERROOO-OOO");
        $('p#output').html($('p#par1').html());
    }
    if (number == 2) {
        console.log("HERROOO-OOO");
        $('p#output').html($('p#par2').html());
    }
    if (number == 3) {
        console.log("HERROOO-OOO");
        $('p#output').html($('p#par3').html());
    }
    if (number == 4) {
        console.log("HERROOO-OOO");
        $('p#output').html($('p#par4').html());
    }
    if (number == 5) {
        console.log("HERROOO-OOO");
        $('p#output').html($('p#par5').html());
    }
}