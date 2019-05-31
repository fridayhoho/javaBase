package com.test.array;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.util.ArrayUtils;

import java.rmi.ConnectIOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Random;

/**
 * ClassName: TestArray
 * Function:  TODO
 * Date:      2019-05-27 21:20
 * author     daguang
 * version    V1.0
 */
@Slf4j
public class TestArray {
	public static void main(String[] args) {
//        findTheMissedOne(generateArrWithMissedOne());
//		int[] targetArr = generateArrWithMissedSome(10, 3);
//		findThoseMissed(targetArr, 3);
//		printMissingNumber(new int[]{2, 5, 4, 10, 9, 7}, 10);
		int[] duplicateArr = new int[]{1, 3, 2, 2, 1, 1, 8, 3};
//		findDumplicate(duplicateArr);
//		int[] rs = removeDuplicates(duplicateArr);
//		for (int i = 0; i < rs.length; i++) {
//			System.out.println(rs[i]);
//		}
		int[] duplicateArrOneMissedDup = new int[]{1, 3, 2, 2, 1, 1, 8, 3};
//		int missDup = findTheMissDuplicateOne(new int[]{1, 3, 1, 3, 4});
//		findDuplicate(new int[]{3, 1, 4, 9, 114, 2, 1});
//		System.out.println(missingNumber(new int[]{3, 0, 1}));
//		System.out.println(missingNumber(new int[]{3, 2, 1}));
//		int[] pivotArr = new int[]{2, 7, 3, 6, 5, 6, 12};
//		System.out.println(pivotIndex(pivotArr));
		System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
		System.out.println(dominantIndex(new int[]{1, 0}));
	}

	/**
	 * 送你一个数组，少一个数，厉害不
	 *
	 * @return
	 */
	private static int[] generateArrWithMissedOne() {
		int[] arr = new int[100];
		int index = new Random().nextInt(100);
		log.info("the missed one:{}", index);
		for (int i = 0; i < 100; i++) {
			if (index == i) {
				continue;
			}
			arr[i] = i;

		}
		log.info("arr:{}", arr);

		return arr;
	}


	private static boolean isInArray(int[] arr, int ele) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ele) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 送你一个数组，少几个数，服不服
	 *
	 * @param arrLen        从1开始多少个数
	 * @param toMissedCount 缺几个
	 * @return
	 */
	public static int[] generateArrWithMissedSome(int arrLen, int toMissedCount) {
		assert (toMissedCount <= arrLen);
		int[] arr = new int[arrLen];
		int[] missedNumbers = new int[toMissedCount];
		for (int i = 0; i < toMissedCount; i++) {
			missedNumbers[i] = new Random().nextInt(arrLen);
		}
		System.out.println("toMissedCount:" + missedNumbers);
		for (int i = 0; i < arrLen; i++) {
			if (isInArray(missedNumbers, i + 1)) {
				log.info("the missed one:{}", i + 1);
				continue;
			}
			arr[i] = i + 1;
		}
		log.info("arr:{}", arr);

		return arr;
	}

	/**
	 * 缺谁了啊 兄die
	 *
	 * @param arr
	 */
	private static void findTheMissedOne(int[] arr) {
		int total = 0;
		int totalTobe = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
			totalTobe += i;
		}
		log.info("the missed one:{}", totalTobe - total);
	}

	/**
	 * 找出缺的好几个
	 *
	 * @param arr
	 */
	public static void findThoseMissed(int[] arr, int cntMissed) {
		BitSet bitSet = new BitSet(arr.length);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				bitSet.set(i);
			}
		}

		int lastMissedIdx = 0;
		for (int i = 0; i < cntMissed; i++) {
			lastMissedIdx = bitSet.nextClearBit(lastMissedIdx);
			log.info("missed:{}", ++lastMissedIdx);

		}
	}

	/**
	 * 要求前提： 索引 = 数字-1
	 * <p>
	 * 如果是 125~190 间找出缺少的数字呢？
	 *
	 * @param numbers
	 * @param count
	 */
	private static void printMissingNumber(int[] numbers, int count) {
		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);
		for (int number : numbers) {
			bitSet.set(number - 1);
		}
		System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}
	}

	public static void findDumplicate(int[] arr) {
		BitSet bitSet = new BitSet();
		BitSet bitSetDup = new BitSet();
		int duplicateCount = 0;
		int[] duplicates = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (!bitSet.get(arr[i])) {
				bitSet.set(arr[i]);
				continue;
			}
			duplicateCount++;
			bitSetDup.set(arr[i] - 1);


		}
		int nextDupIndex = 0;
		System.out.println("重复的有:");
		for (int i = 0; i < duplicateCount; i++) {
			nextDupIndex = bitSetDup.nextSetBit(nextDupIndex);
			nextDupIndex++;
			System.out.println(arr[nextDupIndex]);
		}
	}

	public static int[] removeDuplicates(int[] numbersWithDuplicates) {
		Arrays.sort(numbersWithDuplicates);

		int[] result = new int[numbersWithDuplicates.length];
		int previous = numbersWithDuplicates[0];
		result[0] = previous;

		for (int i = 1; i < numbersWithDuplicates.length; i++) {
			int ch = numbersWithDuplicates[i];

			if (previous != ch) {
				result[i] = ch;
			}
			previous = ch;
		}
		return result;
	}

	/**
	 * 找出不重复那个
	 *
	 * @param arr
	 * @return
	 */
	public static int findTheMissDuplicateOne(int[] arr) {
		assert (arr != null && arr.length > 0);
		int missDup = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			missDup = missDup ^ arr[i];
		}
		System.out.println("不重复的是:" + missDup);
		return missDup;
	}

	public static int findDuplicate(int[] nums) {
		assert (nums != null || nums.length > 0);
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 < nums.length && (nums[i] ^ nums[i + 1]) == 0) {
				System.out.println("重复的是:" + nums[i]);
				return nums[i];
			}
		}
		System.out.println("no重复");
		return -1;//no dup
	}

	public static int missingNumber(int[] nums) {
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		int theMax = nums.length;
		int totalS = (theMax * (nums.length + 1)) / 2;
		return totalS - total;
	}

	public static int pivotIndex(int[] nums) {
		assert nums != null && nums.length > 0;
		int sumL = 0;
		int sumR = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				sumR += nums[j];
			}
			if (sumL == sumR) {
				return i;
			} else {
				sumR = 0;
			}
			sumL += nums[i];
		}
		return -1;
	}

	public static int dominantIndex(int[] nums) {
		if (nums == null || nums.length == 0){
			return -1;
		}
		if(nums.length == 1){
			return 0;
		}
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);
		int maxOne = 0;
		int maxSecond = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i - 1 >= 0 && nums[i] != nums[i - 1]) {
				maxOne = nums[i];
				maxSecond = nums[i - 1];
				break;
			}
		}
		if (maxSecond * 2 <= maxOne) {
			for(int i=0;i<nums2.length;i++){
				if(nums2[i]==maxOne){
					return i;
				}
			}

		}
		return -1;
	}
}
