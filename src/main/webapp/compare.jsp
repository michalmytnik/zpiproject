<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Anty-Plagiat</title>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/ckeditor/ckeditor.js" />"></script>
<script src="<c:url value="/resources/js/compareFile.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-6">
				<div class="panel panel-default">
					<div class="panel-heading"><%=request.getParameter("originalFileName")%></div>
					<div class="panel-body">
						<textarea name="originalFileName" id="originalFileName" rows="40"
							cols="80">
            		</textarea>
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="panel panel-default">
					<div class="panel-heading"><%=request.getParameter("fileName")%></div>
					<div class="panel-body">
						<textarea name="fileName" id="fileName" rows="40" cols="80">
            		</textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'fileName' );
                CKEDITOR.replace( 'originalFileName' );

                $( document ).ready(function() {
                	callCompare('<%=request.getParameter("originalFileName")%>','<%=request.getParameter("fileName")%>');
                	});
                
            </script>
</body>
</html>