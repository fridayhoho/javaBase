package com.test;

import java.util.HashMap;

public class MyHashSet {
       int[][] buckets;
        /** Initialize your data structure here. */
        public MyHashSet() {
            buckets = new int[100][];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new int[10000];
            }
        }

        public void add(int key) {
            int idxBucket = key%100;
            int[] bNodes = buckets[idxBucket];
            int idx = key%10000;
            bNodes[idx] = key + 1;
        }

        public void remove(int key) {
            int idxBucket = key%100;
            int[] bNodes = buckets[idxBucket];
            int idx = key%10000;
            if (bNodes[idx] != 0){
                bNodes[idx] = 0;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int idxBucket = key%100;
            int[] bNodes = buckets[idxBucket];
            int idx = key%10000;
            if (bNodes[idx] - 1 == key){
                return true;
            }
            return false;
        }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(100000);
        hashSet.add(0);

        System.out.println("contains 0 [" + hashSet.contains(0) + "]");
        System.out.println("contains 99 [" + hashSet.contains(99) + "]");
        System.out.println("contains 100000 [" + hashSet.contains(100000) + "]");

        hashSet.remove(100000);

        System.out.println("contains 2390 [" + hashSet.contains(100000) + "]");

        HashMap hashMap = new HashMap();
    }
}
