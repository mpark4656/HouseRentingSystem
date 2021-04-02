$('.button-resetpw-user').on('click', function() {
    let username = $(this).data('username');
    showPasswordResetModal(username);
});

$('#password-reset-modal-password-confirm').on('focusout', function() {
    if(!isPasswordConfirmed()) {
        $(this).popover('show');
    } else {
        $(this).popover('hide');
    }
});

$('#password-reset-modal-form').on('submit', function(e) {
    e.preventDefault();

    let popOverElement = $('#password-reset-modal-password-confirm');

    if(!isPasswordConfirmed()) {
        popOverElement.popover('show');
    } else {
        popOverElement.popover('hide');
        let username = $('#password-reset-modal-submit-button').data('username');
        let password = $('#password-reset-modal-new-password').val();

        $.ajax({
            type: 'POST',
            url: ctx + '/admin/reset-password',
            data: {
                username: username,
                password: password
            },
            success: function() {
                alert("Success");
                $('#password-reset-modal').modal('hide');
            },
            error: function (request, status, error) {
                alert(error);
            }
        });

    }
});

function isPasswordConfirmed() {
    let passwordConfirm = $('#password-reset-modal-password-confirm').val();
    let password = $('#password-reset-modal-new-password').val();

    return passwordConfirm == password
}

function showPasswordResetModal(username) {
    resetPasswordResetForm();
    $('#password-reset-modal-username').val(username);
    $('#password-reset-modal-submit-button').data('username', username);
    $('#password-reset-modal').modal('show');
}

function resetPasswordResetForm() {
    $('#password-reset-modal-username').val('');
    $('#password-reset-modal-password-confirm').val('');
    $('#password-reset-modal-new-password').val('');
}