package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;

public class MyTelegramBot extends TelegramLongPollingBot {

    UI ui;
    private String id;

    public MyTelegramBot(UI ui) {
        this.ui = ui;
        ui.setBot(this);
    }

    @Override
    public String getBotUsername() {
        return "ersteUniq_bot";
    }

    @Override
    public String getBotToken() {
        return "7682523576:AAFgdcbBp6wSQ8Qm6tKmlVUROKmKMoeMwHo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            id = update.getMessage().getChatId().toString();
            ui.setTextField(userMessage);

//            sendTo(userMessage);
        }
    }

    public void sendTo(String text) {
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
