//코드 중복! 함수로 기능으로
const show = (info) => {
  document.body.innerHTML = `
  <h1>${info}님 환영합니다!</h1>
  <button type="button" id="logout">로그아웃</button>
  `;
  // JS가 작성되고 난 뒤에 로그아웃 버튼이 생긴거기 떄문에 같은 스코프에서 기능을 추가해야함.
  const logout = document.querySelector("#logout");
  logout.addEventListener("click", () => {
    localStorage.removeItem("name");
    location.reload();
  });
};

// 로그인이 되어 있는 건지 아닌지 상태 확인
const info = localStorage.getItem("name");
if (info) {
  show(info);
}

const login = document.querySelector("#login");
login.addEventListener("click", () => {
  // 아이디 입력하고 비밀번호 입력받은 값들 로그인
  if (username.value === "" && password.value === "") {
    alert("이름과 비밀번호를 입력해주세요.");
    return;
  }
  localStorage.setItem("name", username.value);
  // 로그인 성공하고 이름을 저장

  //~님 환영합니다. 로그아웃 버튼
  show(username.value);
});
