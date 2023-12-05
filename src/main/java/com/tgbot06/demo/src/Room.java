package com.tgbot06.demo.src;

public class Room {


    private int place;
    private boolean reserved;
    private int num;
    private int price;
    private boolean conditioner;
    private boolean bar;

    public Room(int num, int place, int price, boolean conditioner, boolean bar) {
        this.place = place;
        this.reserved = false;
        this.num = num;
        this.price = price;
        this.conditioner = conditioner;
        this.bar = bar;
    }

    public int getPlace() {
        return place;
    }

    public int getNum() {
        return num;
    }

    public int getPrice() {
        return price;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public boolean isBar() {
        return bar;
    }

    public boolean isReserved() {
        return reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (place != room.place) return false;
        if (reserved != room.reserved) return false;
        if (num != room.num) return false;
        if (price != room.price) return false;
        if (conditioner != room.conditioner) return false;
        return bar == room.bar;
    }

    @Override
    public int hashCode() {
        int result = place;
        result = 31 * result + (reserved ? 1 : 0);
        result = 31 * result + num;
        result = 31 * result + price;
        result = 31 * result + (conditioner ? 1 : 0);
        result = 31 * result + (bar ? 1 : 0);
        return result;
    }


    public String toStrings() {
        return "Last free room: " + num;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}