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