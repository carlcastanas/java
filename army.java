A>
First we have dened an interface with the name WeekDays and method called
Dotw()
import java.rmi.Remote;
import java.RemoteException;
// Creating Remote Interface
public interface WeekDays extends Remote {
void Dotw() throws RemoteException;
}
----------------------------------------------------------------------------
B>
We have created a class named DayofWeek and implemented the interface WeekDays created in A>
and provided body for this method which give day of the week as Monday, Tuesday ...... etc
// Implementing the remote interface
public class DayofWeek implements WeekDays {
public void Dotw() {
Scanner in = new Scanner(System.in);
String month = in.next();
String day = in.next();
String year = in.next();
System.out.println(getDay(day, month, year));
}
public static String getDay(String day, String month, String year) {
Calendar tarikh = Calendar.getInstance();
tarikh.set(Integer.valueOf(year), (Integer.valueOf(month) -1), Integer.valueOf(day));
return tarikh.getDisplayName(Calender.DAY_OF_WEEK.LONG,Locale.getDefault());
}
----------------------------------------------------------------------------------------------------------------------
-------
This program is of an RMI server program for day of the week
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteobject;
import java.util;
public class Server extends DayofWeek {
public Server() {}
public static void main(String args[]) {
try {
// Instantiating the dayofweek class
DayofWeek obj = new DayofWeek();
// Exporting the object of DayofWeek class
// here we are exporting the remote object to the stub
WeekDays stub = (WeekDays) UnicastRemoteObject.exportObject(obj, 0);
// Binding the remote object (stub) in the registry
Registry registry = LocateRegistry.getRegistry();
registry.bind(("WeekDays", stub);
System.err.println(Server ready");
} catch (Exception e) {
System.err.println("Server exception : " + e.toString());
e.printStackTrace();
}
}
}
---------------------------------------------------------------------
This is an RMI client program
import java.rmi.registry.LocateREgistry;
import java.rmi.registry.Registry;
public class Client {
private Client() {}
public static void main(String[] args) {
try {
// Getting the registry
Registry registry = LocateRegistry.getRegistry(null);
// Now registry for the remote object
WeekDays stub = (WeekDays) registry.lookup("WeekDays");
// Calling the remote method using the obtained object stub.Dotw();
} catch (Exception e) {
System.err.println("Client exception: " + e.ostring());
e.printStackTrace();
}
}
}
----------------------------------------------------------------------------
/ This program gives number of days from January 1 to specied date
import java.util.Scanner;
public class noOfDays {
private static Scanner scan;
public static void main(String[] args) {
int mm;
scan = new Scanner(System.in);
System.out.print("Please Enter Month Number from 1 to 12 (1 for January..... 12 for December
:");
mm = scan.nextInt();
if (mm == 1 || mm == 3 || month == 5 || month == 7 || month == 8 || month == 10
|| month 12)
{
System.out.println("\n 31 Days in this Month ");
}
else if ( month == 4 || month == 6 || month == 9 || month == 11)
{
System.out.println("]n 30 Days in this Month ");
}
else if ( month == 2)
{
System.out.println("\n Either 28 or 29 in this Month");
}
else
System.out.println("\n Please enter Valid Number between 1 to 12");
}
}
