package com.test.array;

import lombok.extern.slf4j.Slf4j;

import java.rmi.ConnectIOException;
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
        findTheMissedOne(generateArrWithMissedOne());
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
}
