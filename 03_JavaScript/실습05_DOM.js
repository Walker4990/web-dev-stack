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
