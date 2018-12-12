$(".date-picker-2").datepicker({
    onSelect: function(dateText) { 
        //$('#example-popover-2-title').html('<b>Avialable Appiontments</b>');
        var html = '<button  class="btn btn-success">8:00 am – 9:00 am</button><br><button  class="btn btn-success">10:00 am – 12:00 pm</button><br><button  class="btn btn-success">12:00 pm – 2:00 pm</button>';
        $('#example-popover-2-content').html('On <strong>'+dateText+'</strong><br>'+html);
        $('.date-picker-2').popover('show');
    }
});