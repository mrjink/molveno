




    $(document).ready( function () {
        $('#eventTable').DataTable({
            ajax: {
                "url": "http://localhost:8080/api/event/all",
                "dataSrc": ""
            },
            "columns" : [
                {"data" : "id"},
                {"data" : "startDate"},
                {"data" : "endDate"},
                {"data" : "address"},
                {"data" : "maxUsers"},
                {"data" : "price"},
                {"data" : "catering"},
                {"data" : "eventnameCollection"},
                {"data" : "activityCollection"},
                {"data" : "eventinformationCollection"}
            ]
        });
    } );

    var refreshTable = function(){
        $('#eventTable').DataTable().ajax.reload();



    };



