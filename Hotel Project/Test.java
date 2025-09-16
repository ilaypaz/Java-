package com.example.demo1;

public class Test {
        public static void main(String[]
                                        args) {
            SharedData sd = new SharedData();//one of those objects
            MyThread t1 = new
                    MyThread(sd,1,"T-1");//correlates to creating T1, my thread implements runnable so it has to run
            t1.start();//correlates to starting T-1 within this the run method is there within there is set and get method
            MyThread t2 = new
                    MyThread(sd,0,"T-2");//correlates to creating T2
            t2.start();//correlates to starting T2 within this the run method is there within it there is set and get mehtod
        }
    }
    /* output is
    Creating : T-1
Starting T-1
Creating : T-2
Starting T-2
Running : T-1
Running : T-2
get 1, 0
Set 1
get 2, 1
Set 2
get 3, 2
Set 3

     */

