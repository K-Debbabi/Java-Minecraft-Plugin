package pvpplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public final class MoveListener implements Listener {

    private final StatusManager statusManager;
    private int blocks = 0;

    public MoveListener(StatusManager statusManager) {
        this.statusManager = statusManager;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (event.getTo() == null) return;

        // Only react if the player changed block coordinates
        if (event.getFrom().getBlockX() == event.getTo().getBlockX()
                && event.getFrom().getBlockY() == event.getTo().getBlockY()
                && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) {
            return;
        }

        blocks++;

        PlayerStatus status = statusManager.get(event.getPlayer().getUniqueId());
        event.getPlayer().sendActionBar(
                Component.text("Status: " + status + " | Blocks: " + blocks)
        );
    }
}
