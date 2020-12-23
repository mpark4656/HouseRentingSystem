$('.password-confirm').popover({
    placement: 'right'
});

$('.keyup-pw-event-popover').on('keyup', function() {
    resetPasswordConfirmMessages();
});

$('.validation-form').on('change', '.checkbox-change-event', function() {
    if(this.checked) resetCheckboxValidationMessages();
});

$('.validation-form').on('reset', function() {
    resetPasswordConfirmMessages();
    resetCheckboxValidationMessages();
});

function validateForm() {
    // Password Confirmation
    if($('.password').val() !== $('.password-confirm').val()) {
        $('.password-confirm').popover('show');
        $('.password-confirm').addClass('highlight-error-input');
        validationPassed = false;
    }

    // Checkbox Validation
    if(!$('#input-user-administrator').prop('checked') &&
            !$('#input-user-owner').prop('checked') &&
            !$('#input-user-customer').prop('checked')) {
        $('.checkbox-validation-message').show();
        validationPassed = false;
    }

    return true;
}

function resetPasswordConfirmMessages() {
    $('.password-confirm').popover('hide');
    $('.password-confirm').removeClass('highlight-error-input');
}

function resetCheckboxValidationMessages() {
    $('.checkbox-validation-message').hide();
}