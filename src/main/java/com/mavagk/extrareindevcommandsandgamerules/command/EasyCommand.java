package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.client.Minecraft;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.util.ChatColors;

public class EasyCommand extends ModCommand {
	public EasyCommand() {
		super("easy", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Set difficulty and report
		Minecraft.theMinecraft.gameSettings.difficulty = 1;
		commandExecutor.log("command.extrareindevcommandsandgamerules.easy.execute");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.easy.info");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/easy";
	}
}
