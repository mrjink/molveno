window.onload = function getData(){

            //var url_string = "http://www.example.com/t.html?a=1&b=3&c=m2-m3-m4-m5"; //window.location.href
            //var url = new URL(url_string);
            //var c = url.searchParams.get("c");
            console.log(document.URL);
            var url = new URL(document.URL);
            var c = url.searchParams.get("id");
            console.log(c);

//private String name;
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
//    private long price;
//    private int maxParticipants;
//    private boolean catering;
//    private String additionalInformation;
//    private String activity;
//    private String information;

        //Date!!!!


        //Date!!!!



        $.ajax({
            url: c,
            type: "get",
            success: function(result){
                $('#rolename').val(result.name);
                $('#active').prop('checked',result.active);

            },
            error: function(result){
                console.log(result);
                $('#events').html(result.responseText);
            }
        })
};



    var patchData = function(){
    console.log("In de patchdata");


     console.log(document.URL);
                var url = new URL(document.URL);
                var c = url.searchParams.get("id");
                console.log(c);




        var rolename = $('#rolename').val();
        var act = document.getElementById("active").checked;


        $.ajax({
            url: c,
            type: "patch",
            data: JSON.stringify({
                name:rolename
                ,active:act

                }),
            contentType: "application/json",
            success: function (result){
                console.log("Patch gelukt");
                //$('#eventAdress').val("");
                $('#rolename').val("");

                $('#active').prop('checked',false);










            },
            error: function(result){
                console.log(result);
                $('#events').html(result.responseText);
            }

        })
    };


