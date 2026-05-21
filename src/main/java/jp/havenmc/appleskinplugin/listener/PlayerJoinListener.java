package jp.havenmc.appleskinplugin.listener;

import jp.havenmc.appleskinplugin.task.SyncTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class PlayerJoinListener implements Listener {

    private final SyncTask syncTask;

    public PlayerJoinListener(SyncTask syncTask) {
        this.syncTask = syncTask;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        syncTask.onPlayerJoin(event.getPlayer());
    }
}
