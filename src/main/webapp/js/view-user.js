var userObj = null;

$('.button-view-user').on('click', function() {
    let username = $(this).data('username');
    showUserModal(username, 'view');
});

$('.button-edit-user').on('click', function() {
    let username = $(this).data('username');
    showUserModal(username, 'edit');
});

$('.button-delete-user').on('click', function() {
    let username = $(this).data('username');
    showUserModal(username, 'delete');
});

function showUserModal(username, action) {
    $.ajax({
        url: ctx + '/api/v1/user/find-username/' + username,
        type: 'GET',
        contentType: 'application/json',
        success: function(user) {
            userObj = user;
            populateUserInputs(user);
            setButtonDataAttributes(user.username);
            if(action === 'view') {
                $('#modal-submit-button').hide();
                $('#modal-delete-button').hide();
                $('#modal-title').text('View User - ' + username);
                setModalUserInputsReadOnly();
            }
            if(action === 'edit') {
                $('#modal-submit-button').show();
                $('#modal-delete-button').hide();
                $('#modal-title').text('Edit User - ' + username);
                setModalUserInputEditable();
            }
            if(action === 'delete') {
                $('#modal-submit-button').hide();
                $('#modal-delete-button').show();
                $('#modal-title').text('Delete User - ' + username);
                setModalUserInputsReadOnly();
            }
            $('#user-modal').modal('show');
        }
    });
}

function setButtonDataAttributes(username) {
    $('#modal-submit-button').data('username', username);
    $('#modal-delete-button').data('username', username);
}

function populateUserInputs(user) {
    $('#modal-username').val(user.username);
    $('#modal-first-name').val(user.firstName);
    $('#modal-last-name').val(user.lastName);
    $('#modal-email').val(user.emailAddress);
    $('#modal-user-owner').prop('checked', user.owner);
    $('#modal-user-administrator').prop('checked', user.administrator);
    $('#modal-user-customer').prop('checked', user.customer);
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