<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Anty-Plagiat About</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/script.js" />"></script>
<script src="<c:url value="/resources/js/uploader.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div id="art-page-background-glare">
		<div id="art-page-background-glare-image">
			<div id="art-main">
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
								<li><a href="./index.jsp" class="active"><span class="l">
									</span><span class="r"> </span><span class="t">Start</span></a></li>
								<li><a href="./about-us.jsp"><span class="l"> </span><span
										class="r"> </span><span class="t">O nas</span></a></li>
								<li><a href="./contact-us.jsp"><span class="l">
									</span><span class="r"> </span><span class="t">Kontakt</span></a></li>
							</ul>
						</div>
						<div class="art-header">
							<div class="art-header-center">
								<div class="art-header-jpeg"></div>
							</div>
							<div class="art-logo">
								<h1 id="name-text" class="art-logo-name">
									<a href="./index.jsp">ANTY-PLAGIAT</a>
								</h1>
								<h2 id="slogan-text" class="art-logo-text">...i koniec z
									kopiowaniem!</h2>
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
														<li><a href="./index.jsp" ><span
																class="l"> </span><span class="r"> </span><span
																class="t">Start</span></a></li>
														<li><a href="./about-us.jsp" class="active"><span class="l">
															</span><span class="r"> </span><span class="t">O nas</span></a></li>
														<li><a href="./contact-us.jsp"><span class="l">
															</span><span class="r"> </span><span class="t">Kontakt</span></a></li>
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
													<div class="cleared"></div>
												</div>
											</div>
											<div class="cleared"></div>
										</div>
										<div class="art-block-body" id="fileLoadInfo">
										<!-- info wstawiane przez JS -->
										</div>
									</div>
									<div class="art-block">
										<div class="art-block-body">
											<div class="art-blockcontent">
												<div class="art-blockcontent-body">
													
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
											<div id="mainContent">
												<div class="art-post-inner art-article">
													<h2 class="art-postheader">Kim jesteśmy?</h2>
													<div class="art-postcontent">
														<h2>
															<span style="font-size: 16px;"><span
																style="color: rgb(255, 255, 255);"> </span></span><span
																style="text-transform: none;"><span
																style="font-size: 16px;"><span
																	style="color: rgb(255, 255, 255);">
																	Program stworzono w ramach grupy studenckiej Politechniki Krakowskiej.
																	Podczas implementacji tego serwisu jego twórcy skupiali się przede wszystkim 
																	poszerzaniu wiedzy z zakresu Zarzadzania Projektami Informatycznymi w metodologi Scrum.
																	</span></span></span>
														</h2>
														<p>
															<span style="text-transform: none;"><span
																style="font-size: 16px;"><span
																	style="color: rgb(255, 255, 255);"><br /></span></span></span>
														</p>
														<p>
															<span style="font-size: 14px;">
															Zespół został podzielony na programistów testerów oraz grafików. Każda z grup włożyła wiele pracy aby końcowy projekt miał obecny wygląd.
														 </span>
														</p>
														<p>
															<span style="font-size: 14px;"><br /></span>
														</p>
														<p>
															<span style="font-size: 14px;">Mimo, że "ANTYPLAGIAT" nie został zatwierdzony jako arbiter do rostrzygania o powielaniu istniejących źródeł, to jego kod oraz proces wytwórczy może służyć jako inspiracja oraz przykład dla innych projektów tego tupu... </span>
														</p>
														<p>
															<span style="font-size: 14px;"><br /></span>
														</p>
														<p>
															<span style="font-size: 14px;"></span><span
																style="font-size: 14px;">Misją Anty-Plagiat jest
																dostarczenie rozwiązań technologicznych i
																organizacyjnych, służących poprawie jakości kształcenia
																i ochronie własności intelektualnej.</span><span
																style="color: rgb(247, 247, 247); font-family: Arial, Helvetica, sans-serif;"><span
																style="font-size: 14px;"> </span></span>
														</p>
														<p>
															<span
																style="color: rgb(247, 247, 247); font-family: Arial, Helvetica, sans-serif;"><span
																style="font-size: 14px;"><br /></span></span>
														</p>
													</div>
													<div class="cleared"></div>
												</div>
												<div class="cleared"></div>
											</div>
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
									<p>
										<a href="./#"></a> <a href="./#"></a> <a href="./#"></a>
									</p>
									<p>Copyright© 2014. All Rights Reserved.</p>
								</div>
								<div class="cleared"></div>
							</div>
						</div>
						<div class="cleared"></div>
					</div>
				</div>
				<div class="cleared"></div>
				<p class="art-page-footer">
					Zaprojektowane przez Studentów <a
						href="http://http://www.fmi.pk.edu.pl/">Wydziału Matematyki
						Fizyki i Informatyki PK</a>.
				</p>
			</div>
		</div>
	</div>
</body>
</html>
