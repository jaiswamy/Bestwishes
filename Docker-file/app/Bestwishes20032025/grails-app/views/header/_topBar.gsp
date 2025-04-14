<!--  <div class="top-menu">
	<ul class="nav navbar-nav pull-right">
		<li class="dropdown dropdown-user"><a href="javascript:;"
			class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
			data-close-others="true"> <images:getProfilePic /> <span
				class="username username-hide-on-mobile"> <sec:username />
			</span> <i class="fa fa-angle-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-menu-default">
				<li><a href="#"> <i class="icon-user"></i> My Profile
				</a></li>

				<li><a> <sec:ifLoggedIn>

							<form name="submitForm" method="POST" style="margin: 4px 18px"
								action="${createLink(controller: 'logout')}">
								<i class="icon-key"></i> <input type="hidden" name="" value="">
								<a HREF="javascript:document.submitForm.submit()"> Logout </a>
							</form>

						</sec:ifLoggedIn> <sec:ifNotLoggedIn>
							<i class="icon-key"></i>
							<g:link controller="login" action="auth">
									Login
								</g:link>
						</sec:ifNotLoggedIn>

				</a></li>
			</ul></li>
	</ul>
</div>-->



<div class="top-menu">
	<ul class="nav navbar-nav pull-right">
		<!-- BEGIN NOTIFICATION DROPDOWN -->

		<li class="dropdown dropdown-user"><a href="javascript:;"
			class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
			data-close-others="true">
			
			
			
			<sec:ifAnyGranted roles="ROLE_USER">
				<img alt="" class="img-circle"
				src="assets1/layouts/layout2/img/avatar.png" style="width: 35px; height: 35px;"/> 
			
			</sec:ifAnyGranted>
			
			<sec:ifAnyGranted roles="ROLE_SUPERADMIN">
			<img alt="" class="img-circle"
				src="assets1/layouts/layout2/img/avatar.png" /> 
							</sec:ifAnyGranted>
				
			<sec:ifAnyGranted roles="ROLE_ADMIN">
			 <img
				src="${createLink(controller:'superadmin', action:'viewPimg', id:userimageIstance?.id)}"
				alt="Image" class="img-circle" style="width: 35px; height: 35px;">
				</sec:ifAnyGranted>
				<span class="username username-hide-on-mobile"> <sec:username /></span>
				<i class="fa fa-angle-down"></i>
		</a>
		
		<div class="user-menu dropdown-menu" style="background-color: transparent; margin-top: 2px;">
				<sec:ifLoggedIn>
					<g:form controller="logout">
						<div class="list-item-content">
							<span style="padding: 0 50px;"> </span>
							<g:submitButton name="Log Out" class="btn btn-warning" />
						</div>
					</g:form>
				</sec:ifLoggedIn>
			</div>
		
			
			
			
			</li>
		<!-- END USER LOGIN DROPDOWN -->
		<!-- BEGIN QUICK SIDEBAR TOGGLER -->

		<!-- END QUICK SIDEBAR TOGGLER -->
	</ul>
</div>
