

function myFunction() {
		
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
    				
});