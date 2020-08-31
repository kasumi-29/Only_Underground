package kun.minecraft_plugin.tiny.only_underground;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

public class event implements Listener {
    private final Main m;
    public event(Main main) {
        m=main;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player p=event.getPlayer();
        GameMode player_g=p.getGameMode();
        if(player_g.equals(GameMode.CREATIVE)||player_g.equals(GameMode.SPECTATOR)){return;}
        if(Objects.requireNonNull(event.getTo()).getBlock().getLightFromSky()!=0){
            p.setHealth(0d);
        }
    }
}
