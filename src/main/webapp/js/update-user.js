$('.button-resetpw-user').on('click', function() {
    let username = $(this).data('username');
});

$('#modal-submit-button').on('click', function() {
    let username = $(this).data('username');
    if(username === 'root') {
        alert('The default root account can\'t be edited.');
    } else {
        $.ajax({
            type: 'PUT',
            url: ctx + '/api/v1/user/update-user',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(getUserObj(username)),
            success: function(user) {
                alert('Success');
            },
            error: function (request, status, error) {
                alert(error);
            }
        });
    }
    $('#user-modal').modal('hide');
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
        administrator: $('#modal-user-administrator').prop('checked'),
        customer: $('#modal-user-customer').prop('checked'),
        roles: userRoles
    }
    return userObj;
}