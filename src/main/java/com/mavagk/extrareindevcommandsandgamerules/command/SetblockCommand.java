package com.mavagk.extrareindevcommandsandgamerules.command;

import org.jetbrains.annotations.Nullable;

import net.minecraft.common.command.Command;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.util.ChatColors;
import net.minecraft.common.util.math.Vec3D;
import net.minecraft.common.world.World;

public class SetblockCommand extends Command {
	public SetblockCommand() {
		super("setblock", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// Get arguments
		if (args.length != 2 && args.length != 3 && args.length != 5 && args.length != 6) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		@Nullable String xString = null;
		@Nullable String yString = null;
		@Nullable String zString = null;
		String idString = null;
		@Nullable String metadataString = null;
		if (args.length == 2) {
			if (!commandExecutor.isPlayer()) {
				CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
				return;
			}
			idString = args[1];
		}
		if (args.length == 3) {
			if (!commandExecutor.isPlayer()) {
				CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
				return;
			}
			idString = args[1];
			metadataString = args[2];
		}
		if (args.length == 5) {
			xString = args[1];
			yString = args[2];
			zString = args[3];
			idString = args[4];
		}
		if (args.length == 6) {
			xString = args[1];
			yString = args[2];
			zString = args[3];
			idString = args[4];
			metadataString = args[5];
		}
		// Get position
		int x;
		int y;
		int z;
		if (commandExecutor.isPlayer()) {
			Vec3D relativeTo = commandExecutor.getPosition();
			try {
				if (xString == null || xString.equals("~")) x = 0;
				else x = Integer.parseInt(xString.replace("~", ""));
				if (yString == null || yString.equals("~")) y = 0;
				else y = Integer.parseInt(yString.replace("~", ""));
				if (zString == null || zString.equals("~")) z = 0;
				else z = Integer.parseInt(zString.replace("~", ""));
			}
			catch (NumberFormatException e) {
				commandExecutor.log("command.extrareindevcommandsandgamerules.invalidInt");
				return;
			}
			if (xString == null || xString.startsWith("~")) x += (int)relativeTo.xCoord;
			if (yString == null || yString.startsWith("~")) y += (int)relativeTo.yCoord;
			if (zString == null || zString.startsWith("~")) z += (int)relativeTo.zCoord;
		}
		else {
			try {
				x = Integer.parseInt(xString);
				y = Integer.parseInt(yString);
				z = Integer.parseInt(zString);
			}
			catch (NumberFormatException e) {
				commandExecutor.log("command.extrareindevcommandsandgamerules.invalidInt");
				return;
			}
		}
		// Get block ID
		int blockId;
		@Nullable Integer metadataValue = null;
		try {
			blockId = Integer.parseInt(idString);
			if (metadataString != null) metadataValue = Integer.parseInt(metadataString);
		}
		catch (NumberFormatException e) {
			commandExecutor.log("command.extrareindevcommandsandgamerules.invalidInt");
			return;
		}
		// Set block
		World world = commandExecutor.getWorld();
		if (blockId < 0) {
			commandExecutor.log("command.extrareindevcommandsandgamerules.invalidInt");
			return;
		}
		if (metadataValue == null) world.setBlock(x, y, z, blockId);
		else world.setBlockAndMetadata(x, y, z, blockId, metadataValue);

		commandExecutor.log("command.extrareindevcommandsandgamerules.setblock.execute");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.setblock.info");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/setblock [<x> <y> <z>] <id> [metadata]";
	}

}
