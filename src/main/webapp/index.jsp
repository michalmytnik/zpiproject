<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<title>Anty-Plagiat</title>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
		<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
		<script src="<c:url value="/resources/js/script.js" />"></script>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	</head>
	<body>
		<div id="art-page-background-glare">
			<div id="art-page-background-glare-image">
				<div id="art-main" >
					<div class="art-sheet">
						<div class="art-sheet-tl"></div>
						<div class="art-sheet-tr"></div>
						<div class="art-sheet-bl"></div>
						<div class="art-sheet-br"></div>
						<div class="art-sheet-tc"></div>
						<div class="art-sheet-bc"></div>
						<div class="art-sheet-cl"></div>
						<div class="art-sheet-cr"></div>
						<div class="art-sheet-cc"></div>
						<div class="art-sheet-body">
							<div class="art-nav">
								<div class="l"></div>
								<div class="r"></div>
								<ul class="art-menu">
									<li><a href="./home.html" class="active"><span class="l"> </span><span class="r"> </span><span class="t">Start</span></a></li>
									<li><a href="./about-us.html"><span class="l"> </span><span class="r"> </span><span class="t">O nas</span></a></li>
									<li><a href="./contact-us.html"><span class="l"> </span><span class="r"> </span><span class="t">Kontakt</span></a></li>
								</ul>
							</div>
							<div class="art-header">
								<div class="art-header-center">
									<div class="art-header-jpeg"></div>
								</div>
								<div class="art-logo">
									<h1 id="name-text" class="art-logo-name"><a href="./index.html">ANTY-PLAGIAT</a></h1>
									<h2 id="slogan-text" class="art-logo-text">...i koniec z kopiowaniem!</h2>
								</div>
							</div>
							<div class="art-content-layout">
								<div class="art-content-layout-row">
									<div class="art-layout-cell art-sidebar1">
										<div class="art-vmenublock">
											<div class="art-vmenublock-body">
												<div class="art-vmenublockheader">
													<h3 class="t">Menu</h3>
												</div>
												<div class="art-vmenublockcontent">
													<div class="art-vmenublockcontent-body">
														<ul class="art-vmenu">
															<li><a href="./home.html" class="active"><span class="l"> </span><span class="r"> </span><span class="t">Start</span></a></li>
															<li><a href="./about-us.html"><span class="l"> </span><span class="r"> </span><span class="t">O nas</span></a></li>
															<li><a href="./contact-us.html"><span class="l"> </span><span class="r"> </span><span class="t">Kontakt</span></a></li>
														</ul>
														<div class="cleared"></div>
													</div>
												</div>
												<div class="cleared"></div>
											</div>
										</div>
										<div class="art-block">
											<div class="art-block-body">
												<div class="art-blockcontent">
													<div class="art-blockcontent-body">
														<p>Proszę wprowadzić plik do testu antyplagiatowego</p>
														<p>Plik zostanie sprawdzony z bazą danych programu antyplagiatowego. Po dodaniu pliku proszę nacisnąć przycisk "sprawdzam" i oczekiwać na wynik </p>
														<div class="cleared"></div>
													</div>
												</div>
												<div class="cleared"></div>
											</div>
										</div>
										<div class="art-block">
											<div class="art-block-body">
												<div class="art-blockcontent">
													<div class="art-blockcontent-body">
														<div>
														<form id="form2" method="post" action="http://mich:8080/zpiAntyPlagarismProject-1.0/file/uploadAjax" enctype="multipart/form-data">
  <!-- File input -->    
  <input  class="btn btn-primary" name="file2" id="file2" type="file" style="float:left; background-image:none; background-color:#9ED04C;" /><br/>
</form>
 
<button value="Submit" class="btn btn-primary" type="button" onclick="uploadJqueryForm()" style="float:left; background-image:none; background-color:#9ED04C;">Dodaj plik!</button>
<button value="Submit"  class="btn btn-primary" type="button" onclick="uploadFormData()" style="float:right;background-image:none; background-color:#9ED04C;">Sprawdzam</button>
															  
														</div>
														<div class="cleared"></div>
													</div>
												</div>
												<div class="cleared"></div>
											</div>
										</div>
										<div class="cleared"></div>
									</div>
									<div class="art-layout-cell art-content">
										<div class="art-post">
											<div class="art-post-cc"></div>
											<div class="art-post-body">
												<div class="art-post-inner art-article">
													<h2 class="art-postheader">Czym się zajmujemy?</h2>
													<div class="art-postcontent">
														<h2><span style="font-size: 16px;"><span style="color: rgb(255, 255, 255);"> </span></span><span style="text-transform: none; "><span style="font-size: 16px;"><span style="color: rgb(255, 255, 255);">Anty-Plagiat powstał do wykrywania plagiatów w dokumentach uczelnianych takich jak prace dyplomowe czy też artykuły naukowe oraz do ochrony oryginalności tekstów. Jest tworzony jako niezależny projekt i jego działanie nie może określać w 100% czy ktoś popełnił przestępstwo. Jeśli program da wynik pozytywny osoba sprawdzajaca proszona jest o osobiste sprawdzenie treści dokumentu.</span></span></span></h2>
														<p><span style="text-transform: none; "><span style="font-size: 16px;"><span style="color: rgb(255, 255, 255);"><br /></span></span></span></p>
														<p><span style="font-size: 14px;">Program został stworzony jako projekt uczelniany w ramach przedmiotu "Zarządzanie Projektem Informatycznym", do porównania dokumentów wykorzystuje najpopularniejsze algorytmy wyszukiwania wzorca w tekście takie jak Odległość Levenstheina czy też algorytm Boyera i Moora. </span></p>
														<p><span style="font-size: 14px;"><br /></span></p>
														<p><span style="font-size: 14px;">Twórcy programu zastrzegają, że jego dystrybucja nie jest zezwolona bez zgody twórców i własciciela czyli Politechniki Krakowskiej im. Tadeusza Kościuszki </span></p>
														<p><span style="font-size: 14px;"><br /></span></p>
														<p><span style="font-size: 14px;"></span><span style="font-size: 14px;">Misją Anty-Plagiat jest dostarczenie rozwiązań technologicznych i organizacyjnych, służących poprawie jakości kształcenia i ochronie własności intelektualnej.</span><span style="color: rgb(247, 247, 247); font-family: Arial, Helvetica, sans-serif; "><span style="font-size: 14px;"> </span></span></p>
														<p><span style="color: rgb(247, 247, 247); font-family: Arial, Helvetica, sans-serif; "><span style="font-size: 14px;"><br /></span></span></p>
													</div>
													<div class="cleared"></div>
												</div>
												<div class="cleared"></div>
											</div>
										</div>
										<div class="cleared"></div>
									</div>
								</div>
							</div>
							<div class="cleared"></div>
							<div class="art-footer">
								<div class="art-footer-t"></div>
								<div class="art-footer-l"></div>
								<div class="art-footer-b"></div>
								<div class="art-footer-r"></div>
								<div class="art-footer-body">
									<div class="art-footer-text">
										<p><a href="./#"></a>  <a href="./#"></a>  <a href="./#"></a></p>
										<p>Copyright© 2014. All Rights Reserved.</p>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
							<div class="cleared"></div>
						</div>
					</div>
					<div class="cleared"></div>
					<p class="art-page-footer">Zaprojektowane przez Studentów <a href="http://http://www.fmi.pk.edu.pl/">Wydziału Matematyki Fizyki i Informatyki PK</a>.</p>
				</div>
			</div>
		</div>
	</body>
</html>
