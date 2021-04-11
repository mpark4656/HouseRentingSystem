<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="Login - House Rental System" />
    <jsp:param name="stylesheets" value="default.css" />
</jsp:include>
<body>
    <jsp:include page="/templates/navigation-bar.jsp" />
    <c:if test="${param.err == 'true'}">
        <div class="alert alert-danger text-center" role="alert">
            Check your username/password and try again
        </div>
    </c:if>
    <c:if test="${param.logout == 'true'}">
        <div class="alert alert-success text-center" role="alert">
            You have successfully logged out
        </div>
    </c:if>
    <div class="container">
        <div class="row justify-content-center">
            <h1>House Rental System</h1>
        </div>
        <div class="row justify-content-center">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="input-username">Username:</label>
                    <input type="text" id="input-username" name="username" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="input-password">Password:</label>
                    <input type="password" id="input-password" name="password" class="form-control" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Sign In</button>
                    <button type="reset" class="btn btn-warning">Reset</button>
                </div>
            </form>
        </div>
    </div>
    <jsp:include page="/templates/scripts.jsp" />
</body>
</html>