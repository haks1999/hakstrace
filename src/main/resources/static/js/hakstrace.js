
//initialize
$(function() {
	$.fn.editable.defaults.mode = 'inline';
	//$.fn.editable.defaults.disabled = true;
	
});

// common functions
var hakstrace = {};

hakstrace.initPageableTable = function(tableId){
	$("#" + tableId).attr("pagenum","1").attr("pageable","true");
	$("#" + tableId).append(
		'<tfoot><tr><td colspan="' + $("#"+tableId).find("thead th").length+ '">' +
				'<div class="col-sm-6"><div class="dataTables_info"></div></div>' +
				'<div class="col-sm-6 text-right"><div class="dataTables_paginate paging_bootstrap"> ' +
						'<ul class="pagination"><li class="prev"><a>Previous</a></li><li class="next"><a>Next</a></li></ul>' +
				'</div>' +
				'</div>' +
				'<div class="clearfix"></div>'+
		'</td></tr></tfoot>');
};

/**
 * tableId
 * thymeleaf url 
 * json param
 * callbacks :{ row:function, cols:{colId:function(abbr)}, after:function }
 */
hakstrace.loadPageableTable = function(tableId, url, param, callbacks){
	var targetTable = $('#' + tableId);
	if( $(targetTable).attr("pageable") != "true" ) hakstrace.initPageableTable(tableId);
	$(targetTable).find('tbody tr').not('.hide').remove();
	$(targetTable).find("tfoot ul.pagination li").removeClass("disabled");
	param.pageNum = param.pageNum || $(targetTable).attr("pagenum");
	
	$.ajax({
		contentType: 'application/json',
		url: url,
		type: 'GET',
		data: param,
		success: function(pageableList) {
			var dataList = pageableList.content;
			for( var inx=0; inx < dataList.length; inx++ ){
				var copiedRow = $(targetTable).find('tbody tr.hide').clone();
				if( callbacks && callbacks.row ){
					callbacks.row.call(null, copiedRow);	
				}else{
					$(copiedRow).find('td').each(function(){
						var colname=$(this).attr("abbr");
						if( callbacks && callbacks.cols && callbacks.cols[colname] ){
							$(this).html(callbacks.cols[colname].call(null, dataList[inx]));
						}else{
							if(colname && colname.length>0){
								var colnameArr = colname.split(".");
								var colnameParent = dataList[inx];
								for( var jnx=0;jnx<colnameArr.length;jnx++){
									colnameParent = colnameParent[colnameArr[jnx]];
								}
								$(this).text(colnameParent);
							}
						}
					});
				}
				$(copiedRow).removeClass('hide');
				$(targetTable).append(copiedRow);
			}
			$(targetTable).find("tfoot div.dataTables_info").text("Showing " + (pageableList.number*pageableList.size+1) + " to " + (pageableList.number*pageableList.size+pageableList.numberOfElements) + " of " + pageableList.totalElements + " entries");
			$(targetTable).find("tfoot ul.pagination li a").unbind();
			if(pageableList.firstPage == true){
				$(targetTable).find("tfoot ul.pagination li.prev").addClass("disabled");
			}else{
				$(targetTable).find("tfoot ul.pagination li.prev a").click(function(){
					var prevParam = param;
					prevParam.pageNum = Number(pageableList.number);
					hakstrace.loadPageableTable(tableId, url, prevParam, callbacks);
				});
			}
			if(pageableList.lastPage == true){
				$(targetTable).find("tfoot ul.pagination li.next").addClass("disabled");
			}else{
				$(targetTable).find("tfoot ul.pagination li.next a").click(function(){
					var nextParam = param;
					nextParam.pageNum = Number(pageableList.number)+2;
					hakstrace.loadPageableTable(tableId, url, nextParam, callbacks);
				});
			}
			
			
			if( callbacks && callbacks.after ){
				callbacks.after.call(null);	
			}
		},
		error: function (jqXHR, textStatus, errorThrown) {
			alert(errorThrown);
		},
		dataType: "json",
		async: false
	});
		
		
	
};


hakstrace.loadContent = function(url){
	window.location.hash = url;
	LoadAjaxContent(url);	//devoops.js
};

hakstrace.reloadContent = function(){
	hakstrace.loadContent(location.hash.replace("#",""));
}


hakstrace.saveData = function(url, param, callback){
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
    var _param = param?param:{};
    var _callback = callback?callback:function(){return false;};
	$.ajax({
		contentType: 'application/json',
		url: url,
		type: 'POST',
		dataType: "json",
		data: JSON.stringify(_param),
		success: _callback
	});
	return  false;
};