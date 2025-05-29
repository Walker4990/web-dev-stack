// 1번 문제
function printText() {
  const div = document.querySelector("#result1");
  div.innerHTML = "<span>출력하기</span>";
  console.log(div.innerHTML);
}

// 2번 문제
const customer = document.querySelector("#customer");
function printInputValue() {
  console.log(customer.value);
  customer.innerHTML = customer.value;
}
// 3번 문제
function changeColor() {
  const div = document.querySelector(".div-test");
  div.style.backgroundColor = "red";
}

// 4번 문제
function stringLength() {
  const div = document.querySelector("#text");
  console.log(div.value.length);
}

// 5번 문제
const div = document.querySelector("#la");
function stringSplit() {
  const div1 = div.textContent.split(" ");

  for (i = 0; i < div1.length; i++) console.log(div1[i]);
}

// 6번 문제
function arrayTest() {
  const div = document.querySelector("#preview");
  // const p = document.createElement("div");
  const q = document.querySelector("#remove");
  const arr = div.textContent.split(" ");
  console.log(div.textContent.split(" ")); // <-- 활용! 배열!
  arr.push(add.value);
  // 얘가 추가된 값! <-- 추가! (push)

  console.log(q.value); // 삭제된 값! <-- 일치하는 것!
  // 배열에서! 값 삭제!! splice!

  // console.log(add.value);
  //if ((p.textContent = add.value)) div.appendChild(p);
  ///if ((q = remove.value)) q.remove();
}

// 7번 문제 : prompt로 이름, 나이, 주소 순으로 입력받아서 출력
function addStudent() {}

// 8번
function addItem() {}

// 9번
function toggleClass() {}

// 10번
function addToCart() {}
