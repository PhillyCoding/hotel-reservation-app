package api;

import model.Customer;
import model.HotelRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Date;

public class HotelResource {
    private static HotelResource instance;

    public Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }

    public void createACustomer(String email, String first, String last){
        CustomerService.getInstance().addCustomer(email, first, last);
    }

    public HotelRoom getRoom(String roomNumber){
        return ReservationService.getInstance().getARoom(roomNumber);
    }

    public Reservation bookARoom(String email, HotelRoom room, Date checkIn, Date checkOut){
        return ReservationService.getInstance().reserveARoom(getCustomer(email), room, checkIn, checkOut);
    }

    public Collection<Reservation> getAllRoomsBookByACustomer(String email){

    }
}
