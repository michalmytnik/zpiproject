<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/angular.min.js" />"></script>
<script src="<c:url value="/resources/js/scripts.js" />"></script>
<script src="<c:url value="/resources/js/uploader.js" />"></script>
<script src="<c:url value="/resources/js/jQueryForm.js" />"></script>

</head>
<!-- <body>
	<h1>1. Test CSS</h1>
 
	<h2>2. Test JS</h2>
	<div id="msg"></div>
	
	<c:set var="context" value="${pageContext.request.contextPath}" />	
	<form method="POST" enctype="multipart/form-data"
		action="${context}/file/upload">
		File to upload: <input type="file" name="file"><br /> 
		 <input type="submit" value="Upload"> Press here to upload the file!
	</form>
	
	<button type="button" class="btn btn-default btn-lg">
  			<span class="glyphicon glyphicon-star"></span> Send File!
	</button>
 
</body>-->
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />	
	<h1>JAX-RS Upload Form</h1>
 
	<!--  <form action="${context}/file/upload" method="post" enctype="multipart/form-data">
 
	   <p>
		Select a file ssss: <input type="file" name="uploadedFile" size="50" />
	   </p>
 
	   <input type="submit" value="Upload It" />
	</form>
	
wwww
	<form method="POST" enctype="multipart/form-data"
		action="${context}/file/upload" >
		File to upload: <input type="file" name="file"><br /> Name: <input
			type="text" name="name"><br /> <br /> <input type="submit"
			value="Upload"> Press here to upload the file!
	</form>-->


<i>Uploading File With Ajax</i><br/>
<form id="form2" method="post" action="http://mich:8080/zpiAntyPlagarismProject-1.0/file/uploadAjax" enctype="multipart/form-data">
  <!-- File input -->    
  <input name="file2" id="file2" type="file" /><br/>
</form>
 
<button value="Submit" onclick="uploadJqueryForm()" >Upload</button><i>Using JQuery Form Plugin</i><br/>
<button value="Submit" onclick="uploadFormData()" >Upload</button><i>Using FormData Object</i>
 
<div id="result"></div>
</body>
 

</html>