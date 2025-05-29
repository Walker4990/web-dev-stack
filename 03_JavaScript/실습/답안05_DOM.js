// 1번 문제
const result1 = document.querySelector("#result1");
function printText() {
  result1.textContent = "ㅎㅇ";
}

// 2번 문제
const customer = document.querySelector("#customer");
const result2 = document.querySelector("#result2");
function printInputValue() {
  // input 값(customer)을 가지고 오기
  console.log(customer.value);
  // 가지고와서 result2에 출력
  result2.innerHTML = customer.value;
  // input 값을 비우기 (추가)
  customer.value = "";
}
// 3번 문제
function changeColor() {
  const div = document.querySelector(".div-test");
  div.style.backgroundColor = "red";
}

// 4번 문제
function stringLength() {
  const div = document.querySelector("#text");
  const result4 = document.querySelector("#result4");
  //입력받은 text에서 글자의 글자수 가지고 오기
  console.log(div.value.length);
  //글자수를 result4에 출력
  result4.innerHTML = div.value.length;
  // 입력한 글자 비우기
  div.value = "";
}

// 5번 문제
const div = document.querySelector("#la");
const result5 = document.querySelector("#result5");
function stringSplit() {
  // 1. 사과, 바나나, 오렌지, 포도 문자 가지고 오기
  console.log(div.textContent);
  //2. 가지고 온 문자열 분리하기 -> 배열로 만들기(split)
  const div1 = div.textContent.split(",");

  //6. ul 태그 만들기
  const ul = document.createElement("ul");

  //3. 배열 값 하나씩 가지고 오기 -> 반복문!
  for (let i = 0; i < div1.length; i++) {
    //4. li 태그 만들기
    const li = document.createElement("li");
    //5. li 태그에 값 넣기
    li.innerHTML = div1[i];

    //7. ul 태그에 만들어놓은 li태그들 추가하기
    ul.appendChild(li);

    // ul.innerHTML = "<li>" + div1[i] + "</li>";
    // ul.innerHTML += `<li>${div1[i]}</li>
  }
  console.log(ul);
  //8. result5에 ul 담기
  result5.appendChild(ul);
}

// 6번 문제
const preview = document.querySelector("#preview");
const add = document.querySelector("#add");
const remove = document.querySelector("#remove");
function arrayTest() {
  // 1. 피자 치킨 떡볶이 <- 배열로 만들기
  const preArr = preview.textContent.split(" ");

  /*1-1 정 기억이 안나면 반복문
  for (let i = 0; i < preArr.length; i++) {
    // 이미 가지고 있는 값에서 내가 삭제할 값이 일치하면 배열에서 제거
    if (preArr[i] === remove.value) {
      preArr.splice(i, 1);
    }
  }*/
  // 1-2. 배열에서 제거 - splice(인덱스, 1);
  const delIdx = preArr.indexOf(remove.value);
  console.log(delIdx);
  if (delIdx !== -1) preArr.splice(delIdx, 1);

  // +) 추가
  // console.log(preArr.includes(remove.value));
  // if (preArr.includes(remove.value)) preArr.splice(delIdx, 1);

  //  추가 음식 입력 -> 배열에 추가 (push)
  preArr.push(add.value);
  // 배열을 문자열로 바꾸기
  // console.log(preArr.join(" "));
  preview.textContent = preArr.join(" ");
  remove.value = "";
}

// 7번 문제 : prompt로 이름, 나이, 주소 순으로 입력받아서 출력
const names = document.querySelectorAll(".name");
const ages = document.querySelectorAll(".age");
const addrs = document.querySelectorAll(".addr");
function addStudent() {
  for (let i = 0; i < 3; i++) {
    const name = prompt("이름을 입력하세요");
    const age = prompt("나이를 입력해주세요");
    const addr = prompt("주소를 입력해주세요.");
    names[i].textContent = name;
    ages[i].textContent = age;
    addrs[i].textContent = addr;
  }
}

// 8번
const list = document.querySelector("#list");
function addItem() {
  // 1. li 태그를 만들어서 추가하는 방식
  const li = document.createElement("li");
  li.textContent = "테스트";
  list.appendChild(li);

  // 2. innerHTML로 문자로 추가하는 방식
  list.innerHTML += "<li>테스트</li>";
}
function removeItem() {
  // 1. 부모에서 제거
  console.log(list.childNodes);
  list.removeChild(list.childNodes[0]);
  // 2. 본인이 제거
  const li = document.querySelector("#list li");
  li.remove();
}

// 9번
function toggleClass() {
  const result9 = document.querySelector("#result9");
  result9.classList.toggle("active");
}

// 10번
const item = document.querySelector("#item");
const price = document.querySelector("#price");
const cart = document.querySelector("#cart");
const total = document.querySelector("#total span");
let sum = 0; // 숫자를 더할땐 반드시 기본값이 있어야함.
function addToCart() {
  cart.innerHTML += `<li>${item.value} - ${price.value}</li>`;

  console.log(isNaN(Number(price.value))); //NaN
  if (!isNaN(Number(price.value))) sum += Number(price.value);
  console.log(sum);
  total.innerHTML = sum;
  item.value = "";
  price.value = "";
}
