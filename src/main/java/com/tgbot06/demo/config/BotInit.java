package com.tgbot06.demo.config;

import com.tgbot06.demo.service.TelegramBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
@Component
public class BotInit {
    @Autowired
    TelegramBotService telegramBotService;
    @EventListener({ContextRefreshedEvent.class})
    public void init () throws TelegramApiException{
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi((DefaultBotSession.class));
        telegramBotsApi.registerBot(telegramBotService);
        }
    }

