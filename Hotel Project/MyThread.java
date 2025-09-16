package com.example.demo1;

public class MyThread implements Runnable {//this must implement a run function
    private SharedData sd ;//just some object
    private int code;
    private String name;
    public MyThread (SharedData sd, int code, String name) {//construcotr
        this.sd = sd;
        this.code = code;
        this.name = name;
        System.out.println("Creating : " + name);//every time you create A "my thread" message appears.
    }
    public void run() {
        int s;//this is a delay of sorts
        System.out.println("Running : " + name);//displays this on console
        for (int i=1 ; i <= 3 ;i++) {
            if (code == 1) {//if the code is 1
                System.out.println("Set " + i);//set the  value to i
                sd.setSharedData(i);//setting the value to I
                s = i * 100;
            } else {
                System.out.print("get " + i + ", ");//if the starting number isn't one execute this code
                System.out.println(sd.getSharedData());//prints out 0 initially
                s = 50 ;
            }
            try {
                Thread.sleep(s);//shut that thread down if something goes wrong
            } catch (InterruptedException e) {//this is for simplicity sake
                System.out.println(e);//print out a statement
            }
        }
    }

    public void start() {
        System.out.println("Starting " + name );
        Thread theThread = new Thread(this);//excutes run code, this referring to run
        theThread.start();
    }
}

