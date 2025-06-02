/*
https://api.upbit.com/v1/market/all
{
    "market": "KRW-BTC",
    "korean_name": "비트코인",
    "english_name": "Bitcoin"
  },
*/
// async function dataFetch() {}
// const dataFetch = async function () {};
// async 의 위치는 function 앞에

const dataFetch = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  const data = await response.json(); // 배열 출력
  console.log(data);
  //   for (let i = 0; i < data.length; i++) {
  //     console.log(data[i]);
  //   }
  // };
  //배열 보는 함수
  // 1번예시
  //  data.forEach((item) => {
  //     // startWith : 시작하는 단어 여부, includes : 포함 여부
  //     if (item.market.includes("KRW") == true) {
  //       market.innerHTML += `<h2>${item.korean_name}(${item.market})</h2>`;
  //     } // forEach에 조건이 걸렸을 떄 그걸 배열로 만드는 애가있따.
  //     console.log(item.market.includes("KRW"));
  //     console.log(item.korean_name);
  //   });
  // };
  //   2번예시
  // forEach + 조건문 -> filter
  const krwMarkets = data.filter((item) => item.market.includes("KRW"));
  /*
  let markets = "";
  krwMarkets.forEach((item) => {
    markets += item.market + ",";
  });
  console.log(markets.slice(0, -1));*/
  // forEach + 내가 원하는 형태로 가공하고자 할때 -> map
  const markets = krwMarkets.map((item) => item.market).join(",");

  const tickerResponse = await fetch(
    `https://api.upbit.com/v1/ticker?markets=${markets}`
  );
  const tickerData = await tickerResponse.json();
  console.log(tickerData);

  //filter로 먼저 조건 처리 하고 그다음 forEach로 출력
  krwMarkets.forEach((item) => {
    const ticker = tickerData.find((ticker) => ticker.market === item.market);
    market.innerHTML += `
    <h2>${item.korean_name}(${item.market})</h2>
        <p>현재가 : ${ticker.trade_price.toLocaleString()}원</p>
        <p>24시간 거래량 : ${ticker.acc_trade_volume_24h.toFixed(2)}</p>
        <p>전일 대비 : ${
          ticker.change === "RISE"
            ? "상승"
            : ticker.change === "FALL"
            ? "하락"
            : "보합"
        }(${(ticker.change_rate * 100).toFixed(2)}%)</p>
    `;
    // toLocaleString - 세자리 마다 , 써주는 함수
    // toFixed(2) - 소수점 둘째자리까지
  });
};
dataFetch();

//내가 한거
// const market = document.querySelector("#market");
// const bitcoin = async () => {
//   const response = await fetch("https://api.upbit.com/v1/market/all");
//   const bitcoinData = await response.json();
//   console.log(bitcoinData);
//   for (i = 0; i < bitcoinData.length; i++) {
//     if ((bitcoinData.market = /(KRW)/)) {
//       market.innerHTML += `${bitcoinData[i].korean_name}(${bitcoinData[i].market})`;
//     } else market.innerHTML = "";
//   }
// };
// bitcoin();
