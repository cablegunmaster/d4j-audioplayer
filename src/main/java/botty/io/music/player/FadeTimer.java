package botty.io.music.player;

import sx.blah.discord.handle.obj.IChannel;

import java.util.Timer;
import java.util.TimerTask;

import static botty.io.music.player.PlayerModule.isFadingVolume;

public class FadeTimer extends TimerTask {

    private Timer timer;

    private IChannel channel;
    private int loweringVolume;

    public FadeTimer(IChannel channel, Integer loweringVolume) {
        this.channel = channel;
        this.loweringVolume = loweringVolume;
    }

    @Override
    public void run() {
        System.out.println("Fading volume");
        if (!isFadingVolume(channel, loweringVolume)) {
            timer.cancel();
        }
    }


    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public Timer getTimer() {
        return timer;
    }
}
