package pvpplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class MenuClickListener implements Listener {
    private final MenuGui menuGui;

    public MenuClickListener(MenuGui menuGui) {
        this.menuGui = menuGui;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().title().equals(menuGui.title())) {
            event.setCancelled(true); // stop taking items out

            if (event.getCurrentItem() == null) return;

            // Example: clicked slot 13
            if (event.getSlot() == 13) {
                event.getWhoClicked().sendMessage(Component.text("You clicked the button!"));
            }
        }
    }
}
