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