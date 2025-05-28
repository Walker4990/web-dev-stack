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
  //input 실시간 반영
  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  input.addEventListener("input", (e) => {
    console.log(e.target.value);
    inputResult.innerHTML = e.target.value;
  });

  //select 선택값 출력
  const select = document.querySelector("#select");
  const selectResult = document.querySelector("#selectResult");
  select.addEventListener("change", (e) => {
    console.log(e.target.value);
    selectResult.innerHTML = e.target.value;
  });

  const form = document.querySelector("#form");
  const inputText = document.querySelector("#form input");
  form.addEventListener("submit", (e) => {
    // 값이 없는 경우만 전송 불가, 값이 있으면 전송
    console.log(inputText.value);

    if (inputText.value === "") e.preventDefault();
  });
  // 키 이벤트 : keydown, keypress, keyup
  const keyboard = document.querySelector("#keyboard");
  const keyResult = document.querySelector("#keyResult");
  keyboard.addEventListener("keydown", (e) => {
    console.log(e.key);
    keyResult.innerHTML = e.key;
    if (e.key === "Enter") {
      alert("엔터!");
    }
  });
  // 박스 움직이기
  const move = document.querySelector(".moveBox");
  let x = 0,
    y = 0;
  document.addEventListener("keydown", (e) => {
    console.log(e.key);
    if (e.key === "ArrowUp") {
      // top이 -인 경우
      y -= 15;
    } else if (e.key === "ArrowDown") {
      y += 15;
    } else if (e.key === "ArrowLeft") {
      x -= 15;
    } else if (e.key === "ArrowRight") {
      x += 15;
    }
    move.style.top = `${y}px`;
    move.style.left = `${x}px`;
  });

  // 스크롤 이벤트
  const wheel = document.querySelector("#wheel");
  const scroll = document.querySelector("#scroll");
  // window.addEventListener("wheel", (e) => {
  //   console.log(e.deltaY);
  //   // 휠을 올렸더니 - 100
  //   if (e.deltaY < 0) wheel.textContent = "휠 위로 스크롤 중";
  //   else if (e.deltaY > 0) wheel.textContent = "휠 아래로 스크롤 중";
  //   // 휠을 내렸더니 + 100
  // });
  window.addEventListener("scroll", () => {
    // 전체 높이
    console.log("scrollHeight", document.documentElement.scrollHeight);
    // 화면 보이는 높이
    console.log("innerHeight", window.innerHeight);
    console.log("scrollY", window.scrollY);
    // scrollHeight === innerHeight + scrollY
    // scrollHeight - innerHeight : 스크롤 총 내리는 높이
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;
    const percent = (window.scrollY / totalHeight) * 100;
    console.log(percent);
    scroll.style.width = `${percent}%`;
  });

  // 이벤트 위임
  // 이미지가 클릭될 때마다 해당 이미지 지우기
  // 1. 이미지 마다 이벤트 걸려면 반복문 필요
  /*
  const img = document.querySelectorAll(".container img");
  console.log(img);
  for (let i = 0; i < img.length; i++) {
    console.log(img[i]);
    img[i].addEventListener("click", (e) => {
      // img[i].style.display = "none";
      console.log(e.currentTarget);
      e.currentTarget.style.display = "none";
    });
  }  잠깐 주석 */

  //2. 부모의 컨테이너에 이벤트 걸기
  const container = document.querySelector(".container");
  const removeHandler = (e) => {
    console.log("target", e.target); // 내가 클릭한 이미지 선택
    console.log("crruent", e.currentTarget); // 이벤트 걸린 본인
    if (e.target !== e.currentTarget) e.target.style.display = "none";
  };
  container.addEventListener("click", removeHandler);
});
