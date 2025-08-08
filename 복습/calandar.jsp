<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- FullCalendar 관련 스크립트 -->
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/locales/ko.global.min.js"></script>
    <title>달력</title>
  </head>
  <body>
    <div id="calendar"></div>
    <script type="text/javascript">
      document.addEventListener("DOMContentLoaded", function () {
        $.ajax({
          type: "get",
          url: "/calendar", // 서버에서 일정 데이터를 받아올 경로
          success: function (list) {
            const calArr = [];
            for (const item of list) {
              const cal = {
                title: item.name,
                start: item.startDate,
                end: item.startDate,
              };
              calArr.push(cal);
            }
            const calendarEl = document.getElementById("calendar");
            const calendar = new FullCalendar.Calendar(calendarEl, {
              initialView: "dayGridMonth",
              headerToolbar: {
                left: "dayGridMonth,dayGridWeek,timeGridDay",
                center: "title",
                right: "prev,next today",
              },
              locale: "ko",
              events: calArr, // AJAX로 받아온 일정 데이터 사용
              editable: true,
              selectable: true,
              buttonText: {
                today: "오늘",
                month: "월",
                week: "주",
                day: "일",
              },
            });
            calendar.render();
          },
        });
      });
    </script>
  </body>
</html>
