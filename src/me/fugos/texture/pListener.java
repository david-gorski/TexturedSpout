package me.fugos.texture;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.fugos.texture.TexturedSpout;


public class pListener extends PlayerListener{
		TexturedSpout plugin;
		
		public players(TexturedSpout plugin){
			this.plugin = plugin;
		}
		
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
		
		
		
}