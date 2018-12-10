function format ( d ) {
	// `d` is the original data object for the row
	return '<h4>Room Amenities</h4>'+
		'<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
		    '<tr>'+
		    	'<td>Room Type:</td>'+
		    	'<td>'+d.roomAmenities.roomType+'</td>'+
		    '</tr>'+
		    '<tr>'+
		    	'<td>Number of beds:</td>'+
		    	'<td>'+d.numberOfBeds+'</td>'+
		    '</tr>'+
	    '</table>'+
	'<h4>Guests</h4>'+
		'<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
			'<thead>'+
				'<tr>'+
					'<th>Last Name</th>'+
					'<th>First Name</th>'+
					'<th>Country</th>'+
					'<th>City</th>'+
					'<th>Street</th>'+
					'<th>Housenumber</th>'+
					'<th>Phone number</th>'+
					'<th>Email</th>'+
					'<th>Date of Birth</th>'+
				'</tr>'+
			'</thead>'+
			'<tbody>'+
				generateTableBody(d)+
			'</tbody>'+
		'</table>';
}

function generateTableBody( d ) {
	var tableString = generateTableRow(d.mainBooker);
	for (var i = 0; i < d.otherGuests.length; i++) {
		var g = d.otherGuests[i];
		tableString += generateTableRow(g);
	}
	return tableString;	
}

function generateTableRow( g ) {
	return '<tr>'+
			'<td>'+g.lastName+'</td>'+
			'<td>'+g.firstName+'</td>'+
			'<td>'+g.address.country+'</td>'+
			'<td>'+g.address.city+'</td>'+
			'<td>'+g.address.street+'</td>'+
			'<td>'+g.address.number+g.address.numberextension+'</td>'+
			'<td>'+g.phoneNumber+'</td>'+
			'<td>'+g.email+'</td>'+
			'<td>'+g.dateOfBirth+'</td>'+
		'</tr>';
}

$(document).ready( function () {
    var table = $('#myTable').DataTable({
        ajax: {
	        url: '../api/rooms/all',
	        dataSrc: ''
        },
        columns: [
	        {
	    	    "className":      'details-control',
	    	    "orderable":      false,
	    	    "data":           null,
	    	    "defaultContent": ''
	        },
	        { "data": "roomNumber" },
	        { "data": "mainBooker.lastName" },
	        { "data": "mainBooker.firstName" },
	        { "data": "mainBooker.address.country" },
	        { "data": "bookedBy" },
	        { "data": "startDate" },
	        { "data": "endDate" },
	        { "data": "numberOfBeds" },
	        { "data": "roomStatus" },
	        { "data": "pet" },
	        { "data": "roomBlocked" }
        ],
        order: [[1, 'asc']]
    });

    // Add event listener for opening and closing details
    $('#myTable tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );

        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        } else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    });
});
