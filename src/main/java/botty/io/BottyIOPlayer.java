package botty.io;

import botty.io.events.EventHandlerListener;
import botty.io.music.player.MusicPlayerEvents;
import com.koloboke.collect.set.LongSet;
import org.apache.log4j.BasicConfigurator;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

/**
 * D4J AudioPlayer Tutorial
 * http://github.com/oopsjpeg/d4j-audioplayer/
 *
 * @author oopsjpeg
 */
public class BottyIOPlayer {

    //private static final String TOKEN = "MzQ1OTY5NTk0OTYxNDk0MDE2.DHDBVA.G7uZkJgjYE1Kc5uwGLBx1GHQ5nY";
    public static IDiscordClient client = null;

    public static void main(String[] args) throws DiscordException, RateLimitException {
        BasicConfigurator.configure();

        if (args[0] != null) {
            client = new ClientBuilder().withToken(args[0]).build();
        } else {
            System.out.println("No BotToken found in first argument");
            System.exit(0);
        }

        System.out.println("Logging bot in...");
        BottyIOPlayer bottyIOPlayer = new BottyIOPlayer();

        EventDispatcher dispatcher = client.getDispatcher(); // Gets the EventDispatcher instance for this client instance
        dispatcher.registerListener(new EventHandlerListener(client));
        dispatcher.registerListener(new MusicPlayerEvents());

        client.login();
    }

    public BottyIOPlayer() {
    }

    public static void join(IChannel channel, IUser user) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (user.getVoiceStates().size() < 1)
            channel.sendMessage("You aren't in a voice channel!");
        else {
            IVoiceState state = null;
            LongSet keySet = user.getVoiceStates().keySet();
            for (Long key : keySet) {
                state = user.getVoiceStates().get(key);
            }

            IVoiceChannel voice = state.getChannel();

            if (voice == null) {
                channel.sendMessage("You need to be in a voicechat, which I can join.");
            } else if (!voice.getModifiedPermissions(client.getOurUser()).contains(Permissions.VOICE_CONNECT))
                channel.sendMessage("I can't join that voice channel!");
            else if (voice.getUserLimit() != 0 && voice.getConnectedUsers().size() >= voice.getUserLimit())
                channel.sendMessage("That room is full!");
            else {
                voice.join();
                channel.sendMessage("Connected to **" + voice.getName() + "**.");
            }
        }
    }
}
