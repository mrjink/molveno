window.onload = function getData(){


            console.log(document.URL);
            var url = new URL(document.URL);
            var c = url.searchParams.get("id");
            console.log(c);



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





                document.getElementById('eventnameEnglish').innerHTML = result.name;
                document.getElementById('eventactivityEnglish').innerHTML = result.activity;
                document.getElementById('eventStartDate').innerHTML = sdate;
                document.getElementById('eventStartTime').innerHTML = stime;
                document.getElementById('eventEndDate').innerHTML = edate;
                document.getElementById('eventEndTime').innerHTML = etime;
                document.getElementById('eventprice').innerHTML = result.price;
                document.getElementById('eventcatering').innerHTML = result.catering;
                document.getElementById('eventinfoEnglish').innerHTML = result.information;
                document.getElementById('additionalinfoEnglish').innerHTML = result.additionalInformation;





            },
            error: function(result){
                console.log(result);
                $('#events').html(result.responseText);
            }
        })
};