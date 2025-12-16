package com.mavagk.extrareindevcommandsandgamerules.command;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.jetbrains.annotations.Nullable;

import net.minecraft.common.command.Command;
import net.minecraft.common.command.CommandEntitySelector;
import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.entity.Entity;
import net.minecraft.common.entity.EntityLiving;
import net.minecraft.common.entity.data.DamageTypes;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.stats.StatCollector;
import net.minecraft.common.util.ChatColors;

public class HealCommand extends Command {
	public HealCommand() {
		super("heal", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		List<? extends Entity> selectedEntities = null;
		// Get players
		if (args.length > 3) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		if (args.length == 1) {
			selectedEntities = new Vector<Entity>();
			if (commandExecutor.isPlayer())
				selectedEntities = Collections.singletonList(commandExecutor.getPlayerEntity());
			else {
				commandExecutor.log(StatCollector.translateToLocal("command.noConsole"));
				return;
			}
		}
		if (args.length > 1) {
			selectedEntities = CommandEntitySelector.selectEntities(commandExecutor, args[1]);
		}
		// Get amount to heal
		@Nullable Integer amountToHeal = null;
		if (args.length > 2) {
			try {
				amountToHeal = Integer.parseInt(args[2]);
			}
			catch (NumberFormatException e) {
				commandExecutor.log("command.extrareindevcommandsandgamerules.invalidInt");
				return;
			}
		}
		// Heal players
		int entitiesChanged = 0;
		for (Entity entity : selectedEntities) {
			if (!(entity instanceof EntityLiving)) {
				continue;
			}
			EntityLiving entityLiving = (EntityLiving)entity;
			boolean wasSuccessful = false;
			int oldHealth = entityLiving.health;
			int newHealth;
			if (amountToHeal == null) {
				entityLiving.heal(999999);
				newHealth = entityLiving.health;
			}
			else {
				if (amountToHeal < 0) {
					newHealth = entityLiving.health + amountToHeal;
					if (newHealth < 0)
						newHealth = 0;
					entityLiving.health = newHealth;
					if (newHealth == 0)
						entityLiving.onDeath(null, DamageTypes.GENERIC);
				}
				else {
					entityLiving.heal(amountToHeal);
					newHealth = entityLiving.health;
				}
			}
			if (newHealth != oldHealth) {
				wasSuccessful = true;
			}
			if (wasSuccessful) {
				entitiesChanged++;
				if (entityLiving instanceof EntityPlayer)
					((EntityPlayer)entityLiving).addChatMessage("command.extrareindevcommandsandgamerules.heal.execute");
			}
			else if (entitiesChanged == 1 && (entityLiving instanceof EntityPlayer)) {
				if (wasSuccessful)
					commandExecutor.sendNoticeToOps("Healing " + ((EntityPlayer)entityLiving).username);
				else
					commandExecutor.log("Health not changed");
			}
		}
		if (entitiesChanged > 1) {
			commandExecutor.sendNoticeToOps("Changed the health of " + entitiesChanged + " entities");
		}
		if (entitiesChanged == 0) {
			commandExecutor.log("No entities changed");
		}
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.heal.info");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/heal [entities] [amount]";
	}
}
