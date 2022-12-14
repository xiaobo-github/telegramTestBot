package com.orakcool.telegramTestBot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot extends TelegramLongPollingBot {
    private static Bot botInstance;

    private Bot() {
    }

    @SneakyThrows
    public static void run() {
        if (botInstance == null) {
            botInstance = new Bot();
        }

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(botInstance);
    }

    @Override
    public String getBotUsername() {
        return System.getenv("BOT_USERNAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            if (message.hasText()) {
                sendMessageExecute(chatId, "echo: " + update.getMessage().getText());
            } else {
                sendMessageExecute(chatId, "silence...");
            }
        }
    }

    @SneakyThrows
    private void sendMessageExecute(Long chatId, String message){
        execute(SendMessage.builder()
                .chatId(chatId)
                .text(message)
                .build());
    }
}
