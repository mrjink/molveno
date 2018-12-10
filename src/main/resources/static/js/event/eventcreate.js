//<script
//        src="https://code.jquery.com/jquery-3.3.1.min.js"
//        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
//        crossorigin="anonymous"
        //></script>



//<script type="application/javascript" language="JavaScript">

    var postData = function(){


        //var eventAdress = $('#eventAdress').val();


        //get de waarde van de checkbox (true of false)


        //EventName english
        var eventnameEnglish = $('#eventnameEnglish').val();
        var eventnameChinese = $('#eventnameChinese').val();

        var eventactivityEnglish = $('#eventactivityEnglish').val();
        var eventactivityChinese = $('#eventactivityChinese').val();

        var eventinfoEnglish = $('#eventinfoEnglish').val();
        var eventinfoChinese = $('#eventinfoChinese').val();

        var name = $('#eventnameEnglish').val();
        //Start en enddate hiernder
                //maak van date en time datetime object (STARTDATE)
        var sdate = document.getElementById("eventStartDate").value;
        var stime = document.getElementById("eventStartTime").value;
        var sdatetime = new Date(sdate +" "+ stime);

        //maak van date en time datetime object (ENDDATE)
        var edate = document.getElementById("eventEndDate").value;
        var etime = document.getElementById("eventEndTime").value;
        var edatetime = new Date(edate +" "+ etime);

        var eventprice = $('#eventprice').val();
        var eventmaxUsers = $('#eventmaxUsers').val();
        var eventcatering = document.getElementById("eventcatering").checked;

        var activity = $('#eventactivityEnglish').val();
        var info = $('#eventinfoEnglish').val();
        var additionalinfo = $('#additionalinfoEnglish').val();

        $.ajax({
            url: "http://localhost:8080/event",
            type: "post",
            data: JSON.stringify({
                //address:eventAdress
                name:name
                ,startDate:sdatetime
                ,endDate:edatetime
                ,price:eventprice
                ,maxParticipants:eventmaxUsers
                ,catering:eventcatering
                ,activity:activity
                ,information:info
                ,additionalInformation:additionalinfo

                }),
            contentType: "application/json",
            success: function (result){
                //$('#eventAdress').val("");
                $('#eventmaxUsers').val("");
                $('#eventprice').val("");
                //reset Start: date and time inputbox
                $('#eventStartDate').val("");
                $('#eventStartTime').val("");
                //reset End: date and time inputbox
                $('#eventEndDate').val("");
                $('#eventEndTime').val("");
                $('#eventcatering').prop('checked',false);
                $('#eventnameEnglish').val("");
                //$('#eventnameChinese').val("");
                $('#eventactivityEnglish').val("");
                //$('#eventactivityChinese').val("");
                $('#eventinfoEnglish').val("");
                //$('#eventinfoChinese').val("");
                $('#additionalinfoEnglish').val("");










            },
            error: function(result){
                console.log(result);
                $('#events').html(result.responseText);
            }

        })
    };
//</script>