package kun.minecraft_plugin.tiny.only_underground;

import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new event(this), this);
        Location firstSP =getServer().getWorlds().get(0).getSpawnLocation();
        Objects.requireNonNull(firstSP.getWorld()).setGameRule(GameRule.SPAWN_RADIUS, 0);
        Objects.requireNonNull(firstSP.getWorld()).setGameRule(GameRule.MAX_ENTITY_CRAMMING, 0);

        Location temp_l=firstSP.clone();
        int SP_h=5;
        nextX(temp_l,-1*SP_h/2);
        nextY(temp_l,-1);
        nextZ(temp_l,-1*SP_h/2);
        for (int y=0;y<=SP_h;y++) {
            for (int x = 0; x < SP_h; x++) {
                for (int z = 0; z < SP_h; z++) {
                    if(z==0||z==(SP_h-1)||x==0||x==(SP_h-1)||y==SP_h){
                        temp_l.getBlock().setType(Material.BEDROCK);
                    }else if(y==0) {
                        temp_l.getBlock().setType(Material.GRASS_BLOCK);
                    }else{
                        temp_l.getBlock().setType(Material.AIR);
                    }
                    nextZ(temp_l);
                }
                nextX(temp_l);
                nextZ(temp_l,-1*SP_h);
            }
            nextY(temp_l);
            nextX(temp_l,-1*SP_h);
        }

        getLogger().info("読み込みが完了しました。");
    }

    private void nextZ(Location l,int h){
        l.setZ(l.getZ()+h);
    }
    private void nextZ(Location l){
        nextZ(l,1);
    }
    private void nextX(Location l,int h){
        l.setX(l.getX()+h);
    }
    private void nextX(Location l){
        nextX(l,1);
    }
    private void nextY(Location l,int h){
        l.setY(l.getY()+h);
    }
    private void nextY(Location l){
        nextY(l,1);
    }
}
