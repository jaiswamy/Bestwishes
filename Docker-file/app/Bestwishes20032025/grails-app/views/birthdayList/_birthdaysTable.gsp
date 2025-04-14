<g:if test="${!birthdayMembers?.isEmpty()}">
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>SI. No</th>
                <th>Membership No</th>
                <th>Contact Name</th>
                <th>Date of Birth</th>
                <th>PDF link</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${birthdayMembers}" status="i" var="member">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${i + 1}</td>
                    <td>${fieldValue(bean: member, field: "membershipNo")}</td>
                    <td>${fieldValue(bean: member, field: "contactName")}</td>
                    <td>
                        <g:formatDate format="dd-MM-yyyy" date="${member.dateOfBirth}" />
                    </td>
                 <td><g:if test="${member.birthdaypdfLink}">
                            <a href="${member.birthdaypdfLink}" target="_blank">Open PDF</a>
                        </g:if>
                        <g:else>
                            No Link
                        </g:else>
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>
</g:if>
<g:else>
    <div class="alert alert-info">
        <i class="fa fa-info-circle"></i> No birthdays today.
    </div>
</g:else>
<script>
$(document).ready(function() {
    $(".open-pdf").click(function() {
        var birthdaypdfLink = $(this).data("birthdaypdfLink"); // Get the PDF link from data attribute
        if (birthdaypdfLink) {
            window.open(birthdaypdfLink, "_blank"); // Open the PDF in a new tab
        } else {
            alert("No PDF link available.");
        }
    });
});

   
</script>