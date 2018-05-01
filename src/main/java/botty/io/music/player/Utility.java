package botty.io.music.player;

import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.util.audio.AudioPlayer;

public class Utility {

    /**
     *  Utility methods
     */
    public static AudioPlayer getPlayer(IGuild guild) {
        return AudioPlayer.getAudioPlayerForGuild(guild);
    }


    public static String getTrackTitle(AudioPlayer.Track track) {
        return track.getMetadata().containsKey("title") ? String.valueOf(track.getMetadata().get("title")) : "Unknown Track";
    }

    public static void setTrackTitle(AudioPlayer.Track track, String title) {
        track.getMetadata().put("title", title);
    }
}
