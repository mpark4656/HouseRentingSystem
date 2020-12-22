$('#modal-delete-button').on('click', function() {
    let username = $(this).data('username');

    if(username === 'root') {
        alert('The default root account can\'t be deleted.');
    } else {
        $.ajax({
            type: 'DELETE',
            url: ctx + '/api/v1/user/delete-by-username?username=' + username,
            contentType: 'application/json',
            success: function(user) {
                alert(user.username + ' has been successfully removed.');
                $('#user-table tbody tr').each(function(i, tr) {
                    if($('.tr-username', tr).text() === user.username) {
                        tr.remove();
                    }
                });
            },
            error: function (request, status, error) {
                alert(error);
            }
        });

        $('#user-modal').modal('hide');
    }
});