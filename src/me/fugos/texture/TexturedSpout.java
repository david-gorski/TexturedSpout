package me.fugos.texture;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.bukkit.event.CustomEventListener;

public class TexturedSpout extends JavaPlugin {
	protected pListener playerListener;

	protected final static Logger log = Logger
			.getLogger("Minecraft.TexturedSpout");
	protected static TexturedSpout instance;
	
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
		pm.registerEvent(Event.Type.CUSTOM_EVENT, new CustomEventListener() {
			@Override
			public void onCustomEvent(Event _event) {
			if (_event instanceof SpoutCraftEnableEvent) {
				SpoutCraftEnableEvent event = (SpoutCraftEnableEvent) _event;
			playerListener.doWorldActions(event.getPlayer()
			.getWorld(), event.getPlayer(), getConfiguration());
			}
			}
			}, Event.Priority.Normal, this);


		
			playerListener = new pListener(this);
		
		
		
		config = this.getConfiguration();
		console.info("[" + plName + "] " + plName + " has been enabled.");
		console.info("[" + plName + "] Coded by Fugos");
		config.load();

	
	
	
	
	
	
	
	

	if (getConfiguration().getKeys().isEmpty()) {
		Configuration config = getConfiguration();
		config.setProperty("texturepack.default", "");
		config.setProperty("texturepack.world_voxel",
		"http://dl.dropbox.com/u/32644765/texturepacks/vbtp0-pangea.zip");

		List<Map<String, Object>> worldRegions = new ArrayList<Map<String, Object>>();
		worldRegions.add(new HashMap<String, Object>());
		worldRegions.add(new HashMap<String, Object>());

		Map<String, Object> tmp;

		worldRegions.get(0).put("name", "Example Region");
		worldRegions.get(0).put("description", "Is that... sand?");
		worldRegions.get(0).put("icon", "SANDSTONE");
		tmp = new HashMap<String, Object>();
		worldRegions.get(0).put("min", tmp);
		tmp.put("x", -10);
		tmp.put("y", 0);
		tmp.put("z", -10);
		tmp = new HashMap<String, Object>();
		worldRegions.get(0).put("max", tmp);
		tmp.put("x", 10);
		tmp.put("y", 127);
		tmp.put("z", 10);

		worldRegions.get(1).put("name", "Other Region");
		worldRegions.get(1).put("description", "That is also sand.");
		worldRegions.get(1).put("icon", "SAND");
		worldRegions.get(1).put("music", "MINECRAFT_THEME");
		tmp = new HashMap<String, Object>();
		worldRegions.get(1).put("min", tmp);
		tmp.put("x", 50);
		tmp.put("y", 0);
		tmp.put("z", -5);
		tmp = new HashMap<String, Object>();
		worldRegions.get(1).put("max", tmp);
		tmp.put("x", 60);
		tmp.put("y", 127);
		tmp.put("z", 10);

		config.setProperty("regions.world", worldRegions);

		config.setProperty("player.Fugos.cape",
		"http://llamaslayers.net/cupcape.png");
		config.setProperty("player.Fugos.title",
		"Fugos\nThe Great");

		config.save();
		}

	}}
	
	
	
	
	
	
