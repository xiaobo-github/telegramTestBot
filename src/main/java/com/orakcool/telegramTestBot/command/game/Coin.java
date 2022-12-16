package com.orakcool.telegramTestBot.command.game;

import lombok.SneakyThrows;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.io.InputStream;

public class Coin extends BotCommand {
    public Coin(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @SneakyThrows
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        boolean isHead = Math.random() > 0.5;
        String path = "pictures/" +
                (isHead ? "head" : "tail") +
                ".png";

        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(path);

        assert inputStream != null;

        InputFile inputPicture = new InputFile(inputStream, "coin");
        SendPhoto sendPhoto = new SendPhoto(String.valueOf(chat.getId()), inputPicture);

        absSender.execute(sendPhoto);
    }
}
