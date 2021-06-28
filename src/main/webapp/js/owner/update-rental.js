$('.button-edit-rental').on('click', function() {
    let rentalId = $(this).data('rental-id');
    showRentalModal(rentalId, 'edit');
});