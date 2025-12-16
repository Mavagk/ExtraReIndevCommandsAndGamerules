package com.mavagk.extrareindevcommandsandgamerules.command;

import java.util.List;
import java.util.Vector;

import net.minecraft.common.command.Command;
import net.minecraft.common.command.CommandEntitySelector;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.stats.StatCollector;
import net.minecraft.common.util.ChatColors;

public class SurvivalCommand extends Command {
	public SurvivalCommand() {
		super("survival", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		List<EntityPlayer> players = null;
		// Get players
		if (args.length > 2) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		if (args.length == 1) {
			players = new Vector<EntityPlayer>();
			if (commandExecutor.isPlayer())
				players.add(commandExecutor.getPlayerEntity());
			else {
				commandExecutor.log(StatCollector.translateToLocal("command.noConsole"));
				return;
			}
		}
		if (args.length == 2) {
			players = CommandEntitySelector.selectPlayers(commandExecutor, args[1]);
		}
		// Set gamemode
		int gamemodesChanged = 0;
		for (EntityPlayer player : players) {
			boolean wasSuccessful = player.changeGamemode(0);
			if (wasSuccessful) {
				player.addChatMessage("command.gamemode.changed");
				gamemodesChanged++;
			}
			else if (players.size() == 1) {
				if (wasSuccessful)
					commandExecutor.sendNoticeToOps("Setting " + player.username + " to survival mode");
				else
					commandExecutor.log(player.username + " if already in survival mode");
			}
		}
		if (players.size() > 1) {
			commandExecutor.sendNoticeToOps("Changed the gamemode of " + gamemodesChanged + " players");
		}
		if (players.size() == 0) {
			commandExecutor.log("No players selected");
		}
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.survival.info0");
		commandExecutor.log("command.extrareindevcommandsandgamerules.survival.info1");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/survival [players]";
	}
}
