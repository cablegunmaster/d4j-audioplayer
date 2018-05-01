package botty.io.music.player;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static botty.io.music.player.Utility.getPlayer;
import static botty.io.music.player.Utility.setTrackTitle;

/**
 * Audio player methods
 */
public class PlayerModule {

    public static void queueUrl(IChannel channel, String url) throws RateLimitException, DiscordException, MissingPermissionsException {
        try {
            URL u = new URL(url);
            setTrackTitle(getPlayer(channel.getGuild()).queue(u), u.getFile());
        } catch (MalformedURLException e) {
            channel.sendMessage("That URL is invalid!");
        } catch (IOException e) {
            channel.sendMessage("An IO exception occured: " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            channel.sendMessage("That type of file is not supported!");
        }
    }

    public static void queueFile(IChannel channel, String file) throws RateLimitException, DiscordException, MissingPermissionsException {
        File f = new File(file);
        if (!f.exists())
            channel.sendMessage("That file doesn't exist!");
        else if (!f.canRead())
            channel.sendMessage("I don't have access to that file!");
        else {

            if (getPlayer(channel.getGuild()).getVolume() == 0) {
                volume(channel, 50);
            }

            try {
                setTrackTitle(getPlayer(channel.getGuild()).queue(f), f.toString());
            } catch (IOException e) {
                channel.sendMessage("An IO exception occured: " + e.getMessage());
            } catch (UnsupportedAudioFileException e) {
                channel.sendMessage("That type of file is not supported!");
            }
        }
    }

    public static void setLoop(IChannel channel, boolean loop) {
        getPlayer(channel.getGuild()).setLoop(loop);
    }

    public static void pause(IChannel channel, boolean pause) {
        getPlayer(channel.getGuild()).setPaused(pause);
    }

    public static void skip(IChannel channel) {
        getPlayer(channel.getGuild()).skip();
    }

    public static void volume(IChannel channel, int percent) throws RateLimitException, DiscordException, MissingPermissionsException {
        volume(channel, (float) (percent) / 100);
    }

    public static void volume(IChannel channel, Float vol) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (vol > 1.5) vol = 1.5f;
        if (vol < 0) vol = 0f;
        getPlayer(channel.getGuild()).setVolume(vol);
        channel.sendMessage("Set volume to **" + (int) (vol * 100) + "%**.");
    }

    public static boolean isFadingVolume(IChannel channel, int loweringPercent) throws RateLimitException, DiscordException, MissingPermissionsException {
        boolean isPlaySong = true;
        float vol;

        if (loweringPercent > 0) {
            vol = (float) (loweringPercent) / 100;
            vol = getPlayer(channel.getGuild()).getVolume() - vol; //calc to lower volume.

            if (vol > 1.5) {
                vol = 1.5f;
            }

        } else {
            vol = (float) 0;
        }

        if (vol <= 0) {
            vol = 0f;
            isPlaySong = false;
        }

        //fade a little bit
        getPlayer(channel.getGuild()).setVolume(vol);

        if (!isPlaySong) {
            skip(channel);
            setLoop(channel, false);
        }

        return isPlaySong;
    }
}
