$(document).ready(function () {

    $(function () {
        $("#manufacturingDatepicker").datepicker();
    });
    $(function () {
        $("#expiretionDatepicker").datepicker();
    });
    //Check File API support
    if (window.File && window.FileList && window.FileReader) {
        var filesInput = document.getElementById("files");
        filesInput.addEventListener("change", function (event) {
            var files = event.target.files; //FileList object
            var output = document.getElementById("result");
            for (var i = 0; i < files.length; i++) {
                var file = files[i];
                //Only pics
                if (!file.type.match('image'))
                    continue;
                var picReader = new FileReader();
                picReader.addEventListener("load", function (event) {
                    var picFile = event.target;
                    var div = document.createElement("div");
                    div.setAttribute("class", "col-4");
                    div.innerHTML = "<img class='thumbnail' src='" + picFile.result + "'" +
                        "title='" + picFile.name + "'/>";
                    output.insertBefore(div, null);
                });
                //Read the image
                picReader.readAsDataURL(file);
            }
        });
    } else {
        console.log("Your browser does not support File API");
    }
    // $(document).on('blur', '.exDate', function () {
    //     var exDate = new Date($('#expiretionDatepicker').datepicker('getDate'));
    //     exDate.setHours(0, 0, 0, 0);
    //     var today = new Date();
    //     today.setHours(0, 0, 0, 0);
    //     if (today > exDate || new Date($('#manufacturingDatepicker').datepicker('getDate') > exDate))
    //         $("#expiretionDateValidationError").text("Error : invalid expiration date");
    //     else
    //         $("#expiretionDateValidationError").text("");
    // });
    //
    // $(document).on('blur', '.manDate', function () {
    //     var manDate = new Date($('#manufacturingDatepicker').datepicker('getDate'));
    //     manDate.setHours(0, 0, 0, 0);
    //     var today = new Date();
    //     today.setHours(0, 0, 0, 0);
    //     if (today < manDate || new Date($('#expiretionDatepicker').datepicker('getDate') < manDate))
    //         $("#manufacturingDateValidationError").text("Error : invalid manufacturing date");
    //     else
    //         $("#manufacturingDateValidationError").text("");
    // });

    $(document).on('click', '.addCatgry', function () {
        var newCategoryName = $("#categoryName").val();

        $.ajax({
            url: "newCategory",
            type: "POST",
            dataType: "JSON",
            data: {"newCat": newCategoryName},
            statusCode: {
                200: function (data) {
                    console.log(data);
                    $('#categories').append(`<option value="${data.categoryId}"> 
                                       ${data.categoryName} 
                                  </option>`);
                },
                460: function () {
                    console.log("error")
                },
                500: function () {
                    alert("leh ya rb m 5k2tny4 m3za");
                }

            }
        });
    });

    // $(document).on('click', '.submit', function () {
    //     let myForm = document.getElementById('addProductForm');
    //     let images = document.getElementById('images');
    //     // data: {"product": jsonObject, "images": images},
    //     const formData = new FormData(myForm);
    //     let jsonObject = {};
    //     for (const [key, value] of formData.entries()) {
    //         jsonObject[key] = value;
    //     }
    // console.log(jsonObject);
    // $.ajax({
    //     url: "addProduct",
    //     type: "POST",
    //     data: jsonObject,
    //     contentType: false,
    //     cache: false,
    //     processData: false,
    //     success: function (response) {
    //         console.log("heyyyy");
    //     },
    //     beforeSend: function () {
    //         // $('').html('<h1>Uploading......</h1>');
    //         console.log("Uploading......");
    //     }
    // });

    //
    // $.ajax({
    //     type: "POST",
    //     url: "addProduct",
    //     dataType: "JSON",
    //     data: {"product": jsonObject},
    //     enctype: 'multipart/form-data',
    //     cache: false,
    //     processData: false,
    //     contentType: false,
    //     statusCode: {
    //         200: function (data) {
    //             console.log(data);
    //             alert("ok");
    //
    //             // onSuccess(data);
    //         },
    //         201: function (data) {
    //             console.log(data);
    //             alert("ok");
    //
    //             // onSuccess(data);
    //         },
    //         460: function () {
    //             console.log("error");
    //             alert("leh ya rb m 5k2tny4 m3za");
    //
    //             // onError(data);
    //         },
    //         500: function () {
    //             alert("leh ya rb m 5k2tny4 m3za");
    //         },
    //         302: function (data) {
    //             // setRedirect(data);
    //             alert("leh ya rb m 5k2tny4 m3za");
    //
    //         }
    //
    //     }
    // })
// });

// $(document).ready(function () {
//     $('#uploadImage').click(function () {
//         var form = $('#uploadform');
//         $.ajax({
//             type: 'Post',
//             url: 'UploadImage',
//             data: form.serialize(),
//             enctype: 'multipart/form-data',
//             success: function (result) {
//                 $('#uploadResult').html(result);
//             }
//         });
//     });
// });

})
;

