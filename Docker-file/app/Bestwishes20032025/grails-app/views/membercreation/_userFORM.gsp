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

    .hidden-section {
        display: none;
    }

    .margin-bottom-20 {
        margin-bottom: 20px;
    }

    .col-md-3 {
        margin-bottom: 15px;
    }
</style>

<script>
    function toggleAnniversaryFields() {
        var status = document.getElementById('maritalStatus').value;
        var anniversarySection = document.getElementById('anniversarySection');
        var anniversaryImage = document.getElementById('anniversaryImage');

        if (status === 'Married') {
            anniversarySection.style.display = 'block';
            anniversaryImage.style.display = 'block';
        } else {
            anniversarySection.style.display = 'none';
            anniversaryImage.style.display = 'none';
        }
    }

    window.onload = function () {
        toggleAnniversaryFields(); // Ensure correct visibility on page load
    };
</script>

<div class="margin-bottom-20"></div>

<g:form controller="membercreation" enctype="multipart/form-data" name="validateip" class="horizontal-form">

    <!-- Contact Name -->
    <div class="col-md-3">
        <label for="contactName" class="form-label fw-bold">
            <g:message code="user.contactName.label" default="Contact Name" />
        </label>
        <g:if test="${params?.action != 'adminEdit'}">
            <g:textField name="contactName" class="form-control spinner input-circle styled-input"
                         value="${usersInstance?.contactName}" required="true" />
        </g:if>
        <g:else>
            <input name="contactName" class="form-control spinner input-circle styled-input"
                   value="${usersInstance?.contactName}" />
        </g:else>
    </div>

    <!-- Username -->
    <div class="col-md-3">
        <label for="username"><g:message code="user.username.label" default="Username" /></label>
        <g:if test="${params?.action != 'adminEdit'}">
            <g:textField name="username" class="form-control spinner input-circle styled-input"
                         value="${usersInstance?.username}" required="true" />
        </g:if>
        <g:else>
            <input name="username" class="form-control spinner input-circle styled-input"
                   value="${usersInstance?.username}" />
        </g:else>
    </div>

    <!-- Password -->
    <div class="col-md-3">
        <label for="password"><g:message code="user.password.label" default="Password" /></label>
        <g:if test="${params?.action != 'adminEdit'}">
            <g:passwordField name="password" class="form-control spinner input-circle styled-input"
                             value="${usersInstance?.password}" required="true" />
        </g:if>
        <g:else>
            <input type="password" name="password" class="form-control spinner input-circle styled-input"
                   value="${usersInstance?.password}" />
        </g:else>
    </div>

    <!-- Contact No -->
    <div class="col-md-3">
        <label for="contactNo"><g:message code="user.contactNo.label" default="Contact No." /></label>
        <input type="tel" name="contactNo" id="contactNo" class="form-control spinner input-circle styled-input"
               value="${usersInstance?.contactNo}" required="true" maxlength="10"
               pattern="^\d{10}$" title="Please enter exactly 10 digits for the contact number." />
    </div>

    <!-- Date of Birth -->
    <div class="col-md-3">
        <label for="dateOfBirth" class="form-label fw-bold">
            <g:message code="user.dateOfBirth.label" default="Date of Birth" />
        </label>
        <g:if test="${params?.action != 'adminEdit'}">
            <g:datePicker name="dateOfBirth" class="form-control styled-input"
                          value="${usersInstance?.dateOfBirth}" precision="day" required="true" />
        </g:if>
        <g:else>
            <input type="date" name="dateOfBirth" class="form-control styled-input"
                   value="${usersInstance?.dateOfBirth}" />
        </g:else>
    </div>

    <!-- Marital Status -->
    <div class="col-md-3">
        <label for="maritalStatus" class="form-label fw-bold">Marital Status</label>
        <select id="maritalStatus" name="maritalStatus" class="form-control styled-input" onchange="toggleAnniversaryFields()" required>
            <option value="">-- Select Status --</option>
            <option value="Married" ${usersInstance?.maritalStatus == 'Married' ? 'selected' : ''}>Married</option>
            <option value="unmarried" ${usersInstance?.maritalStatus == 'unmarried' ? 'selected' : ''}>unmarried</option>
        </select>
    </div>

    <!-- Anniversary Fields Section -->
    <div id="anniversarySection" class="col-md-3 hidden-section">
        <label for="dateOfAnniversary" class="form-label fw-bold">
            <g:message code="user.dateOfAnniversary.label" default="Date of Anniversary" />
        </label>
        <g:if test="${params?.action != 'adminEdit'}">
            <g:datePicker name="dateOfAnniversary" class="form-control styled-input"
                          value="${usersInstance?.dateOfAnniversary}" precision="day" required="true" />
        </g:if>
        <g:else>
            <input type="text" class="form-control styled-input" name="dateOfAnniversary"
                   id="dateOfAnniversary" placeholder="dd/MM/yyyy"
                   value="${formatDate(format:'dd/MM/yyyy', date:usersInstance?.dateOfAnniversary)}" />
        </g:else>
    </div>

    <!-- Address -->
    <div class="col-md-3">
        <label for="address"><g:message code="user.address.label" default="Address" /></label>
        <g:textField name="address" class="form-control spinner input-circle styled-input"
                     value="${usersInstance?.address ?: ''}" required="true" />
    </div>

    <!-- Contact Upload Image -->
    <div class="col-md-3">
        <label>Contact Upload Image</label>
        <input type="file" class="form-control spinner input-circle styled-input" name="file_1" />
    </div>

    <!-- Anniversary Image Upload -->
    <div class="col-md-3 hidden-section" id="anniversaryImage">
        <label>Anniversary Image</label>
        <input type="file" class="form-control spinner input-circle styled-input" name="file_2" />
    </div>

    <!-- Submit Buttons -->
    <div class="col-md-12 mt-3">
        <g:if test="${params?.action != 'userEdit'}">
            <g:actionSubmit action="saveUser" class="btn btn-primary btn-md px-5 rounded-pill shadow-sm" value="Save Details" />
        </g:if>
        <g:else>
            <g:hiddenField name="userListid" value="${usersInstance?.id}" />
            <g:actionSubmit action="updateUser" class="btn btn-success btn-lg px-5 rounded-pill shadow" value="Update Details" />
        </g:else>
    </div>

</g:form>
