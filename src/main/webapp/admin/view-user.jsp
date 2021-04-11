<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="View Existing Users" />
    <jsp:param name="stylesheets" value="form-validation.css,view-user.css" />
</jsp:include>
<body>
<jsp:include page="/templates/navigation-bar.jsp"/>
<div id="password-reset-modal" class="modal" tabindex="-1" aria-labelledby="password-reset-modal-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="password-reset-modal-label" class="modal-title">Modal</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="password-reset-modal-form" class="validation-form">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="password-reset-modal-username" class="form-label">Username</label>
                        <input id="password-reset-modal-username" type="text" class="form-control" readonly required>
                    </div>
                    <div class="form-group">
                        <label for="password-reset-modal-new-password" class="form-label">New Password</label>
                        <input id="password-reset-modal-new-password" type="password" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="password-reset-modal-password-confirm" class="form-label">Confirm New Password</label>
                        <input id="password-reset-modal-password-confirm"
                            type="password"
                            class="form-control"
                            data-toggle="popover"
                            data-trigger="manual"
                            title="Passwords don't match"
                            data-content="Make sure you entered the password correctly." required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button id="password-reset-modal-submit-button" type="submit" class="btn btn-danger">
                        Reset Password
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="user-modal" class="modal" tabindex="-1" aria-labelledby="user-modal-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="user-modal-label" class="modal-title">Modal</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="user-modal-form" class="validation-form">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="user-modal-username" class="form-label">Username</label>
                        <input id="user-modal-username" type="text" class="form-control" readonly required>
                    </div>
                    <div class="form-group">
                        <label for="user-modal-first-name" class="form-label">First Name</label>
                        <input id="user-modal-first-name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="user-modal-last-name" class="form-label">Last Name</label>
                        <input id="user-modal-last-name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="user-modal-email" class="form-label">E-mail Address</label>
                        <input id="user-modal-email" type="email" class="form-control" required>
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
                    <button id="user-modal-submit-button" type="submit" class="btn btn-primary">Save changes</button>
                    <button id="user-modal-delete-button" type="button" class="btn btn-danger">Delete</button>
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
    <jsp:param name="scripts" value="user-form-validation.js,view-user.js,delete-user.js,update-user.js,reset-password.js" />
</jsp:include>
</body>
</html>