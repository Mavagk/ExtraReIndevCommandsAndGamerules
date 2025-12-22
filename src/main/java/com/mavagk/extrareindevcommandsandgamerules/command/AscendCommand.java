package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.stats.StatCollector;
import net.minecraft.common.util.ChatColors;
import net.minecraft.common.world.World;

public class AscendCommand extends ModCommand {
	public AscendCommand() {
		super("ascend", true, false, "up");
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// The command must be executed by a player
		if (!commandExecutor.isPlayer()) {
			commandExecutor.log(StatCollector.translateToLocal("command.noConsole"));
			return;
		}
		//
		EntityPlayer player = commandExecutor.getPlayerEntity();
		World world = commandExecutor.getWorld();
		int playerX = (int)Math.floor(player.posX);
		int playerY = (int)player.posY;
		int playerZ = (int)Math.floor(player.posZ);
		boolean lastBlockWasSolid = false;
		boolean lastLastBlockWasSolid = false;
		for (int y = playerY; y < world.highestY; y++) {
			boolean blockIsSolid = world.getBlockMaterial(playerX, y, playerZ).isSolid();
			if (!blockIsSolid && !lastBlockWasSolid && lastLastBlockWasSolid) {
				player.teleportTo(player.posX, y + 0.65, player.posZ, player.rotationYaw, player.rotationPitch);
				commandExecutor.log("command.extrareindevcommandsandgamerules.ascend.execute");
				return;
			}
			lastLastBlockWasSolid = lastBlockWasSolid;
			lastBlockWasSolid = blockIsSolid;
		}
		commandExecutor.log("command.extrareindevcommandsandgamerules.ascend.error");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.ascend.info");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/ascend";
	}
}
