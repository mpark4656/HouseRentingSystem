$('.button-view-rental').on('click', function(event) {
    let rentalId = $(event.target).data('rental-id');
    showRentalModal(rentalId, 'view');
});

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