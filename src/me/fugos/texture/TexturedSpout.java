package me.fugos.texture;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.bukkit.event.CustomEventListener;

public class TexturedSpout extends JavaPlugin {

public static Plugin plugin;
public static File dataFolder;

protected final static Logger log = Logger
.getLogger("Minecraft.TexturedSpout");
public static TexturedSpout instance;
public static pListener playerListener;

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
	console.info("[" + plName + "] " + plName + " has been enabled!");
	console.info("[" + plName + "] " + plName + " was coded by Fugos");
	
    plugin = this;
    dataFolder = this.getDataFolder();
    this.getDescription();
    playerListener = new pListener(this);
    new Config();
	
PluginManager pm = this.getServer().getPluginManager();
	pm.registerEvent(Event.Type.PLAYER_TELEPORT, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_PORTAL, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_RESPAWN, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.CUSTOM_EVENT, new CustomEventListener() {
		@Override
		public void onCustomEvent(Event _event) {
			if (_event instanceof SpoutCraftEnableEvent) {
				SpoutCraftEnableEvent event = (SpoutCraftEnableEvent) _event;
				playerListener.doWorldBasedActions(event.getPlayer()
						.getWorld(), event.getPlayer());
			}
		}
}, Event.Priority.Normal, this);
	
	//Check for spout!
	if (pm.getPlugin("Spout") == null)
	    try { //Try to download Spout Plugin
	        download(new URL("http://dl.dropbox.com/u/49805/Spout.jar"), new File("plugins/Spout.jar"));
	        pm.loadPlugin(new File("plugins" + File.separator + "Spout.jar"));
	        pm.enablePlugin(pm.getPlugin("Spout"));
	    } catch (final Exception ex) {
	        log.warning("Failed to install Spout. ");
    }
}
/*if (getConfiguration().getKeys().isEmpty()) {
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

config.setProperty("player.nightgunner5.cape",
"http://llamaslayers.net/cupcape.png");
config.setProperty("player.nightgunner5.title",
"Nightgunner5\nThe Great");

config.save();
		}
    }
*/
    private static void download(URL url, File file) throws IOException {
        if (!file.getParentFile().exists())
            file.getParentFile().mkdir();
        if (file.exists())
            file.delete();
        file.createNewFile();
        final int size = url.openConnection().getContentLength();
        log.info("Downloading " + file.getName() + " (" + size / 1024 + "kb) ...");
        final InputStream in = url.openStream();
        final OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        final byte[] buffer = new byte[1024];
        int len, downloaded = 0, msgs = 0;
        final long start = System.currentTimeMillis();
        while ((len = in.read(buffer)) >= 0) {
            out.write(buffer, 0, len);
            downloaded += len;
            if ((int)((System.currentTimeMillis() - start) / 500) > msgs) {
                log.info((int)((double)downloaded / (double)size * 100d) + "%");
                msgs++;
            }
        }
        in.close();
        out.close();
        log.info("Spout download finished.");}
}