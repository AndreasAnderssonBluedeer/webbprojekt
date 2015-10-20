function myFunction() {

	var rate = $("#test6").val();
	var year = $("#test4").val();
	var genre = $("#test2").val();
	var search = document.getElementById("title").value;

	$("#test2").val("");
	$("#test4").val("");
	$("#test6").val("");
	$("#test2").text("Genre");
	$("#test4").text("Year");
	$("#test6").text("Rating");
	$("#title").val("");

	window.location.href = 'searchtest.html?s=' + search +'&g='+ genre +'&y='+ year +'&r=' +rate;
}
	function searchFunction(){
		var substr = window.location.search.substr(1);
	$.getJSON('http://localhost:4567/search/' + substr, function(jd) {
		if(jd.length === 0){
			console.log("Empty JSON");
		}

		else{
			console.log(jd);
			document.getElementById("searchContainer").innerHTML = "";
			var searchContainer = document.getElementById('searchContainer');

			for(var i = 0; i<jd.Search.length; i++) {
				var search = jd.Search[i];
				var title = search.Title;
				var str = title;
				var res = str.replace("'", "*");


				var thumbnail = document.createElement('div');

				thumbnail.className = 'newElement';
				thumbnail.innerHTML =
					// onClick="gotoNode(\'' + result.name + '\')" />'
					'<div class="col-sm-6 col-md-4" onclick="loadPage(\'' + res + '\')">'+
					'<div class="thumbnail">' +
					'<img src="'+ search.Poster +'" alt="...">' +
					'<div class="caption">'+
					'<h4>'+ search.Title +'</h4>'+
					'<p>'+ search.Plot +'</p>'+
					'</div>'+
					'</div>'+
					'</div>';

				searchContainer.appendChild(thumbnail);
			}
		}
	});
	}

function loadPage(title){
	window.location.href ='trailer.html?'+title;
}

function configTrailer() {
	var title = window.location.search.substr(1);
	var str = title;
	var res = str.replace("*", "'");

	$.getJSON('http://localhost:4567/info/' + res, function (jd) {
		if (jd.length === 0) {
			console.log("Empty JSON");
		}
		else {
			console.log(title);
			console.log(jd.Plot);
			if(jd.trailer_link == null){
				document.getElementById("movieframe").setAttribute('src', "https://www.youtube.com/embed/DRMBxnxWiNQ?autoplay=1");
			}
			else {
				document.getElementById("movieframe").setAttribute('src', jd.trailer_link);
			}
			document.getElementById("movie-title").innerHTML = jd.Title;
			document.getElementById("plot").innerHTML = jd.Plot;
			document.getElementById("released-date").innerHTML = jd.Released;
			document.getElementById("rated-pg-name").innerHTML = jd.Rated;
			document.getElementById("runtime-length").innerHTML = jd.Runtime;
			document.getElementById("genre-name").innerHTML = jd.Genre;
			document.getElementById("director-name").innerHTML = jd.Director;
			document.getElementById("writer-name").innerHTML = jd.Writer;
			document.getElementById("actor-name").innerHTML = jd.Actors;
			document.getElementById("language-name").innerHTML = jd.Language;
			document.getElementById("country-name").innerHTML = jd.Country;
			document.getElementById("award-name").innerHTML = jd.Awards;
			document.getElementById("rating-number").innerHTML = jd.imdbRating;
			document.getElementById("votes-number").innerHTML = jd.imdbVotes;
			document.getElementById("imdb-id-name").innerHTML = jd.imdbID;
			document.getElementById("is-a-movie").innerHTML = jd.Type;
		}
	});
}

$(function fd(){

	$("#test a").click(function fd(){

		$("#test2").text($(this).text());
		$("#test2").val($(this).text());
	});
});

$(function fds(){

	$("#test3 a").click(function fds(){
		$("#test4").text($(this).text());
		$("#test4").val($(this).text());
	});

});

$(function fdsd(){

	$("#test5 a").click(function fdsd(){
		$("#test6").text($(this).text());
		$("#test6").val($(this).text());
	});
});


