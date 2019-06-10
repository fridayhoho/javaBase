package com.test.array;

/**
 * ClassName: FindLargestAndSmallest
 * Function:  TODO
 * Date:      2019-06-10 20:11
 * author     daguang
 * version    V1.0
 */
public class FindLargestAndSmallest {
	public static void main(String[] args) {
		int[] arr = new int[]{-20, 34, 21, -87, 92,
				Integer.MAX_VALUE};
		findLargestAndSmallest(arr);

		int a =9;
		int b = 888;
//		exchangeValue(a, b);
	}

	public static void findLargestAndSmallest(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int small = arr[0];
		int large = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < small){
				small = arr[i];
			}else{
				large = arr[i];
			}
		}
		System.out.println(" largest:"+large+" smallest:"+small);
	}

	public static void exchangeValue(int x, int y){
		System.out.println("orin  x:"+x + " y:"+y);
		y = x ^ y;
		x = x ^ y;
		y = x ^ y;
		System.out.println("exchanged x:"+x + " y:"+y);
	}
}
