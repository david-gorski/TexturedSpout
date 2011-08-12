package me.fugos.texture;

import org.bukkit.World;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;
import me.fugos.texture.Config;
import me.fugos.texture.TexturedSpout;


public class pListener extends PlayerListener{

public static TexturedSpout plugin; public pListener(TexturedSpout instance) {
plugin = instance;
}

@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		doWorldBasedActions(event.getPlayer().getWorld(),
				SpoutManager.getPlayer(event.getPlayer()));
/*		Bukkit.getServer()
		.getScheduler()
		.scheduleSyncDelayedTask(TexturedSpout.instance,
				new TSPlayerTask(event.getPlayer().getName(), this), 1);
*/
}
	@Override
	public void onPlayerTeleport(PlayerTeleportEvent event) {
//		if (event.getFrom().getWorld() != event.getTo().getWorld()) {
			doWorldBasedActions(event.getTo().getWorld(),
					SpoutManager.getPlayer(event.getPlayer()));
		}
	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		doWorldBasedActions(event.getPlayer().getWorld(),
				SpoutManager.getPlayer(event.getPlayer()));
		/*		Bukkit.getServer()
		.getScheduler()
		.scheduleSyncDelayedTask(TexturedSpout.instance,
				new TSPlayerTask(event.getPlayer().getName(), this), 1);
*/
}
	@Override
	public void onPlayerPortal(PlayerPortalEvent event) {
	//	if (event.getFrom().getWorld() != event.getTo().getWorld());
			doWorldBasedActions(event.getTo().getWorld(),
					SpoutManager.getPlayer(event.getPlayer()));
	/*		Bukkit.getServer()
	.getScheduler()
	.scheduleSyncDelayedTask(TexturedSpout.instance,
			new TSPlayerTask(event.getPlayer().getName(), this), 1);
*/
}
/*	private static class TSPlayerTask implements Runnable {
		private final String playerName;
		private final pListener listener;

		public TSPlayerTask(String playerName, pListener listener) {
			this.playerName = playerName;
			this.listener = listener;
}

		@Override
		public void run() {
			Player player = Bukkit.getServer().getPlayer(playerName);
			if (player != null) {
				//listener.doPlayerBasedActions();
				SpoutPlayer splayer = SpoutManager.getPlayer(player);
*/			
	public void doWorldBasedActions(World world, SpoutPlayer splayer) {
		String worldName = splayer.getWorld().getName();
		String worldPack = Config.getWorldPack(worldName);
				if (worldPack != null && worldPack != "") {
				try {
				splayer.setTexturePack(worldPack);
				} catch (IllegalArgumentException ex) {
				TexturedSpout.log
				.severe("[TexturedSpout] Error with texture pack for world "
				+ splayer.getWorld().getName()
				+ " : "
				+ ex.getMessage());
				}
			}
		}
}