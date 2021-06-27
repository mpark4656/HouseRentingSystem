document.getElementById('user-create-form').addEventListener('submit', function(e) {
    // Do not submit and cause any redirection
    e.preventDefault();

    if(!validateForm()) return;

    // Challenge: Try using the vanilla javascript for ajax instead of using jQuery for a practice
    let xhr = new XMLHttpRequest();
    let formData = new FormData(this);

    xhr.open('POST', 'create-user');
    xhr.send(formData);

    xhr.onreadystatechange = function() {
        if(xhr.readyState == xhr.DONE && xhr.status == 200) {
            $('#alert-message').text(formData.get('username') + " has been successfully created");

            $('#success-alert').show();
            $(function () {
                var duration = 3000;
                setTimeout(function () { $('#success-alert').hide(); }, duration);
            });

            $('#user-create-form')[0].reset();
        }

        if(xhr.readyState == xhr.DONE && xhr.status != 200) {
            $('#modal-body-message').text(xhr.statusText);
            $('#error-modal').modal('show');
        }
    };
});

