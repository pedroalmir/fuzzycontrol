$(document).ready(function() {
	$('[data-toggle=offcanvas]').click(function() {
		$('.row-offcanvas').toggleClass('active');
	});
	if(document.location.toString().indexOf("project") != -1){
		$('#projectLI').attr("class", "active");
		$('#homeLI').attr("class", "");
		$('#aboutLI').attr("class", "");
		$('#contactLI').attr("class", "");
		
		
		$('#leftMenuProject').attr("class", "menu_active");
		$('#leftMenuSprints').attr("class", "");
		$('#leftMenuTasks').attr("class", "");
	}else if(document.location.toString().indexOf("sprint") != -1){
		$('#projectLI').attr("class", "active");
		$('#homeLI').attr("class", "");
		$('#aboutLI').attr("class", "");
		$('#contactLI').attr("class", "");
		
		
		$('#leftMenuProject').attr("class", "");
		$('#leftMenuSprints').attr("class", "menu_active");
		$('#leftMenuTasks').attr("class", "");
	}
});