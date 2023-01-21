/**
 COPYRIGHT (C) Dulaksha Rajasekera - 20210327 - w1867072 - dulaksha.20210327@iit.ac.Lk. ALL Rights Reserved.
 Task 3 Cruise Ship Passenger controller.
 Software Development II Coursework L4 Semester2.
 @author Dulaksha Rajasekera.
 @version 2 2022-04-18.
 **/

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class Tast_3 {
    static Cabin temp = new Cabin();
    static int count1 = 12;
    static String menu;
    static Cabin[] cabins = new Cabin[12];
    static Queue queues = new Queue(5);
    static Scanner UserInput = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        initialise(cabins);
        Scanner UserMenu = new Scanner(System.in);
        while (true) {
            System.out.print("----------- MENU ----------- \n" +
                    " V: View all cabins \n" +
                    " A: Add a customer to a cabin \n" +
                    " E: Display Empty cabins \n" +
                    " D: Delete customer from cabin \n" +
                    " F: Find cabin from customer name \n" +
                    " S: Store program data into file \n" +
                    " L: Load program data from file \n" +
                    " O: View passengers Ordered alphabetically by name \n" +
                    " T: the expenses per passenger as well as the total expenses of all passengers in cabin \n" +
                    " Q: Exit \n" +
                    "> ");
            menu = UserMenu.next();
            menu = menu.toLowerCase();
            switch (menu) {
                case "v":
                    for (int x = 0; x < 12; x++) {
                        if (cabins[x].passengers[0] == null) {
                                System.out.println("Cabin " + x + " is empty");
                        }
                        else {
                            cabins[x].showUserData();

                        }
                    }
                    for (int i = 0; i < queues.queue.length; i++) {
                        if ( queues.queue[i] != null) {
                            System.out.println("Queue of cabin : \n");
                            System.out.println(queues.queue[i]);
                        }
                    }
                    break;
                case "e":
                    showEmptyCabins();
                    break;
                case "a":
                    String roomName;
                    String lName;
                    int Expenses;
                    while (true){
                        if ( count1 > 0){
                            System.out.println("Enter cabin number : ");
                            try {
                                int cabinNum = UserInput.nextInt();
                                System.out.println("Enter number of passangers : ");
                                int passangersNum = UserInput.nextInt();
                                for (int j = 0; j < passangersNum; j++){
                                    System.out.println("Enter first name for room " + (j+1) + " :");
                                    roomName = UserInput.next();
                                    System.out.println("Enter last name for room " + (j+1) + " :");
                                    lName = UserInput.next();
                                    System.out.println("Enter Expenses for room " + (j+1) + " :");
                                    Expenses = UserInput.nextInt();
                                    cabins[cabinNum].addAPassanger(roomName,lName,Expenses);
                                }
                                count1--;
                                break;
                            }
                            catch (Exception e){
                                System.out.print("Pleas enter number for cabin number \n");
                                break;
                            }
                        }
                        else {
                            String choose;
                            System.out.println("All cabins are full you can add to queue do you like press Y or not press N : ");
                            choose = UserInput.next();
                            choose = choose.toLowerCase();
                            if (choose.equals("y")) {
                                System.out.println("Enter number of passangers : ");
                                int passangersNum = UserInput.nextInt();
                                for (int j = 0; j < passangersNum; j++){
                                    System.out.println("Enter first name for room " + (j+1) + " :");
                                    roomName = UserInput.next();
                                    System.out.println("Enter last name for room " + (j+1) + " :");
                                    lName = UserInput.next();
                                    System.out.println("Enter Expenses for room " + (j+1) + " :");
                                    Expenses = UserInput.nextInt();
                                    temp.addAPassanger(roomName,lName,Expenses);
                                }
                                queues.enqueue(temp);
                                System.out.println("Successfuly added to queue");
                            }else{
                                break;
                            }
                        }
                    }break;
                case "d":
                    deleteUserData();
                    break;
                case "f":
                    findCustomerName();
                    break;
                case "s":
                    saveDataToFile();
                    break;
                case "l":
                    readDataFromFile();
                    break;
                case "o":
                    int count = 0;
                    for (int index = 0; index < cabins.length; index++) {
                        for (int ind = 0; ind < cabins[index].passengers.length; ind++) {
                            if (cabins[index].passengers[ind] != null) {
                                count++;
                            }
                        }
                    }
                    String[] customers = new String[count];
                    for (int index1 = 0; index1 < cabins.length; index1++) {
                        for (int ind = 0; ind < cabins[index1].passengers.length; ind++) {
                            if (cabins[index1].passengers[ind] != null) {
                                customers[ind] = cabins[index1].passengers[ind].getName();
                                System.out.println(customers[ind]);
                            }
                        }
                    }
                    for (int v = 0; v < customers.length; v++) {
                        int ma = v;
                        for (int p = v + 1; p < customers.length; p++) {
                            if (customers[p].compareTo(customers[ma]) < 0) {
                                ma = p;
                            }
                        }
                        String ta = customers[ma];
                        customers[ma] = customers[v];
                        customers[v] = ta;
                    }
                    for(String i: customers){
                        System.out.print(i+", ");}
                    System.out.println(" ");
                    break;
                case "t":
                    getExpances();
                    break;
                case "q":
                    return;
                default:
                    System.out.print("please Enter correctly \n");
            }
        }
    }

    private static void initialise(Cabin[] cruiseRef){
        for (int x = 0; x < cabins.length; x++ ) {
            cruiseRef[x] = new Cabin();
        }
    }

    private static void showEmptyCabins() {
        for (int n = 0; n < 12; n++) {
            if (cabins[n].passengers[0] == null) {
                System.out.println("Cabin " + n + " is empty now");
            }
        }
    }

    private static void deleteUserData() {
        System.out.print("What cadin number do you want to delete : ");
        int delete = UserInput.nextInt();
        if (delete < 12) {
            cabins[delete].passengers[0] = null;
            cabins[delete].passengers[1] = null;
            cabins[delete].passengers[2] = null;
        } else {
            System.out.print("Please give a number between 0 to 11");
        }
        for(int i=0;i<cabins.length;i++){
            if(cabins[i]==null){
                cabins[i] = queues.queue[0];
            }
        }
        queues.dequeue();

    }

    private static void findCustomerName() {
        System.out.print("Enter your name : ");
        String name = UserInput.next();
        boolean hii = true;
        for (int m = 0; m < cabins.length; m++) {
            for (int j = 0; j < cabins[m].passengers.length; j++) {
                if (cabins[m].passengers[j] != null && (cabins[m].passengers[j].getUserFirstName().equals(name))){
                    System.out.println("Your cabin number is : " + m);
                }
            }
        }
    }

    private static void saveDataToFile() throws IOException {
        try {
            File UserData1 = new File("C:\\Dulaksha\\uni\\Assessments\\sd 2\\Task_3\\src\\UserData.txt");
            PrintStream writer = new PrintStream(UserData1);
            int index = 0;
            while ( index < cabins.length) {
                for (int ind = 0; ind < cabins[index].passengers.length; ind++){
                    if (cabins[index].passengers[ind] != null){
                        writer.println("Custome first name : " + cabins[index].passengers[ind].getUserFirstName() + "," + " Last name : " + cabins[index].passengers[ind].getUserSurName() + "," + " Expanses : " + cabins[index].passengers[ind].getUserExpenses() + "." );
                    }
                    else {
                        writer.println("Cabin " + index + " number is empty");
                    }
                }
                index = index +1;
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        System.out.println("Successfully saved your data");
    }

    private static void readDataFromFile() throws IOException {
        try{
            File UserData = new File("C:\\Dulaksha\\uni\\Assessments\\sd 2\\Task_3\\src\\UserData.txt");
            Scanner myFileReader = new Scanner(UserData);
            while (myFileReader.hasNextLine()) {
                String data = myFileReader.nextLine();
                System.out.println(data);
                }
            myFileReader.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
    }
    private static void getExpances() {
        int total = 0;
        int cabinNum = 0;
        while (true) {
            System.out.print("Enter A for all expenses in cabin, P for per person expenses and Q for exit : ");
            String value = UserInput.next();
            value = value.toLowerCase();
            if (value.equals("a")) {
                System.out.println("Enter your cabin number : ");
                cabinNum = UserInput.nextInt();
                for (int ind = 0; ind < cabins[cabinNum].passengers.length; ind++) {
                    int tem_total = cabins[cabinNum].passengers[ind].getUserExpenses();
                    total = total + tem_total;
                }
                System.out.println("Total of expances is : " + total);
                break;
            } else if (value.equals("p")) {
                System.out.println("Enter your name : ");
                String name = UserInput.next();
                for (int m = 0; m < cabins.length; m++) {
                    for (int j = 0; j < cabins[m].passengers.length; j++) {
                        if (cabins[m].passengers[j] != null && (cabins[m].passengers[j].getUserFirstName().equals(name))) {
                            int expences = cabins[m].passengers[j].getUserExpenses();
                            System.out.println("Your expences is : " + expences);
                        }
                    }
                }
                break;
            }
            else if (value.equals("q")){
                return;
            }
            else {
                System.out.println("Your input is not valid please check ");
            }
        }
    }
}