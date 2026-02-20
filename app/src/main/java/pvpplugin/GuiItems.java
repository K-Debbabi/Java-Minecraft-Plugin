package pvpplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public final class GuiItems {
    private final NamespacedKey menuSwordKey;

    public GuiItems(PVPPlugin plugin) {
        this.menuSwordKey = new NamespacedKey(plugin, "menu_sword");
    }

    public ItemStack createMenuSword() {
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = sword.getItemMeta();
        meta.displayName(Component.text("Menu Sword"));
        meta.getPersistentDataContainer().set(menuSwordKey, PersistentDataType.BYTE, (byte) 1);
        sword.setItemMeta(meta);
        return sword;
    }

    public boolean isMenuSword(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        Byte val = item.getItemMeta().getPersistentDataContainer().get(menuSwordKey, PersistentDataType.BYTE);
        return val != null && val == 1;
    }
}
