package com.test;

public class SuperbSort {

    public static void main(String[] args) {
        int[] arrTdo = new int[]{23, 45, 676, 29, 555, 999};
        superSort(arrTdo);
    }

    public static void superSort(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            final int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(arr[finalI]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(arr[finalI]);
                }
            }.start();


        }
    }
}
