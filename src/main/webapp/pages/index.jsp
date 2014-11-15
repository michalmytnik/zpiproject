<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/angular.min.js" />"></script>
<script src="<c:url value="/resources/js/scripts.js" />"></script>
</head>
<body>
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
 
</body>
</html>