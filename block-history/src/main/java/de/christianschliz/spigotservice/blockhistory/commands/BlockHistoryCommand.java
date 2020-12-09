package de.christianschliz.spigotservice.blockhistory.commands;

import de.christianschliz.spigotservice.blockhistory.BlockHistory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockHistoryCommand implements CommandExecutor {

    private final BlockHistory parent;

    public BlockHistoryCommand(BlockHistory parent) {
        this.parent = parent;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This Command must be executed as a player!");
            return true;
        }

        Player player = (Player) commandSender;

        return false;
    }
}
