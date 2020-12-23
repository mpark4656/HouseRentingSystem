$('.button-resetpw-user').on('click', function() {
    let username = $(this).data('username');
});

$('#modal-submit-button').on('click', function() {
    let username = $(this).data('username');
    if(username === 'root') {
        alert('The default root account can\'t be deleted.');
    } else {
        updateUserObj();
    }
});

function updateUserObj() {
    userObj.firstName = $('#modal-first-name').val();
    userObj.lastName = $('#modal-last-name').val();
    userObj.emailAddress = $('#modal-email').val();
    userObj.owner = $('#modal-user-owner').prop('checked');
    userObj.administrator = $('#modal-user-administrator').prop('checked');
    userObj.customer = $('#modal-user-customer').prop('checked');
    userObj.roles = [];
    if(userObj.owner) userObj.roles.push('OWNER');
    if(userObj.administrator) userObj.roles.push('ADMINISTRATOR');
    if(userObj.customer) userObj.roles.push('CUSTOMER');
}