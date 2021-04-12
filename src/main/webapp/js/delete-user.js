$('.button-delete-user').on('click', function() {
    let username = $(this).data('username');
    showUserModal(username, 'delete');
});

$('#user-modal-delete-button').on('click', function() {
    let username = $(this).data('username');

    if(username === 'root') {
        alert('The default root account can\'t be deleted.');
        $('#user-modal').modal('hide');
    } else {
        $.ajax({
            type: 'POST',
            url: ctx + '/admin/delete-user',
            data: {
                username: username
            },
            success: function() {
                alert(username + ' has been successfully removed.');
                $('#user-table tbody tr').each(function(i, tr) {
                    if(tr.cells[0].innerText === username) {
                        tr.remove();
                    }
                });
                $('#user-modal').modal('hide');
            },
            error: function (request, status, error) {
                alert(request.responseText);
            }
        });
    }
});