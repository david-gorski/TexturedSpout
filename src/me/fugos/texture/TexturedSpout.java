package me.fugos.texture;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TexturedSpout extends JavaPlugin {
	private final pListener playerListener = new pListener(this);

public boolean Dtod;

	public static Configuration config;
	Logger console = Logger.getLogger("Minecraft");
	String plName = "TexturedSpout";


	public void onDisable() 
	{
		console.info("[" + plName + "] " + plName + " has been disabled.");
		console.info("[" + plName + "] " + plName + " was coded by Fugos");
		console.info("[" + plName + "] " + plName + " is Funded by your generous Donations!");
	}

	public void onEnable() 
	{
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener, Event.Priority.Normal, this);
		
		config = this.getConfiguration();
		console.info("[" + plName + "] " + plName + " has been enabled.");
		console.info("[" + plName + "] Coded by Fugos");
		ConfigurationCheck();
		config.load();
	}
	public void ConfigurationCheck() 
	{
	
		if(config.getProperty("config.texturepack") == null)
		{
		     config.setProperty("config.texturepack", "http://dl.dropbox.com/u/32889036/Exodus%20Minecraft%20Pack.zip");
		     config.save();
		}
		
		if(config.getProperty("config.Default to Defualt Texture Pack") == null ) {
		
			config.setProperty("config.Default to Defualt Texture Pack", true);
			config.save();
		}
			
		if(config.getProperty("config.skin") == null)
		{
			config.setProperty("config.skin", "http://www.minecraftskins.com/save/136841");
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
	
	
	
	
	
	
