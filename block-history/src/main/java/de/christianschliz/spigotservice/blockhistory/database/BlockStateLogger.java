package de.christianschliz.spigotservice.blockhistory.database;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.AsyncResultSet;
import de.christianschliz.spigotms.api.database.DatastaxController;
import org.bukkit.block.Block;
import java.util.concurrent.CompletionStage;

public class BlockStateLogger {

    CqlSession session;

    public BlockStateLogger(DatastaxController controller) {
        session = controller.get();
    }

    public void insert(String playerId, Block block, boolean force) {
        insertDatastax(playerId, block, force);
    }

    private void insertDatastax(String playerId, Block block, boolean force) {
        CompletionStage<AsyncResultSet> responseStage = session.executeAsync("SELECT release_version FROM system.local");
        responseStage.whenComplete(((asyncResultSet, throwable) -> {
            if (throwable != null) {
                System.err.println("Could not insert block state change into the database!");
            }
        }));
    }

}
