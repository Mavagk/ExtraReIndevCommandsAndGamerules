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
		@Nullable Integer amount_to_heal = null;
		if (args.length > 2) {
			try {
				amount_to_heal = Integer.parseInt(args[2]);
			}
			catch (NumberFormatException e) {
				commandExecutor.log("command.extrareindevcommandsandgamerules.invalidInt");
				return;
			}
		}
		// Heal players
		int entities_changed = 0;
		for (Entity entity : selectedEntities) {
			if (!(entity instanceof EntityLiving)) {
				continue;
			}
			EntityLiving entity_living = (EntityLiving)entity;
			boolean was_successful = false;
			int old_health = entity_living.health;
			int new_health;
			if (amount_to_heal == null) {
				entity_living.heal(999999);
				new_health = entity_living.health;
			}
			else {
				if (amount_to_heal < 0) {
					new_health = entity_living.health + amount_to_heal;
					if (new_health < 0)
						new_health = 0;
					entity_living.health = new_health;
					if (new_health == 0)
						entity_living.onDeath(null, DamageTypes.GENERIC);
				}
				else {
					entity_living.heal(amount_to_heal);
					new_health = entity_living.health;
				}
			}
			if (new_health != old_health) {
				was_successful = true;
			}
			if (was_successful) {
				entities_changed++;
				if (entity_living instanceof EntityPlayer)
					((EntityPlayer)entity_living).addChatMessage("command.extrareindevcommandsandgamerules.execute");
			}
			else if (entities_changed == 1 && (entity_living instanceof EntityPlayer)) {
				if (was_successful)
					commandExecutor.sendNoticeToOps("Healing " + ((EntityPlayer)entity_living).username);
				else
					commandExecutor.log("Health not changed");
			}
		}
		if (entities_changed > 1) {
			commandExecutor.sendNoticeToOps("Changed the health of " + entities_changed + " entities");
		}
		if (entities_changed == 0) {
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
