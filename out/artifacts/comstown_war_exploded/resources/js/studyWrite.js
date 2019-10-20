

$(function(){
    $.xss = function (pValue){
        var strReturenValue = "";
        strReturenValue = pValue.replace(/&/gi, '&amp;').replace(/</gi, '&lt;').replace(/>/gi, '&gt;').replace(/"/gi, '&quot;').replace(/'/gi, '&apos;');
        return strReturenValue;
    };
    //전역변수
    var obj = [];
    //스마트에디터 프레임생성
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: obj,
        elPlaceHolder: "editor",
        sSkinURI: "/smarteditor/SmartEditor2Skin.html",
        htParams : {
            // 툴바 사용 여부
            bUseToolbar : true,
            // 입력창 크기 조절바 사용 여부
            bUseVerticalResizer : true,
            // 모드 탭(Editor | HTML | TEXT) 사용 여부
            bUseModeChanger : true,
        }
    });
    //전송버튼
    $("#insertBoard").click(function(){
        //validate
        if($('#category').val() === null || $('#category').val() === 'none'){
            alert("카테고리를 설정해주세요.");
            return;
        }
        else{
            if(confirm("글을 등록 하시겠습니까?")){
                //xss security
                var tmp = $.xss($('#title').val());
                $('#title').val(tmp);

                //id가 smarteditor인 textarea에 에디터에서 대입
                obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
                //폼 submit
                $("#insertBoardFrm").submit();
                alert("글 등록이 완료되었습니다.");
            }
        }
    });
});