const currentTime = () => {
  const weeks = ["일", "월", "화", "수", "목", "금", "토"];
  const today = new Date();
  console.log(today);
  console.log(today.getFullYear()); // 년
  console.log(today.getMonth() + 1); // 월
  console.log(today.getDate()); // 일
  console.log(today.getDay()); // 요일 (0:일, 1:월 ~)

  console.log(weeks[today.getDay()]); // 요일 설정법

  const year = today.getFullYear();
  const month = today.getMonth() + 1;
  const date = today.getDate();
  const day = weeks[today.getDay()];

  const current = document.querySelector("#current");
  function todays() {
    current.innerHTML = `${year}년 ${month}월 ${date}일 (${day})`;
  }
  todays();

  console.log(today.getHours()); // 시
  console.log(today.getMinutes()); // 분
  console.log(today.getSeconds()); // 초

  const hour = String(today.getHours()).padStart(2, "0");
  const min = String(today.getMinutes()).padStart(2, "0");
  const sec = String(today.getSeconds()).padStart(2, "0");
  // 00초로 만들기 : String(parameter).padStart(자릿수, 0)
  const time = document.querySelector("#time");

  time.innerHTML = `${hour}:${min}:${sec}`;
};

const randomBackground = () => {
  const body = document.body;
  const r = Math.floor(Math.random() * 256);
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  // 0 <= random < 256
  body.style.background = `rgba(${r}, ${g}, ${b}, 0.3)`;

  //   const backGround = [
  //     "#ED833A",
  //     "#EA839B",
  //     "#42B667",
  //     "#FFC228",
  //     "#005456",
  //     "#ACDED5",
  //   ];
  //   body.style.background =
  //     backGround[Math.floor(Math.random() * backGround.length)];
  // random 코드 복습
};

const count = () => {
  const last = new Date("2026-01-01 00:00:00"); // 목표날짜
  const now = new Date();
  //   console.log(Math.floor((last - now) / 1000)); // <- 밀리 세컨드로 계산됨.
  const second = Math.floor((last - now) / 1000); // 1초 = 밀리세컨드/1000,
  const minute = Math.floor(second / 60); // 1분
  const hour = Math.floor(minute / 60); // 1시간
  const day = Math.floor(hour / 24);
  console.log(day);
  console.log(hour);
  //이따 물어보기
  console.log(hour % 24);
  console.log(minute % 60);
  console.log(second % 60);
  const count = document.querySelector("#count");
  count.innerHTML = `올해 남은 시간 ${day}일 ${hour % 24}시간 ${
    minute % 60
  }분 ${second % 60}초`;
};

import quotes from "./JS실습05_quotes.js";
// js 에서만 사용하려면 뒤에 .js 붙여야함.
const eng = document.querySelector("#eng");
const kor = document.querySelector("#kor");
const randomQuote = () => {
  const random = quotes[Math.floor(Math.random() * quotes.length)];
  // 무한 루프도 되는지 물어보기
  console.log(quotes[1].en);
  console.log(quotes[1].ko);
  kor.innerHTML = random.ko;
  eng.innerHTML = random.en;
};

currentTime();
randomBackground();
count();
randomQuote();

setInterval(() => {
  randomBackground();
  randomQuote();
}, 5000);

setInterval(() => {
  currentTime();
  count();
}, 1000); // 1000이 1초
