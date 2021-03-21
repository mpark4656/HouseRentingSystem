$('.button-resetpw-user').on('click', function() {
    let username = $(this).data('username');
    showPasswordResetModal(username);
});

function showPasswordResetModal(username) {
    $('#password-reset-modal-username').val(username);
    $('#password-reset-modal-submit-button').data('username', username);
    $('#password-reset-modal').modal('show');
}