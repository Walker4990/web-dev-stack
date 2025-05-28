window.addEventListener("DOMContentLoaded", () => {
  const box1 = document.querySelector(".box1");
  console.log(box1);
  let count = 1;
  box1.addEventListener("click", () => {
    box1.innerHTML = `Click ${count++}`;
    const img = document.querySelectorAll("img"); // 3개
    console.log(img);

    for (const item of img) {
      const random1 = Math.floor(Math.random() * 3 + 1);
      item.setAttribute("src", `assets/spy${random1}.jpg`);
    }
  });
  // 클릭을 누르면 이미지가 세개가 랜덤출력

  // 속성을 변경 setAttribute("속성", "값")
});
