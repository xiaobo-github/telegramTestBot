package com.orakcool.telegramTestBot;

import com.orakcool.telegramTestBot.util.MenuItems;
import lombok.SneakyThrows;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import static com.orakcool.telegramTestBot.util.NonCommand.NonCommandWork;

public class Bot extends TelegramLongPollingCommandBot {
    private static Bot botInstance;

    private Bot() {
        registerAll(MenuItems.getCommands());
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
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            execute(NonCommandWork(message));
        }
    }

}
