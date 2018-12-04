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


