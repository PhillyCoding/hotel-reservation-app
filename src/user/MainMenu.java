package user;

import api.HotelResource;
import model.HotelRoom;
import model.RoomType;

import java.util.*;

public class MainMenu {
    //Find and Reserve a room
    public void findAndReserveARoom(Date checkIn, Date checkOut, RoomType roomType){
        HotelResource hr = HotelResource.getInstance();
        Collection<HotelRoom> possibleRooms = hr.findARoom(checkIn, checkOut);
        Collection<HotelRoom> availableRooms = new LinkedList<>();
        for (HotelRoom room: possibleRooms
             ) {
            if (room.getRoomType() != roomType) {
                availableRooms.add(room);
            }
        }
        if (!availableRooms.isEmpty()){
            System.out.println("Suggested Available Rooms: ");
            for (HotelRoom room: availableRooms
            ) {
                System.out.println("Room #"+room.getRoomNumber()+" is available.\n");
            }
            //Ask for the room number they'd like
            System.out.println("Please choose one of the above rooms: ");
            Scanner s = new Scanner(System.in);
            int roomChoice = s.nextInt();
            if (availableRooms.contains(hr.getRoom((Integer.toString(roomChoice))))){ //room choice must be available
                HotelRoom userDesiredRoom = hr.getRoom((Integer.toString(roomChoice)));
                System.out.println();
            }
            //get that room using resource

            //book room using resource
        }

    }
    //See my reservations

    //Create account

    //Admin

    //Exit
}
