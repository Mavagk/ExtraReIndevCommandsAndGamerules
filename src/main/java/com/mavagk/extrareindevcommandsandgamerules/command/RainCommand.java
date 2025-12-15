package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.common.command.Command;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.networking.Packet;
import net.minecraft.common.networking.Packet70Bed;
import net.minecraft.common.util.ChatColors;
import net.minecraft.common.world.WorldInfo;

public class RainCommand extends Command {
	public RainCommand() {
		super("rain", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Set weather and report
		WorldInfo world_info = commandExecutor.getWorld().getWorldInfo();
		world_info.setRaining(true);
		world_info.setThundering(false);
		commandExecutor.sendPacket(ICommandListener.Scope.OVERWORLD, (Packet)new Packet70Bed(5, 0), (EntityPlayer[])null);
		commandExecutor.log("command.weather.rain");
		commandExecutor.sendNoticeToOps("Setting weather to rain");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.rain.info0");
		commandExecutor.log("command.extrareindevcommandsandgamerules.rain.info1");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/rain";
	}
}
