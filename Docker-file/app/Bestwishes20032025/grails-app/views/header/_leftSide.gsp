<ul
	class="page-sidebar-menu  page-header-fixed page-sidebar-menu-hover-submenu "
	data-keep-expanded="false" data-auto-scroll="true"
	data-slide-speed="200">



	<%--<li class="nav-item start active open"><g:link
			controller="superadmin" action="indexx" class="nav-link nav-toggle">
			<i class="icon-home"></i>
			<span class="title">Dashboard</span>
			<span class="selected"></span>
			<span class="arrow open"></span>
		</g:link></li>
	--%><sec:ifAnyGranted roles="ROLE_SUPERADMIN">
		<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="fa fa-plus"></i> <span
				class="title">Create Admin</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				<li class="nav-item  "><g:link controller="superadmin"
						action="index" class="nav-link ">
						<span class="title">Create Admin</span>
					</g:link></li>
				<li class="nav-item  "><g:link controller="superadmin"
						action="index" class="nav-link ">
						<span class="title">View AdminList</span>
					</g:link></li>
			</ul></li>
	</sec:ifAnyGranted>
	
	<sec:ifAnyGranted roles="ROLE_ADMIN">
		<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="fa fa-plus"></i> <span
				class="title"> Create Contact</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				<li class="nav-item  "><g:link controller="membercreation"
						action="index" class="nav-link ">
						<span class="title">Create Contact</span>
					</g:link></li>
				<li class="nav-item  "><g:link controller="membercreation"
						action="index" class="nav-link ">
						<span class="title">View ContactList</span>
					</g:link></li>
			</ul></li>
			
			
			<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="icon-user"></i> <span
				class="title"> Image Upload</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				
				<li class="nav-item  "><g:link controller="imageUpload"
						action="index" class="nav-link ">
						<span class="title">Upload Templates </span>
					</g:link></li>
										
		
			</ul>
			<li class="nav-item  "> 
				  <g:link controller="birthdayList" action="index" class="nav-link">
						<i class="fa fa-birthday-cake" aria-hidden="true"></i><span class="title">Birthday List</span>
					</g:link></li>
				<li class="nav-item  "> 
				  <g:link controller="anniversaryList" action="index" class="nav-link">
						<i class="fa fa-gift" aria-hidden="true"></i><span class="title">Anniversary List</span>
					</g:link></li>	
		<!--	<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="icon-user"></i> <span
				class="title"> MonthlyCollection </span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				
				<li class="nav-item  "><g:link controller="monthlyCollection"
						action="index" class="nav-link ">
						<span class="title">MonthlyCollection Form</span>
					</g:link></li>
	
			
		
				
				<li class="nav-item  "> 
				  <g:link controller="monthlyCollection" action="index" class="nav-link">
						<span class="title">MonthlyCollection List</span>
					</g:link></li>

			</ul>
			</li>
			<!--  <li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="icon-user"></i> <span
				class="title"> Pending List</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				
				<li class="nav-item  "><g:link controller="report"
						action="pending" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>
			</ul></li>
			
			<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="icon-user"></i> <span
				class="title"> Closed List</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				
				<li class="nav-item  "><g:link controller="report"
						action="closed" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>
			</ul></li>
			
			
			
			
	</sec:ifAnyGranted>
	
	
	<sec:ifAnyGranted roles="ROLE_VCADMIN">
		<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="fa fa-plus"></i> <span
				class="title"> Create Section</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				<li class="nav-item  "><g:link controller="usercreate"
						action="index" class="nav-link ">
						<span class="title">Create Section</span>
					</g:link></li>
					
				<li class="nav-item  "><g:link controller="usercreate"
						action="index" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>
			       </ul></li>


             	<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="icon-user"></i> <span
				class="title"> Create Viewer</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				<li class="nav-item  "><g:link controller="viewerUsercreate"
						action="viewerIndex" class="nav-link ">
						<span class="title">Create Viewer</span>
					</g:link></li>
				<li class="nav-item  "><g:link controller="viewerUsercreate"
						action="viewerIndex" class="nav-link ">
						<span class="title"> Viewer View List</span>
					</g:link></li>
			</ul></li>

		<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="icon-user"></i> <span
				class="title"> Create InwardForm</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				<li class="nav-item  "><g:link controller="inwardform"
						action="create" class="nav-link ">
						<span class="title">Create Inward</span>
					</g:link></li>
				<li class="nav-item  "><g:link controller="inwardform"
						action="index" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>
			</ul></li>
			
			<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="fa fa-list"></i> <span
				class="title"> Approved List</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				
				<li class="nav-item  "><g:link controller="report"
						action="approved" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>
			</ul></li>
			
			<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="fa fa-list"></i> <span
				class="title"> Pending List</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				
				<li class="nav-item  "><g:link controller="report"
						action="pending" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>
			</ul></li>
			
			<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="fa fa-list"></i> <span
				class="title"> Closed List</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				
				<li class="nav-item  "><g:link controller="report"
						action="closed" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>
			</ul></li>


	</sec:ifAnyGranted>

	<sec:ifAnyGranted roles="ROLE_USER">

		<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"><i class="fa fa-file"></i><span
				class="title">View Reports</span> <span class="arrow"></span> </a>
			<ul class="sub-menu">
				<li class="nav-item  ">
				<li class="nav-item  "><g:link controller="inwardform"
						action="userlist" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>

			</ul></li>

	</sec:ifAnyGranted>
	
	<sec:ifAnyGranted roles="ROLE_DUSER">
		
			
			
			<li class="nav-item  "><a href="javascript:;"
			class="nav-link nav-toggle"> <i class="fa fa-list"></i> <span
				class="title"> Inward Form Lists</span> <span class="arrow"></span>
		</a>
			<ul class="sub-menu">
				
				<li class="nav-item  "><g:link controller="inwardform"
						action="viewerList" class="nav-link ">
						<span class="title">View List</span>
					</g:link></li>
			</ul></li>-->
			
	</sec:ifAnyGranted>
	
	
	
</ul>



<style>
.page-sidebar .page-sidebar-menu>li>a {
	min-height: 50px !important;
	display: block !important;
	position: relative !important;
	margin: 0;
	border: 0;
	padding: 10px 0px 0px !important;
	text-decoration: none;
	font-size: 15px !important;
	font-weight: 600 !important;
	text-align: center !important;
}

.page-sidebar .page-sidebar-menu .sub-menu li>a {
	font-size: 15px !important;
	font-weight: 600 !important;
	color: #7d97f4 !important;
}
</style>