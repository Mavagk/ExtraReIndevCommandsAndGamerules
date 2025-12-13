package com.mavagk.extrareindevcommandsandgamerules;

import net.minecraft.common.command.Command;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.util.ChatColors;

public class OriginCommand extends Command {
	public OriginCommand() {
		super("origin", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		if (!commandExecutor.isPlayer()) {
			commandExecutor.log("§aMust execute as a player.");
		}
		commandExecutor.getPlayerEntity().teleportTo(0, 150, 0, 0, 0);
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/origin";
	}
}
