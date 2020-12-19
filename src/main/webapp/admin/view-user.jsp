<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="View Existing Users" />
    <jsp:param name="stylesheets" value="view-user.css" />
</jsp:include>
<body>
<jsp:include page="/templates/navigation-bar.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <h1>Existing Users</h1>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered">
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
                            <c:out value="${role} "/>
                        </c:forEach>
                    </td>
                    <td>
                        <button data-username="${user.username}" class="btn btn-success button-view-user">View</button>
                        <button data-username="${user.username}" class="btn btn-warning button-edit-user">Edit</button>
                        <button data-username="${user.username}" class="btn btn-danger button-delete-user">Delete</button>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
<div>
<jsp:include page="/templates/scripts.jsp">
    <jsp:param name="scripts" value="view-user.js" />
</jsp:include>
</body>
</html>