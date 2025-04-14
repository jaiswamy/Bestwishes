<!DOCTYPE html>

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
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<link
	href="assets1/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets1/global/plugins/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets1/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets1/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<link href="assets1/global/plugins/datatables/datatables.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets1/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css"
	rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="assets1/global/css/components-rounded.min.css"
	rel="stylesheet" id="style_components" type="text/css" />
<link href="assets1/global/css/plugins.min.css" rel="stylesheet"
	type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<link href="assets1/layouts/layout4/css/layout.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets1/layouts/layout4/css/custom.min.css" rel="stylesheet"
	type="text/css" />
 <link href="assets1/layouts/layout4/css/themes/default.min.css" rel="stylesheet" 
 type="text/css" id="style_color" />
<!-- END THEME LAYOUT STYLES -->
<link rel="shortcut icon" href="assets1/pages/img/cowicons.png" />
<style>
    .caption {
        background-color: #f7f7f7;
        padding: 20px;
        border-radius: 8px;
        display: flex;
        align-items: center;
    }
    .btn-primary {
        background-color: #007bff;
        border-color: #007bff;
        transition: background-color 0.3s, border-color 0.3s;
    }
    .btn-primary:hover {
        background-color: #0056b3;
        border-color: #0056b3;
    }
    .fa-heart {
        font-size: 20px;
    }
</style>
</head>
<!-- END HEAD -->

<body
	class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid">
	<!-- BEGIN HEADER -->
	<div class="page-header navbar navbar-fixed-top">
		<!-- BEGIN HEADER INNER -->
		<div class="page-header-inner ">
			<!-- BEGIN LOGO -->
			<g:render template="/header/logo"></g:render>
			<!-- END LOGO -->
			<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="menu-toggler responsive-toggler"
				data-toggle="collapse" data-target=".navbar-collapse"> </a>
			<!-- END RESPONSIVE MENU TOGGLER -->
			<!-- BEGIN PAGE ACTIONS -->
			<!-- DOC: Remove "hide" class to enable the page header actions -->
			<div class="page-actions"></div>
			<!-- END PAGE ACTIONS -->
			<!-- BEGIN PAGE TOP -->
			<div class="page-top">
				<!-- BEGIN HEADER SEARCH BOX -->

				<!-- END HEADER SEARCH BOX -->
				<!-- BEGIN TOP NAVIGATION MENU -->
				<g:render template="/header/topBar"></g:render>
				<!-- END TOP NAVIGATION MENU -->
			</div>
			<!-- END PAGE TOP -->
		</div>
		<!-- END HEADER INNER -->
	</div>
	<!-- END HEADER -->
	<!-- BEGIN HEADER & CONTENT DIVIDER -->
	<div class="clearfix"></div>
	<!-- END HEADER & CONTENT DIVIDER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<!-- END SIDEBAR -->
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<g:render template="/header/leftSide"
					model="[activ:[adminssion:'start active open']]"></g:render>
				<!-- END SIDEBAR MENU -->
			</div>
			<!-- END SIDEBAR -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<!-- BEGIN CONTENT BODY -->
			<div class="page-content">
				<!-- BEGIN PAGE HEADER-->
				<!-- BEGIN THEME PANEL -->

				<!-- END THEME PANEL -->

				<div class="page-bar">
					<ul class="page-breadcrumb breadcrumb">
						<li><i class="icon-home"></i> <a href="#">Home</a>
					</ul>

				</div>
				<!-- END PAGE HEADER-->
				<div class="row">
					<div class="col-md-12">
						<div class="tabbable-line boxless tabbable-reversed"></div>
						<div class="tab-pane" id="tab_1">
							<div class="portlet box blue">
								<div class="portlet-title">
									<div class="caption"></div>
								</div>
								<div class="portlet-body form">
    <!-- BEGIN FORM-->
    <g:if test="${flash.message}">
        <div class="alert alert-success" id="mydiv">
            <div class="text-center" style="color: #000;" role="status">
                <span class="badge badge-pill badge-success">Success</span>
                ${flash.message}
            </div>
        </div>
    </g:if>

 <div class="m-content">
        <div id="update1"></div>
    </div>
    <hr>

    <div class="row">
        <div class="col-md-12">
           <!-- BEGIN EXAMPLE TABLE PORTLET -->
