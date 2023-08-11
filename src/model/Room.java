package model;

public class Room implements HotelRoom {
    String roomNumber;

    Double price;

    RoomType roomType;

    public Room(String roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public Room(String roomNumber, RoomType roomType, Double price) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    public void setRoomPrice(Double price) {
        this.price = price;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }

    @Override
    public boolean isFree() {
        return this.price == 0;
    }

    @Override
    public String toString(){
        return "Room " + getRoomNumber() + " is a " + getRoomType()  + " priced at " + getRoomPrice();
    }

    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
        if (this == obj) {
            return true;
        }

        // Check if the object is an instance of Room
        if (!(obj instanceof Room)) {
            return false;
        }

        // Typecast obj to Room to compare the data members
        Room room = (Room) obj;

        // Compare the roomNumber of the two rooms
        return roomNumber.equals(room.roomNumber);
    }

    @Override
    public int hashCode() {
        return roomNumber.hashCode();
    }


}
