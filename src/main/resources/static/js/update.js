$(document).ready(function () {
    $('#summernote').summernote({
        height: 500,
        callbacks: {
            onInit: function (c) {
                c.editable.html('');
            }
        }
    });

});