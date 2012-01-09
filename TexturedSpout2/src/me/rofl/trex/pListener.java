package me.rofl.trex;

import java.util.logging.Logger;

import me.rofl.trex.TexturedSpout2;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class pListener extends PlayerListener {
	
	protected final static Logger log = Logger
			.getLogger("Minecraft.TexturedSpout");
	Logger console = Logger.getLogger("Minecraft");

	public static TexturedSpout2 plugin; public pListener(TexturedSpout2 instance) {
		plugin = instance;
		}
	
	public void onPlayerJoin(PlayerJoinEvent event, SpoutPlayer splayer) {
		console.info("[TexturedSpout2] getting player join info");
		Player player = event.getPlayer();
		String worldName = getPlayerWorldName(player);
		String path = "Worlds." + worldName;
		String worldPack = Config.getConfigString(path);
		setTexturePack(splayer, worldPack);
	}
		
	public void onPlayerRespawn(PlayerRespawnEvent event, SpoutPlayer splayer) {
		console.info("[TexturedSpout2] getting player respawn info");
		Player player = event.getPlayer();
		String worldName = getPlayerWorldName(player);
		String path = "Worlds." + worldName;
		String worldPack = Config.getConfigString(path);
		setTexturePack(splayer, worldPack);
	}
	
	public void onPlayerTeleport(PlayerTeleportEvent event, SpoutPlayer splayer) {
		console.info("[TexturedSpout2] getting player teleport info");
		Player player = event.getPlayer();
		String worldName = getPlayerWorldName(player);
		String path = "Worlds." + worldName;
		String worldPack = Config.getConfigString(path);
		setTexturePack(splayer, worldPack);
	}
	
	public void onPlayerPortal(PlayerPortalEvent event, SpoutPlayer splayer) {
		console.info("[TexturedSpout2] getting player portal info");
		Player player = event.getPlayer();
		String worldName = getPlayerWorldName(player);
		String path = "Worlds." + worldName;
		String worldPack = Config.getConfigString(path);
		setTexturePack(splayer, worldPack);
	}
	
	
	private String getPlayerName(Player player){
		String name = player.getName();
		return name;
	}
	
	private World getPlayerWorld(Player player){
		World world = player.getWorld();
		return world;
	}
	
	private String getPlayerWorldName(Player player){
		String worldname = player.getWorld().getName();
		return worldname;
	}
	
	private Location getPlayerLocation(Player player){
		Location loc = player.getLocation();
		return loc;
	}

	private void setTexturePack(SpoutPlayer splayer, String worldPack){
		if (worldPack != null || worldPack != " "){
		console.info("[TexturedSpout2] setting texturepack");
		splayer.setTexturePack(worldPack);
		}
	}
	public void onSpoutCraftEnabled(World world, SpoutPlayer splayer) {
		console.info("[TexturedSpout2] getting spoutcraft enabled info");
		String worldName = world.getName();
		String path = "Worlds." + worldName;
		String worldPack = Config.getConfigString(path);
		console.info("[TexturedSpout2] the path is" + path);
		console.info("[TexturedSpout2] the pat is" + worldPack);
		setTexturePack(splayer, worldPack);
		
	}
	}
