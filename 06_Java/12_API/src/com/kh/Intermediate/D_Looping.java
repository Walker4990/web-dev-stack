package com.kh.Intermediate;

import java.nio.file.DirectoryStream.Filter;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * 반복
 * - 요소 전체를 반복하는 역할
 * - peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * - forEach : 최종 처리 단계에서 전체요소를 반복하면서 추가적인 작업을 하기위해 사용
 * 
 * */
public class D_Looping {

	public static void main(String[] args) {
		
		int[] values = {1, 2, 3, 4, 5};
		
		
		// 1 ~ 5까지 출력(forEach)하고 짝수의 합계(sum)
		Arrays.stream(values)
		.forEach(num -> System.out.println(num));
				
		int sum = Arrays.stream(values)
				.filter(num -> num % 2 == 0)
				.sum();
				System.out.println(sum);
	
		// peek 같이 사용
			sum = Arrays.stream(values)
				 .peek(System.out::println)
				 .sum();	
			System.out.println("짝수의 합 : "+ sum);
				 
	}

}
