package Other_Type;

import java.util.ArrayList;
import java.util.List;

class Room{
    private int roomNumber;
    private String type;
    private  double price;

    public Room(int roomNumber,String type,double price){
        this.roomNumber = roomNumber;
        this.price = price;
        this.type = type;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room{" +
               "roomNumber=" + roomNumber +
               ", type='" + type + '\'' +
               ", price=" + price +
               '}';
    }
}

class Motel{
    private List<Room> manageRooms;

    public Motel(){
        this.manageRooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        manageRooms.add(room);
        System.out.println("Room " + room.getRoomNumber() + " added to the Motel.");
    }

    public void listRoom(){
        System.out.println("Available Rooms:");
        for(Room room : manageRooms){
            System.out.println(room);
        }
    }

    public Room getRoomByNumber(int roomNumber){
        for(Room room : manageRooms){
            if(room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }

    public void removeRoom(Room room){
        manageRooms.remove(room);
        System.out.println("Room " + room.getRoomNumber() + " removed from availability.");
    }
}

class Customer{
    private String name;
    private List<Room> bookedRooms;

    public Customer(String name){
        this.name = name;
        this.bookedRooms = new ArrayList<>();
    }

    public void bookRoom(int roomNumber, Motel h){
        Room room = h.getRoomByNumber(roomNumber);
        if(room != null){
            bookedRooms.add(room);
            h.removeRoom(room);
            System.out.println(name + " booked room: " + room.getRoomNumber());
        }else{
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    public void viewBookedRooms() {
        System.out.println(name + "'s Booked Rooms:");
        for (Room room : bookedRooms) {
            System.out.println(room);
        }
    }
}



public class Hotel {
    public static void main(String[] args) {
        Motel h = new Motel();
        h.addRoom(new Room(101, "Single", 100));
        h.addRoom(new Room(102, "Double", 150));
        h.addRoom(new Room(103, "Suite", 300));

        Customer customer = new Customer("Vinay");
        System.out.println();
        h.listRoom();

        customer.bookRoom(101, h); 
        customer.bookRoom(103, h); 
        customer.bookRoom(105, h); 

        System.out.println();
        h.listRoom();

        System.out.println();
        customer.viewBookedRooms();

    }
}
