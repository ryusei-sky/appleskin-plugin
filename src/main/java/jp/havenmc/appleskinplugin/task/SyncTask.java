package jp.havenmc.appleskinplugin.task;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class SyncTask extends BukkitRunnable {

    private final JavaPlugin plugin;

    private final Map<UUID, Float> saturationMap = new HashMap<>();
    private final Map<UUID, Float> exhaustionMap = new HashMap<>();

    private static final float EXHAUSTION_THRESHOLD = 0.01F;

    public SyncTask(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            update(player);
        }
    }

    private void update(Player player) {
        UUID uuid = player.getUniqueId();

        float sat = player.getSaturation();
        Float prevSat = saturationMap.get(uuid);

        if (prevSat == null || prevSat != sat) {
            player.sendPluginMessage(plugin,
                    "appleskin:saturation",
                    ByteBuffer.allocate(4).putFloat(sat).array()
            );
            saturationMap.put(uuid, sat);
        }

        float exh = player.getExhaustion();
        Float prevExh = exhaustionMap.get(uuid);

        if (prevExh == null || Math.abs(prevExh - exh) >= EXHAUSTION_THRESHOLD) {
            player.sendPluginMessage(plugin,
                    "appleskin:exhaustion",
                    ByteBuffer.allocate(4).putFloat(exh).array()
            );
            exhaustionMap.put(uuid, exh);
        }
    }

    public void onPlayerJoin(Player player) {
        saturationMap.remove(player.getUniqueId());
        exhaustionMap.remove(player.getUniqueId());
    }
}
