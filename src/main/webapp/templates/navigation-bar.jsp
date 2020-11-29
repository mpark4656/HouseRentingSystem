<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-md navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
        <img src="${pageContext.request.contextPath}/img/logo.png" width="30" height="30" loading="lazy">
        HRS
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav m-auto">
        <c:forEach var="role" items="${sessionScope.user.roles}">
            <c:if test="${role eq 'CUSTOMER'}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle"
                       href="#" id="adminNavbarDropdownMenuLink" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Customer
                    </a>
                    <div class="dropdown-menu" aria-labelledby="adminNavbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">Browse</a>
                    </div>
                </li>
            </c:if>
            <c:if test="${role eq 'ADMINISTRATOR'}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle"
                       href="#" id="customerNavbarDropdownMenuLink" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Administrator
                    </a>
                    <div class="dropdown-menu" aria-labelledby="customerNavbarDropdownMenuLink">
                        <a class="dropdown-item"
                            href="${pageContext.request.contextPath}/admin/create-user">
                            Create New User
                        </a>
                    </div>
                </li>
            </c:if>
        </c:forEach>
        </ul>
        <ul class="navbar-nav my-2 my-lg-0">
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <li class="nav-item">
                         <a class="nav-link"
                            href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle"
                           href="#" id="userNavbarDropdownMenuLink" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                           Hello, ${sessionScope.user.firstName} ${sessionScope.user.lastName}!
                        </a>
                        <div class="dropdown-menu" aria-labelledby="userNavbarDropdownMenuLink">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">
                                Logout
                            </a>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>