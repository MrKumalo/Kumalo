$(document).ready(function () {
	$('#board td').click(function(event) {
		var id = $(this).attr('id');
		if(!$(this).hasClass('used'))
		{
			$(this).addClass('used');
			$(this).append('<p>X</p>');
		}
		console.log(id);
	});
});