
function myFunction() {

		$.getJSON('http://localhost:4567/search/harry', function(jd) {
		console.log(jd);	
		})

		var rate= $("#test6").val();
		var year= $("#test4").val();
		var genre= $("#test2").val();
		var search = document.getElementById("title").value;
		document.getElementById("search_title").innerHTML = genre+", "+year+", "+rate+", "+search;
		
		$("#test2").val("");
		$("#test4").val("");
		$("#test6").val("");
		$("#test2").text("Genre");
		$("#test4").text("Year");
		$("#test6").text("Rating");
		$("#title").val("");

		return function() {  
   			$.ajax({
   			method: 'GET',
    		url: 'http://www.omdbapi.com/?t=harry&y=&plot=short&r=json',
      		headers: {"Accept": "application/json"}
    })
    .done(function (data) {
    	$console.log(data);

					});
	}
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
					

$( document ).ready(function() {
	
    	
    	


		for (var i = 0 ; i< 5; i++) {	
		if(i==0){
			var headtitle="The Grey"+i;
			document.getElementById("rc_link_0").href="https://www.google.se/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=";
			document.getElementById("poster_"+i).style.backgroundImage = "url(pika.png)";

			document.getElementById("title_"+i).innerHTML = headtitle;

			document.getElementById("plot_"+i).innerHTML = "Mystique helps a bunch of mutants escape a busy"+
			" Vietnam military base in a cargo plane while being disguised as an army colonel"+
			" and the moment they leave she turns around and morphs into a blonde chick in front"+
			" of hundreds of other soldiers and no one notices her. "+i;


		}else{
		var headtitle="The Grey"+i;
		var link = document.getElementById('rc_link_0'),
    	clonelink = link.cloneNode(true); // true means clone all childNodes and all event handlers
		clonelink.id = "rc_link_"+i;

		clonelink.href="https://www.google.se/";

		clonelink.href="https://www.google.se/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q="+headtitle;


		document.getElementById("results").appendChild(clonelink);	
		var div = document.getElementById('rc_link_'+i);
		var clone = div.children[0];
		clone.id= "result_container_"+i;
		
		
		//Första barnet från ett element
		var elem = document.getElementById('result_container_'+i);
		var child = elem.children[0].children[0];
		child.id= "poster_"+i;
		document.getElementById("poster_"+i).style.backgroundImage = "url(lord2.jpg)";

		
		var title = elem.children[1].children[0].children[0];
		title.id= "title_"+i;
		document.getElementById("title_"+i).innerHTML = headtitle;
		var plot = elem.children[1].children[0].children[1];
		plot.id= "plot_"+i;
		document.getElementById("plot_"+i).innerHTML ="Mystique helps a bunch of mutants escape a busy"+
			" Vietnam military base in a cargo plane while being disguised as an army colonel"+
			" and the moment they leave she turns around and morphs into a blonde chick in front"+
			" of hundreds of other soldiers and no one notices her. "+i;	
		}
		};
});













