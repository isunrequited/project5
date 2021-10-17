<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<body>
   
   <div class="write-container">
      <h1>일정 등록</h1>

      <form class="write-form" action="/schedule/scd-add">
         <div class="input-box">

            
            # 제목: <input class="form-control" type="text" name="scdTitle"><br>
            # 내용: <br>
            <textarea class="form-control" rows="5" cols="30" name="scdContent"></textarea>
            <br>

            <label>
                #일정 구분: 
                <input type="checkbox" name="type" value="C"> 회사 일정
                <input type="checkbox" name="type" value="D"> 부서 일정
                <input type="checkbox" name="type" value="P"> 개인 일정
            </label>

            <input type="date" name="date">
            <input type="time" name="date">

         </div>
         <button type="submit">등록</button>
         
      </form>
   </div>

   <input type="button" value="ajax" id="go">

   <script>
      $("#go").click(()=> {
         $.ajax({
            type:"GET",
            url:"/schedule/test",
            dataType: "json",
            success: function(data){
               alert(data.title);
            },
             error: function() {
                alert("실패");
            }
         })
      })

   </script>


</body>

</html>