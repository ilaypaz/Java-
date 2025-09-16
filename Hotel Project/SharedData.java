package com.example.demo1;

    public class SharedData
    {
        private int value;//shared between the threads.

        public void setSharedData(int n)//setter method
        {

            value = n;//basic setter for changing the value displayed
        }
        public int getSharedData()//method for getting shared data
        {

            return value;//basic getter
        }
    }

