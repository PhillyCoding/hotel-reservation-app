package model;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, roomType);
        this.price = 0.0;
    }

    @Override
    public String toString(){
        return "Room " + getRoomNumber() + " is a " + getRoomType()  + " priced at " + getRoomPrice();
    }
}
