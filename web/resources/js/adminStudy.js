function deleteArticle(no) {
    if(confirm("정말로 삭제하시겠습니까?")){
        $.ajax({
            url:"/admin/delete.do",
            type:"POST",
            contentType:"application/json",
            dataType:"json",
            data :JSON.stringify(no),
            success:function(result){
                if(result == true){
                    alert("삭제가 완료되었습니다.");
                    location.reload();
                }
                else{
                    alert("삭제에 실패하였습니다.");
                }
            },
            error:function(error){
                alert("일시적인 장애로 인해 삭제에 실패하였습니다. 잠시후 다시 이용해주세요.");
            }
        });
    }

}

function layer_popup(el){

    var $el = $(el);        //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    $el.find('a.btn-layerClose').click(function(){
        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        return false;
    });

    $('.layer .dimBg').click(function(){
        $('.dim-layer').fadeOut();
        return false;
    });

}