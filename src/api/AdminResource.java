package api;

import model.Customer;
import model.HotelRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource instance;

    private AdminResource(){}

    public static AdminResource getInstance() {
        if (instance == null) {
            instance = new AdminResource();
        }
        return instance;
    }

    public Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }

    public void addRooms(Collection<HotelRoom> rooms){
        for (HotelRoom room :
                rooms) {
            ReservationService.getInstance().addRoom(room);
        }
    }

    public Collection<HotelRoom> getAllRooms(){
        return ReservationService.getInstance().getAllRooms().values();
    }

    public Collection<Customer> getAllCustomers(){
        return CustomerService.getInstance().getAllCustomers();
    }

    public void displayAllReservations(){
        ReservationService.getInstance().printAllReservations();
    }
}
