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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

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
    .styled-input {
        background-color: #f9f9f9;
        border: 2px solid #007bff;
        border-radius: 0.5rem;
        padding: 0.5rem 1rem;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .styled-input:focus {
        outline: none;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
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
									<sec:ifAnyGranted roles='ROLE_ADMIN'>
										<g:formRemote name="kk" url="[action:'createUser']"
											update="update1" class="horizontal-form">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button
												class="btn btn-primary" style="margin-top: 20px">
												<i class="fa fa-plus"></i> &nbsp;&nbsp;Create Contact
											</button>
										</g:formRemote>

										<div class="m-content">
											<div id="update1"></div>
										</div>
										<hr>

										<div class="row">
											<div class="col-md-12">
												<!-- BEGIN EXAMPLE TABLE PORTLET-->
												<div class="portlet light ">
													<div class="portlet-title">
														<div class="caption font-red">
															<i class="icon-settings font-red"></i> <span
																class="caption-subject bold uppercase">Member
																List </span>
														</div>
														<div class="tools"></div>
													</div>
													<div class="portlet-body">
    <table
        class="table table-striped table-checkable table-bordered table-hover"
        id="sample_1">
        <thead>
            <tr>
                <th>SI.No</th>
                <th>Membership No</th>
                <th>Contact Name</th>
                <th>Username</th>
                <th>Password</th>
                <th>Phone No</th>
                <th>Date of Birth</th>
                <th>Date of Anniversary</th>
                <th>Address</th>
                
                <th>Image</th>
               <th>Anniversary Photo</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${usersInstanceList?.reverse()}" status="i" var="usersInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>
                        ${i + 1}
                    </td>
                    <td>
                        ${fieldValue(bean: usersInstance, field: "membershipNo")}
                    </td>
                    <td>
                        ${fieldValue(bean: usersInstance, field: "contactName")}
                    </td>
                    <td>
                        ${fieldValue(bean: usersInstance, field: "username")}
                    </td>
                    <td>
                        ${fieldValue(bean: usersInstance, field: "password")}
                    </td>
                    <td>
                        ${fieldValue(bean: usersInstance, field: "contactNo")}
                    </td>
                    <td>
                        ${fieldValue(bean: usersInstance, field: "dateOfBirth")}
                    </td>
                    <td>
                        ${fieldValue(bean: usersInstance, field: "dateOfAnniversary")}
                    </td>
                    <td>
                        ${fieldValue(bean: usersInstance, field: "address")}
                    </td>
                   
                    <td>
                       <img
    src="${createLink(controller:'membercreation', action:'viewimg', id:usersInstance?.id)}?t=${System.currentTimeMillis()}"
    alt="Image" class="img-responsive" style="width: 50px; height: 50px;">

                    </td>
                              <td>
                       <img
    src="${createLink(controller:'membercreation', action:'viewimg1', id:usersInstance?.id)}?t=${System.currentTimeMillis()}"
    alt="Image" class="img-responsive" style="width: 50px; height: 50px;">

                    </td>
                  
                   <td>
    <g:formRemote name="editUser" url="[action:'userEdit']" update="update1">
        <g:hiddenField name="userListid" value="${usersInstance?.id}" />
        <g:submitButton name="edit" value="Edit" class="btn btn-warning" />
    </g:formRemote>

   <!-- Download Birthday Certificate Button -->
<button class="btn btn-success download-certificate" 
        data-userid="${usersInstance.id}" 
        data-username="${usersInstance.contactName}" 
        data-type="birthday">
    <i class="fa fa-download"></i> Download Birthday Certificate
</button>

<!-- Download Anniversary Certificate Button -->
<button class="btn btn-success download-certificate" 
        data-userid="${usersInstance.id}" 
        data-username="${usersInstance.contactName}" 
        data-type="anniversary">
    <i class="fa fa-download"></i> Download Anniversary Certificate
</button>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>

												</div>
											</div>
										</div>
									</sec:ifAnyGranted>

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
    document.addEventListener('DOMContentLoaded', function() {
        flatpickr('.datepicker', {
            dateFormat: 'Y-m-d', // Adjust the format if needed
            allowInput: true // Allows manual input
        });
    });
</script>

<script>
$(document).ready(function() {
    $(".download-certificate").click(function() {
        var userId = $(this).data("userid");
        var certType = $(this).data("type");

        var downloadUrl = certType === "birthday" 

            
                ? "/greeting/membercreation/downloadCertificate?id=" + userId 
                : "/greeting/membercreation/downloadCertificate2?id=" + userId;

        window.location.href = downloadUrl;
    });
});
   
</script>



</body>

</html>