package pvpplugin;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public final class PVPPlugin extends JavaPlugin {
    private StatusManager statusManager;

    @Override
    public void onEnable() {

        statusManager = new StatusManager();
        
        getServer().getPluginManager().registerEvents(new StatusListener(statusManager), this);
        getServer().getPluginManager().registerEvents(new MoveListener(statusManager), this);

                GuiItems guiItems = new GuiItems(this);
        MenuGui menuGui = new MenuGui();

        getServer().getPluginManager().registerEvents(new MenuListener(guiItems, menuGui), this);
        getServer().getPluginManager().registerEvents(new MenuClickListener(menuGui), this);

        // quick test: give sword on join (optional)
        getServer().getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
                e.getPlayer().getInventory().addItem(guiItems.createMenuSword());
            }
        }, this);


        
        getLogger().info("PVPPlugin enabled!");
        
        getCommand("test").setExecutor((sender, command, label, args) -> {
        sender.sendMessage("Plugin läuft – /test wurde ausgeführt.");
        return true;
        });

        getCommand("spawn").setExecutor((sender, command, label, args) -> {
            if (!(sender instanceof Player player)) {
                sender.sendMessage("Nur ein Spieler kann /up benutzen.");
                return true;
            }

            Location target = new Location(
                    player.getWorld(),
                    0.5, 90, 0.5,
                    player.getLocation().getYaw(),
                    player.getLocation().getPitch()
            );

            player.teleport(target);
            player.sendMessage("Teleportiert zu spawn");
            return true;
        });

        getCommand("status").setExecutor(new StatusCommand(statusManager));
    }

    @Override
    public void onDisable() {
        getLogger().info("PVPPlugin disabled!");
    }
}
