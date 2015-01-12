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
			$('#mainContent').html("");
			$('#mainContent').html(result);
		},
		fail : function(){
			console.err('Something wrong with check request');
		}
	});
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