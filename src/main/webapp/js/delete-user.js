$('.button-delete-user').on('click', function() {
    let username = $(this).data('username');
    showUserModal(username, 'delete');
});

$('#modal-delete-button').on('click', function() {
    let username = $(this).data('username');

    if(username === 'root') {
        alert('The default root account can\'t be deleted.');
        $('#user-modal').modal('hide');
    } else {
        $.ajax({
            type: 'DELETE',
            url: ctx + '/api/v1/user/delete-by-username?username=' + username,
            contentType: 'application/json',
            success: function(user) {
                alert(user.username + ' has been successfully removed.');
                $('#user-table tbody tr').each(function(i, tr) {
                    if(tr.cells[0].innerText === user.username) {
                        tr.remove();
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