package botty.io.events;

import botty.io.commands.*;
import botty.io.utils.BotUtils;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.Permissions;
import sx.blah.discord.util.PermissionUtils;

public class EventHandlerListener {

    private IDiscordClient client;

    public EventHandlerListener(IDiscordClient client) {
        this.client = client;
    }

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) throws InterruptedException {

        //replace the word fuck with ****
        String message = event.getMessage().getContent().replaceAll("\\s+", "");

        String withoutPrefixCommands = message.toLowerCase();
        switch (withoutPrefixCommands) {
            case "fuck":
                if (PermissionUtils.hasPermissions(event.getChannel(), client.getOurUser(), Permissions.MANAGE_MESSAGES)) {
                    event.getMessage().delete();
                }
                break;
            default:
                if (event.getMessage().getContent().contains("┻")) {
                    BotUtils.sendMessage(event.getChannel(), FlipTable.getString());
                }
                break;
        }


        //botty.io.commands
        if (event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX)) {
            IChannel channel = event.getChannel();

            channel.setTypingStatus(true); //set typing to true.

            String[] contentArray = event.getMessage().toString().split(" ", 2); //split in 2.
            if (!contentArray[0].isEmpty()) {
                String command = contentArray[0].substring(BotUtils.BOT_PREFIX.length());
                String content = contentArray.length > 1 ? contentArray[1] : null;

                switch (command) {
                    case "help":
                        BotUtils.sendMessage(channel, HelpMessage.getString());
                        break;
                    case "reverse":
                        BotUtils.sendMessage(channel, new StringBuilder(content).reverse().toString());
                        break;
                    case "8ball":
                        if (event.getMessage().getContent().split("\\s+").length == 1) {
                            BotUtils.sendMessage(channel, event.getAuthor() + ", I need a question! ask me one? please!");
                        } else {
                            BotUtils.sendMessage(channel, Eightball.getString());
                        }
                        break;
                    case "rquote":
                        BotUtils.sendMessage(channel, RandomQuotes.getString());
                        break;
                    case "roll":
                        String[] dices = event.getMessage().toString().split(" ", 3); //split in 2.

                        if (dices.length == 2) {
                            BotUtils.sendMessage(channel, Dice.oneDice(dices));
                        }

                        if(dices.length == 3) {
                            BotUtils.sendMessage(channel, Dice.roll(dices));
                        }
                }
            }
            event.getChannel().setTypingStatus(false);
        }
    }

}
