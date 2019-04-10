package com.test;

class  Test{
    private static boolean isStop;
    public  static  void main(String[] args) throws InterruptedException {
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < 300; i++) {
            sf.append("test").append(i).append("ceshi");
        }



















//        Thread thread = new Thread(new Runnable() {
//            public void run() {
//                int i = 0;
//                while (!isStop){
//                    i++;
//                    System.out.println(i);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread.start();
//
//        TimeUnit.SECONDS.sleep(3);
//
//        isStop = true;
    }
}