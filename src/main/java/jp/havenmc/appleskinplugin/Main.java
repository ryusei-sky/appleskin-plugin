package jp.havenmc.appleskinplugin;

import jp.havenmc.appleskinplugin.listener.PlayerJoinListener;
import jp.havenmc.appleskinplugin.service.ChannelService;
import jp.havenmc.appleskinplugin.task.SyncTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private ChannelService channelService;
    private SyncTask syncTask;

    @Override
    public void onEnable() {
        this.channelService = new ChannelService(this);
        this.channelService.register();

        this.syncTask = new SyncTask(this);

        getServer().getPluginManager().registerEvents(
                new PlayerJoinListener(this.syncTask),
                this
        );

        this.syncTask.runTaskTimer(this, 1L, 1L);
    }

    @Override
    public void onDisable() {
        if (this.syncTask != null) {
            this.syncTask.cancel();
            this.syncTask = null;
        }

        if (this.channelService != null) {
            this.channelService.unregister();
            this.channelService = null;
        }
    }
}
