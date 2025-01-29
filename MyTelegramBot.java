package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;

public class MyTelegramBot extends TelegramLongPollingBot {

    HashMap<String, Integer> hashMap = new HashMap<>();
    UI ui;
    String text;

    public MyTelegramBot(UI ui) {
        this.ui = ui;
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
            String id = update.getMessage().getChatId().toString();

            ui.setTextField(userMessage);

            if(hashMap.containsKey(id)){
                hashMap.put(id, hashMap.get(id) + Integer.parseInt(userMessage));
            } else {
                hashMap.put(id, Integer.parseInt(userMessage));
            }

            String response = "Result: " + hashMap.get(id);
            SendMessage message = new SendMessage();
            message.setChatId(id);
            message.setText(response);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
