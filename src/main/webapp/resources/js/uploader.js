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
			$('#cover').fadeOut(1000);
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
	$('#cover').fadeIn(10);
	
}

function callChecker(filename){
	filename = encodeURI(filename)
	var url = getPath(document.URL) + '/check/isPlagarism?fileName=' + filename;
	console.log('url: ' +url)
		if(url.indexOf("C:%5Cfakepath%5C") > -1)
		{
			console.log('changed url ');
			url = url.replace("C:%5Cfakepath%5C", "");
		}
	console.log('url2: ' +url)
	$.ajax({
		url : url,
		type : 'GET',
		dataType : 'json',
		success : function(result){
			console.log('Check successfull!');
			showResults(result, filename);
			$('#cover').fadeOut(1500);
		},
		fail : function(){
			console.err('Something wrong with check request');
			$('#cover').fadeOut(1000);
		}
	});
}

function showResults(result, originalFileName){
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
	row.append($('<td />').text('LP'));
	row.append($('<td />').text('Dane'));
	row.append($('<td />').text('Plik'));
	row.append($('<td />').text('Porównaj'));
	row.append($('<td />').text('Raport'));
	table.append(row);
	
	if( result.length> 0 )
		alert ('Wykryto Plagiat !!! Szczegóły znajduja się w tabeli...')
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
			var fileNameCell = $('<td />').html('<span">'+ result[i].fileName.replace(".txt","") +'</span>');
			var fileCell = $('<td />').html('<a href="'+ url +'">'+ result[i].fileName +'</a>');
			var fileCellReport = $('<td />').html('<a href="'+ url.replace(".txt",".pdf") +'">'+ result[i].fileName.replace(".txt",".pdf") +'</a>');
			var urlToCompare = getPath(document.URL) + '/compare.jsp?originalFileName='+ originalFileName +"&fileName="+ encodeURI(result[i].fileName);
			var compareCell = $('<td />').html('<a href="'+ urlToCompare +'" target="_blank">'+ result[i].fileName +'</a>'
					);
			/*tempRow.append(dataCell);*/
			var lp = $('<td />').html(i+1 + '.');
			tempRow.append(lp);
			tempRow.append(fileNameCell);
			tempRow.append(fileCell);
			tempRow.append(compareCell);
			tempRow.append(fileCellReport);
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