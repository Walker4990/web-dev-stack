const today = document.querySelector("#today");
function dateTime() {
  const now = new Date();
  console.log(now);

  today.textContent =
    now.getFullYear() +
    " " +
    (now.getMonth() + 1) +
    " " +
    now.getDate() +
    " " +
    now.getDay();
}
dateTime();

const times = document.querySelector("#times");
function time() {
  const now = new Date();
  times.textContent =
    now.getHours() + " " + now.getMinutes() + " " + now.getSeconds();
}
time();

setInterval(() => {
  time();
}, 1000);

const leftTimes = document.querySelector("#leftTimes");
function left() {
  const now = new Date();
  now.textContent =
    `${now.getFullYear()}` +
    " " +
    `${now.getMonth() + 1}` +
    " " +
    `${now.getDate()}` +
    " " +
    `${now.getDay()}` +
    " " +
    `${now.getHours()}` +
    " " +
    `${now.getMinutes()}` +
    " " +
    `${now.getSeconds()}`;

  console.log(now);
}
left();
// // 현재 날짜와 시간을 가져오기
// const currentDate = new Date();

// // 날짜와 시간을 문자열로 포맷팅
// const formattedDate = `${currentDate.getFullYear()}-${
//   currentDate.getMonth() + 1
// }-${currentDate.getDate()}
// ${currentDate.getHours()}:
// ${currentDate.getMinutes()}:
// ${currentDate.getSeconds()}`;

// // 포맷팅된 날짜와 시간을 출력
// document.write(formattedDate);
