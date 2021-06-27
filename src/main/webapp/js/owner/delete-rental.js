$('.button-delete-rental').on('click', function(event) {
    let rentalId = $(event.target).data('rental-id');
    showRentalModal(rentalId, 'delete');
});

$('#rental-modal-delete-button').on('click', function() {
    let rentalId = $(this).data('rental-id');

    $.ajax({
        type: 'POST',
        url: ctx + '/owner/delete-rental',
        data: {
            'rental-id': rentalId
        },
        success: function(returnedId) {
            alert(`Rental ID ${returnedId} has been successfully removed.`);
            $('#rental-table tbody tr').each(function(i, tr) {
                let id = $(tr).find('button').first().data('rental-id');
                if(id == returnedId) {
                    tr.remove();
                }
            });
            $('#rental-modal').modal('hide');
        },
        error: function (request, status, error) {
            alert(error);
        }
    });
});

// TODO Move these to the view-rental.js in the future
function showRentalModal(rentalId, action) {
    $.ajax({
        url: ctx + '/api/v1/rental/get/' + rentalId,
        type: 'GET',
        contentType: 'application/json',
        success: function(rental) {
            populateRentalInputs(rental);
            setButtonDataAttributes(rental.id);
            if(action === 'view') {
                $('#rental-modal-submit-button').hide();
                $('#rental-modal-delete-button').hide();
                $('#rental-modal-label').text('View - Rental ID ' + rentalId);
                setModalRentalInputsReadOnly(true);
            }
            if(action === 'edit') {
                $('#rental-modal-submit-button').show();
                $('#rental-modal-delete-button').hide();
                $('#rental-modal-label').text('Edit - Rental ID ' + rentalId);
                setModalRentalInputsReadOnly(false);
            }
            if(action === 'delete') {
                $('#rental-modal-submit-button').hide();
                $('#rental-modal-delete-button').show();
                $('#rental-modal-label').text('Delete - Rental ID ' + rentalId);
                setModalRentalInputsReadOnly(true);
            }
            $('#rental-modal').modal('show');
        }
    });
}

function setButtonDataAttributes(rentalId) {
    $('#rental-modal-submit-button').data('rental-id', rentalId);
    $('#rental-modal-delete-button').data('rental-id', rentalId);
}

function populateRentalInputs(rental) {
    $('#rental-modal-owner').val(rental.house.owner.username);
    $('#rental-modal-num-of-rooms').val(rental.house.numOfRooms);
    $('#rental-modal-rent').val(rental.rent);
    $('#rental-modal-locality').val(rental.house.locality);
    $('#rental-modal-description').val(rental.description);
}

function setModalRentalInputsReadOnly(readonly) {
    $('#rental-modal-num-of-rooms').prop('readonly', readonly);
    $('#rental-modal-rent').prop('readonly', readonly);
    $('#rental-modal-locality').prop('readonly', readonly);
    $('#rental-modal-description').prop('readonly', readonly);
}