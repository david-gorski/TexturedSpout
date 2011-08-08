package me.fugos.texture;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TexturedSpout extends JavaPlugin {

public boolean Dtod;

	public static Configuration config;
	Logger console = Logger.getLogger("Minecraft");
	String plName = "TexturedSpout";


	public void onDisable() 
	{
		console.info("[" + plName + "] " + plName + " has been disabled.");
		console.info("[" + plName + "] " + plName + " was coded by Fugos");
	}

	public void onEnable() 
	{
		config = this.getConfiguration();
		PluginManager pm = getServer().getPluginManager();
		console.info("[" + plName + "] " + plName + " has been enabled.");
		console.info("[" + plName + "] Coded by Fugos");
		pm.registerEvent(Type.CUSTOM_EVENT, new sListener(), Priority.Low, this);
		ConfigurationCheck();
		config.load();
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Type.CUSTOM_EVENT, new BInputListener(this),
				Priority.Normal, this);
		pm.registerEvent(Type.CUSTOM_EVENT, new BInvListener(this),
				Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_JOIN, new sListener(this),
				Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_QUIT, new BPlayerListener(this),
				Priority.Normal, this);
		pm.registerEvent(Type.ENTITY_DEATH, new BEntListener(this),
		getServer().getPluginManager().registerEvent(Type.PLAYER_JOIN, sListener, Priority.Lowest, this);
		getServer().getPluginManager().registerEvent(Type.PLAYER_JOIN, TexturedSpout, Priority.Lowest, this);
		
	
	public void onPlayerJoin(PlayerJoinEvent event,  World world, SpoutPlayer splayer,SpoutCraftEnableEvent sevent) {
		if(1 == 1) {
        	String WorldUrl = config.getString(
    				"texturepack." + world.getName());
    				String DefaultUrl = config.getString("texturepack.default");
    		if (WorldUrl != null) {
    		sevent.getPlayer().setTexturePack(TexturedSpout.config.getProperty("config.texturepack." +  world.getName()).toString());
    	}	if (WorldUrl == null){
    		config.setProperty("config.texturepack." + world.getName(), "http://dl.dropbox.com/u/32889036/Exodus%20Minecraft%20Pack.zip");
    	     config.save();
    	     	if (Dtod == false)
    			splayer.sendMessage( ChatColor.RED + "A Texture Pack is not set for this world!" );
    	     	if (Dtod == true)
    			splayer.setTexturePack(DefaultUrl); }}
		
		
	}
	
	
	
	
	
	public void ConfigurationCheck() 
	{
	
		if(config.getProperty("config.texturepack") == null)
		{
		     config.setProperty("config.texturepack", "http://dl.dropbox.com/u/32889036/Exodus%20Minecraft%20Pack.zip");
		     config.save();
		}
		
		if(config.getProperty("config.Default to Defualt Texture Pack:") == null ) {
		
			config.setProperty("config.Default to Defualt Texture Pack", true);
			config.save();
		}
			
		if(config.getProperty("config.skin") == null)
		{
			config.setProperty("config.skin", "http://www.minecraftskins.com/save/146841");
			config.save();
			
		}
		Dtod = config.getBoolean("Default to Defualt Texture Pack", true);
		
		
		
		
		
		  String file = this.getDataFolder().toString()+"/config.yml";
		  File yml = new File(file);
		  if (!yml.exists()) {
			  new File(this.getDataFolder().toString()).mkdir();
			  try {
				  yml.createNewFile();
			  } catch (IOException e) {
				  e.printStackTrace();
			  	}
		  	}
		}
	}
	
	
	
	
	
	
