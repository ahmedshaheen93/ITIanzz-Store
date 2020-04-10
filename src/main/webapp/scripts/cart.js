
$('.value-plus').on('click', function(){
    var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
    divUpd.text(newVal);
});

$('.value-minus').on('click', function(){
    var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
    if(newVal>=1) divUpd.text(newVal);
});
<!--quantity-->
$(document).ready(function(c) {
    $('.close1').on('click', function(c){
        $('.rem1').fadeOut('slow', function(c){
            $('.rem1').remove();
        });
    });
});