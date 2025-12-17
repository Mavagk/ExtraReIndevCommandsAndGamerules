package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.util.ChatColors;

public class NightCommand extends ModCommand {
	public NightCommand() {
		super("night", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Set time and report
		commandExecutor.getWorld().setTimeViaCommand(15000L);
		commandExecutor.log("command.time.night");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.night.info0");
		commandExecutor.log("command.extrareindevcommandsandgamerules.night.info1");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/night";
	}
}
