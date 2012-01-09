package me.rofl.trex;

import java.util.List;

import me.rofl.trex.TexturedSpout2;

import org.bukkit.World;


public class Config {
    public Config(TexturedSpout2 instance) {
    }

    public static void loadConfiguration(List<World> worlds){
    	
        TexturedSpout2.plugin.getConfig().addDefault("Use-Permissions", true);
        TexturedSpout2.plugin.getConfig().addDefault("Use-Regions", false);
        TexturedSpout2.plugin.getConfig().addDefault("Use-Default", true);
  
    	for (World world : worlds) {
    	String worldName = world.getName();
    	String worldPath = "Worlds." + worldName;
    	String resetPath = "ResetTexturePacks." + worldName;
    	TexturedSpout2.plugin.getConfig().addDefault(worldPath, "");
    	TexturedSpout2.plugin.getConfig().addDefault(resetPath, false);
    }
    TexturedSpout2.plugin.getConfig().options().copyDefaults(true);
    TexturedSpout2.plugin.saveConfig();
}
    
    public static String getConfigString(String path){
    	String response = TexturedSpout2.plugin.getConfig().getString(path);
		return response;
    }
    
    public static int getConfigInt(String path){
    	int response = TexturedSpout2.plugin.getConfig().getInt(path);
		return response;
    }
    
    public static Boolean getConfigBoolean(String path){
    	Boolean response = TexturedSpout2.plugin.getConfig().getBoolean(path);
		return response;
    }
    
}
    