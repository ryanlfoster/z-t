

$(document).ready(function(){
	alert("clicked");
});
	$('.category-input').click(function(e){
		alert("clicked");
		var checkboxArray = $('input:checkbox:checked').map(function() {
			// if($("input:checkbox:checked"))
			return this.value;
		}).get().join(',');
		alert(checkboxArray);
		
	});

