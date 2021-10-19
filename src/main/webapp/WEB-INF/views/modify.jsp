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
      <h1>일정 수정</h1>

      <form class="write-form" action="/schedule/mod-schedule/${empNo}" method="POST">
         <div class="input-box">
            <input type="hidden" name="scdNo" value="${schedule.scdNo}">
            
            # 제목: <input class="form-control" type="text" name="scdTitle" value="${schedule.scdTitle}"><br>

            # 시작날짜: <input type="date" name="startDay" value="${schedule.startDay}"><br>
            # 시작시간: <input type="time" name="startTime" value="${schedule.startTime}"><br>
            # 종료날짜: <input type="date" name="endDay" value="${schedule.endDay}"><br>
            # 종료시간: <input type="time" name="endTime" value="${schedule.endTime}"><br>

            <label>
                #일정 구분: 
                <input id="C-type" type="radio" name="type" value="C" disabled> 회사 일정
                <input id="D-type" type="radio" name="type" value="D" disabled> 부서 일정
                <input id="P-type" type="radio" name="type" value="P" disabled> 개인 일정
            </label>

         </div>
         <button type="submit">수정</button>
         
      </form>
      <button type="button" onclick="location.replace('/schedule/calendar/${empNo}') ">취소</button>
      <button id="delBtn">삭제</button>
   </div>

</body>

<script>
   $(function() {
      // 라디오 체크 부여
      let type = '${schedule.scdCode}'.substr(0,1);
      let checkbox = '#' + type + '-type';
      $(checkbox).prop('checked', true);

      // 삭제 버튼 클릭시 삭제

      $('#delBtn').on('click', e =>{
        
         fetch('/schedule/del-schedule/${schedule.scdNo}')
            .then(res => res.text())
            .then(msg => {
               if(msg === 'deleteSuccess') {
                  location.replace('/schedule/calendar/${empNo}')
               } else if (msg === 'check') {
                  console.log('테스트중');
               } 
            })
      });
   })
   
   

</script>

</html>