



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
	
    	
    	

    	/*var $test= $( ".result_container" ).clone();
    	var $test30= $( ".result_container" ).clone();
    	$('#poster').css('background','url(pika.png)');
    	var $newdiv1 = $( "<p>"+$test.text +"</p>" );
    //	$('.outer > .inner')
    	//$demo.css("background", "url(pika.png)");
    	$test.css("border", "1px solid white");

    	var $fun = $('#poster').clone().prop('id', 'fun');
    	$('#fun').css('background','url(pika.png)');

		
		var $title = $( "#info h4" ).attr( "value" );

		var $d = document.getElementById("result_container");
		$d.className = d.className + " otherclass";
		$( "#results" ).append( $d);*/

		for (var i = 0 ; i< 5; i++) {
			
		if(i==0){
			
			document.getElementById("poster_"+i).style.background = "url(pika.png)";

			document.getElementById("title_"+i).innerHTML = "New text!"+i;
			document.getElementById("plot_"+i).innerHTML = "Blaa bla ab la abl al la bla l al la l la lla"+i;


		}else{

		var div = document.getElementById('result_container_0'),
    	clone = div.cloneNode(true); // true means clone all childNodes and all event handlers
		clone.id = "result_container_"+i;

		document.getElementById("results").appendChild(clone);
		
		//Första barnet från ett element
		var elem = document.getElementById('result_container_'+i);
		var child = elem.children[0].children[0];
		child.id= "poster_"+i;
		document.getElementById("poster_"+i).style.background = "url(poster.jpg)";

		
		var title = elem.children[1].children[0].children[0];
		title.id= "title_"+i;
		document.getElementById("title_"+i).innerHTML = "New text!"+i;

		var plot = elem.children[1].children[0].children[1];
		plot.id= "plot_"+i;
		document.getElementById("plot_"+i).innerHTML = "Blaa bla ab la abl al la bla l al la l la lla"+i;
		}

		};
	//	$( ".result_info" ).html( "MOUHAHAH" );
	//	$test.html( "MOUHAHAH" );
		
  		

		//<div class="result_info" id="info">
		//			 	<h4>The Grey</h4>
    	//$( ".result_container" ).clone().appendTo( "#results" );
    	//var $test= document.getElementById("poster");
    //	var $test= document.getElementById("poster");
		 	  /*var $newdiv1 = $( "<div id='object1'/>" ),
		  newdiv2 = document.createElement( "div" ),
		  existingdiv1 = document.getElementById( "foo" );
		 
		$( "body" ).append( $newdiv1, [ newdiv2, existingdiv1 ] );*/
 
	//$( "#results" ).append( $test );



    	/*
    for (i = 0; i < data.length; i++) {
      html = '<li id="unicorn_' + i + '">' + data[i]['name'] + '</li>';
      list.append(html);
      $('#unicorn_' + i).click(fetchAndUpdateInfo(data[i]['details']));*/

});













