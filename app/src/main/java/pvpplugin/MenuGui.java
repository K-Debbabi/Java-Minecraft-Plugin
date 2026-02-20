package pvpplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class MenuGui {
    private final Component title = Component.text("My Menu");

    public Inventory create() {
        Inventory inv = Bukkit.createInventory(null, 27, title); // 3 rows

        ItemStack example = new ItemStack(Material.EMERALD);
        ItemMeta meta = example.getItemMeta();
        meta.displayName(Component.text("Example button"));
        example.setItemMeta(meta);

        inv.setItem(9, example);
        return inv;
    }

    public Component title() {
        return title;
    }
}
