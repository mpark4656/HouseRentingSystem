$('.button-resetpw-user').on('click', function() {
    let username = $(this).data('username');
    showPasswordResetModal(username);
});

function showPasswordResetModal(username) {
    $('#password-reset-modal').modal('show');
}