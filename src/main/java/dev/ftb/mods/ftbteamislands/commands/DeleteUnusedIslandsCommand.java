package dev.ftb.mods.ftbteamislands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.ftb.mods.ftbteamislands.islands.IslandsManager;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;

import java.util.Set;
import java.util.UUID;

/**
 * Delete region of island
 */
public class DeleteUnusedIslandsCommand {
    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return Commands.literal("delete")
            .requires(commandSource -> commandSource.hasPermission(2))
            .executes(DeleteUnusedIslandsCommand::execute);
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        ServerLevel level = context.getSource().getServer().getLevel(IslandsManager.getTargetIsland());
        Set<UUID> unclaimedIslands = IslandsManager.get(level).getUnclaimedIslands();
        int islandsToDelete = unclaimedIslands.size();



        return 0;
    }
}
