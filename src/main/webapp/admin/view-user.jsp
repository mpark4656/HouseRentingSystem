<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="View Existing Users" />
    <jsp:param name="stylesheets" value="form-validation.css,view-user.css" />
</jsp:include>
<body>
<jsp:include page="/templates/navigation-bar.jsp"/>
<div id="user-modal" class="modal" tabindex="-1" aria-labelledby="user-modal-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="modal-title" class="modal-title" id="user-modal-label">Modal</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="user-modal-form" class="validation-form">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="modal-username" class="form-label">Username</label>
                        <input id="modal-username" type="text" class="form-control" readonly required>
                    </div>
                    <div class="form-group">
                        <label for="modal-first-name" class="form-label">First Name</label>
                        <input id="modal-first-name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="modal-last-name" class="form-label">Last Name</label>
                        <input id="modal-last-name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="modal-email" class="form-label">E-mail Address</label>
                        <input id="modal-email" type="email" class="form-control" required>
                    </div>
                    <span class="checkbox-validation-message">You must select at least one role for this user.</span>
                    <div class="form-check">
                        <input id="modal-user-administrator"
                            type="checkbox"
                            value="administrator"
                            class="checkbox-validation">
                        <label for="modal-user-administrator">Administrator</label>
                    </div>
                    <div class="form-check">
                        <input id="modal-user-owner"
                            type="checkbox"
                            value="owner"
                            class="checkbox-validation">
                        <label for="modal-user-owner">Owner</label>
                    </div>
                    <div class="form-check">
                        <input id="modal-user-customer"
                            type="checkbox"
                            value="customer"
                            class="checkbox-validation">
                        <label for="modal-user-customer">Customer</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button id="modal-submit-button" type="submit" class="btn btn-primary">Save changes</button>
                    <button id="modal-delete-button" type="button" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container">
    <div class="row justify-content-center">
        <h1>Existing Users</h1>
    </div>
    <div class="table-responsive">
        <table id="user-table" class="table table-bordered">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email Address</th>
                    <th>Roles</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${requestScope.users}">
                <tr>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.emailAddress}"/></td>
                    <td>
                        <c:forEach var="role" items="${user.roles}">
                            <c:choose>
                                <c:when test="${role eq 'ADMINISTRATOR'}">
                                    <c:out value="<strong>${role}</strong> " escapeXml="false"/>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${role} "/>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </td>
                    <td>
                        <button data-username="${user.username}" class="btn btn-success button-view-user">View</button>
                        <button data-username="${user.username}" class="btn btn-warning button-edit-user">Edit</button>
                        <button data-username="${user.username}" class="btn btn-warning button-resetpw-user">Reset Password</button>
                        <button data-username="${user.username}" class="btn btn-danger button-delete-user">Delete</button>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
<div>
<jsp:include page="/templates/scripts.jsp">
    <jsp:param name="scripts" value="form-validation.js,view-user.js,delete-user.js,update-user.js" />
</jsp:include>
</body>
</html>