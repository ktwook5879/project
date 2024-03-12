function SelectChange(str) {
    if (str == 0) {
        alert("인증게시판은 인증만을 위한 게시판입니다");
    } else if (str == 1) {
        alert("자유게시판 규칙에 따라 게시글 작성바랍니다.")
    }
}


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


$(document).ready(function (){

    $("#btn-cancel").on("click", function () {

        if(confirm("취소하시겠습니까??")){
            location.href = "/board";
        }

    });

    //   수정 버튼
    $("#btn-insert").on("click", function() {
        if(confirm("등록하겠습니까?")) {
            const frm = $("#frm")[0];
            frm.action = "/board/insert";
            frm.submit();
        }
    });
});