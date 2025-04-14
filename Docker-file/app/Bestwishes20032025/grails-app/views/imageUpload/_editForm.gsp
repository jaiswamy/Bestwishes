<div class="portlet box blue">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-edit"></i> Edit Short Term Loan
        </div>
    </div>
    <div class="portlet-body form">
        <g:form name="editLoanForm" action="update" id="${shortTermLoanInstance.id}" method="POST" class="form-horizontal">
            <g:hiddenField name="id" value="${shortTermLoanInstance?.id}" />
            <div class="form-body">
                <!-- Loan Sanction Year -->
                <div class="form-group row">
                    <label for="loanSanctionYear" class="col-sm-3 col-form-label text-right font-weight-bold">
                        Loan Sanction Year:
                    </label>
                    <div class="col-sm-6">
                        <g:textField name="loanSanctionYear" class="form-control"
                                     placeholder="Enter Loan Sanction Year"
                                     value="${shortTermLoanInstance?.loanSanctionYear}" required="true" />
                    </div>
                </div>

                <!-- Loan Amount -->
                <div class="form-group row">
                    <label for="loanAmount" class="col-sm-3 col-form-label text-right font-weight-bold">
                        Loan Amount:
                    </label>
                    <div class="col-sm-6">
                        <g:textField name="loanAmount" class="form-control"
                                     placeholder="Enter Loan Amount"
                                     value="${shortTermLoanInstance?.loanAmount}" required="true" />
                    </div>
                </div>

                <!-- Duration in Months -->
                <div class="form-group row">
                    <label for="durationInMonths" class="col-sm-3 col-form-label text-right font-weight-bold">
                        Duration (Months):
                    </label>
                    <div class="col-sm-6">
                        <g:textField name="durationInMonths" class="form-control"
                                     placeholder="Enter Duration in Months"
                                     value="${shortTermLoanInstance?.durationInMonths}" required="true" />
                    </div>
                </div>

                <!-- Rate of Interest -->
                <div class="form-group row">
                    <label for="rateOfInterest" class="col-sm-3 col-form-label text-right font-weight-bold">
                        Rate of Interest (%):
                    </label>
                    <div class="col-sm-6">
                        <g:textField name="rateOfInterest" class="form-control"
                                     placeholder="Enter Rate of Interest"
                                     value="${shortTermLoanInstance?.rateOfInterest}" required="true" />
                    </div>
                </div>

                <!-- Select Month -->
                <div class="form-group row">
                    <label for="selectedMonth" class="col-sm-3 col-form-label text-right font-weight-bold">
                        Select Month:
                    </label>
                    <div class="col-sm-6">
                        <select name="selectedMonth" id="selectedMonth" class="form-control" required>
                            <option value="" disabled selected>Select Month</option>
                            <g:each in="${['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']}" var="month">
                                <option value="${month}" ${shortTermLoanInstance?.selectedMonth == month ? 'selected' : ''}>
                                    ${month}
                                </option>
                            </g:each>
                        </select>
                    </div>
                </div>
            </div>

            <!-- Form Actions -->
            <div class="form-actions text-center">
                <g:submitButton name="update" class="btn btn-primary btn-lg" value="Update" />
                <button type="button" class="btn btn-secondary btn-lg" onclick="$('#editFormContainer').hide();">Cancel</button>
            </div>
        </g:form>
    </div>
</div>
