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
});
