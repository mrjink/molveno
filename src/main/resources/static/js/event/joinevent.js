   var patchData = function(){
    console.log("In de patchdata");


     console.log(document.URL);
                var url = new URL(document.URL);
                var c = url.searchParams.get("id");
                console.log(c);


        var userURL = "localhost:8080/api/guest/1"


        $.ajax({
            url: c,
            type: "patch",
            data: JSON.stringify({
                participants:[userURL]

                }),
            contentType: "application/json",
            success: function (result){
                console.log("Patch gelukt");











            },
            error: function(result){
                console.log(result);
                $('#events').html(result.responseText);
            }

        })
    };

