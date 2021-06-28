<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="View My Rental Postings" />
    <jsp:param name="stylesheets" value="default.css,owner/view-rental.css" />
</jsp:include>
<body>
<jsp:include page="/templates/navigation-bar.jsp"/>
<div id="rental-modal" class="modal" tabindex="-1" aria-labelledby="rental-modal-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="rental-modal-label" class="modal-title"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="rental-modal-form">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="rental-modal-owner" class="form-label">Owner Username</label>
                        <input id="rental-modal-owner" type="text" class="form-control" required disabled>
                    </div>
                    <div class="form-group">
                        <label for="rental-modal-num-of-rooms" class="form-label">Number of Rooms</label>
                        <input id="rental-modal-num-of-rooms" type="number" class="form-control" readonly required>
                    </div>
                    <div class="form-group">
                        <label for="rental-modal-rent" class="form-label">Rent ($)</label>
                        <input id="rental-modal-rent" type="number" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="rental-modal-locality" class="form-label">Locality</label>
                        <input id="rental-modal-locality" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="rental-modal-description" class="form-label">Description</label>
                        <textarea id="rental-modal-description" class="form-control" required></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button id="rental-modal-submit-button" type="submit" class="btn btn-primary">Save changes</button>
                    <button id="rental-modal-delete-button" type="button" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container">
    <div class="row justify-content-center">
        <h1>My Rental Posting</h1>
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
                    <td><textarea><c:out value="${rental.description}"/></textarea></td>
                    <td class="no-wrap">
                        <button data-rental-id="${rental.id}" class="btn btn-success button-view-rental">View</button>
                        <button data-rental-id="${rental.id}" class="btn btn-warning button-edit-rental">Edit</button>
                        <button data-rental-id="${rental.id}" class="btn btn-danger button-delete-rental">Delete</button>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/templates/scripts.jsp">
    <jsp:param name="scripts" value="owner/view-rental.js,owner/update-rental.js,owner/delete-rental.js" />
</jsp:include>
</body>
</html>