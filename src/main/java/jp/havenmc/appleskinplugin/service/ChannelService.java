package jp.havenmc.appleskinplugin.service;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;

import java.util.List;

public final class ChannelService {

    public static final List<String> CHANNELS = List.of(
            "appleskin:saturation",
            "appleskin:exhaustion"
    );

    private final JavaPlugin plugin;

    public ChannelService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        Messenger messenger = plugin.getServer().getMessenger();

        CHANNELS.forEach(channel ->
                messenger.registerOutgoingPluginChannel(plugin, channel)
        );
    }

    public void unregister() {
        Messenger messenger = plugin.getServer().getMessenger();

        CHANNELS.forEach(channel ->
                messenger.unregisterOutgoingPluginChannel(plugin, channel)
        );
    }
}
