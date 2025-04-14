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
                        <li><i class="icon-home"></i> <a href="#">Home</a></li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">Image Upload</div>
                            </div>
                            <div class="portlet-body form">
                                <g:if test="${flash.message}">
                                    <div class="alert alert-success">
                                        <div class="text-center" style="color: #000;" role="status">
                                            <span class="badge badge-pill badge-success">Success</span>
                                            ${flash.message}
                                        </div>
                                    </div>
                                </g:if>
                               <g:formRemote name="kk" url="[action:'imageUploadFORM']" update="update1" class="horizontal-form">
    <button class="btn btn-primary" style="margin-top: 20px">
        <i class="fa fa-plus"></i> &nbsp;&nbsp;Image Upload Form
    </button>
</g:formRemote>
                                <div class="m-content">
                                    <div id="update1"></div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="portlet light">
                                            <div class="portlet-title">
                                                <div class="caption font-red">
                                                    <i class="icon-settings font-red"></i> <span class="caption-subject bold uppercase">Uploaded Images</span>
                                                </div>
                                            </div>
                                        <div class="portlet-body">
                                     <table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>SI.No</th>
            <th>Date of Birth Image</th>
            <th>Date of Anniversary Image</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <g:if test="${imageList?.size() > 0}">
            <g:each in="${imageList}" status="i" var="image">
                <tr>
                    <td>${i + 1}</td>
                    <td>
                        <g:if test="${image?.dobImage}">
                            <img src="${createLink(controller: 'imageUpload', action: 'viewimg', id: image.id, params: [type: 'dob'])}" 
                                alt="DOB Image" class="img-responsive" style="width: 50px; height: 50px;" />
                        </g:if>
                        <g:else>
                            <span class="text-muted">No DOB Image</span>
                        </g:else>
                    </td>
                    <td>
                        <g:if test="${image?.doaImage}">
                            <img src="${createLink(controller: 'imageUpload', action: 'viewimg', id: image.id, params: [type: 'doa'])}" 
                                alt="DOA Image" class="img-responsive" style="width: 50px; height: 50px;" />
                        </g:if>
                        <g:else>
                            <span class="text-muted">No DOA Image</span>
                        </g:else>
                    </td>
                    <td>
                        <g:link action="delete" id="${image.id}" class="btn btn-danger" 
                                onclick="return confirm('Are you sure you want to delete this image?');">
                            <i class="fa fa-trash-o"></i> Delete
                        </g:link>
                    </td>
                </tr>
            </g:each>
        </g:if>
        <g:else>
            <tr>
                <td colspan="4" class="text-center">No images uploaded from this form.</td>
            </tr>
        </g:else>
    </tbody>
</table>


</div>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="page-footer">
        <g:render template="/header/footer"></g:render>
    </div>
    <script src="assets1/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="assets1/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
