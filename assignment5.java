import java.util.Scanner;

class Room {

    // Private data members for encapsulation
    private int roomNumber;
    private String roomType;
    private String customerName;
    private int numberOfDays;
    private double pricePerDay;
    private boolean bookingStatus;

    // Static variable to count total bookings
    private static int totalBookings = 0;

    // Parameterized constructor
    Room(int roomNumber, String roomType, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.customerName = "";
        this.numberOfDays = 0;
        this.bookingStatus = false;
    }

    // Getter and Setter methods

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    // Method to book a room
    public void bookRoom(String customerName, int numberOfDays) {

        if (bookingStatus) {
            System.out.println("Room is already booked.");
            return;
        }

        this.customerName = customerName;
        this.numberOfDays = numberOfDays;
        this.bookingStatus = true;

        totalBookings++;

        System.out.println("\n===== Booking Confirmation =====");
        System.out.println("Room Number : " + roomNumber);
        System.out.println("Room Type : " + roomType);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Number of Days : " + numberOfDays);
        System.out.println("Price Per Day : ₹" + pricePerDay);
        System.out.println("Total Bill : ₹" + calculateBill());
        System.out.println("Room booked successfully.");
    }

    // Method to display room details
    public void displayRoomDetails() {

        System.out.println("\n===== Room Details =====");
        System.out.println("Room Number : " + roomNumber);
        System.out.println("Room Type : " + roomType);

        if (bookingStatus) {
            System.out.println("Customer Name : " + customerName);
            System.out.println("Number of Days : " + numberOfDays);
            System.out.println("Price Per Day : ₹" + pricePerDay);
            System.out.println("Booking Status : Booked");
        } else {
            System.out.println("Customer Name : Not Available");
            System.out.println("Number of Days : 0");
            System.out.println("Price Per Day : ₹" + pricePerDay);
            System.out.println("Booking Status : Available");
        }
    }

    // Method to calculate bill
    public double calculateBill() {
        return numberOfDays * pricePerDay;
    }

    // Method to cancel booking
    public void cancelBooking() {

        if (!bookingStatus) {
            System.out.println("Room is not currently booked.");
            return;
        }

        customerName = "";
        numberOfDays = 0;
        bookingStatus = false;

        System.out.println("Booking cancelled successfully.");
    }

    // Method to check room status
    public void checkRoomStatus() {

        if (bookingStatus) {
            System.out.println("Room " + roomNumber + " is Booked.");
        } else {
            System.out.println("Room " + roomNumber + " is Available.");
        }
    }

    // Static method to get total bookings
    public static int getTotalBookings() {
        return totalBookings;
    }
}


// Main class
public class assignment5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating Room objects using parameterized constructor
        Room room1 = new Room(101, "Standard", 2000);
        Room room2 = new Room(205, "Deluxe", 3500);
        Room room3 = new Room(301, "Premium", 5000);

        Room selectedRoom = null;

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     HOTEL ROOM BOOKING SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Book Room");
            System.out.println("2. Display Room Details");
            System.out.println("3. Calculate Bill");
            System.out.println("4. Check Room Status");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Display Total Bookings");
            System.out.println("7. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                // Book Room
                case 1:

                    System.out.println("\nAvailable Rooms:");
                    System.out.println("101 - Standard - ₹2000/day");
                    System.out.println("205 - Deluxe - ₹3500/day");
                    System.out.println("301 - Premium - ₹5000/day");

                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();

                    if (roomNumber == 101) {
                        selectedRoom = room1;
                    } else if (roomNumber == 205) {
                        selectedRoom = room2;
                    } else if (roomNumber == 301) {
                        selectedRoom = room3;
                    } else {
                        System.out.println("Invalid room number.");
                        break;
                    }

                    if (selectedRoom.isBookingStatus()) {
                        System.out.println("Room is already booked.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();

                    selectedRoom.bookRoom(customerName, days);

                    break;


                // Display Room Details
                case 2:

                    System.out.print("Enter room number: ");
                    roomNumber = sc.nextInt();

                    if (roomNumber == 101) {
                        room1.displayRoomDetails();
                    } else if (roomNumber == 205) {
                        room2.displayRoomDetails();
                    } else if (roomNumber == 301) {
                        room3.displayRoomDetails();
                    } else {
                        System.out.println("Invalid room number.");
                    }

                    break;


                // Calculate Bill
                case 3:

                    System.out.print("Enter room number: ");
                    roomNumber = sc.nextInt();

                    if (roomNumber == 101) {
                        selectedRoom = room1;
                    } else if (roomNumber == 205) {
                        selectedRoom = room2;
                    } else if (roomNumber == 301) {
                        selectedRoom = room3;
                    } else {
                        System.out.println("Invalid room number.");
                        break;
                    }

                    if (!selectedRoom.isBookingStatus()) {
                        System.out.println("Room is not booked.");
                    } else {

                        System.out.println("\n===== Bill Details =====");
                        System.out.println("Room Number : "
                                + selectedRoom.getRoomNumber());
                        System.out.println("Customer Name : "
                                + selectedRoom.getCustomerName());
                        System.out.println("Number of Days : "
                                + selectedRoom.getNumberOfDays());
                        System.out.println("Price Per Day : ₹"
                                + selectedRoom.getPricePerDay());
                        System.out.println("Total Bill : ₹"
                                + selectedRoom.calculateBill());
                    }

                    break;


                // Check Room Status
                case 4:

                    System.out.print("Enter room number: ");
                    roomNumber = sc.nextInt();

                    if (roomNumber == 101) {
                        room1.checkRoomStatus();
                    } else if (roomNumber == 205) {
                        room2.checkRoomStatus();
                    } else if (roomNumber == 301) {
                        room3.checkRoomStatus();
                    } else {
                        System.out.println("Invalid room number.");
                    }

                    break;


                // Cancel Booking
                case 5:

                    System.out.print("Enter room number: ");
                    roomNumber = sc.nextInt();

                    if (roomNumber == 101) {
                        room1.cancelBooking();
                    } else if (roomNumber == 205) {
                        room2.cancelBooking();
                    } else if (roomNumber == 301) {
                        room3.cancelBooking();
                    } else {
                        System.out.println("Invalid room number.");
                    }

                    break;


                // Display Total Bookings
                case 6:

                    System.out.println("\nTotal Bookings Made: "
                            + Room.getTotalBookings());

                    break;


                // Exit
                case 7:

                    System.out.println(
                            "\nThank you for using Hotel Room Booking System!"
                    );

                    break;


                // Invalid Choice
                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 7);

        sc.close();
    }
}