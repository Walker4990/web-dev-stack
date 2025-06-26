package com.kh.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Application {

	public void arr() {
		int[] result = new int[4];
		// 인덱스 : 0 -> 2등 ~ 3 ->5등
		
		// 1등 당첨 기준 : 로또번호 6개
		// 둘 다 랜덤 로또번호는 1번
		// 내번호는 맞출때까지
		// 로또 번호는 1 ~ 45

		// ArrayList
		List<Integer> lotto = new ArrayList<>();

		int count = 0;
		while (lotto.size() < 7) {
			int num = (int) (Math.random() * 45 + 1);
			if (!lotto.contains(num)) {
				lotto.add(num);
			}
		}
		List<Integer> realLotto = new ArrayList<>(lotto.subList(0, 6));
		int bonus = lotto.get(6);

		Collections.sort(realLotto);

		while (true) {
			List<Integer> myNum = new ArrayList<>();
			while (myNum.size() < 6) {

				int num = (int) (Math.random() * 45 + 1);
				if (!myNum.contains(num)) {
					myNum.add(num);
				}
			}
			Collections.sort(myNum);
			System.out.println("로또번호 : " + lotto + "보너스 번호 : " + bonus);
			System.out.println("내 번호 : " + myNum);
			count++;

			// 만약 2, 3, 4, 5 등 당첨!
			// 2등 당첨 -> 보너스 번호 일치 + 5개가 같은 경우
			// 3등 : 5개가 같은경우
			// 4등 : 4개가 같은 경우
			// 5등 : 3개만 같은 경우
			int match = 0;
			for (int i : realLotto) {
				if (myNum.contains(i))
					match++;
			}

			boolean bounsMatch = myNum.contains(bonus);

			if (match == 6) {
				System.out.println("축하합니다!! 1등입니다!!");
				System.out.println("도전횟수 : " + count);
				for(int i = 0; i<result.length; i++) {
					System.out.println((i+2)+ "등 당첨 횟수 : " + result[i]+"회");
				}
				break;
			} else if (match == 5 && bounsMatch) {
				System.out.println("축하합니다!! 2등입니다!!");
				System.out.println("도전횟수 : " + count);
				result[0]++;
			} else if (match == 5) {
				System.out.println("3등입니다!!");
				System.out.println("도전횟수 : " + count);
				result[1]++;
			} else if (match == 4) {
				System.out.println("4등입니다!!");
				System.out.println("도전횟수 : " + count);
				result[2]++;
			} else if (match == 3) {
				System.out.println("5등입니다!!");
				System.out.println("도전횟수 : " + count);
				result[3]++;
			}

		}
	}

	public void set() {

		int count = 0;
		HashSet<Integer> lotto = new HashSet<>();
		while (lotto.size() < 6) {
			int num = (int) (Math.random() * 45 + 1);
			lotto.add(num);

		}
		System.out.println("로또 번호 : " + lotto);

		while (true) {
			HashSet<Integer> myLotto = new HashSet<>();
			while (myLotto.size() < 6) {
				int num = (int) (Math.random() * 45 + 1);
				myLotto.add(num);

			}
			System.out.println("로또번호 : " + lotto);
			System.out.println("내 번호 : " + myLotto);
			count++;

			if (lotto.equals(myLotto)) {
				System.out.println("1등당첨");
				System.out.println("도전 횟수 : " + count);
				System.out.println("로또 번호 : " + lotto);
				System.out.println("내 번호 : " + myLotto);
				break;
			}

		}

	}

	public static void main(String[] args) {
		Application app = new Application();
		app.arr();
//		app.set();
	}

}
