//Student name: Hiruni Perera Student ID: w1898953
package com.example.javafxml_task4;

import javafx.application.Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class mainclass {
    private static String first;
    private static String second;
    private static String veh_num;
    private static int ltrs;

    static int count1= 0;
    static int count2= 0;
    static int count3= 0;
    static int count4= 0;
    static int count5= 0;
    static int countwait=0;
    static int max_count = 6;                           // creating variables to avoid using magic numbers directly in the code
    static int min_fuel = 500;
    static int stock = 6600;
    static String option ;
    static int [] arrcounter =new int[5] ;
    static int arrindex=0;
    static FuelQueue Q1=new FuelQueue("Que 1");
    static FuelQueue Q2=new FuelQueue("Que 2");
    static FuelQueue Q3=new FuelQueue("Que 3");
    static FuelQueue Q4=new FuelQueue("Que 4");
    static FuelQueue Q5=new FuelQueue("Que 5");
    static FuelQueue wait_list=new FuelQueue("waiting Queue");

    static FuelQueue [] TotalQueues = {Q1,Q2,Q3,Q4,Q5,wait_list};

    public static void main (String[] args)  {

        while(true){                               // a loop to make the program contibue
            Scanner scan = new Scanner(System.in);           //printing the options and taking the option needed by thr operator
            System.out.println("""
                                                                           
                100 or VFQ: View all Fuel Queues.
                101 or VEQ: View all Empty Queues.
                102 or ACQ: Add customer to a Queue.
                103 or RCQ: Remove a customer from a Queue. (From a specific location)
                104 or PCQ: Remove a served customer.
                105 or VCS: View Customers Sorted in alphabetical order (Do not use library sort routine)
                106 or SPD: Store Program Data into file.
                107 or LPD: Load Program Data from file.
                108 or STK: View Remaining Fuel Stock.
                109 or AFS: Add Fuel Stock.
                999 or EXT: Exit the Program.
                110 or IFQ: View income of all Fuel Queues.
                111 or GUI: View in Scene Builder.
                
                Select and enter your option from above:""");
            option = scan.next();
            option = option.toUpperCase();

            switch (option){                            //Using switch case for the different options of the program
                case "100":
                case "VFQ":
                    // view_fq();
                    printlist(Q1.getQueues(),"Que 1:",count1);
                    printlist(Q2.getQueues(),"Que 2:",count2);
                    printlist(Q3.getQueues(),"Que 3:",count3);
                    printlist(Q4.getQueues(),"Que 4:",count4);
                    printlist(Q5.getQueues(),"Que 5:",count5 );
                    printlist(wait_list.getQueues(),"waiting queue:",countwait);
                    break;
                case "101":
                case "VEQ":
                    view_emptyq(Q1.getQueues(),"Que 1:",count1);
                    view_emptyq(Q2.getQueues(),"Que 2:",count2);
                    view_emptyq(Q3.getQueues(),"Que 3:",count3);
                    view_emptyq(Q4.getQueues(),"Que 4:",count4);
                    view_emptyq(Q5.getQueues(),"Que 5:",count5);
                    view_emptyq(wait_list.getQueues(),"waiting queue:",countwait);
                    if(count1==max_count && count2==max_count && count3==max_count && count4==max_count && count5==max_count && countwait==max_count){
                        System.out.println("There are no empty queues.");
                    }
                    break;
                case "102":
                case "ACQ":
                    addtoqueue();
                    break;
                case "103":
                case "RCQ":
                    remove_specific();
                    break;
                case "104":
                case "PCQ":
                    remove_served();
                    break;
                case "105":
                case "VCS":
                    System.out.println("Customers sorted in alphabetical order:");
                    alphabetical_sort(Q1.getQueues(),"Que 1:",count1);
                    alphabetical_sort(Q2.getQueues(),"Que 2:",count2);
                    alphabetical_sort(Q3.getQueues(),"Que 3:",count3);
                    alphabetical_sort(Q4.getQueues(),"Que 4:",count4);
                    alphabetical_sort(Q5.getQueues(),"Que 5:",count5);
                    alphabetical_sort(wait_list.getQueues(),"waiting Queue:",countwait);
                    break;
                case "106":
                case "SPD":
                    store();
                    break;
                case "107":
                case "LPD":
                    load();
                    break;
                case "108":
                case "STK":
                    System.out.println("Remaining stock of fuel: "+stock+" liters.");
                    break;
                case "109":
                case "AFS":
                    add_stock();
                    break;
                case "999":
                case "EXT":
                    return;                   //exits the loop
                case "110":
                case "IFQ":
                    income(Q1,count1);
                    income(Q2,count2);
                    income(Q3,count3);
                    income(Q4,count4);
                    income(Q5,count5);
                    break;
                case "111":
                case "GUI":
                    Application.launch(view_app.class, args);
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
            //Gives a warning when th fuel reaches 500 liters.
            if (stock <= min_fuel) {
                System.out.println("""
                                     
                                     WARNING!Stock of fuel has reached below 500 liters.""");
            }
        }


    }

    //This method gets the details and then creates a passenger object and then adds it to the Arraylist
    static void add_customer( FuelQueue FuelQueue){
        try {
            getdetails();
            Passenger pass = new Passenger(first, second, veh_num, ltrs);
            FuelQueue.getQueues().add(pass);
            stock = stock - pass.getLiters();
            System.out.println("The customer has been added to " + FuelQueue.getQnum());
        }
        catch (Exception type){
            System.out.println("Unable to add customer. Please try again.");
        }
    }
    //adds counter to the arraycounter
    static void addcount(int counter){
        if (counter<max_count){
            arrcounter[arrindex]=counter;
            arrindex++;
        }
    }

    //this method sorts the arraycounter and finds the minimum count which helps to find the queue
    // with the least customers and then adds the customer to the respective queue.
    static void addtoqueue(){
        arrindex=0;
        addcount(count1);
        addcount(count2);
        addcount(count3);
        addcount(count4);
        addcount(count5);
        int min = arrcounter[0];
        for (int j : arrcounter) {
            if (j < min) {
                min = j;
            }
        }

        if(min == count1){
            add_customer(Q1);
            count1++;
        } else if (min==count2) {
            add_customer(Q2);
            count2++;
        } else if (min==count3) {
            add_customer(Q3);
            count3++;
        } else if (min==count4) {
            add_customer(Q4);
            count4++;
        }else if (min==count5){
            add_customer(Q5);
            count5++;
        }else if (arrindex==0 && countwait<=max_count){
            add_customer(wait_list);
            countwait++;
        }else{
            System.out.println("All Queues are full, including the waiting list.");
        }
    }
    //this method is responsible to add new stock
    static void add_stock(){
        try {
            Scanner amt = new Scanner(System.in);
            System.out.println("Enter the amount of stock to add:");
            int amount = amt.nextInt();
            stock = stock + amount;
            System.out.println("Stock has been added. Remaining stock is now: " + stock + " litres.");
        }
        catch (Exception type){
            System.out.println("Please enter a valid amount");
            add_stock();
        }

    }

    //This method checks and prints the partially or fully empty queues.
    static void view_emptyq(ArrayList<Passenger> FQ, String Qno, int counter){
        if(counter<6){
            printlist(FQ,Qno,counter);
        }
    }

    //This is the method that helps to print each arraylist.
    static void printlist(ArrayList <Passenger> FQ,String Qno,int counter) {
        if (counter == 0) {
            System.out.println(Qno);
            System.out.println("empty");
        }else{
            System.out.println(Qno);
            for (Passenger passenger : FQ) {
                System.out.println(passenger.getname());
            }
        }
    }

    //This method removes the served(first in queue) customer from a queue and adds the first customer
    // from wait list to the end of the queue
    static void remove_served() {
        try {
            Scanner que = new Scanner(System.in);
            System.out.println("Enter the queue from which the served queue should be removed(Enter1,2,3,4 or 5. )");
            int quetoremove = que.nextInt();
            switch (quetoremove) {
                case 1:
                    removefirst(Q1);
                    count1--;
                    if (countwait > 0 && count1<max_count) {
                        add_waitingpass(Q1);
                        count1++;
                    }
                    break;
                case 2:
                    removefirst(Q2);
                    count2--;
                    if (countwait > 0  && count2<max_count) {
                        add_waitingpass(Q2);
                        count2++;
                    }
                    break;
                case 3:
                    removefirst(Q3);
                    count3--;
                    if (countwait > 0 && count3<max_count) {
                        add_waitingpass(Q3);
                        count3++;
                    }
                    break;
                case 4:
                    removefirst(Q4);
                    count4--;
                    if (countwait > 0  && count4<max_count) {
                        add_waitingpass(Q4);
                        count4++;
                    }
                    break;
                case 5:
                    removefirst(Q5);
                    count5--;
                    if (countwait > 0 && count5<max_count) {
                        add_waitingpass(Q5);
                        count5++;
                    }
                    break;
                default:
                    System.out.println("Please try again with a correct queue number.");
                    break;
            }
        }catch (Exception type){
            System.out.println("Please try again with a correct queue number.");
        }
    }
    //removes first customer in the queue.
    static void removefirst(FuelQueue FQ){
        FQ.getQueues().remove(0);
        System.out.println("The served customer has been removed from "+FQ.getQnum());
    }

    //this method removes customer from a specific queue and position
    static void remove_specific() {
        try {
            Scanner que = new Scanner(System.in);
            System.out.println("Enter the queue from which the customer has to be removed.(Enter 1,2,3,4,5 or 6 for wait list.): ");
            int quetoremove = que.nextInt();
            Scanner pos = new Scanner(System.in);
            System.out.println("Enter the position occupied by the customer in the queue,(Enter a digit from 1 to 6):");
            int position = pos.nextInt();
            position = position - 1;
            switch (quetoremove) {
                case 1:
                    remove(Q1, position);
                    count1--;
                    stock=stock+Q1.getpass(position).getLiters();
                    break;
                case 2:
                    remove(Q2, position);
                    count2--;
                    stock=stock+Q2.getpass(position).getLiters();
                    break;
                case 3:
                    remove(Q3, position);
                    count3--;
                    stock=stock+Q3.getpass(position).getLiters();
                    break;
                case 4:
                    remove(Q4, position);
                    count4--;
                    stock=stock+Q4.getpass(position).getLiters();
                    break;
                case 5:
                    remove(Q5, position);
                    count5--;
                    stock=stock+Q5.getpass(position).getLiters();
                case 6:
                    remove(wait_list,position);
                    countwait--;
                    break;
                default:
                    System.out.println("Please try again with a correct queue number or position.");
                    break;
            }
        }catch (Exception type){
            System.out.println("Please try again with a correct queue number or position");
        }
    }

    //removes customer from the given index
    static void remove(FuelQueue FQ, int pos){
        FQ.getQueues().remove(pos);
        System.out.println("The customer has been removed from "+FQ.getQnum());
    }
    //sorts the queues in alphabetical order
    static void alphabetical_sort(ArrayList <Passenger> FQ,String Q,int counter){
        String comp;
        String [] alpha=new String[FQ.size()];
        for (int i = 0; i < FQ.size(); i++) {
            alpha[i]=FQ.get(i).getname();
        }
        for(int i = 0; i < alpha.length - 1; i++){
            for(int j = 1 ; j < alpha.length; j++){
                if(alpha[j] != null && alpha[j-1] != null && alpha[j].compareToIgnoreCase(alpha[j - 1]) < 0){
                    comp = alpha[j];
                    alpha[j] = alpha[j - 1];
                    alpha[j - 1] = comp;
                }
            }
        }
        print_queue(alpha,Q,counter);

    }
    //Prints an array
    static void print_queue(String[] Queue,String q,int count){
        if(count == 0){
            System.out.println(q + "empty");
        }
        else{
            System.out.println(q);
            for(int i = 0; i < count; i++){
                System.out.println(Queue[i]);
            }
        }
    }
    //prompts for the customer details.
    static void getdetails(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your first name: ");
        first=scan.next().strip();
        System.out.println("Enter your second name: ");
        second=scan.next().strip();
        System.out.println("Enter your vehicle number: ");
        veh_num= scan.next();
        System.out.println("Enter the no. of liters required: ");
        ltrs= scan.nextInt();

    }
    //Adds customer to the waiting queue when all queues are full
    static void add_waitingpass(FuelQueue FQ) {
        Passenger waiting = wait_list.getpass(0);
        FQ.getQueues().add(waiting);
        wait_list.getQueues().remove(0);
        countwait--;
        stock = stock - waiting.getLiters();
    }
    //stores data to a text file
    static void store(){
        try{
            FileWriter myWriter = new FileWriter("fuel_class.txt");
            String line="";
            myWriter.write(count1+"\n");
            line=queuedata(Q1,count1);
            myWriter.write(line);
            myWriter.write(count2+"\n");
            line=queuedata(Q2,count2);
            myWriter.write(line);
            myWriter.write(count3+"\n");
            line=queuedata(Q3,count3);
            myWriter.write(line);
            myWriter.write(count4+"\n");
            line=queuedata(Q4,count4);
            myWriter.write(line);
            myWriter.write(count5+"\n");
            line=queuedata(Q5,count5);
            myWriter.write(line);
            myWriter.write(countwait+"\n");
            line=queuedata(wait_list,countwait);
            myWriter.write(line);
            myWriter.write(stock+"\n");
            myWriter.close();
            System.out.println("successfully stored data to the file.");
        }catch (Exception e){
            System.out.println("Unable to store data. Try again.");
        }
    }
    // assembling queue data
    static String queuedata(FuelQueue Q, int count ){
        String line = "";
        for(int i=0; i < count; i++){
            line=line+" "+Q.getpass(i).getname()+" "+Q.getpass(i).getVehiclenum()+" "+Q.getpass(i).getLiters()+"\n";
        }
        return line;
    }
    //loads data from file and assigns to the variables
    static void load(){
        try {
            File inputFile = new File("fuel_class.txt");
            Scanner rf = new Scanner(inputFile);
            count1 = rf.nextInt();
            loadqueue(Q1, count1, rf);
            count2 = rf.nextInt();
            loadqueue(Q2, count2, rf);
            count3 = rf.nextInt();
            loadqueue(Q3, count3, rf);
            count4 = rf.nextInt();
            loadqueue(Q4, count4, rf);
            count5 = rf.nextInt();
            loadqueue(Q5, count5, rf);
            countwait = rf.nextInt();
            loadqueue(wait_list, countwait, rf);
            stock= rf.nextInt();
            rf.close();
            System.out.println("Data was successfully loaded from the file.");
        }
        catch (FileNotFoundException e){
            System.out.println("Unable to load data. Try again.");
        }
    }
    //assigning details to objects
    static void loadqueue(FuelQueue FQ, int counter, Scanner rf){
        FQ.getQueues().clear();
        for (int i = 0; i < counter; i++) {
            String fn = rf.next();
            String sn = rf.next();
            String vn = rf.next();
            int fl = rf.nextInt();
            Passenger loadpass = new Passenger(fn,sn,vn,fl);
            FQ.getQueues().add(loadpass);
        }
    }
    //calculates income of each queue
    static void income(FuelQueue FQ,int counter){
        int total_ltrs=0;
        int price_liter=430;
        for (int i = 0; i < counter; i++) {
            total_ltrs=total_ltrs+FQ.getpass(i).getLiters();
        }
        int income = total_ltrs*price_liter;
        System.out.println("The income of "+FQ.getQnum()+" is Rs."+income );
    }

}
