var submitFlag = false;
$(function(){

    //전송버튼
    $("#send-reply").click(function(){
        if(submitFlag == true){
            console.log('1'+submitFlag);
            alert("현재 댓글 등록이 이루어지고 있습니다.\n댓글 등록과 동시에 관리자에게 알림 메일을 전송하기 때문에 작업이 느려질 수 있습니다.");
            return;
        }
        console.log('2'+submitFlag);
        submitFlag = true;
        console.log('3'+submitFlag);
        var JSONdata ={
            email : $("#email").val(),
            pw : $("#password").val(),
          content : $("#content").val(),
          boardID :$("#boardID").val()
        }


        $.ajax({
            url:"/reply",
            type:"POST",
            contentType:"application/json",
            dataType:"json",
            data :JSON.stringify(JSONdata),
            success:function(data){
                alert(data.mention);
                submitFlag == false;
                if(data.result){
                    location.reload();
                }
            },
            error:function(error){
                submitFlag == false;
                alert("일시적인 장애로 인해 댓글 작성이 실패하였습니다. 잠시후 다시 이용해주세요.");
            }
        });
    });



});

function delete_popup(replyID) {
    var $el = $('#delete-check');        //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.delete-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight / 2,
            marginLeft: -$elWidth / 2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    $el.find('a.btn-layerClose').off("click").click(function () {
        isDim ? $('.delete-layer').fadeOut() : $el.fadeOut();
        $('#pop-password').val('');
        return false;
    });
    $el.find('a.btn-layerCheck').off("click").click(function () {
        isDim ? $('.delete-layer').fadeOut() : $el.fadeOut();
        deleteReply(replyID);

        return false;
    });

    $('.layer .dimBg').click(function () {
        $('.delete-layer').fadeOut();
        return false;
    });

}

function update_popup(replyID) {
    var $el = $('#update-check');        //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.update-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight / 2,
            marginLeft: -$elWidth / 2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    $el.find('a.btn-updateClose').off("click").click(function () {
        isDim ? $('.update-layer').fadeOut() : $el.fadeOut();
        $('#pop-password2').val('');
        $('#pop-content').val('');
        return false;
    });
    $el.find('a.btn-updateCheck').off("click").click(function () {
        isDim ? $('.update-layer').fadeOut() : $el.fadeOut();
        updateReply(replyID);

        return false;
    });

    $('.layer .dimBg').click(function () {
        $('.update-check').fadeOut();
        return false;
    });

}


function deleteReply(replyID) {

    var password = $('#pop-password').val();
    var JSONdata ={
        replyID : replyID+"",
        password : password
    }

       $.ajax({
            url:"/reply",
            type:"DELETE",
            contentType:"application/json",
            dataType:"json",
            data :JSON.stringify(JSONdata),

            success:function(data){
                alert(data.comment);
                if(data.result){
                    location.reload();
                }
                $('#pop-password').val('');
                return;
            },

            error:function(error){
                alert("일시적인 장애로 인해 댓글 삭제에 실패하였습니다. 잠시후 다시 이용해주세요.");
                $('#pop-password').val('');
                return;
            }
        });
}

function updateReply(replyID) {

    var password = $('#pop-password2').val();
    var content = $('#pop-content').val();
    var JSONdata ={
        replyID : replyID+"",
        password : password,
        content : content
    }

    $.ajax({
        url:"/reply",
        type:"PUT",
        contentType:"application/json",
        dataType:"json",
        data :JSON.stringify(JSONdata),

        success:function(data){
            alert(data.comment);
            if(data.result){
                location.reload();
            }
            $('#pop-password2').val('');
            $('#pop-content').val('');
            return;
        },

        error:function(error){
            alert("일시적인 장애로 인해 댓글 삭제에 실패하였습니다. 잠시후 다시 이용해주세요.");
            $('#pop-password2').val('');
            $('#pop-content').val('');
            return;
        }
    });
}



