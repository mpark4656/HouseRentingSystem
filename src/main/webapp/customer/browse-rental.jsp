<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="View My Rental Postings" />
    <jsp:param name="stylesheets" value="default.css" />
</jsp:include>
<body>
<jsp:include page="/templates/navigation-bar.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <h1>Browse Available Rentals</h1>
    </div>
    <div class="table-responsive">
        <table id="rental-table" class="table table-bordered">
            <thead>
                <tr>
                    <th>Post Date</th>
                    <th>Owner</th>
                    <th># of Rooms</th>
                    <th>Locality</th>
                    <th>Rent</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="rental" items="${rentals}">
                <tr>
                    <td class="no-wrap"><c:out value='${rental.dateAdded.format(dateTimeFormatter)}'/></td>
                    <td><c:out value='${rental.house.owner.username}'/></td>
                    <td><c:out value="${rental.house.numOfRooms}"/></td>
                    <td><c:out value="${rental.house.locality}"/></td>
                    <td><c:out value='${String.format("$%.2f",rental.rent)}'/></td>
                    <td><textarea readonly><c:out value="${rental.description}"/></textarea></td>
                    <td class="no-wrap">
                        <button data-rental-id="${rental.id}" class="btn btn-success button-view-rental">Rent</button>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    <div>
<jsp:include page="/templates/scripts.jsp">
    <jsp:param name="scripts" value="" />
</jsp:include>
</body>
</html>