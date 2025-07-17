// $(document).ready(function () {}); -->
$(function () {
  //   const h1 = document.querySelector("h1");
  //   h1.style.color = "red"; -->
  $("h1").css("color", "blue");

  //   const pList = document.querySelectorAll("p");
  //   for (p of pList) {
  //     p.style.color = "white";
  //     p.style.backgroundColor = "tomato";
  //   } -->
  $("p").css("color", "blue");
  $("p").css("background-color", "tomato");
  $("p").css({
    color: "white",
    backgroundColor: "tomato",
    //backgroundColor -> "background-color" 따옴표 붙이면 css속성 그대로 사용가능
  });

  $("p").first().css("font-size", "2rem");
  $("p").eq(5).text("eq로 다시 글 작성합니다");
  $("p").last().css("color", "yellow");
  $(".wrap").children().css({
    color: "white",
    border: "2px solid green",
  });
  $(".wrap").find("h1").css({ color: "orange" });
  $("h1").siblings("p").css("background-color", "navy");

  // DOM 객체
  // 자바스크립트
  const p = document.createElement("p");
  p.innerText = "자바스크립트로 추가";
  document.querySelector("#content").appendChild(p);

  // jQuery
  const p2 = $("<p>").html("제이쿼리로 추가");
  $("#content").append(p2);
  // append 해당 자식 요소 뒷부분에 추가
  $("#item").append("<span>append</span>");
  // appendTO : append와 기능은 같지만 순서가 바뀜
  // "<span>appendTo</span>".appendTo("#item");
  // prepend 해당 자식 요소 앞부분에 추가
  $("#item").prepend("<span>prepend</span>");
  // after 해당 형제 요소로 뒷부분에 추가
  $("#item").after("<span>after</span>");
  // before 해당 형제 요소로 앞부분에 추가
  $("#item").before("<span>before</span>");

  // 이벤트
  /*
  $("#textarea").on({
    keydown: (e) => {
      // 키보드 눌려지는 상황
      console.log(`keydown - e.key : ${e.key}, 
                            e.keyCode : ${e.keyCode}`);
    },
    keypress: (e) => {
      // 키가 입력될때
      console.log(`keypress - e.key : ${e.key},
                            e.keyCode: ${e.keyCode}`);
    },
    keyup: (e) => {
      // 키가 떼어질 때
      console.log(`keyup - e.key : ${e.key},
                            e.keyCode: ${e.keyCode}`);
    },
  });
  */
  $("#textarea").keyup((e) => {
    let target = $(e.target);
    let length = target.val().length;

    if (length > 50) {
      target.val(target.val().substr(0, 50));
    } else {
      $("#counter").text(length);
    }
  });

  $("#userId").keyup((e) => {
    let target = $(e.target);
    let id = target.val();
    const idRegex = /^[a-z][a-z0-9]{3,11}$/;
    if (!idRegex.test(id)) {
      $("#idCheck").text("사용 불가능한 아이디입니다.").css("color", "red");
    } else if (id === "") {
      $("#idCheck").text("");
    } else {
      $("#idCheck").text("사용 가능한 아이디입니다.").css("color", "green");
    }
  });
});
