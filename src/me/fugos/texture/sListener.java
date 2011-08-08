package me.fugos.texture;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.util.config.Configuration;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.event.spout.SpoutListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class sListener extends SpoutListener{
	
	public boolean Dtod, isinConfig;
	public static Configuration config;
	
	public void onSpoutCraftEnable(SpoutCraftEnableEvent event, World world, SpoutPlayer splayer) {
        if(event.getPlayer().isSpoutCraftEnabled()) {
        	String WorldUrl = config.getString(
    				"texturepack." + world.getName());
    				String DefaultUrl = config.getString("texturepack.default");
    		if (WorldUrl != null) {
    		event.getPlayer().setTexturePack(TexturedSpout.config.getProperty("config.texturepack." +  world.getName()).toString());
    	}	if (WorldUrl == null){
    		config.setProperty("config.texturepack." + world.getName(), "http://dl.dropbox.com/u/32889036/Exodus%20Minecraft%20Pack.zip");
    	     config.save();
    	     	if (Dtod == false)
    			splayer.sendMessage( ChatColor.RED + "A Texture Pack is not set for this world!" );
    	     	if (Dtod == true)
    			splayer.setTexturePack(DefaultUrl); }}
	  //else 
		//doWorldActions(event.getPlayer().getWorld(), null, null);
		
	}
	
	
	
	
	
	public void doWorldActions(World world, SpoutPlayer splayer,Configuration config, SpoutCraftEnableEvent event) {
		String WorldUrl = config.getString(
				"texturepack." + world.getName());
				String DefaultUrl = config.getString("texturepack.default");
		if (WorldUrl != null) {
		event.getPlayer().setTexturePack(TexturedSpout.config.getProperty("config.texturepack").toString());
	}	if (WorldUrl == null){
		config.setProperty("config.texturepack." + world.getName(), "http://dl.dropbox.com/u/32889036/Exodus%20Minecraft%20Pack.zip");
	     config.save();
	     	if (Dtod == false)
			splayer.sendMessage( ChatColor.RED + "A Texture Pack is not set for this world!" );
	     	if (Dtod == true)
			splayer.setTexturePack(DefaultUrl);
	}
			
	
	
	}


	
}
