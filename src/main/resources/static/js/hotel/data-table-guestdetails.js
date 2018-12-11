$(document).ready( function () {
    var table = $('#myTable').DataTable({
        ajax: {
	        url: '../api/guest/all',
	        dataSrc: ''
        },
        columns: [
	     /*   {
	    	    "className":      'details-control',
	    	    "orderable":      false,
	    	    "data":           null,
	    	    "defaultContent": ''
	        },   DON'T HAVE EXTRA DATA TO SHOW YET  */
	        { "data": "lastName" },
	        { "data": "firstName" },
	        { "data": "address.country" },
	        { "data": "address.city" },
	        { "data": "address.street" },
	        { "data": "address.number" },
	        { "data": "phoneNumber" },
	        { "data": "email" },
	        { "data": "dateOfBirth" }
        ],
        order: [[1, 'asc']]
    });
});
