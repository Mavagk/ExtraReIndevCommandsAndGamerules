package com.mavagk.extrareindevcommandsandgamerules.command;

import java.util.Collections;
import java.util.List;

import net.minecraft.common.command.CommandEntitySelector;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.entity.Entity;
import net.minecraft.common.util.ChatColors;

public class OriginCommand extends ModCommand {
	public OriginCommand() {
		super("origin", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// Get entities to effect
		List<? extends Entity> selectedEntities;
		if (args.length < 2) {
			if (!commandExecutor.isPlayer()) {
				CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
				return;
			} 
			selectedEntities = Collections.singletonList(commandExecutor.getPlayerEntity());
		}
		else if (args.length == 2) {
			selectedEntities = CommandEntitySelector.selectEntities(commandExecutor, args[1]);
		}
		else {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Teleport entities
		for (Entity entity: selectedEntities) {
			entity.teleportTo(0, 150, 0, 0, 0);
		} 
		commandExecutor.sendNoticeToOps("Teleported " + selectedEntities.size() + " entities!");
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.origin.info");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/origin [player/entities]";
	}
}
