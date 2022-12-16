package com.orakcool.telegramTestBot.util;

import com.orakcool.telegramTestBot.command.StartCommand;
import com.orakcool.telegramTestBot.command.game.Coin;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.helpCommand.HelpCommand;

@UtilityClass
public class MenuItems {
    private static final IBotCommand[] commands = new IBotCommand[]{
            new StartCommand("start", "Begin use bot!"),
            new Coin("toss", "Toss a coin"),
            new HelpCommand("help", "Show all commands", "This command displays all commands the bot has to offer."),
    };

    public static IBotCommand[] getCommands() {
        return commands.clone();
    }
}
