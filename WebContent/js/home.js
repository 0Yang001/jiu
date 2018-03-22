$(function(){
	setInterval(function(){
		var newli = $('#dongtai>:first').clone(true);
		$('#dongtai').append(newli);
		$('#dongtai>:first').remove();
	},1000);
});