package com.orakcool.telegramTestBot.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static com.orakcool.telegramTestBot.util.Messages.sendMessage;

public class StartCommand extends BotCommand {

    public StartCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String username = user.getFirstName();
        String message = String.format("Hello %s! I am a simple bot :)\n I can flip a coin for you,\n and if you write any text, I'll just copy it.\n What else to do with it.",username);

        sendMessage(absSender, chat.getId(), message);
    }
}
