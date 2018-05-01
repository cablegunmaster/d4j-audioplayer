package botty.io.music.player;

import botty.io.utils.BotUtils;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import sx.blah.discord.util.audio.events.TrackFinishEvent;
import sx.blah.discord.util.audio.events.TrackQueueEvent;
import sx.blah.discord.util.audio.events.TrackStartEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import static botty.io.BottyIOPlayer.join;
import static botty.io.music.player.PlayerModule.*;
import static botty.io.music.player.Utility.getPlayer;
import static botty.io.music.player.Utility.getTrackTitle;


public class MusicPlayerEvents {

    // Stores the last channel that the join command was sent from
    private final Map<IGuild, IChannel> lastChannel = new HashMap<>();
    private FadeTimer fadeTimer = null;

    public MusicPlayerEvents() {
    }

    /**
     * General MusicPlayerEvents
     */
    @EventSubscriber
    public void onReady(ReadyEvent event) {
        System.out.println("Bot is now ready!");
    }

    @EventSubscriber
    public void onMessage(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        IMessage message = event.getMessage();
        IUser user = message.getAuthor();
        if (user.isBot()) return;

        IChannel channel = message.getChannel();
        IGuild guild = message.getGuild();
        String[] split = message.getContent().split(" ");

        if (split.length >= 1 && split[0].startsWith(BotUtils.BOT_PREFIX)) {

            String command = split[0].replaceFirst(BotUtils.BOT_PREFIX, "").toLowerCase();
            String[] args = split.length >= 2 ? Arrays.copyOfRange(split, 1, split.length) : new String[0];

            switch (command) {
                case "join":
                    joinVoiceChannel(guild, channel, user);
                    break;
                case "leave":
                    IVoiceChannel voiceChannel = guild.getConnectedVoiceChannel();
                    if (voiceChannel != null) {
                        voiceChannel.leave();
                        lastChannel.clear();
                        channel.sendMessage("I left the voice channel");
                    } else {
                        channel.sendMessage("I am currently not in a voicechannel.");
                    }
                    break;
                case "queueurl":
                    queueUrl(channel, String.join(" ", args));
                    break;
                case "queuefile":
                    queueFile(channel, String.join(" ", args));
                    break;
                case "loop":
                    if (getPlayer(guild).isLooping()) {
                        channel.sendMessage("Loop is turned OFF");
                        setLoop(channel, false);
                    } else {
                        channel.sendMessage("Loop is turned ON");
                        setLoop(channel, true);
                    }
                case "unpause":
                case "play":
                    pause(channel, false);
                    break;
                case "pause":
                    pause(channel, true);
                    break;
                case "stop":
                    pause(channel, true);
                case "skip":
                    skip(channel);
                    break;
                case "volume":
                case "vol":
                    try {
                        volume(channel, Integer.parseInt(args[0]));
                    } catch (NumberFormatException e) {
                        channel.sendMessage("Invalid volume percentage.");
                    }
                    break;
                case "fade":
                    fadeOut(channel, args);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Fade out function
     * @param channel
     * @param args
     */
    private void fadeOut(IChannel channel, String[] args) {
        // first arg is seconds
        // second arg is volume lowering.

        Integer seconds = null;
        Integer loweringVolume = null;

        try {
            seconds = Integer.parseInt(args[0]);
        } catch (Exception ex) {
            channel.sendMessage("Seconds to wait for next lowering volume should be a number like" +
                    ":'!fade <time in msec (1000 is 1 sec)><space><loweringVolumeByInPercent>' ex: !fade 600 4");
            System.out.println(ex);
            return;
        }

        try {
            loweringVolume = Integer.parseInt(args[1]);
        } catch (Exception ex) {
            channel.sendMessage("Lowering volume should be a number like:" +
                    "'!fade<space><time in msec (1000 is 1 sec)><space><loweringVolumeByInPercent>' ex: !fade 600 4");
            System.out.println(ex);
            return;
        }

        //Bot sends message too high ..
        if (seconds > 30 * 1000) {
            seconds = 30 * 1000;
            channel.sendMessage("first argument should be 30 seconds or less.");
        }

        try {
            fadeTimer = new FadeTimer(channel, loweringVolume);
            fadeTimer.setTimer(new Timer(false));
            fadeTimer.getTimer().scheduleAtFixedRate(fadeTimer, 0, seconds);
        } catch (NumberFormatException e) {
            channel.sendMessage("Invalid volume percentage.");
        }

    }

    private void joinVoiceChannel(IGuild guild, IChannel channel, IUser user) {
        IVoiceChannel voiceChannel = guild.getConnectedVoiceChannel();

        //Not connected join the users channel.
        if (voiceChannel == null || !voiceChannel.isConnected()) {
            lastChannel.put(guild, channel);
            join(channel, user);
        }
    }

    /**
     * Track MusicPlayerEvents
     */
    @EventSubscriber
    public void onTrackQueue(TrackQueueEvent event)
            throws RateLimitException, DiscordException, MissingPermissionsException {
        IGuild guild = event.getPlayer().getGuild();
        if (lastChannel.size() > 0) {
            lastChannel.get(guild).sendMessage("Added **" + getTrackTitle(event.getTrack()) + "** to the playlist.");
        }
    }

    @EventSubscriber
    public void onTrackStart(TrackStartEvent event)
            throws RateLimitException, DiscordException, MissingPermissionsException {
        IGuild guild = event.getPlayer().getGuild();

        if (!getPlayer(guild).isLooping() && lastChannel.size() > 0) {
            lastChannel.get(guild).sendMessage("Now playing **" + getTrackTitle(event.getTrack()) + "**.");
        }
    }

    @EventSubscriber
    public void onTrackFinish(TrackFinishEvent event)
            throws RateLimitException, DiscordException, MissingPermissionsException {

        IGuild guild = event.getPlayer().getGuild();

        if (!getPlayer(guild).isLooping() && lastChannel.size() > 0) {
            lastChannel.get(guild).sendMessage("Finished playing **" + getTrackTitle(event.getOldTrack()) + "**.");
        }

        if (event.getNewTrack() == null) {
            lastChannel.get(guild).sendMessage("The playlist is now empty.");
        }
    }
}
