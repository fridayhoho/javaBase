package com.test.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: QSort
 * Function:  TODO
 * Date:      2019-06-10 20:52
 * author     daguang
 * version    V1.0
 */
public class QSort {
	public static void main(String[] args) {
		int[] arr = new int[]{33, 4, 5, 2, 1, 9};

//		partition(arr, 0, arr.length - 1);
		System.out.println("before: "+Arrays.toString(arr));
		quickSort(arr);
//		int pivotIdx = partion2(arr, 0, arr.length-1);
		System.out.println(" after: "+Arrays.toString(arr));
	}

	public static int partion2(int[] arr, int lowIdx, int highIdx) {
		int pivot = arr[lowIdx];
		

		while (lowIdx <= highIdx) {
			//find larger than pivot
			while (arr[lowIdx] < pivot) {
				lowIdx++;
			}
			//find smaller than pivot
			while (arr[highIdx] > pivot) {
				highIdx--;
			}
//			找到 一对，一个大于轴，一个小于轴  如果索引位置 大的在左侧，则交换位置
			if (lowIdx <= highIdx) {
				int tmp = arr[lowIdx];
				arr[lowIdx] = arr[highIdx];
				arr[highIdx] = tmp;
				lowIdx++;
				highIdx--;
			}
		}
		return lowIdx;
	}

	public static void exchangeValue(int[] arr, int idx_a, int idx_b) {
		System.out.println("orin  x:" + arr[idx_a] + " y:" + idx_b);
		arr[idx_b] = arr[idx_a] ^ arr[idx_b];
		arr[idx_a] = arr[idx_a] ^ arr[idx_b];
		arr[idx_b] = arr[idx_a] ^ arr[idx_b];
		System.out.println("exchanged x:" + arr[idx_a] + " y:" + arr[idx_b]);
	}

	public static int partition(int[] array, int left, int right) {
		int pivot = array[left]; // taking first element as pivot

		while (left <= right) {
			//searching number which is greater than pivot, bottom up
			while (array[left] < pivot) {
				left++;
			}
			//searching number which is less than pivot, top down
			while (array[right] > pivot) {
				right--;
			}

			// swap the values
			if (left <= right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;

				//increment left index and decrement right index
				left++;
				right--;
			}
		}
		return left;
	}

	public static void quickSort(int[] array) {
		recursiveQuickSort(array, 0, array.length - 1);
	}

	public static void recursiveQuickSort(int[] array, int startIdx,
										  int endIdx) {

		int idx = partion2(array, startIdx, endIdx);

		// Recursively call quicksort with left part of the partitioned array
		if (startIdx < idx - 1) {
			recursiveQuickSort(array, startIdx, idx - 1);
		}

		// Recursively call quick sort with right part of the partitioned array
		if (endIdx > idx) {
			recursiveQuickSort(array, idx, endIdx);
		}
	}
}
