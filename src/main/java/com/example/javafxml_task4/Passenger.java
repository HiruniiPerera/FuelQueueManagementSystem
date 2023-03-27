//Student name: Hiruni Perera Student ID: w1898953
package com.example.javafxml_task4;

public class Passenger extends FuelQueue {
    //this class creates passenger objects.
    //these objects hold all the details of a customer
    //All details are private and is only accessed using methods
    private String Fname;
    private String Sname;
    private String vehiclenum;
    private int liters;

    Passenger(String first, String second, String veh_num, int ltrs) {
        this.Fname = first;
        this.Sname = second;
        this.vehiclenum = veh_num;
        this.liters = ltrs;
    }

    public String getFname() {
        return Fname;
    }

    public String getSname() {
        return Sname;
    }

    public String getVehiclenum() {
        return vehiclenum;
    }

    public int getLiters() {
        return liters;
    }

    public String getname() {
        return this.getFname() + " " + this.getSname();
    }

    public String toString(){
        return this.Fname+"\n"+this.Sname+"\n"+this.vehiclenum+"\n"+this.liters;
    }

}
