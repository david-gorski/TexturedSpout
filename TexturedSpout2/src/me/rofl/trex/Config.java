package me.rofl.trex;

import java.util.List;

import me.rofl.trex.TexturedSpout2;

import org.bukkit.World;
import org.bukkit.plugin.Plugin;


public class Config {
	static TexturedSpout2 plugin;
	public static TexturedSpout2 instance;
    public Config(TexturedSpout2 instance) {
    	plugin = instance;
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
    	String response = plugin.getConfig().getString(path);
		return response;
    }
    
    public static int getConfigInt(String path){
    	int response = plugin.getConfig().getInt(path);
		return response;
    }
    
    public static Boolean getConfigBoolean(String path){
    	Boolean response = plugin.getConfig().getBoolean(path);
		return response;
    }
    
}
    