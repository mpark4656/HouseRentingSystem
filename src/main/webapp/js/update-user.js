$('.button-resetpw-user').on('click', function() {
    let username = $(this).data('username');
});

$('#modal-submit-button').on('click', function() {
    let username = $(this).data('username');
    if(username === 'root') {
        alert('The default root account can\'t be edited.');
        $('#user-modal').modal('hide');
    } else {
        $.ajax({
            type: 'PUT',
            url: ctx + '/api/v1/user/update-user',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(getUserObj(username)),
            success: function(user) {
                alert('Success');
                $('#user-modal').modal('hide');
            },
            error: function (request, status, error) {
                alert(error);
            }
        });
    }
});

function getUserObj(username) {
    var userRoles = [];
    if($('#modal-user-owner').prop('checked')) userRoles.push('OWNER');
    if($('#modal-user-administrator').prop('checked')) userRoles.push('ADMINISTRATOR');
    if($('#modal-user-customer').prop('checked')) userRoles.push('CUSTOMER');

    var userObj = {
        username: username,
        firstName: $('#modal-first-name').val(),
        lastName: $('#modal-last-name').val(),
        emailAddress: $('#modal-email').val(),
        owner: $('#modal-user-owner').prop('checked'),
        password: '6748ca77-423e-47ef-b340-e5315688645c',
        administrator: $('#modal-user-administrator').prop('checked'),
        customer: $('#modal-user-customer').prop('checked'),
        roles: userRoles
    }
    return userObj;
}