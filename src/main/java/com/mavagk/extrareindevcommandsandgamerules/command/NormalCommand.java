package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.client.Minecraft;
import net.minecraft.common.command.Command;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.util.ChatColors;

public class NormalCommand extends Command {
	public NormalCommand() {
		super("normal", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Set difficulty and report
		Minecraft.theMinecraft.gameSettings.difficulty = 2;
		commandExecutor.log("command.extrareindevcommandsandgamerules.normal.execute");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.normal.info");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/normal";
	}
}
