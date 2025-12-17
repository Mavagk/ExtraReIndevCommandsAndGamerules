package com.mavagk.extrareindevcommandsandgamerules.command;

import org.jetbrains.annotations.Nullable;

import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.util.ChatColors;
import net.minecraft.common.world.World;

public class SetblockCommand extends ModCommand {
	public SetblockCommand() {
		super("setblock", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// Get arguments and parse
		if (args.length != 2 && args.length != 3 && args.length != 5 && args.length != 6) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		@Nullable Integer x = null;
		@Nullable Integer y = null;
		@Nullable Integer z = null;
		@Nullable Integer id = null;
		@Nullable Integer metadata = null;
		if (args.length == 2 || args.length == 3) {
			x = parseRelativeBlockCoordinateX(null, commandExecutor);
			y = parseRelativeBlockCoordinateY(null, commandExecutor);
			z = parseRelativeBlockCoordinateZ(null, commandExecutor);
			id = parseBlockId(args[1]);
		}
		if (args.length == 3) metadata = parseBlockMetadata(args[2]);
		if (args.length == 5 || args.length == 6) {
			x = parseRelativeBlockCoordinateX(args[1], commandExecutor);
			y = parseRelativeBlockCoordinateY(args[2], commandExecutor);
			z = parseRelativeBlockCoordinateZ(args[3], commandExecutor);
			id = parseBlockId(args[4]);
		}
		if (args.length == 6) metadata = parseBlockMetadata(args[5]);
		// Check for errors while parsing
		if (x == null || y == null || z == null) {
			commandExecutor.log("command.extrareindevcommandsandgamerules.invalidPosition");
			return;
		}
		if (id == null) {
			commandExecutor.log("command.extrareindevcommandsandgamerules.invalidBlockId");
			return;
		}
		if ((args.length == 3 || args.length == 6) && metadata == null) {
			commandExecutor.log("command.extrareindevcommandsandgamerules.invalidMetadata");
			return;
		}
		// Set block
		World world = commandExecutor.getWorld();
		if (metadata == null) world.setBlock(x, y, z, id);
		else world.setBlockAndMetadata(x, y, z, id, metadata);
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
