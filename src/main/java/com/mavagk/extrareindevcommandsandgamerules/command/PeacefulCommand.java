package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.client.Minecraft;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.util.ChatColors;

public class PeacefulCommand extends ModCommand {
	public PeacefulCommand() {
		super("peaceful", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Set difficulty and report
		Minecraft.theMinecraft.gameSettings.difficulty = 0;
		commandExecutor.log("command.extrareindevcommandsandgamerules.peaceful.execute");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.peaceful.info");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/peaceful";
	}
}
