package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class MyTelegramBot extends TelegramLongPollingBot {

    private String id;

    public MyTelegramBot() {
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

            if (userMessage.equalsIgnoreCase("read")) {
                sendSavedMessages();
            } else {
                DB.save(userMessage);
                sendTo(id, "Повідомлення збережено");
            }
        }
    }

    public void sendTo(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println("Помилка при відправці повідомлення: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendSavedMessages() {
        ArrayList<String> savedMessages = DB.read();
        sendTo(id, savedMessages.toString());
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyTelegramBot());
            System.out.println("Бот запущено успішно!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
