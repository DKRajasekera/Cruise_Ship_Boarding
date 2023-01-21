public class Cabin{
    Passenger[] passengers;

    public Cabin () {
        passengers = new Passenger[3];
    }
    public void addAPassanger (String fName, String lName, int expenses) {
        for (int i = 0; i < passengers.length; i++){
           if (passengers[i] == null){
               passengers[i] = new Passenger(fName, lName, expenses);
               break;
           }
       }
//        System.out.println("add name class method ");
    }
    public void showUserData() {
        System.out.print("Cabin occupied by : \n");
        boolean cabin = true;
        for (int i = 0; i < passengers.length; i++){
            if (passengers[i] != null){
                System.out.println(this.passengers[i].getName() + ".");
                cabin = true;
            }
        }
    }
}