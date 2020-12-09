package de.christianschliz.spigotservice.blockhistory;

import de.christianschliz.spigotms.api.SpigotService;
import de.christianschliz.spigotservice.blockhistory.commands.BlockHistoryCommand;

public class BlockHistory extends SpigotService {

    private BlockHistoryCommand blockHistoryCommand;

    @Override
    protected void onEnable() {
        registerCommand("blockhistory", blockHistoryCommand);
    }

    @Override
    protected void onDisable() {

    }

    @Override
    protected void onLoad() {
        blockHistoryCommand = new BlockHistoryCommand(this);
    }

    public void getCqlSession() {
        getPlugin().getDatabaseControllers().datastax().get();
    }
}
