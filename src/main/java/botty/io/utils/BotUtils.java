package botty.io.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

public class BotUtils {

	// Constants for use throughout the bot
	public static String BOT_PREFIX = "!";

	// Helper functions to make certain aspects of the bot easier to use.
	public static void sendMessage(IChannel channel, String message){

		Logger log = LoggerFactory.getLogger(BotUtils.class);

		// This might look weird but it'll be explained in another page.
		RequestBuffer.request(() -> {
			try{
				channel.sendMessage(message);
			} catch (DiscordException e){
				log.error("Message could not be sent with error: {}", e);
			}
		});

	}
}

