package com.orakcool.telegramTestBot.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;

@UtilityClass
public class Messages {

    @SneakyThrows
    public static void sendMessage(AbsSender absSender, Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.enableHtml(true);
        message.setChatId(chatId.toString());
        message.setText(text);

        absSender.execute(message);
    }
}
