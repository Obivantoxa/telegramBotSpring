package com.tgbot06.demo.src;

public class Methods {

    public String StartMessage(String userName){
        return "Добро пожаловать "+ userName +" в бота по управлению бронированием в отеле.\n" +
                "Для получения справки введите команду /help";
    }

    public String HelpMessage(){
        return """
                Поиск свободных комнат:
                /getFreeRooms
                Поиск свободных комнат с условием:
                /getFreeRooms 1000-2000 2 bar conditioner
                Получение полной информации по всем комнатам:
                /getFreeRoomsWithAllInfo
                Бронирование комнаты:
                /reserve 32
                Выселение:
                /goOut 32""";
    }
}
