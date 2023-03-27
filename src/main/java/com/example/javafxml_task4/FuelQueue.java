//Student name: Hiruni Perera Student ID: w1898953
package com.example.javafxml_task4;

import java.util.ArrayList;

public class FuelQueue {
    //This class creates fuelqueue objects especially arraylists to hold the passengers
    private ArrayList<Passenger> Queues;

    public FuelQueue() {
    }

    public ArrayList getQueues(){return Queues;}
    public String getQnum(){return Qnum;}
    public Passenger getpass(int index){return Queues.get(index);}

    private String Qnum;

    FuelQueue(String Qnum){
        this.Queues= new ArrayList<>();
        this.Qnum= Qnum;

    }
    public Passenger toPassenger(int index){
        return this.getpass(index);
    }
}
