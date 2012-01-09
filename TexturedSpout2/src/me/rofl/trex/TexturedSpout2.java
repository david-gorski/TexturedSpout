package me.rofl.trex;

import java.util.List;
import java.util.logging.Logger;

import me.rofl.trex.TexturedSpout2;
import me.rofl.trex.pListener;
import me.rofl.trex.Config;

import org.bukkit.World;
import org.bukkit.event.CustomEventListener;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;

public class TexturedSpout2 extends JavaPlugin {
	public static Plugin plugin;
	public static TexturedSpout2 instance;
	public static pListener playerListener;
	
	protected final static Logger log = Logger
			.getLogger("Minecraft.TexturedSpout");
	Logger console = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		plugin = this;
		List<World> worlds = TexturedSpout2.plugin.getServer().getWorlds();
		Config.loadConfiguration(worlds);
		
	    playerListener = new pListener(this);
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_TELEPORT, playerListener, Event.Priority.Low, this);
		pm.registerEvent(Event.Type.PLAYER_PORTAL, playerListener, Event.Priority.Low, this);
		pm.registerEvent(Event.Type.PLAYER_RESPAWN, playerListener, Event.Priority.Low, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, new CustomEventListener() {
			@Override
			public void onCustomEvent(Event _event) {
				if (_event instanceof SpoutCraftEnableEvent) {
					SpoutCraftEnableEvent event = (SpoutCraftEnableEvent) _event;
					playerListener.onSpoutCraftEnabled(event.getPlayer()
							.getWorld(), event.getPlayer());
				}
			}
	}, Event.Priority.Normal, this);
		
		console.info("[TexturedSpout2] has been enabled!");
		
	}
	public void onDisable() {
		console.info("[TexturedSpout2] has been disabled!");
	}
}
