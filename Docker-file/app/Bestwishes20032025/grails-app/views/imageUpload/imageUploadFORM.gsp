<div class="margin-bottom-20"></div>
    <g:form controller="imageUpload" action="save" method="post" enctype="multipart/form-data" class="horizontal-form">
    <input type="hidden" name="uploadSource" value="form_upload" /> <!-- Identification Mark -->
    <div class="form-body">
        <div class="row">
            <div class="col-md-3">
                <label>Date of Birth Image</label>
                <input type="file" name="dobFile" class="form-control" required />
            </div>
            <div class="col-md-3">
                <label>Date of Anniversary Image</label>
                <input type="file" name="doaFile" class="form-control" required />
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <g:actionSubmit id="submitButton" action="save" class="btn btn-primary" value="Submit" />
            </div>
        </div>
    </div>
</g:form>


<script>
    function disableSubmitButton() {
        document.getElementById('submitButton').disabled = true;
    }
</script>
