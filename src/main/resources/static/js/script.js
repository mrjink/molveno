// $(document).ready(function() {
//     $("#moviesBtn").on( "click", function() {
//         getMovies();
//     });
//
//     $("#addBtn").on( "click", function() {
//         var name = $("#addName").val();
//         var watched = $("#addWatched").val();
//         addMovie(name, watched);
//     });
// });
//
// function getMovies(){
//     $.get("/api/movie/all", function(data, status){
//         var output = "<table id='movieTable'><thead><tr><th>Name</th><th>Watched</th></tr></thead><tbody>";
//         var count = 1;
//         $.each(data, function(index, movie){
//             watched = movie.watched == true ? "Yes" : "No";
//             output += "<tr id='+ count + '><td>" + movie.name + "</td><td>" + watched + "</td></tr>";
//             count++;
//         })
//         output += "</tbody></table>";
//         $("#moviesList").html(output);
//     })
//         .done(function() {
//             $('#movieTable').DataTable();
//             // console.log("second success");
//         })
//         .fail(function() {
//             alert("error");
//         })
//         .always(function() {
//             // console.log("finished");
//         });
// }
//
// function addMovie(name, watched){
//     $.ajax ({
//         url: "/api/movie/add",
//         type: "POST",
//         data: JSON.stringify({ name: name, watched: watched }),
//         dataType: "json",
//         contentType: "application/json;",
//         success: function(){
//             console.log("Het is gelukt..");
//             getMovies();
//         }
//     });
// }
