<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${param.title}"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
          crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Maven+Pro&family=Open+Sans&display=swap" rel="stylesheet">
    <c:if test="${not empty param.stylesheets}">
        <c:set var="stylesheets" value="${fn:split(param.stylesheets,',')}" />
        <c:forEach var="stylesheet" items="${stylesheets}">
            <c:out value="<link rel='stylesheet' href='${pageContext.request.contextPath}/css/${stylesheet}'>"
                escapeXml="false" />
        </c:forEach>
    </c:if>
</head>