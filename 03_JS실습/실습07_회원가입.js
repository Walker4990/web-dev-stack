// 아이디를 입력하면서 조건에 안맞으면 문구 유지,
const id = document.querySelector("#id");
const id1 = document.querySelector("#id1");

let check1 = false;
let check2 = false;
let check3 = false;
let check4 = false;
let check5 = false;
let check6 = false;

const func1 = () => {
  id.addEventListener("input", (e) => {
    let idCond = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
    if (idCond.test(e.target.value)) {
      console.log("아이디 사용가능");
      id1.innerHTML = "사용 가능한 아이디입니다.";
      id1.style.color = "green";
      check1 = true;
    } else {
      console.log("아이디 사용 불가");
      id1.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
      id1.style.color = "orange";
      check1 = false;
    }
  });
};
const pw = document.querySelector("#pw");
const pw1 = document.querySelector("#pw1");
const func2 = () => {
  pw.addEventListener("input", (e) => {
    let pwCond =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
    if (pwCond.test(e.target.value)) {
      console.log("사용 가능한 비밀번호입니다.");
      pw1.innerHTML = "사용 가능한 비밀번호입니다.";
      pw1.style.color = "green";
      // return true;
      check2 = true;
    } else {
      pw1.innerHTML = "사용 불가능한 비밀번호입니다.";
      pw1.style.color = "orange";
      // return false;
      check2 = false;
    }
  });
};
const repeat = document.querySelector("#repeat");
const repeat1 = document.querySelector("#repeat1");
const func3 = () => {
  repeat.addEventListener("input", (e) => {
    if (pw.value === e.target.value) {
      repeat1.innerHTML = "비밀번호가 일치합니다.";
      repeat1.style.color = "green";
      check3 = true;
    } else {
      repeat1.innerHTML = "비밀번호가 일치하지않습니다.";
      repeat1.style.color = "orange";
      check3 = false;
    }
  });
};
// 위 첫 비밀번호 값과 동일할 경우 true 틀릴경우 false

const name = document.querySelector("#name");
const name1 = document.querySelector("#name1");
const func4 = () => {
  name.addEventListener("input", (e) => {
    let nameVal = /^[가-힣]{2,}$/;
    if (nameVal.test(e.target.value)) {
      name1.innerHTML = "";
      check4 = true;
    } else {
      name1.innerHTML = "다시 입력해주세요.";
      name1.style.color = "black";
      check4 = false;
    }
  });
};
const mail = document.querySelector("#mail");
const mail1 = document.querySelector("#mail1");
const func5 = () => {
  mail.addEventListener("input", (e) => {
    let mailVal = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
    if (mailVal.test(e.target.value)) {
      mail1.innerHTML = "사용가능한 메일입니다.";
      mail1.style.color = "green";
      check5 = true;
    } else {
      mail1.innerHTML = "사용 불가능한 메일입니다.";
      mail1.style.color = "orange";
      check5 = false;
    }
  });
};
const tel = document.querySelector("#tel");
const tel1 = document.querySelector("#tel1");
const func6 = () => {
  tel.addEventListener("input", (e) => {
    let telVal = /^010-\d{4}-\d{4}$/;
    if (telVal.test(e.target.value)) {
      tel1.innerHTML = "사용가능한 전화번호입니다.";
      tel1.style.color = "green";
      check6 = true;
    } else {
      tel1.innerHTML = "사용 불가능한 전화번호입니다.";
      tel1.style.color = "orange";
      check6 = false;
    }
  });
};

func1();
func2();
func3();
func4();
func5();
func6();
const join = document.querySelector("#join");
join.addEventListener("click", () => {
  if (check1 && check2 && check3 && check4 && check5 && check6) {
    window.confirm("가입하시겠습니까?") ? alert("네") : alert("아니요");
  } else {
    alert("다시 확인해주세요");
  }
  //   if (
  //     func1() == true &&
  //     func2() == true &&
  //     func3() == true &&
  //     func4() == true &&
  //     func5() == true &&
  //     func6() == true
  //   ) {
  //     window.confirm("가입하시겠습니까?") ? alert("네") : alert("아니요");
  //   } else alert("다시 확인해주세요");
});

const cancel = document.querySelector("#cancel");
cancel.addEventListener("click", () => {
  location.reload();
});
