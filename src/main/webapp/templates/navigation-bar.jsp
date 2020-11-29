<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-md navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="../img/logo.png" width="30" height="30" loading="lazy">
        HRS
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <c:forEach var="role" items="${sessionScope.user.roles}">
            <c:if test="${role eq 'CUSTOMER'}">
                <ul class="navbar-nav m-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Browse <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </c:if>
            <c:if test="${role eq 'ADMINISTRATOR'}">
                <ul class="navbar-nav m-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="../admin/create-user.jsp">Create User <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </c:if>
        </c:forEach>

        <ul class="navbar-nav my-2 my-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="#">Login</a>
            </li>
        </ul>
    </div>
</nav>