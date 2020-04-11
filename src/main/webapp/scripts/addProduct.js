$(document).ready(function () {
    function readURL(input , imgtype) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                if (imgtype == 'main')
                    $('#main_image').attr('src', e.target.result);
                else
                    $('#auxiliary_images').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]); // convert to base64 string
        }
    }

    $("#imgInp").change(function() {
        readURL(this , 'main');
    });
    $("#filebuttonAuxiliary").change(function() {
        readURL(this , 'aux');
    });
    $( function() {
        $( "#manufacturingDatepicker" ).datepicker();
    } );
    $( function() {
        $( "#expiretionDatepicker" ).datepicker();
    } );

});