package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.common.command.Command;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.networking.Packet;
import net.minecraft.common.networking.Packet70Bed;
import net.minecraft.common.util.ChatColors;

public class FairCommand extends Command {
	public FairCommand() {
		super("fair", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Set weather and report
		commandExecutor.getWorld().clearWeather();
		commandExecutor.sendPacket(ICommandListener.Scope.OVERWORLD, (Packet)new Packet70Bed(4, 0), (EntityPlayer[])null);
		commandExecutor.log("command.weather.clear");
		commandExecutor.sendNoticeToOps("Clearing weather");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.fair.info0");
		commandExecutor.log("command.extrareindevcommandsandgamerules.fair.info1");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/fair";
	}
}
