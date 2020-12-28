package dev.efnilite.witp;

import dev.efnilite.witp.util.Verbose;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class WITPAPI {

    private WITPAPI() throws IllegalAccessException {
        throw new IllegalAccessException("Initializing API class");
    }

    /**
     * Registers a player and makes a player join the world
     *
     * @param   player
     *          The player
     *
     * @return The registered version of the player, even if the player is already registered
     * @throws  IOException
     *          If something goes wrong with reading the player's file
     */
    public static @NotNull ParkourPlayer registerPlayer(@NotNull Player player) throws IOException {
        return ParkourPlayer.register(player);
    }

    /**
     * Unregisters a player and kicks the player from the world (or sends them back to the server assigned in config.yml)
     * @see #unregisterPlayer(ParkourPlayer)
     *
     * @param   player
     *          The Bukkit version of the player
     *
     * @throws IOException If saving the file of the player goes wrong
     */
    public static void unregisterPlayer(@NotNull Player player) throws IOException {
        ParkourPlayer pp = ParkourPlayer.getPlayer(player);
        if (pp == null) {
            Verbose.error("Player " + player.getName() + " isn't registered!");
            return;
        }
        ParkourPlayer.unregister(pp);
    }

    /**
     * Unregisters a player and kicks the player from the world (or sends them back to the server assigned in config.yml)
     * @see #unregisterPlayer(Player)
     *
     * @param   player
     *          The player
     *
     * @throws IOException If saving the file of the player goes wrong
     */
    public static void unregisterPlayer(@NotNull ParkourPlayer player) throws IOException {
        ParkourPlayer.unregister(player);
    }

    /**
     * Gets a player
     * @see ParkourPlayer
     *
     * @param   player
     *          The Bukkit version of the player
     *
     * @return the {@link ParkourPlayer} version of the player
     */
    public static @Nullable ParkourPlayer getPlayer(Player player) {
        return ParkourPlayer.getPlayer(player);
    }
}
