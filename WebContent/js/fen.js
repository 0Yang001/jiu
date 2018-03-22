$(function(){
	
	var pageindex = $('#index').val();
	var pagesum = $('#sum').val();
	pageindex = parseFloat(pageindex);
	pagesum = parseFloat(pagesum);
	
	
	$('.ye').click(function(){
		var yeid = $(this).attr('id');
		if(yeid == 'one'){
			pageindex = 1;
			
			
		}else if(yeid == 'two'){
			if(pageindex == 1){
				return false;
			}else{
				pageindex -= 1;
			}
		}else if(yeid == 'free'){
			if(pageindex == pagesum){
				return false;
			}else{
				pageindex += 1;
			}
		}else{
			pageindex = pagesum;
		}
		
		$("#index").val(pageindex);
		
		
		//使用a标签控制表单提交
		$("#form").submit();
		
		return false;
	});
});