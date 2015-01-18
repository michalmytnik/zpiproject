/**
 * 
 */
var getPath = function(url){
	var path = url.substring(0, url.lastIndexOf('/'));
	return path;
}

function callCompare(originalFileName, fileName) {
	originalFileName = encodeURI(originalFileName)
	fileName = encodeURI(fileName)
	var url = getPath(document.URL)
			+ '/check/compareControler?originalFileName=' + originalFileName
			+ "&fileName=" + fileName;

	$.ajax({
		url : url,
		type : 'GET',
		dataType : 'json',
		success : function(result) {
			console.log('Check successfull!');
			showResults(result);
		},
		fail : function() {
			console.err('Something wrong with check request');
		}
	});
}

function showResults(result) {

	CKEDITOR.instances.originalFileName.setData("");
	CKEDITOR.instances.fileName.setData("");
	
	var tempRow = $('<p />');
	for (var i = 0; i < result.length; i++) {

		if (i == 0) {
			CKEDITOR.instances.originalFileName.setData(result[i]);
		}
		if (i == 1) {
			CKEDITOR.instances.fileName.setData(result[i]);
		}

	}
}