$(".date-picker-2").datepicker({
         onSelect: function(dateText) {
             //$('#example-popover-2-title').html('<b>Avialable Appiontments</b>');
             var html = '<table><tr><td><button  class="btn btn-success" onclick="timeClick(this)">08:00 am</button></td><td> <button  class="btn btn-success" onclick="timeClick(this)">10.00 am</button></td><td><button  class="btn btn-success" onclick="timeClick(this)">12.00 am</button></td></tr><tr><td><button  class="btn btn-success" onclick="timeClick(this)">13:00 am</button></td><td> <button  class="btn btn-success" onclick="timeClick(this)">15.00 am</button></td><td><button  class="btn btn-success" onclick="timeClick(this)">17.00 am</button></td></tr><tr><td><button  class="btn btn-success" onclick="timeClick(this)">19:00 pm</button></td><td><button  class="btn btn-success" onclick="timeClick(this)">21.00 pm</button></td><td><button  class="btn btn-success" onclick="timeClick(this)">23.00 pm</button></td></tr></table>';
             $('#example-popover-2-content').html('On <strong>'+dateText+'</strong><br>'+html);
             $('.date-picker-2').popover('show');
             $('#date').val(dateText);
         }
     });

         function timeClick(timeSlot){
     $('#time').val(timeSlot.innerHTML);
         }