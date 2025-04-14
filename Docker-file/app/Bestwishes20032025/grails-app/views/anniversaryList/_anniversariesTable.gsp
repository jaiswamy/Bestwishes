<g:if test="${!anniversaryMembers?.isEmpty()}">
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>SI. No</th>
                <th>Membership No</th>
                <th>Contact Name</th>
                <th>Date of Anniversary</th>
                 <th>PDF link</th>
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
                     <td>
                        <g:if test="${member.anniversarypdfLink}">
                            <a href="${member.anniversarypdfLink}" target="_blank">Open PDF</a>
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
        <i class="fa fa-info-circle"></i> No anniversaries today.
    </div>
</g:else>
<script>
    // Ensure this variable is available in your .gsp
    var downloadCertificateUrl = "${createLink(controller:'membercreation', action:'downloadCertificate2')}";

    document.addEventListener("DOMContentLoaded", function () {
        document.querySelectorAll(".download-certificate").forEach(button => {
            button.addEventListener("click", function () {
                let userId = this.getAttribute("data-userid");
                let username = this.getAttribute("data-username");

                if (!userId) {
                    alert("User ID is missing.");
                    return;
                }

                if (confirm(`Download certificate for ${username}?`)) {
                    let downloadUrl = downloadCertificateUrl + "?id=" + encodeURIComponent(userId);
                    window.open(downloadUrl, "_blank");
                }
            });
        });
    });
</script>
<script>
$(document).ready(function() {
    $(".open-pdf").click(function() {
        var anniversarypdfLink = $(this).data("anniversarypdfLink"); // Get the PDF link from data attribute
        if (anniversarypdfLink) {
            window.open(anniversarypdfLink, "_blank"); // Open the PDF in a new tab
        } else {
            alert("No PDF link available.");
        }
    });
});

   
</script>