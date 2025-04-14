${userdet}
hiideals
  	<div class="form-body">

		<div class="row">
		<label>Membership No:</label>
          <g:textField name="membershipNo" value="${membercreation?.membershipNo}" readonly="true" />
			<div class="col-md-3">
				<div
					class="fieldcontain ${hasErrors(bean: userdet, field: 'username', 'error')} ">
					
					<label for="username"> <g:message
							code="user.username.label" default="Username" />

					</label>
					<g:if test="${params?.action !="adminEdit"}">
						<g:textField name="username" class="form-control spinner input-circle"
							value="${userdet?.username}" required="true" />
					</g:if>
					<g:else>
						<input name="username" class="form-control spinner input-circle"
							value="${userdet?.username}" />
					</g:else>
				</div>
			</div>

			<div class="col-md-3">
				<div
					class="fieldcontain ${hasErrors(bean: userdet, field: 'password', 'error')} ">
					<label for="password"> <g:message
							code="user.password.label" default="Password" />

					</label>
					<g:if test="${params?.action !="adminEdit"}">
						<g:textField name="password" class="form-control spinner input-circle"
							value="${userdet?.password}" required="true" />
					</g:if>
					<g:else>
						<input name="password" class="form-control spinner input-circle"
							value="${userdet?.password}" />
					</g:else>
				</div>
			</div>
			<div class="col-md-3">
				<div
					class="fieldcontain ${hasErrors(bean: userdet, field: 'fullName', 'error')} ">
					<label for="fullName"> <g:message
							code="user.fullName.label" default="fullName" />

					</label>
					<g:if test="${params?.action !="adminEdit"}">
						<g:textField name="fullName" class="form-control spinner input-circle"
							value="${userdet?.fullName}" required="true" />
					</g:if>
					<g:else>
						<input name="fullName" class="form-control spinner input-circle"
							value="${userdet?.fullName}" />
					</g:else>
				</div>
			</div>

			<%--<div class="col-md-3">
<div class="fieldcontain ${hasErrors(bean: userdet, field: 'uniqueNo', 'error')} ">
	<label for="uniqueNo">
		<g:message code="user.uniqueNo.label" default="Unique No" />
		
	</label>
	<g:textField name="uniqueNo" class="form-control" value="${userdet?.uniqueNo ? userdet?.uniqueNo : uniqueNo }"/>

</div>
</div>
--%>
			<div class="col-md-3">
				<div
					class="fieldcontain ${hasErrors(bean: userdet, field: 'phoneNo', 'error')} ">
					<label for="phoneNo"> <g:message code="user.phoneNo.label"
							default="Phone No" />

					</label>
					<g:textField name="phoneNo" class="form-control spinner input-circle"
						value="${userdet?.phoneNo}" required="true" />

				</div>
			</div>
			<div class="col-md-3">
				<div
					class="fieldcontain ${hasErrors(bean: userdet, field: 'totalshareAmount', 'error')} ">
					<label for="address"> TotalShare Amount</label>
					<g:textField name="totalshareAmount" class="form-control spinner input-circle"
						value="${userdet?.totalshareAmount}" />

				</div>
			</div>

		</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<label>MonthlyShare Amount</label>
				<g:textField name="monthlyshareAmount" value="${userdet?.monthlyshareAmount}"
					class="form-control spinner input-circle" />
			</div>
					</div>
			