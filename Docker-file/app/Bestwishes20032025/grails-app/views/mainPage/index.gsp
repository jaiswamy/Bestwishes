<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>

<!--[if lt IE 10]><link rel="stylesheet" type="text/css" href="css/ie.css"/><![endif]-->
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-N37K4R8');</script>
<!-- End Google Tag Manager -->

<meta charset="utf-8" />
<title>BestWishes</title>



<link href="assets2/plugins/socicon/socicon.css" rel="stylesheet"
	type="text/css" />
<link href="assets2/plugins/bootstrap-social/bootstrap-social.css"
	rel="stylesheet" type="text/css" />
<link href="assets2/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets2/plugins/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets2/plugins/animate/animate.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets2/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN: BASE PLUGINS  -->
<link href="assets2/plugins/cubeportfolio/css/cubeportfolio.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets2/plugins/owl-carousel/owl.carousel.css"
	rel="stylesheet" type="text/css" />
<link href="assets2/plugins/owl-carousel/owl.theme.css" rel="stylesheet"
	type="text/css" />
<link href="assets2/plugins/owl-carousel/owl.transitions.css"
	rel="stylesheet" type="text/css" />
<link href="assets2/plugins/fancybox/jquery.fancybox.css"
	rel="stylesheet" type="text/css" />
<link href="assets2/plugins/slider-for-bootstrap/css/slider.css"
	rel="stylesheet" type="text/css" />

<link href="assets2/base/css/plugins.css" rel="stylesheet"
	type="text/css" />
<link href="assets2/base/css/components.css" id="style_components"
	rel="stylesheet" type="text/css" />
<link href="assets2/base/css/themes/default.css" rel="stylesheet"
	id="style_theme" type="text/css" />
<link href="assets2/base/css/custom.css" rel="stylesheet"
	type="text/css" />
<link href="assets2/style.css" rel="stylesheet" type="text/css" />
<link href="assets2/normalize.css" rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
 <link rel="shortcut icon" href="stylesheet/images/favicon.png">
<script type="text/javascript"
	src="lesscss/js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="lesscss/js/plugins/jquery/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="lesscss/js/plugins/bootstrap/bootstrap.min.js"></script>


<script type="text/javascript"
	src="lesscss/js/plugins/jquery-validation/jquery.validate.min.js"></script>
	
	
	<style>
	 .chatApp{
	
	position:fixed;
	bottom:10px;
	right:0px;
	z-index:1000;
}
	.c-twitter1 
	{
		background: #f9f9f9;
		margin: 0;
		font-family: 'Open Sans', sans-serif;
		font-weight: 400;
		font-size: 0.813em;
		line-height: 1.6em;
		color: #5c666b;
		text-align:justify;
	}
	label
	{
		color:red;
	}
	
	</style>
</head>
<body
	class="c-layout-header-fixed c-layout-header-mobile-fixed">
	<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-N37K4R8"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
<div class="chatApp">
<ul class="list-unstyled">
	<%--<li>
		<a href="https://join.skype.com/bot/97257265-afbe-4efd-8762-fff31608ebd2" target="_blank">
		<img src="http://et.e-trucktax.com/wp-content/uploads/2018/10/skypeBot.png" title="Skype Chat" style="width:50px"/>
		</a>
	</li>
	--%><li>
		<a href='http://et.e-trucktax.com/virtualAssistanteTtVa78fc730ef2a35b5086d1b84c9a64AsTnt456214.php' onclick='window.open(this.href,"popupwindow", "width=500,height=800,left=800,top=5,scrollbars,toolbar=0,resizable"); return false;' Target='_blank' ><img src="img/botIcon.png" title="Hi <sec:username/>, How can I help you?" style="width:70px;"/></a>
	</li>
	<%--<li>
		<a href='https://m.me/346042169296978'  onclick='window.open(this.href,"popupwindow", "width=500,height=800,left=800,top=5,scrollbars,toolbar=0,resizable"); return false;' Target='_blank' ><img src="http://et.e-trucktax.com/wp-content/uploads/2018/10/fbBot.png" title="Facebook Messenger" style="width:60px"/></a>
	</li>
--%></ul>

