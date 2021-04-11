$("#rental-create-form").on("submit", function(event) {
    event.preventDefault();

    $.ajax({
        type: 'POST',
        url: ctx + '/owner/create-rental',
        data: {
            numOfRooms: $("#num-of-rooms").val(),
            rent: $("#rent").val(),
            locality: $("#locality").val(),
            description: $("#description").val()
        },
        success: function() {
            alert("Your new rental has been created successfully.");
            window.location.replace(ctx + '/owner/view-rental');
        },
        error: function (request, status, error) {
            alert(request.responseText);
        }
    });
});