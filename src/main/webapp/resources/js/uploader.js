//using FormData() object
function uploadFormData(){
    $('#result').html('');
 
  var oMyForm = new FormData();
  oMyForm.append("file", file2.files[0]);
 
  $.ajax({
    url: 'http://mich:8080/zpiAntyPlagarismProject-1.0/file/uploadAjax',
    data: oMyForm,
    dataType: 'text',
    processData: false,
    contentType: false,
    type: 'POST',
    success: function(data){
      $('#result').html(data);
    }
  });
}

//using jquery.form.js
function uploadJqueryForm(){
    $('#result').html('');
 
   $("#form2").ajaxForm({
    success:function(data) { 
          $('#result').html(data);
     },
     dataType:"text"
   }).submit();
}