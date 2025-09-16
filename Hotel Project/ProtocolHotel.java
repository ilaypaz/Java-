package com.example.demo1;

public interface ProtocolHotel {
    int PORT = 18888;//matches both codes
    int USER = 1;
    int RESERVE = 2;
    int CANCEL = 3;
    int AVAIL = 4;
    int QUIT = 5;
    int INVALID_COMMAND = 6;
    int FAILURE = 7;
    int SUCCEED = 8;
    int CLOSED = 9;
}
