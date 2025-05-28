// DomContentLoaded 이벤트는 HTML 문서의 구조가 완전히 로드된 후 발생
window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  // 클릭 이벤트
  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    // 클릭 이벤트가 일어나면 행하고자 하는 코드 작성
    alert("클릭 이벤트 발생!");
    // click 색상을 변경
    click.style.background = "red";
  });

  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블 클릭 발생!");
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", (evnet) => {
    //alert("우클릭 발생!"); //()=>{} 이벤트 핸들러라 불리고 (event가 생략되어있음)
    // 우클릭 방지 시 사용
    event.preventDefault(); // 우클릭 방지
  });
  const hover = document.querySelector("#hover");
  hover.addEventListener("mouseenter", () => {
    console.log("mouseenter!");
    hover.style.background = "green";
    hover.innerHTML = "Mouse Enter";
  });
  hover.addEventListener("mouseleave", () => {
    console.log("mouseleave!");
    hover.style.background = "navy";
    hover.innerHTML = "Mouse Leave";
  });

  //폼 이벤트
  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  input.addEventListener("input", (e) => {
    console.log(e.target.value);
    inputResult.innerHTML = e.target.value;
  });
});
