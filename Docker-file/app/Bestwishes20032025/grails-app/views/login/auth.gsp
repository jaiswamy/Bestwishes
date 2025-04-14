<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.7
Version: 4.7.5
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
<meta charset="utf-8" />
<title>BestWishes</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="Animate Research"
	name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link
	href="../assets1/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="../assets1/global/plugins/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="../assets1/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="../assets1/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<link href="../assets1/global/plugins/select2/css/select2.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="../assets1/global/plugins/select2/css/select2-bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="../assets1/global/css/components-rounded.min.css"
	rel="stylesheet" id="style_components" type="text/css" />
<link href="../assets1/global/css/plugins.min.css" rel="stylesheet"
	type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="../assets1/pages/css/login.min.css" rel="stylesheet"
	type="text/css" />
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<!-- END THEME LAYOUT STYLES -->
<link rel="shortcut icon" href="../assets1/pages/img/cowicons.png" />
</head>
<!-- END HEAD -->

<body class=" login"
	style="background-image:url('../assets1/pages/img/B5.png');background-repeat: no-repeat;
  background-attachment: fixed; background-position: center;background-size: cover;
  position: relative;">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<a href="index.html"> <img
			src="../assets1/layouts/layout2/img/banker.png" alt="" />
		</a>
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="login-form" action='${postUrl}' method='POST'
			 autocomplete='off' id="text">
			<h3 class="form-title font-green">Sign In</h3>

			<g:if test='${flash.message}'>
				<div class='login_message' style="color: red">
					${flash.message}
				</div>
			</g:if>

			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span> Enter any username and password. </span>
			</div>
			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<input class="form-control form-control-solid placeholder-no-fix"
					type="text" autocomplete="off" placeholder="Username" 
					name="j_username" />
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<input class="form-control form-control-solid placeholder-no-fix"
					type="password" autocomplete="off" placeholder="Password"
					name="j_password"  />
			</div>
			<div class="form-actions" style="text-align: center;">
				<button type="submit" class="btn green uppercase" id=submit
					value='${message(code: "springSecurity.login.button")}'>Login</button>
				<!--  <label class="rememberme check mt-checkbox mt-checkbox-outline">
					<input type="checkbox" name="remember" value="1" />Remember <span></span>
				</label>-->

			</div>

			<div class="create-account"
				style="background-color: #041832; !important">
				<p>
					<a href="javascript:;" class="uppercase"  >2024 © BestWishes Powered by Hi-Ideals Technologies </a>
				</p>
				
			</div>
		</form>
		<!-- END LOGIN FORM -->
		<!-- BEGIN FORGOT PASSWORD FORM -->

		<!-- END FORGOT PASSWORD FORM -->
		<!-- BEGIN REGISTRATION FORM -->

		<!-- END REGISTRATION FORM -->
	</div>
	
	<!--[if lt IE 9]>
<script src="../assets1/global/plugins/respond.min.js"></script>
<script src="../assets1/global/plugins/excanvas.min.js"></script> 
<script src="../assets1/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
	<!-- BEGIN CORE PLUGINS -->
	<script src="../assets1/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="../assets1/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="../assets1/global/plugins/js.cookie.min.js"
		type="text/javascript"></script>
	<script
		src="../assets1/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<script src="../assets1/global/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script
		src="../assets1/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script
		src="../assets1/global/plugins/jquery-validation/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script
		src="../assets1/global/plugins/jquery-validation/js/additional-methods.min.js"
		type="text/javascript"></script>
	<script src="../assets1/global/plugins/select2/js/select2.full.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN THEME GLOBAL SCRIPTS -->
	<script src="../assets1/global/scripts/app.min.js"
		type="text/javascript"></script>
	<!-- END THEME GLOBAL SCRIPTS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="../assets1/pages/scripts/login.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<!-- BEGIN THEME LAYOUT SCRIPTS -->
	<!-- END THEME LAYOUT SCRIPTS -->
	<script>
		$(document).ready(function() {
			$('#clickmewow').click(function() {
				$('#radio1003').attr('checked', 'checked');
			});
		})
	</script>
	<script>
		document.getElementById("text").addEventListener("keyup", function(e) {
			if (e.keyCode === 13) {
				document.getElementById("submit").click();
			}
		});
		document.getElementById("submit").onclick = function() {
			document.getElementById("submit").click();
		}
	</script>

</body>

</html>