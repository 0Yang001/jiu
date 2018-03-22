			$('input[name=password]').blur(function(){
				var val = $(this).val();
				if(val.length<8){
					$(this).data({'s':0});
					$(this).parent().next().show();
				}else{
					$(this).data({'s':1});
					$(this).parent().next().hide();
				}
			});
			$('input[name=respassword]').blur(function(){
				var val1 = $(this).val();
				var val2 = $('input[name=password]').val();
				if(val1==val2){
					$(this).data({'s':1});
					$(this).parent().next().hide();					
				}else{
					$(this).data({'s':0});
					$(this).parent().next().show();
				}
			});
			$('input[name=nicheng]').blur(function(){
				var val = $(this).val();
				if(val.length<6){
					$(this).data({'s':0});
					$(this).parent().next().show();
				}else{
					$(this).data({'s':1});
					$(this).parent().next().hide();
				}
			});
			$('input[name=tel]').blur(function(){
				var val = $(this).val();
				var regPartton=/1[3-8]+\d{9}/;
				if(regPartton.test(val)){
					$(this).data({'s':1});
					$(this).parent().next().hide();
				}else{
					$(this).data({'s':0});
					$(this).parent().next().show();
				}
			});
			
			
			
			
			
			