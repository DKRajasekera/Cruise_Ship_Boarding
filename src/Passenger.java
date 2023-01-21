public class Passenger {
    private String UserFirstName;
    private String UserSurName;
    private int UserExpenses;

public Passenger(String UserFirstName, String UserLastName, int UserExpenses){
    this.UserFirstName = UserFirstName;
    this.UserSurName = UserLastName;
    this.UserExpenses = UserExpenses;
}
public String getName(){
    return UserFirstName + " " + UserSurName;
}
public String getUserFirstName(){
    return UserFirstName;
}
public String getUserSurName(){
    return UserSurName;
}
public int getUserExpenses(){
    return UserExpenses;
}
}
