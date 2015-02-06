function swPage(page_id){
	$("#inbound_id").removeClass("active");
	$("#inbound_query_id").removeClass("active");
	$("#warehouse_query_id").removeClass("active");
	$("#outbound_id").removeClass("active");
	
	$(page_id).addClass("active");
}