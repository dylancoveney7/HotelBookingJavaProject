package skillsDemo3;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class addingcode {
 static String[] cleaningRoster;
 static String[] guests;
 static Scanner sc = new Scanner(System.in);
 static DecimalFormat moneyFormat = new DecimalFormat("€###,##0.00");
 static String name;
 static String contactNumber;
 static String email;
 static String checkInDate;
 static String booking;
 static byte numOfNights;
 static float costOfStay;
 boolean validEmail;
 public static void main(String[] args) {
 cleaningRoster = new String[7]; // one entry for each day of the week
 guests = new String[100]; // array to keep track of guests staying in the hotel
 boolean quit = false;
 printMenu();
 sc.close();
 }
 // print menu
 public static void printMenu() {
 int choice = 0;
 while (choice != 6) {
 System.out.println("Welcome to the Management System");
 System.out.println("1. Book in");
 System.out.println("2. Check out");
 System.out.println("3. Generate key code");
 System.out.println("4. Print cleaning roster");
 System.out.println("5. Change/Set the promo code");
 System.out.println("6. Quit");
 System.out.print("Enter your choice: ");
 try {
 choice = sc.nextInt();
 } catch (Exception e) {
 System.out.println("Invalid choice. Please try again.");
 sc.nextLine(); // consume the extra line left by nextInt()
 continue;
 }
 handleChoice(choice);
 }
 }
 public static void handleChoice(int choice) {
 switch (choice) {
 case 1:
 bookIn();
 break;
 case 2:
 checkOut();
 break;
 case 3:
 generateKeyCode();
 break;
 case 4:
 printCleaningRoster();
 break;
 case 5:
 changePromoCode();
 break;
 case 6:
 System.out.println("Goodbye!");
 break;
 default:
 System.out.println("Invalid choice. Please try again.");
 break;
 }
 }
 public static void bookIn() {
 // Prompt the user for information
 System.out.println("Please enter your name:");
 name = sc.next();
 // Prompt the user for their contact number
 System.out.println("Please enter your contact number:");
 contactNumber = sc.next();
 // Prompt the user for their email address
 String emailAddress = "";
 boolean validEmail = false;
 while (!validEmail) {
 System.out.println("Please enter your email address:");
 emailAddress = sc.next();
 if (emailAddress.contains("@") && emailAddress.contains(".")) {
 validEmail = true;
 
 validEmail = true;
 }
 else {
 System.out.println("Invalid email address, please re-enter your email address.");
 }
 }
 // Prompt the user for their room number
 int roomNumber = 0;
 boolean validRoomNumber = false;
 while (!validRoomNumber) {
 System.out.println("Please enter your room number (between 100 and 599):");
 roomNumber = sc.nextInt();
 if (roomNumber >= 100 && roomNumber <= 599) {
 validRoomNumber = true;
 } else {
 System.out.println("Invalid room number, please enter a number between 100 and 599.");
 }
 }
 // Prompt the user for the check-in date
 System.out.println("Please enter the check-in date (DD/MM/YYYY):");
 String checkInDate = sc.next();
 // Prompt the user for the number of nights they will be staying
 System.out.println("How many nights will you be staying?");
 byte numOfNights = sc.nextByte();
 // Calculate the cost of stay
 float costOfStay = numOfNights * 105.0f;
 System.out.print("Enter promo code (leave blank for none): ");
 String inputPromoCode = sc.nextLine();
 double discount = 0.0;
 if (inputPromoCode.equals(inputPromoCode)) {
 discount = 0.1; // 10% discount for valid promo code
 System.out.println("Promo code applied.");
 } else {
 System.out.println("Invalid promo code.");
 }
 // Update the cleaning roster for the days of the booking
 LocalDate startDate = LocalDate.parse(checkInDate, 
DateTimeFormatter.ofPattern("dd/MM/yyyy"));
 for (int i = 0; i < numOfNights; i++) {
 DayOfWeek dayOfWeek = startDate.plusDays(i).getDayOfWeek();
 int dayIndex = dayOfWeek.getValue() - 1;
 cleaningRoster[dayIndex] += "\n" + "Room " + roomNumber + ": " + 
name;
 
 // apply promo code
 
 }
 
 // Generate a booking reference number
 int bookingReference = (int)(Math.random() * 1000000);
 // Display the booking information
 System.out.println("Booking successful! Here is your booking information:");
 System.out.println("Name: " + name);
 System.out.println("Contact number: " + contactNumber);
 System.out.println("Email address: " + emailAddress);
 System.out.println("Room number: " + roomNumber);
 System.out.println("Check-in date: " + checkInDate);
 System.out.println("Number of nights: " + numOfNights);
 System.out.println("Cost of stay: €" + costOfStay);
 System.out.println("Booking reference number: " + bookingReference);
 // Added the closing brace for the method#
 // Prompt the user for their credit card details
 boolean validCard = false;
 long creditCardNumber = 0;
 int expiryMonth = 0;
 int expiryYear = 0;
 while (!validCard) {
 System.out.println("Please enter your credit card number: to confirm payment");
 creditCardNumber = sc.nextLong();
 if (creditCardNumber < 1000000000000000L || creditCardNumber > 
9999999999999999L) {
 System.out.println("Invalid credit card number, please re-enter your credit card number.");
 continue;
 }
 System.out.println("Please enter the expiry month (MM):");
 expiryMonth = sc.nextInt();
 if (expiryMonth < 1 || expiryMonth > 12) {
 System.out.println("Invalid expiry month, please re-enter your expiry month.");
 continue;
 }
 System.out.println("Please enter the expiry year (YYYY):");
 expiryYear = sc.nextInt();
 if (expiryYear < LocalDate.now().getYear() || expiryYear > 
LocalDate.now().getYear() + 10) {
 System.out.println("Invalid expiry year, please re-enter your expiry year.");
 continue;
 }
 validCard = true;
 }
 
 // Mask the credit card number
 String maskedCardNumber = "XXXX-XXXX-XXXX-" + 
String.valueOf(creditCardNumber).substring(12);
 // Construct the email message
 System.out.println( "Dear " + name + ",\n\n" +
 "On behalf of our entire staff, we would like to welcome you to Hotel Siochan and hope that you " +
 "will have a memorable experience.\n\n" +
 "Your stay details are as follows:\n" +
 "Name: " + name + "\n" +
 "Contact number: " + contactNumber + "\n" +
 "Email address: " + emailAddress + "\n" +
 "Room number: " + roomNumber + "\n" +
 "Check-in date: " + checkInDate + "\n" +
 "Number of nights: " + numOfNights + "\n" +
 "Cost of stay: €" + costOfStay + "\n" +
 "Booking reference number: " + bookingReference + "\n" +
 "Credit card number: " + maskedCardNumber + "\n" +
 "Key code: " + roomNumber + bookingReference + "\n\n" +
 "If you need anything during your stay, our \n\n staff will be pleased to assist you at any time. " +
 "Just call the front desk and we will be at your service.\n\n You can also text us at 083-1234567 " +
 "or on Facebook Messenger hotelSiochan@facebook.com\n\n" +
 "Best regards,\n" +
 "Hotel Siochan staff");
 
 }
 // cleaning roster so that the employees can see what rooms are occupied and which are not
public static void printCleaningRoster() {
 System.out.println("Cleaning Roster:");
 for (int i = 0; i < cleaningRoster.length; i++) {
 System.out.println(DayOfWeek.of(i + 1).toString() + ": " + 
cleaningRoster[i]);
 }
}
// to allow the employee to check visitor out and ask if they used any extra facility's
public static void checkOut() {
 System.out.println("Checking out a room");
 System.out.println("Please enter the room number:");
 int roomNumber = sc.nextInt();
 boolean hotelParking = false;
 boolean hotelSpa = false;
 float additionalCost = 0.0f;
 System.out.println("Did the guest avail of hotel parking? (y/n)");
 String input = sc.next();
 if (input.equalsIgnoreCase("y")) {
 hotelParking = true;
 additionalCost += 15.0f;
 }
 System.out.println("Did the guest avail of the hotel's spa? (y/n)");
 input = sc.next();
 if (input.equalsIgnoreCase("y")) {
 hotelSpa = true;
 additionalCost += 60.0f;
 }
 if (additionalCost > 0.0f) {
 System.out.println("The additional cost for facilities is: " + 
moneyFormat.format(additionalCost));
 System.out.println("Please enter the guest's credit card number for payment:");
 String creditCardNumber = sc.next();
 }
// updating cleaning roster when a visitor checkout
 for (int i = 0; i < cleaningRoster.length; i++) {
 if (cleaningRoster[i] != null) {
 String[] bookingDetails = cleaningRoster[i].split(":");
 String bookedRoomNumber = bookingDetails[0].substring(5);
 if (bookedRoomNumber.equals(Integer.toString(roomNumber))) 
{
 System.out.println("Room " + roomNumber + " has been checked out.");
 String checkInDate = bookingDetails[1].substring(1);
 DateTimeFormatter formatter = 
DateTimeFormatter.ofPattern("d/M/yyyy");
 LocalDate checkIn = LocalDate.parse(checkInDate, 
formatter);
 int numOfDays = 
Integer.parseInt(bookingDetails[2].substring(1));
 LocalDate checkOut = checkIn.plusDays(numOfDays);
 DayOfWeek checkOutDay = checkOut.getDayOfWeek();
 cleaningRoster[i] = null;
 System.out.println("Room " + roomNumber + " was checked in on " + checkInDate + " and checked out on " + checkOut.format(formatter) + 
" (" + checkOutDay + ").");
 break;
 }
 }
 }
 
 // Display a message indicating that the room has been checked out
 System.out.println("Room " + roomNumber + " has been checked out.");
}
// making promo code
public static String changePromoCode() {
 System.out.println("Enter the new promo code:");
 String newPromoCode = sc.next();
 String promoCode = newPromoCode;
 System.out.println("Promo code updated to: " + promoCode);
 
 String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
 int length = 8;
 StringBuilder sb = new StringBuilder();
 for (int i = 0; i < length; i++) {
 int index = (int) (Math.random() * characters.length());
 sb.append(characters.charAt(index));
 }
 return "HOTEL10-" + sb.toString();
}
// key code maker for rooms
public static void generateKeyCode() {
 System.out.println("Generating key code...");
 int keyCode = (int) (Math.random() * 1000000);
 System.out.println("Key code generated: " + keyCode);
}
}
