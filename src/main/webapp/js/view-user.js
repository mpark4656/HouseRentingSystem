$('.button-view-user').click(function() {
    let username = $(this).data('username');

    $('#user-modal').modal('show');
});

$('.button-edit-user').click(function() {
    let username = $(this).data('username');
    $('#user-modal').modal('show');
});

$('.button-delete-user').click(function() {
    let username = $(this).data('username');
    $('#user-modal').modal('show');
});

function hideModalUserInputs() {

}

function showModalUserInputs() {

}

function setModalUserInputsReadOnly() {

}

function setModalUserInputEditable() {

}

function showModalResetPasswordButton() {

}

function hideModalResetPasswordButton() {

}