package com.example.demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class hotelClient implements ProtocolHotel {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", ProtocolHotel.PORT);
             DataInputStream in = new DataInputStream(client.getInputStream());
             DataOutputStream out = new DataOutputStream(client.getOutputStream())) {

            System.out.println("Setting user name to MARVIN...");
            out.writeInt(USER);
            out.writeUTF("MARVIN");
            out.flush();
            String response = in.readUTF();
            System.out.println("Received: " + response);

            System.out.println("Reserving a room from the 1st of March to the 5th of March...");
            int startDate = 1;
            int endDate = 5;
            out.writeInt(RESERVE);
            out.writeInt(startDate);
            out.writeInt(endDate);
            out.flush();
            String reserveResponse = in.readUTF();
            System.out.println("Received: " + reserveResponse);

            System.out.println("Getting reservation info...");
            out.writeInt(AVAIL);
            out.flush();
            String availResponse = in.readUTF();
            System.out.println("Received: " + availResponse);

            System.out.println("Cancelling the reservation...");
            out.writeInt(CANCEL);
            out.flush();
            String cancelResponse = in.readUTF();
            System.out.println("Received: " + cancelResponse);

            System.out.println("Quitting the program...");
            out.writeInt(QUIT);
            out.flush();
            int quitResponse = in.readInt();
            System.out.println("Received: " + quitResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
