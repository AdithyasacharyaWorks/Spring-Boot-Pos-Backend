package dev.foodPos.food.pos.app.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "room_tables")
public class RoomTable {

    @Id
    private String id;
    private String tableNumberOrRoomNumber; // Can be either table or room number
    private String tableOrRoomName; // Added field for a more descriptive name
    private String roomNumber; // Optional: Keep this if you specifically need to track room numbers separately
    private int capacity; // Added field
    private int floor; // Added field
    private boolean isOccupied;
    private String qrCode;
    private String notes; // Added field

    // Constructors
    public RoomTable() {
    }

    public RoomTable(String tableNumberOrRoomNumber, String tableOrRoomName, String roomNumber, int capacity, int floor, boolean isOccupied, String qrCode, String notes) {
        this.tableNumberOrRoomNumber = tableNumberOrRoomNumber;
        this.tableOrRoomName = tableOrRoomName;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.floor = floor;
        this.isOccupied = isOccupied;
        this.qrCode = qrCode;
        this.notes = notes;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableNumberOrRoomNumber() {
        return tableNumberOrRoomNumber;
    }

    public void setTableNumberOrRoomNumber(String tableNumberOrRoomNumber) {
        this.tableNumberOrRoomNumber = tableNumberOrRoomNumber;
    }

    public String getTableOrRoomName() {
        return tableOrRoomName;
    }

    public void setTableOrRoomName(String tableOrRoomName) {
        this.tableOrRoomName = tableOrRoomName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
