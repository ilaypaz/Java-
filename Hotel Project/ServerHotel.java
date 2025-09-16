package com.example.demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ServerHotel {
    public static void main(String[] args) {
        final int SBAP_PORT = 18888;//the specific extension for device
        try (ServerSocket server = new ServerSocket(SBAP_PORT)) {//server socket looking for incoming requests
            Hotel hotel = new Hotel();//just some outside object
            while (true) {
                System.out.println("Waiting for clients to connect...");
                Socket client = server.accept();//accepting the connection request
                System.out.println("Client connected.");
                HotelService service = new HotelService(client, hotel);//hotel service implements runnable so we can have a thread with it
                Thread t = new Thread(service);//new thread with the runnable object
                t.start();//lets go
            }
        } catch (IOException e) {//this is in case there is an interruption, port does not exist etc
            System.out.println("Error initializing server: " + e.getMessage());
        }
    }
}


class HotelService implements Runnable, ProtocolHotel {
    private final Socket client;//this is the other end of the socket
    private DataInputStream in;//input from server
    private DataOutputStream out;//output to server
    private final Hotel hotel;
    private String current;

    public HotelService(Socket client, Hotel hotel) {
        this.client = client;
        this.hotel = hotel;
    }

    public void run() {
        try {
            in = new DataInputStream(client.getInputStream());//input from the server
            out = new DataOutputStream(client.getOutputStream());//output to server
            doService();//some crappy method
        } catch (IOException exception) {//in case shit goes bad
            System.out.println("Something went wrong: " + exception.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException exception) {
                System.out.println("Failed to close client socket: " + exception.getMessage());
            }
        }
    }

    private void doService() throws IOException {
        int command = 0;
        while (command != QUIT) {
            command = in.readInt();
            switch (command) {
                case USER:
                    current = in.readUTF(); // Read in string in this case the name
                    out.writeInt(SUCCEED);
                    out.writeUTF("Hello, " + current);
                    out.flush();
                    break;

                case RESERVE:
                    int startDate = in.readInt();
                    int endDate = in.readInt();
                    if (current == null) {
                        out.writeInt(FAILURE);
                        out.writeUTF("Reservation unsuccessful: User not set.");
                        break;
                    }
                    boolean success = hotel.requestReservation(current, startDate, endDate);
                    if (success) {
                        out.writeInt(SUCCEED);
                        out.writeUTF("Reservation made: " + current + " from " + startDate + " through " + endDate);
                    } else {
                        out.writeInt(FAILURE);
                        out.writeUTF("Reservation unsuccessful: " + current + " from " + startDate + " through " + endDate);
                    }
                    out.flush();
                    break;

                case CANCEL:
                    if (current == null) {
                        out.writeInt(FAILURE);
                        out.writeUTF("Reservations not canceled: User not set.");
                        break;
                    }
                    boolean cancelSuccess = hotel.cancelReservation(current);
                    if (cancelSuccess) {
                        out.writeInt(SUCCEED);
                        out.writeUTF("Reservations successfully canceled for " + current);
                    } else {
                        out.writeInt(FAILURE);
                        out.writeUTF("Reservations not canceled for " + current + ", no current reservation.");
                    }
                    out.flush();
                    break;

                case AVAIL:
                    String info = hotel.reservationInformation();
                    out.writeInt(SUCCEED);
                    out.writeUTF(info);
                    out.flush();
                    break;

                case QUIT:
                    out.writeInt(CLOSED);
                    out.writeUTF("Closing Connection");
                    out.flush();
                    break;

                default:
                    out.writeInt(INVALID_COMMAND);
                    out.writeUTF("Invalid command: Closing Connection");
                    out.flush();
                    break;
            }
        }
    }
}

