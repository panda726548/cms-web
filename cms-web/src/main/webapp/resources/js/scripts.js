$(function(){
	$("#search_con").css("opacity",0.5);
	var search_v;
	$("#search_con").focus(function(){
		search_v = $(this).val();
		$(this).css("border","none");
		$("#search_con").css("opacity",1.0);
		$(this).val("");
	});
	$("#search_con").blur(function(){
		if($(this).val()=="") {
			$(this).css("opacity",0.5);
			$(this).val(search_v);
		}
	});
	$("#search_btn").click(function(){
		var sc = $("#search_con").val();
		if(sc==""||sc=="Search..") {
			alert("你需要输入相应的检索内容");
		} else {
			window.location.href=$("#ctx").val()+"/search/"+sc;
		}
	});
	
});