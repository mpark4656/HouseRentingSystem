$('.button-view-user').click(function() {
    let username = $(this).data('username');
    showUserModal(username, 'view');
});

$('.button-edit-user').click(function() {
    let username = $(this).data('username');
    showUserModal(username, 'edit');
});

$('.button-delete-user').click(function() {
    let username = $(this).data('username');
    showUserModal(username, 'delete');
});

function showUserModal(username, action) {
    $.ajax({
        url: ctx + '/api/v1/user/find-username/' + username,
        type: 'GET',
        contentType: 'application/json',
        success: function(user) {
            populateUserInputs(user);
            if(action === 'view') {
                $('#modal-resetpw-button').hide();
                $('#modal-submit-button').hide();
                $('#modal-delete-button').hide();
                $('#modal-title').text('View User - ' + username);
                setModalUserInputsReadOnly();
            }
            if(action === 'edit') {
                $('#modal-resetpw-button').show();
                $('#modal-submit-button').show();
                $('#modal-delete-button').hide();
                $('#modal-title').text('Edit User - ' + username);
                setModalUserInputEditable();
            }
            if(action === 'delete') {
                $('#modal-resetpw-button').hide();
                $('#modal-submit-button').hide();
                $('#modal-delete-button').show();
                $('#modal-title').text('Delete User - ' + username);
                setModalUserInputsReadOnly();
            }
            $('#user-modal').modal('show');
        }
    });
}

function populateUserInputs(user) {
    $('#modal-username').val(user.username);
    $('#modal-first-name').val(user.firstName);
    $('#modal-last-name').val(user.lastName);
    $('#modal-email').val(user.emailAddress);
    if(user.owner) $('#modal-user-owner').prop('checked', true);
    else $('#modal-user-owner').prop('checked', false);

    if(user.administrator) $('#modal-user-administrator').prop('checked', true);
    else $('#modal-user-administrator').prop('checked', false);

    if(user.customer) $('#modal-user-customer').prop('checked', true);
    else $('#modal-user-customer').prop('checked', false);
}

function setModalUserInputsReadOnly() {
    $('#modal-first-name').prop('readonly', true);
    $('#modal-last-name').prop('readonly', true);
    $('#modal-email').prop('readonly', true);
    $('#modal-user-administrator').prop('disabled', true);
    $('#modal-user-owner').prop('disabled', true);
    $('#modal-user-customer').prop('disabled', true);
}

function setModalUserInputEditable() {
    $('#modal-first-name').prop('readonly', false);
    $('#modal-last-name').prop('readonly', false);
    $('#modal-email').prop('readonly', false);
    $('#modal-user-administrator').prop('disabled', false);
    $('#modal-user-owner').prop('disabled', false);
    $('#modal-user-customer').prop('disabled', false);
}