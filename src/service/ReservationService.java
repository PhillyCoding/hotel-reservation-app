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

    public Map<String, HotelRoom> getAllRooms() {
        return allRooms;
    }


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

    public Collection<HotelRoom> findRooms(Date requestedCheckInDate, Date requestedCheckOutDate){
        List<HotelRoom> availableRooms = new LinkedList<>();
        for (HotelRoom room:allRooms.values()) {
            for (Reservation rsrv: allReservations) {
                if (
                    room == rsrv.getRoom()
                    && (requestedCheckOutDate.before(rsrv.getCheckInDate())
                    || requestedCheckInDate.after(rsrv.getCheckOutDate()))
                ){
                        availableRooms.add(room);
                }
            }
        }
        return availableRooms;
    }

    public Collection<Reservation> getCustomerReservations(Customer customer){
        List<Reservation> allReservationsMadeByCustomer = new LinkedList<>();
        for (Reservation rsrv:
             allReservations) {
            if (Objects.equals(customer, rsrv.getCustomer())){
                allReservationsMadeByCustomer.add(rsrv);
            }
        }
        return allReservationsMadeByCustomer;
    }



    public void printAllReservations(){
        for (Reservation rsrv:
                allReservations) {
            System.out.println(rsrv);
        }
    }

}
