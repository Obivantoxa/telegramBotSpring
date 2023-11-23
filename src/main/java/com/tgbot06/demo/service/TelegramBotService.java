package com.tgbot06.demo.service;

import com.tgbot06.demo.config.BotConfig;
import com.tgbot06.demo.src.Methods;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBotService extends TelegramLongPollingBot {
    final BotConfig config;
    final Methods methods = new Methods();

    public TelegramBotService(BotConfig config) {
        this.config = config;
    }


    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    public void BotGiveResponse(String response, long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(response);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    public void BotGiveResponse(String response,String userName, long chatId) {
        SendMessage message = new SendMessage();
        message.getChatId();
        message.setChatId(chatId);
        message.setText(response);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
       // String userName = update.
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            if (messageText.equals("/start")) {
                BotGiveResponse(methods.StartMessage(), chatId);
            } else if (messageText.equals("/help")) {
                BotGiveResponse(methods.HelpMessage(), chatId);
            }
    /*{
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if(messageText.equals("/start")){
                String response = "Hellow world";
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText(response);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }*/
        }
    }
}