package pvpplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.event.block.Action.*;

public final class MenuListener implements Listener {
    private final GuiItems guiItems;
    private final MenuGui menuGui;

    public MenuListener(GuiItems guiItems, MenuGui menuGui) {
        this.guiItems = guiItems;
        this.menuGui = menuGui;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        // left or right click in air / block
        if (!(event.getAction() == LEFT_CLICK_AIR
                || event.getAction() == LEFT_CLICK_BLOCK
                || event.getAction() == RIGHT_CLICK_AIR
                || event.getAction() == RIGHT_CLICK_BLOCK)) {
            return;
        }

        ItemStack item = event.getItem();
        if (!guiItems.isMenuSword(item)) return;

        event.setCancelled(true); // prevents breaking/attacking with it when opening GUI

        Player player = event.getPlayer();
        player.openInventory(menuGui.create());
    }
}
