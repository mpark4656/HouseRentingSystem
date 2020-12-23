$('.button-edit-user').on('click', function() {
    let username = $(this).data('username');
    showUserModal(username, 'edit');
});

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
                alert(user.username + ' has been changed successfully.');
                $('#user-table tbody tr').each(function(i, tr) {
                    if(tr.cells[0].innerText === user.username) {
                        tr.cells[1].innerText = user.firstName;
                        tr.cells[2].innerText = user.lastName;
                        tr.cells[3].innerText = user.emailAddress;
                        tr.cells[4].innerText = '';
                        user.roles.forEach(function(role, i) {
                            if(role === 'ADMINISTRATOR') {
                                var strongElement = document.createElement('strong');
                                var textNode = document.createTextNode(' ' + role + ' ');
                                strongElement.appendChild(textNode);
                                tr.cells[4].appendChild(strongElement);
                            } else {
                                var textNode = document.createTextNode(' ' + role + ' ');
                                tr.cells[4].appendChild(textNode);
                            }
                        });
                    }
                });

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