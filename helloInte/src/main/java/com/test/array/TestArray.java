package com.test.array;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.util.ArrayUtils;

import java.rmi.ConnectIOException;
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
        findThoseMissed(generateArrWithMissedSome());
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
     * @return
     */
    private static int[] generateArrWithMissedSome() {
        int[] arr = new int[10];
        int[] indexs = new int[]{new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10)};

        for (int i = 0; i < 10; i++) {
            if (isInArray(indexs, i)) {
                log.info("the missed one:{}", i);
                continue;
            }
            arr[i] = i;
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
    private static void findThoseMissed(int[] arr) {
        BitSet bitSet = new BitSet(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                bitSet.set(i);
            }
        }
        int lastMissedIdx = 0;
        for (int i = 0; i < bitSet.length(); i++) {
            lastMissedIdx = bitSet.nextClearBit(lastMissedIdx );
            log.info("missed:{}", lastMissedIdx);
        }
    }
}
