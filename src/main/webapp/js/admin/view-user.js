$('.button-view-user').on('click', function() {
    let username = $(this).data('username');
    showUserModal(username, 'view');
});

function showUserModal(username, action) {
    $.ajax({
        url: ctx + '/api/v1/user/find-username/' + username,
        type: 'GET',
        contentType: 'application/json',
        success: function(user) {
            populateUserInputs(user);
            setButtonDataAttributes(user.username);
            if(action === 'view') {
                $('#user-modal-submit-button').hide();
                $('#user-modal-delete-button').hide();
                $('#user-modal-label').text('View User - ' + username);
                setModalUserInputsReadOnly(true);
            }
            if(action === 'edit') {
                $('#user-modal-submit-button').show();
                $('#user-modal-delete-button').hide();
                $('#user-modal-label').text('Edit User - ' + username);
                setModalUserInputsReadOnly(false);
            }
            if(action === 'delete') {
                $('#user-modal-submit-button').hide();
                $('#user-modal-delete-button').show();
                $('#user-modal-label').text('Delete User - ' + username);
                setModalUserInputsReadOnly(true);
            }
            $('#user-modal').modal('show');
        }
    });
}

function setButtonDataAttributes(username) {
    $('#user-modal-submit-button').data('username', username);
    $('#user-modal-delete-button').data('username', username);
}

function populateUserInputs(user) {
    $('#user-modal-username').val(user.username);
    $('#user-modal-first-name').val(user.firstName);
    $('#user-modal-last-name').val(user.lastName);
    $('#user-modal-email').val(user.emailAddress);
    $('#modal-user-owner').prop('checked', user.owner);
    $('#modal-user-administrator').prop('checked', user.administrator);
    $('#modal-user-customer').prop('checked', user.customer);
}

function setModalUserInputsReadOnly(readonly) {
    $('#user-modal-first-name').prop('readonly', readonly);
    $('#user-modal-last-name').prop('readonly', readonly);
    $('#user-modal-email').prop('readonly', readonly);
    $('#modal-user-administrator').prop('disabled', readonly);
    $('#modal-user-owner').prop('disabled', readonly);
    $('#modal-user-customer').prop('disabled', readonly);
}