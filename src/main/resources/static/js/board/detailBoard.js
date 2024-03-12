$(document).ready(function () {

    var i = 0;
    // 목록 버튼



    $("#btn_review").on("click", function () {
        if (confirm("등록하시겠습니까?")) {

            const content = $("#content").val();

            const nickname = $("#Nick_input").val();
            const cmIdx = $("#cmIdx").val();

            if (nickname !== "") {
                $.ajax({
                    url: "/board/review",
                    type: "POST",
                    data: {content: content, cmIdx: cmIdx},
                    success: function (data) {
                        alert("댓글이 등록되었습니다");
                        location.reload();
                    },
                    error: function () {
                        alert("댓글 등록에 실패했습니다.");
                    }
                })
            } else {
                alert("로그인 후 이용바랍니다.");
                location.href = "/login/login.do";
            }


        } else {

        }

    });

    $("#view_reply").on("click", function () {

        i += 1;

        const cmIdx = $("#cmIdx").val();
        if(i%2==1) {
            $.ajax({
                url: "/board/reviewSelect",
                type: "POST",
                data: {commIdx: cmIdx},
                success: function (data) {
                    var view = $("#review_area");
                    var text = null;
                    view.empty();

                    for (let i = 0; i < data.length; i++) {


                        text = `<div class="p_review">
  <div class="auth">
    <img class="ms-2 me-1" src="/img/minsome_m.png">
    <span id="nick_span">${data[i].reNick}</span>

    <span class="kebab-menu mt-1 ms-6">
      <ul> 
        <li><span class="kebab-menu_1" data-id=${i}>
          <i class="kebab-menu-icon"></i>
          <i class="kebab-menu-icon"></i>
          <i class="kebab-menu-icon"></i>
          </span>
          <ul class="sub_ul hidden" data-id=${i}>
            <li class="hidden"><p id="help" data-id="${data[i].reNick}"></p></li>
            <li><button id="btn_del"  data-id="${data[i].rno}">삭제</a></li>
          </ul>
        </li>
      </ul>
    </span>
  </div>
  <p>${data[i].content}</p>
  <p class="re_date" style="float:right;">${data[i].reDate}</p>
</div>`
                        view.append(text);
                    }


                },
                error: function () {
                    alert("댓글 확인이 불가능합니다.")
                }
            })
        }
        else {
            var view = $("#review_area");

            view.empty();

        }
    });




});

$(document).on("click", ".kebab-menu_1",function (){

    // 해당 케밥 메뉴에 속한 서브메뉴 표시
    const kebabMenuDataId = $(this).attr("data-id");

    $(".sub_ul[data-id='" + kebabMenuDataId + "']").toggleClass("hidden");


    $(document).on("click", "#btn_del",function (){
        const rno = $(this).attr("data-id");



        location.href="/board/review/delete?rno="+rno;

    });


});


