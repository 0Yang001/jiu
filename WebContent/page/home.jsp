<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
		<style type="text/css">
			*{
				margin: 0;
				padding: 0;
			}
			img{
				width: 100;
				height: 100;
			}
			.lunbo{
				width: 1000px;
				height: 300px;
				margin: 20px auto;
				overflow: hidden;
				
			}
			
			.footer .navleft{
				margin-left: 80px;
				float: left;
				width: 200px;
				height: 400px;
				border: 1px dashed #ccc;
				padding: 10px 20px;
				overflow: hidden;
			}
			.footer .navleft .tou,.tou_right{
				line-height: 40px;
				text-align: center;
				background-color: #87CEEB;
				
			}
			.footer .navleft ul li{
				list-style: none;
				border-bottom: 1px dashed #ccc;
				padding: 15px 0px;
			}
			.footer .navright{
				float: left;
				margin-left: 100px;
				border-left: 1px solid #ccc;
				padding-left: 100px;
			}
			.footer .navright ul li{
				list-style: none;
				border-bottom: 1px dashed #ccc;
				padding: 15px 0px;
			}
		</style>
	</head>
	<body onload="play()">
		<div class="home">
			<div class="lunbo">
				<img src="../img/0.jpg"/>
			</div>
			<div class="footer">
				<div class="navleft">
					<div class="tou">
						<span id="">
							公告
						</span>
					</div>
					<ul id="dongtai">
						<li>关于举办2017年“山东—名校人才直通车”金融人才专场活动的公告</li>
						<li>山东省2016年第八期创业咨询师培训招生简章</li>
						<li>山东省2016年第五十期职业指导师培训招生简章</li>
						<li>全国重点高校优秀毕业生推介会在烟台举办</li>
						<li>山东省国际人才交流协会招聘工作人员公告</li>
						<li>2016年“生源信息采集系统V2.4”发布</li>
						<li>关于发起“济南市大学生就业能力提升培训工程”的公告</li>
					</ul>
				</div>
				<div class="navright">
					<div class="tou_right">
						<span id="">
							各地招聘会
						</span>
					</div>
					<ul>
						<li>[辽宁]9月辽宁招聘网大型招聘会</li>
						<li>[全国]9月9日广州大学城综合场及文科类校园招聘会</li>
						<li>[全国]8月26日2017届湖北高校毕业生(含研究生)大型供需见面会</li>
						<li>[河南]8月25日河南省2017届毕业生暨夏季大型综合招聘会</li>
						<li>[山东]8月19日山东省应往届及实习毕业生综合类名企大型人才招聘会</li>
						<li>[辽宁]7月8日辽宁人才机械电气、电力电子、加工制造及汽车行业专场招聘会</li>
						<li>[全国]7月1日第七届留法校友招聘论坛在北京、上海、广州、成都、沈阳、武汉举行</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
	<script>
		var image;
			var num = 0;
			var timer;
			var images = new Array(4);
			
				for (var i = 0 ; i<images.length;i++) {
					images[i] = new Image();
					images[i].src = "../img/"+i+".jpg";
				}
				image = document.images[0];
			
			function setSrc(i){
				image.src = images[i].src;
			}
			
			
			function play(){
				if(num>=3){
					num = -1;
				}
				setSrc(++num);
				timer=setTimeout(play,1500);
			}
		
		
	</script>
	<script type="text/javascript" src="../js/home.js" ></script>
</html>
