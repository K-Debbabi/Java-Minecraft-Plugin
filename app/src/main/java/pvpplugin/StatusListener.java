package pvpplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class StatusListener implements Listener {
    private final StatusManager statusManager;

    public StatusListener(StatusManager statusManager) {
        this.statusManager = statusManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        statusManager.set(e.getPlayer().getUniqueId(), PlayerStatus.ONLINE);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        statusManager.set(e.getPlayer().getUniqueId(), PlayerStatus.OFFLINE);
    }
}
