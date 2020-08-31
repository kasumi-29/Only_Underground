package kun.minecraft_plugin.tiny.only_underground;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class event implements Listener {
    private final Main m;
    public event(Main main) {
        m=main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        System.out.println (event.getPlayer().getLocation().getBlock().getLightFromSky());
    }
}
