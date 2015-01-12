//using FormData() object
function uploadFileToRepo(doCheck) {
	$('#result').html('');

	var oMyForm = new FormData();
	var filename = file2.value;
	oMyForm.append("file", file2.files[0]);
	//var url = 'http://localhost:8080/zpiAntyPlagarismProject/file//uploadAjax';
	
	var message = "Plik dodano do bazy materiałów";

	var url = getPath(document.URL) + '//file/uploadAjax';
		
	console.log(document.domain);
	$.ajax({
		url : url,
		data : oMyForm,
		dataType : 'text',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(data) {
			showInfo(message);
			console.info('File uploaded.')
			if(doCheck){
				callChecker(filename);
			}
			
		},
		fail : function() {
			console.err('Cannot upload file!');
		}
	});
}

function showInfo(message){
	var spanMessage = $('<span/>', {
		text : message,
		display : 'none',
		id : 'messageSpan'
	});
	$('#fileLoadInfo').append(spanMessage);
	$(spanMessage).fadeIn("slow");
	setTimeout(function(){spanMessage.fadeOut("slow");}, 2000);
}

var getPath = function(url){
	var path = url.substring(0, url.lastIndexOf('/'));
	return path;
}

function checkPlagarism(){
	//var servicePath = '//file/uploadToCheck'
	uploadFileToRepo(true);
}

function callChecker(filename){
	filename = encodeURI(filename)
	var url = getPath(document.URL) + '/check/isPlagarism?fileName=' + filename;
	
	$.ajax({
		url : url,
		type : 'GET',
		dataType : 'json',
		success : function(result){
			console.log('Check successfull!');
			showResults(result);
		},
		fail : function(){
			console.err('Something wrong with check request');
		}
	});
}

function showResults(result){
	//clear space for result
	$('#mainContent').html("");
	/*[
	 * {
	 * 		levenstheinDistance : int, 
	 * 		textSimilarity : int,
	 * 		pecentageOfMatchRows : int,
	 * 		pecentageOfWordMatchWords : int,
	 * 		levenstheinDistanceBinary : int,
	 * 		fileName : string
	 * }
	 * ]
	*/
	
	var resultDiv = $('<div />', {
		class : "resultTable",	
	});
	
	var table = $('<table />');
	var row = $('<tr />');
	var cell = $('<td />');
	row.append($('<td />').text('Dane'));
	row.append($('<td />').text('Plik'));
	table.append(row);
	
	for(var i=0; i<result.length; i++){
		
		if(result[i].textSimilarity > 80){
			var tempRow = $('<tr />');
			var dataCell = $('<td />').html(
					'fileName : ' + result[i].fileName + '<br />' +
					'levenstheinDistance : ' + result[i].levenstheinDistance + '<br />' +
					'levenstheinDistanceBinary : ' + result[i].levenstheinDistanceBinary + '<br />' +
					'pecentageOfMatchRows : ' + result[i].pecentageOfMatchRows + '<br />' +
					'pecentageOfWordMatchWords : ' + result[i].pecentageOfWordMatchWords + '<br />' +
					'textSimilarity : ' + result[i].textSimilarity + '<br />'				
					);
			
			var url = getPath(document.URL) + '/download/file?fileName=' + encodeURI(result[i].fileName);
			var fileCell = $('<td />').html('<a href="'+ url +'">'+ result[i].fileName +'</a>'
					);
			tempRow.append(dataCell);
			tempRow.append(fileCell);
			table.append(tempRow);
		}
	}
	
	resultDiv.append(table);
	$('#mainContent').append(resultDiv);
		
}

// using jquery.form.js
function uploadJqueryForm() {
	$('#result').html('');

	$("#form2").ajaxForm({
		success : function(data) {
			$('#result').html(data);
		},
		dataType : "text"
	}).submit();
}