package service;

import model.IRoom;

import java.util.HashMap;
import java.util.Map;

public class ReservationService {

    static Map<String, IRoom> rooms = new HashMap<>();
    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomNumber){
        return rooms.get(roomNumber);
    }



}
