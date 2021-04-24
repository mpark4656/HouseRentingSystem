$('.button-edit-user').on('click', function() {
    let username = $(this).data('username');
    showUserModal(username, 'edit');
});

$('.button-resetpw-user').on('click', function() {
    let username = $(this).data('username');
});

$('#user-modal-form').on('submit', function(e) {
    // Do not submit and cause any redirection
    e.preventDefault();

    let username = $('#user-modal-submit-button').data('username');
    let firstName = $('#user-modal-first-name').val();
    let lastName = $('#user-modal-last-name').val();
    let emailAddress = $('#user-modal-email').val();
    let owner = $('#modal-user-owner').prop('checked');
    let administrator = $('#modal-user-administrator').prop('checked');
    let customer = $('#modal-user-customer').prop('checked');

    if(username === 'root') {
        alert('The default root account can\'t be edited.');
        $('#user-modal').modal('hide');
    } else {
        if(!validateForm()) return;

        $.ajax({
            type: 'POST',
            url: ctx + '/admin/update-user',
            data: {
                username: username,
                firstName: firstName,
                lastName: lastName,
                emailAddress: emailAddress,
                owner: owner,
                administrator: administrator,
                customer: customer
            },
            success: function(user) {
                alert(username + ' has been changed successfully.');
                $('#user-table tbody tr').each(function(i, tr) {
                    if(tr.cells[0].innerText === username) {
                        tr.cells[1].innerText = firstName.toUpperCase();
                        tr.cells[2].innerText = lastName.toUpperCase();
                        tr.cells[3].innerText = emailAddress.toUpperCase();
                        tr.cells[4].innerText = '';

                        if(administrator) {
                            var strongElement = document.createElement('strong');
                            var textNode = document.createTextNode('ADMINISTRATOR');
                            strongElement.appendChild(textNode);
                            tr.cells[4].appendChild(strongElement);
                            tr.cells[4].appendChild(document.createElement('br'));
                        }

                        if(owner) {
                            var textNode = document.createTextNode('OWNER');
                            tr.cells[4].appendChild(textNode);
                            tr.cells[4].appendChild(document.createElement('br'));
                        }

                        if(customer) {
                            var textNode = document.createTextNode('CUSTOMER');
                            tr.cells[4].appendChild(textNode);
                            tr.cells[4].appendChild(document.createElement('br'));
                        }
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