package com.orakcool.telegramTestBot.util;

import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@UtilityClass
public class NonCommand {

    public static SendMessage NonCommandWork(Message message) {

        Long chatId = message.getChatId();
        String answerText = "no text message, no echo... ";
        if (message.hasText()) {
            answerText = "echo: " + message.getText();
        }

        return SendMessage.builder()
                .chatId(chatId)
                .text(answerText)
                .build();
    }
}
