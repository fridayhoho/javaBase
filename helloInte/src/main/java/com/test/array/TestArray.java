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
		printMissingNumber(new int[]{2, 5, 4, 10, 9, 7}, 10);
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
	 *
	 * 如果是 125~190 间找出缺少的数字呢？
	 *
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


}