</div>
	
	<g:render template="/shared/staticheader"></g:render>
	

	
	<div class="c-layout-page">

	
		<div class="c-content-box c-size-md"  style="background-image: url(assets2/base/img/content/backgrounds/bg-100.jpg)">
			<div class="container">
				<div class="c-shop-login-register-1">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default c-panel">
								<div class="panel-body c-panel-body">

									<g:if test="${flash.email}">
										<div class="message" role="status"
											style="font-size: medium; margin-left: 120px; color: red;">
											${flash.email}
										</div>
									</g:if>
								

									
									
									<form  method="post"
										action="register/createUser" class="c-form-login">
										<p
											style="color: #32c5d2; font-size: 20px;text-align:center">
											<b>SIGN UP</b>
										</p>
										
										
											<g:if test="${flash.emailverify}">
										<div class="message" role="status"
											style="font-size: medium; color: green; font-size: 21px; margin-top: 20px;">											${flash.emailverify}
										</div>
									</g:if>

										<br>
										<br>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group">

													<input type="text" id="username" name="username"
														regex="/^[a-zA-Z](?!.*  )(?!.*  )[a-zA-Z0-9 _\-\@]{4,40}$/"
														class="form-control c-square c-theme input-lg"
														placeholder="Your username" value="" />

												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">

													<input type="number" id="phoneno" name="phoneno"
														min=10 max=10
														class="form-control c-square c-theme input-lg"
														placeholder="Your Phonenumber" value="" />

												</div>
											</div>
											<div class="col-md-6">

												<div class="form-group">
													<input type="email" name="email"
														class="form-control c-square c-theme input-lg"
														placeholder="Your e-mail" value="" />
												</div>
											</div>
										</div>


										<div class="row">
											<div class="col-md-6">

												<div class="form-group">
													<input type="password" name="password"
														class="form-control c-square c-theme input-lg"
														placeholder="password" id="password"
														value="${userInstance?.password}" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<input type="password" name="re-password"
														class="form-control c-square c-theme input-lg"
														placeholder="Repeat password"
														value="${userInstance?.confirmpassword}" />

												</div>
											</div>
										</div>
									
									  
									  <br>
                                     
										<button
											class=" btn btn-lg c-theme-btn c-btn-square c-btn-uppercase c-btn-bold"
											type="submit">Sign Up</button>

													 <div class="btn btn-lg c-theme-btn c-btn-square c-btn-uppercase c-btn-bold">
										
										<g:link controller="login" action="auth" style="color:white">Back</g:link>
										
										</div>

									</form>

									<div class="sp"></div>

								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
		<!-- END: CONTENT/SHOPS/SHOP-LOGIN-REGISTER-1 -->
		<!-- END: PAGE CONTENT -->
	</div>
	<!-- END: PAGE CONTAINER -->
	<!-- BEGIN: LAYOUT/FOOTERS/FOOTER-6 -->
	<a name="footer"></a>
	<footer class="c-layout-footer">
		<div class="c-content-box c-size-md c-bg-white"
			>
			<div class="container">
				<div class="c-prefooter c-bg-white">


					<div class="c-body">
						<div class="row" >

							<div class="col-md-4 col-sm-6 col-xs-12">
								<div class="c-content-title-1 c-title-md">
									<h3 class="c-title c-font c-font-bold" style="color:#32c5d2">Sequro</h3>
									<div class="c-line-left hide"></div>
								</div>
								<div class="c-twitter">
								
									<P>
										<a href="mailto: support@sequrotechnologies.com"> support@sequrotechnologies.com</a>
									</P>
									<!-- p><strong>Contact Us : 609-582-4196</strong></p-->
								</div>
							</div>
							

							

							
						</div>
					</div>
				</div>

			</div>
		</div>
		</div>
		<div class="c-postfooter c-bg-dark-2">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						 <img src="assets2/base/img/layout/logos/log1.png" alt="E-trucktax form 2290 filing" style="margin-top:8px">
					</div>

					<div class="col-md-5" style="margin-top: 13px">
						<p class="" style="color: white">
							Copyright &copy; 2024 by <a href="#" target="_blank"
								style="color: white">www.sequrotechnologies.com All Rights Reserved</a>
						</p>
					</div>

					<div class="col-md-4" style="margin-top: 13px">
						<p style="color: white">
							
								<b style="color: white">Terms & Conditions</b>
							
						</p>
					</div>
				</div>
				<div class="clear"></div>

			</div>
		</div>



	</footer>
	<script>
		$('[id="username"]').on('change', function() {
			var input = $('#username');
			input.val(input.val().replace(/ +(?= )/g, function(str) {
				return '';
			})); //trim multiple spaces

		});
	</script>
	<script type="text/javascript">
		$("#signupForm").validate({
			rules : {
				login : {
					required : true,
					minlength : 2
				},
				password : {
					required : true,
					minlength : 8
				},
				're-password' : {
					required : true,
					minlength : 8,
					equalTo : "#password"
				},
				email : {
					required : true,
					email : true
				},
				username : {
					required : true,
					minlength : 5,
					maxlength : 40

				}
			}
		});

		$.validator.addMethod("regex", function(value, element, regstring) {
			// fast exit on empty optional
			if (this.optional(element)) {
				return true;
			}

			var regParts = regstring.match(/^\/(.*?)\/([gim]*)$/);
			if (regParts) {
				// the parsed pattern had delimiters and modifiers. handle them. 
				var regexp = new RegExp(regParts[1], regParts[2]);
			} else {
				// we got pattern string without delimiters
				var regexp = new RegExp(regstring);
			}

			return regexp.test(value);
		}, "Please enter the characters between 5 to 40.");
	</script>
	<script src="../assets2/global/plugins/excanvas.min.js"></script>
	<script src="assets2/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="assets2/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script src="assets2/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="assets2/plugins/jquery.easing.min.js"
		type="text/javascript"></script>
	<script src="assets2/plugins/reveal-animate/wow.js"
		type="text/javascript"></script>
	<script src="assets2/base/js/scripts/reveal-animate/reveal-animate.js"
		type="text/javascript"></script>
	<!-- END: CORE PLUGINS -->
	<!-- BEGIN: LAYOUT PLUGINS -->
	<script
		src="assets2/plugins/cubeportfolio/js/jquery.cubeportfolio.min.js"
		type="text/javascript"></script>
	<script src="assets2/plugins/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<script src="assets2/plugins/counterup/jquery.counterup.min.js"
		type="text/javascript"></script>
	<script src="assets2/plugins/counterup/jquery.waypoints.min.js"
		type="text/javascript"></script>
	<script src="assets2/plugins/fancybox/jquery.fancybox.pack.js"
		type="text/javascript"></script>
		<script type="text/javascript"></script>
	<script
		src="assets2/plugins/slider-for-bootstrap/js/bootstrap-slider.js"
		type="text/javascript"></script>
	<!-- END: LAYOUT PLUGINS -->
	<!-- BEGIN: THEME SCRIPTS -->
	<script src="assets2/base/js/components.js" type="text/javascript"></script>
	<script src="assets2/base/js/components-shop.js" type="text/javascript"></script>
	<script src="assets2/base/js/app.js" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			App.init(); // init core    
		});
	</script>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script','https://www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-104333473-1', 'auto');
		ga('send', 'pageview');
	</script>
	
</body>
</html>