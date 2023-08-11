package user;

import api.AdminResource;
import model.*;

import java.util.*;

public class AdminMenu {
    //See all customers
    public void getAllCustomers(){
        System.out.println(AdminResource.getInstance().getAllCustomers());
    }
    //See all rooms
    public void getAllRoom(){
        System.out.println(AdminResource.getInstance().getAllRooms());
    }
    //See all reservations
    public void getAllReservations(){
        AdminResource.getInstance().displayAllReservations();
    }
    //Add one or multiple rooms
    public void addRooms(){
        Scanner s = new Scanner(System.in);
        Set<HotelRoom> roomsToBeAdded = new HashSet<>();
        boolean anotherOne = true;
        do {
            HotelRoom newRoom;
            System.out.println("What is the room number? (greater than 0)");
            String roomNum = s.next();
            if (Integer.parseInt(roomNum) < 1){continue;}
            System.out.println("""
                What is the room type?
                1. SINGLE
                2. DOUBLE""");
            int type = s.nextInt();
            RoomType typeOfRoom= null;
            switch (type) {
                case 1 -> typeOfRoom = RoomType.SINGLE;
                case 2 -> typeOfRoom = RoomType.DOUBLE;
            }

            System.out.println("What is the price of the room?");
            double roomPrice = s.nextDouble();

            if (roomPrice == 0.0){ newRoom = new FreeRoom(roomNum, typeOfRoom);
            }
            else { newRoom = new Room(roomNum, typeOfRoom, roomPrice);}

            roomsToBeAdded.add(newRoom);

            System.out.println("Another room(y/n)?");
            String userResponse = s.next();
            if(!(userResponse.equalsIgnoreCase("yes") || userResponse.equalsIgnoreCase("y"))) {
                anotherOne = false;
            }
        }while (anotherOne);

        AdminResource.getInstance().addRooms(roomsToBeAdded);
    }
    //Back to main menu
}
