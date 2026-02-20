package pvpplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class StatusCommand implements CommandExecutor {
    private final StatusManager statusManager;

    public StatusCommand(StatusManager statusManager) {
        this.statusManager = statusManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }
        sender.sendMessage("Your status: " + statusManager.get(player.getUniqueId()));
        sender.sendMessage("Your UUID: " + player.getUniqueId());
        return true;
    }
}