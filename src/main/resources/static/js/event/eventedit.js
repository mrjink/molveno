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
                $('#eventmaxUsers').val(result.maxParticipants);
                $('#eventprice').val(result.price);

                //Splits datetime object in date en time:
                var sdatetime = result.startDate;
                var sdate = "";
                var stime = "";
                var Tgevonden = false;


                if (sdatetime != null && sdatetime.length > 0) {
                    var i;
                    for (i = 0; i < sdatetime.length; i++) {
                        if(sdatetime.charAt(i) == "T"){
                            console.log("Dit is de T");
                            Tgevonden = true;
                        }
                        else{
                            if(Tgevonden){
                                stime = stime + sdatetime.charAt(i);
                                //console.log(date);
                            }
                            else{
                              sdate = sdate + sdatetime.charAt(i);
                              //console.log();
                            }//else
                        }
                    }//for
                }//if
                $('#eventStartDate').val(sdate);
                $('#eventStartTime').val(stime);



                //Splits datetime object in date en time:
                var edatetime = result.endDate;
                var edate = "";
                var etime = "";
                Tgevonden = false;


                if (edatetime != null && edatetime.length > 0) {
                    var i;
                    for (i = 0; i < edatetime.length; i++) {
                        if(edatetime.charAt(i) == "T"){
                            console.log("Dit is de T");
                            Tgevonden = true;
                        }
                        else{
                            if(Tgevonden){
                                etime = etime + edatetime.charAt(i);
                                //console.log(date);
                            }
                            else{
                              edate = edate + edatetime.charAt(i);
                              //console.log();
                            }//else
                        }
                    }//for
                }//if
                $('#eventEndDate').val(edate);
                $('#eventEndTime').val(etime);




                //console.log(result.startDate);
                //console.log(date);
                //console.log(time);

                //END DATE OOK!!!!! TODO


                //$('#eventEndDate').val("");
                //$('#eventEndTime').val("");
                $('#eventcatering').prop('checked',result.catering);
                $('#eventnameEnglish').val(result.name);
                $('#eventactivityEnglish').val(result.activity);
                $('#eventinfoEnglish').val(result.information);
                $('#additionalinfoEnglish').val(result.additionalInformation);

            },
            error: function(result){
                console.log(result);
                $('#events').html(result.responseText);
            }
        })
};



// var postData = function(id){
//
//        $.ajax({
//            url: "http://localhost:8080/api/event/update/" + id,
//            type: "patch",
//            data: JSON.stringify({
//                address: $('#eventAdress').val()
//                }),
//            contentType: "application/json",
//            success: function (result){
//               console.log("patch is gelukt");
//
//               // getData();
//            },
//            error: function(result){
//                console.log(result);
//                $('#events').html(result.responseText);
//            }
//        })
//    };






    var patchData = function(){
    console.log("In de patchdata");


     console.log(document.URL);
                var url = new URL(document.URL);
                var c = url.searchParams.get("id");
                console.log(c);


        //var eventAdress = $('#eventAdress').val();


        //get de waarde van de checkbox (true of false)


        //EventName english
        //var eventnameChinese = $('#eventnameChinese').val();

        //var eventactivityEnglish = $('#eventactivityEnglish').val();
        //var eventactivityChinese = $('#eventactivityChinese').val();

        //var eventinfoEnglish = $('#eventinfoEnglish').val();
        //var eventinfoChinese = $('#eventinfoChinese').val();

        //var name = $('#eventnameEnglish').val();
        //Start en enddate hiernder

         var eventnameEnglish = $('#eventnameEnglish').val();


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
            url: c,
            type: "patch",
            data: JSON.stringify({
                name:eventnameEnglish
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
                console.log("Patch gelukt");
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


