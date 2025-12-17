package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.networking.Packet;
import net.minecraft.common.networking.Packet70Bed;
import net.minecraft.common.util.ChatColors;
import net.minecraft.common.world.WorldInfo;

public class ThunderCommand extends ModCommand {
	public ThunderCommand() {
		super("thunder", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Set weather and report
		WorldInfo worldInfo = commandExecutor.getWorld().getWorldInfo();
		worldInfo.setRaining(true);
		worldInfo.setThundering(true);
		commandExecutor.sendPacket(ICommandListener.Scope.OVERWORLD, (Packet)new Packet70Bed(6, 0), (EntityPlayer[])null);
		commandExecutor.log("command.weather.thunder");
		commandExecutor.sendNoticeToOps("Setting weather to thunder");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.thunder.info0");
		commandExecutor.log("command.extrareindevcommandsandgamerules.thunder.info1");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/thunder";
	}
}