<div class="portlet light">
    <div class="portlet-title">
        <div class="caption font-red">
    <a href="#" id="viewAnniversariesBtn" class="btn btn-primary mt-3 d-flex align-items-center">
        <i class="fa fa-heart mr-2"></i> 
        <span>View Today's Anniversaries</span>
    </a>
</div>
        <div class="tools"></div>
    </div>
    <div class="portlet-body">
   <div id="anniversariesTable">
    <g:if test="${!anniversaryMembers?.isEmpty()}">
        <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th>SI. No</th>
                    <th>Membership No</th>
                    <th>Contact Name</th>
                    <th>Date of Anniversary</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${anniversaryMembers}" status="i" var="member">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td>${i + 1}</td>
                        <td>${fieldValue(bean: member, field: "membershipNo")}</td>
                        <td>${fieldValue(bean: member, field: "contactName")}</td>
                        <td>
                            <g:formatDate format="dd-MM-yyyy" date="${member.dateOfAnniversary}" />
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </g:if>
    <g:else>
        <div class="alert alert-info">
            <i class="fa fa-info-circle"></i> No anniversaries today.
        </div>
    </g:else>
</div>

                </div>
            </div>
        </div>
    
    <!-- END FORM-->
</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- END CONTENT BODY -->

	<!-- END CONTENT -->
	<!-- BEGIN QUICK SIDEBAR -->


	<!-- END QUICK SIDEBAR -->

	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="page-footer">
		<g:render template="/header/footer"></g:render>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN QUICK NAV -->

	<div class="quick-nav-overlay"></div>
	<!-- END QUICK NAV -->
	<!--[if lt IE 9]>
<script src="assets1/global/plugins/respond.min.js"></script>
<script src="assets1/global/plugins/excanvas.min.js"></script> 
<script src="assets1/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
	<!-- BEGIN CORE PLUGINS -->
	<script src="assets1/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="assets1/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="assets1/global/plugins/js.cookie.min.js"
		type="text/javascript"></script>
	<script
		src="assets1/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<script src="assets1/global/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script
		src="assets1/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="assets1/global/scripts/datatable.js"
		type="text/javascript"></script>
	<script src="assets1/global/plugins/datatables/datatables.min.js"
		type="text/javascript"></script>
	<script
		src="assets1/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN THEME GLOBAL SCRIPTS -->
	<script src="assets1/global/scripts/app.min.js" type="text/javascript"></script>
	<!-- END THEME GLOBAL SCRIPTS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="assets1/pages/scripts/table-datatables-rowreorder.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<!-- BEGIN THEME LAYOUT SCRIPTS -->
	<script src="assets1/layouts/layout4/scripts/layout.min.js"
		type="text/javascript"></script>
	<script src="assets1/layouts/layout4/scripts/demo.min.js"
		type="text/javascript"></script>
	<script src="assets1/layouts/global/scripts/quick-sidebar.min.js"
		type="text/javascript"></script>
	<script src="assets1/layouts/global/scripts/quick-nav.min.js"
		type="text/javascript"></script>
	<!-- END THEME LAYOUT SCRIPTS -->

	<script>
		$(document).ready(function() {
			$('#clickmewow').click(function() {
				$('#radio1003').attr('checked', 'checked');
			});
		})
	</script>
   
    <script>
    $(document).ready(function () {
        $('#viewAnniversariesBtn').click(function (e) {
            e.preventDefault(); // Prevent default link behavior
            
            $.ajax({
                url: "${createLink(controller: 'anniversaryList', action: 'fetchTodayAnniversaries')}",
                type: 'GET',
                success: function (response) {
                    // Update the table with the fetched anniversaries
                    $('#anniversariesTable').html(response);
                },
                error: function () {
                    alert('Failed to fetch anniversaries. Please try again.');
                }
            });
        });
    });
</script>


</body>

</html>

