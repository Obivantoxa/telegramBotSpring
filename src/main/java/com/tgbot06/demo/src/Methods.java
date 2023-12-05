package com.tgbot06.demo.src;

import java.util.ArrayList;

public class Methods {


    private ArrayList<Room> rooms = new ArrayList<>();

    Room room11 = new Room(11, 2, 2300, false, false);
    Room room12 = new Room(12, 3, 3000, true, true);
    Room room13 = new Room(13, 4, 4000, true, true);
    Room room21 = new Room(21, 2, 2300, false, false);
    Room room22 = new Room(22, 3, 3023, true, true);
    Room room23 = new Room(23, 4, 4500, true, true);
    Room room31 = new Room(31, 2, 2300, false, false);
    Room room32 = new Room(32, 3, 3100, true, true);
    Room room33 = new Room(33, 4, 5004, true, true);

    public Methods() {
        test();
    }

    public void test() {
        rooms.add(room11);
        rooms.add(room12);
        rooms.add(room13);
        rooms.add(room21);
        rooms.add(room22);
        rooms.add(room23);
        rooms.add(room31);
        rooms.add(room32);
        rooms.add(room33);

    }

    public String StartMessage(String userName) {
        return "Добро пожаловать " + userName + " в бота по управлению бронированием в отеле.\n" +
                "Для получения справки введите команду /help";
    }

    public String HelpMessage() {
        return """
                Поиск свободных комнат:
                /getFreeRooms
                Поиск свободных комнат с условием:
                не реализовано /getFreeRooms 1000-2000 2 bar conditioner
                Получение полной информации по всем комнатам:
                не реализовано /getFreeRoomsWithAllInfo
                Бронирование комнаты:
                /reserve 32
                Выселение:
                /unreserve 32""";
    }

    public String getFreeRooms() {
        String response = "";
        for (Room r : rooms) {
            if (!r.isReserved()) {
                response += r.getNum() + ". ";
            }
        }
        return response;
    }


    public String reserveAnswerMessage(String messageText) {
        int numberReservedRoom = Integer.parseInt(messageText.split(" ")[1]);
        for (Room r : rooms) {
            if (r.getNum() == numberReservedRoom && !(r.isReserved())) {
                r.setReserved(true);

            }
        }
        return "You are successfully reserved room: " + numberReservedRoom + ". \n" +
                "Next free rooms: " + getFreeRooms();

    }

    public String unReserveAnswerMessage(String messageText) {
        int numberReservedRoom = Integer.parseInt(messageText.split(" ")[1]);
        for (Room r : rooms) {
            if (r.getNum() == numberReservedRoom) {
                r.setReserved(false);
                break;
            }
        }
        return "You are successfully unreserved room: " + numberReservedRoom + ".\n"
                + "Next free rooms: " + getFreeRooms();

    }


}
