package service;

import model.Customer;
import model.HotelRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {
    private static ReservationService instance;
    private Map<String, HotelRoom> allRooms = new HashMap<>();
    private List<Reservation> allReservations = new ArrayList<>();
    private ReservationService(){}
    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }
    public void addRoom(HotelRoom room){
        allRooms.put(room.getRoomNumber(), room);
    }

    public HotelRoom getARoom(String roomNumber){
        return allRooms.get(roomNumber);
    }

    public Reservation reserveARoom(Customer customer, HotelRoom room, Date checkInDate, Date checkOutDate){
        Reservation newlyReservedRoom = new Reservation(customer, room, checkInDate, checkOutDate);
        allReservations.add(newlyReservedRoom);
        return newlyReservedRoom;
    }

    public Collection<HotelRoom> findRooms(Date checkInDate, Date checkOutDate){
        List<HotelRoom> availableRooms = new LinkedList<>();
        for (HotelRoom room:allRooms.values()) {
            //for loop reservations to compare to room and reservation
                //if statement --> if requested checkOut comes before reserved checkIn 
                // OR requested checkIn comes after reserved checkOut THEN --> This is an available room
            for (Reservation rsrv: allReservations) {
                if (room == rsrv.getRoom() && (checkOutDate.before(rsrv.getCheckInDate()) || checkInDate.after(rsrv.getCheckOutDate()))){
                    availableRooms.add(room);
                }
            }
        }
        return availableRooms;
    }

    public Collection


}
