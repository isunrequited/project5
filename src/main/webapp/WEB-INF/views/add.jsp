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

      <form class="write-form" action="/schedule/add-schedule/${empNo}" method="POST">
         <div class="input-box">

            
            # 제목: <input class="form-control" type="text" name="scdTitle"><br>

            # 시작날짜: <input type="date" name="startDay"><br>
            # 시작시간: <input type="time" name="startTime"><br>
            # 종료날짜: <input type="date" name="endDay"><br>
            # 종료시간: <input type="time" name="endTime"><br>

            <label>
                #일정 구분: 
                <input type="radio" name="type" value="C" checked> 회사 일정
                <input type="radio" name="type" value="D"> 부서 일정
                <input type="radio" name="type" value="P"> 개인 일정
            </label>

         </div>
         <button type="submit">등록</button>
         
      </form>
      <button type="button" onclick="location.replace('/schedule/calendar/${empNo}') ">뒤로가기</button>
   </div>

</body>

</html>