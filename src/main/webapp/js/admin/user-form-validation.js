$('.password-confirm').popover({
    placement: 'right',
    trigger: 'manual'
});

$('.password-popover-reset').on('keyup', function() {
    resetPasswordConfirmMessages();
});

$('.user-form-validation').on('change', '.checkbox-validation', function() {
    if(this.checked) resetCheckboxValidationMessages();
});

$('.user-form-validation').on('reset', function() {
    resetPasswordConfirmMessages();
    resetCheckboxValidationMessages();
});

function validateForm() {
    let result = true;

    // Password Confirmation
    if($('.password').val() !== $('.password-confirm').val()) {
        $('.password-confirm').popover('show');
        $('.password-confirm').addClass('highlight-error-input');
        result = false;
    }

    // Checkbox Validation
    let checkBoxChecked = false;
    $('.checkbox-validation').each(function(i, checkbox) {
        if($(checkbox).prop('checked')) checkBoxChecked = true;
    });
    if(!checkBoxChecked) {
        $('.checkbox-validation-message').show();
        result = false;
    }

    return result;
}

function resetPasswordConfirmMessages() {
    $('.password-confirm').popover('hide');
    $('.password-confirm').removeClass('highlight-error-input');
}

function resetCheckboxValidationMessages() {
    $('.checkbox-validation-message').hide();
}