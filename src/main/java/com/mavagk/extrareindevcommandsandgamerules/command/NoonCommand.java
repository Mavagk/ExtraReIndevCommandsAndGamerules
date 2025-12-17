package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.util.ChatColors;

public class NoonCommand extends ModCommand {
	public NoonCommand() {
		super("noon", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Set time and report
		commandExecutor.getWorld().setTimeViaCommand(6000L);
		commandExecutor.log("command.time.noon");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.noon.info0");
		commandExecutor.log("command.extrareindevcommandsandgamerules.noon.info1");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/noon";
	}
}
