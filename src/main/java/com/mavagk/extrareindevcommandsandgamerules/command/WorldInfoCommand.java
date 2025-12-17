package com.mavagk.extrareindevcommandsandgamerules.command;

import net.minecraft.common.command.CommandErrorHandler;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.stats.StatCollector;
import net.minecraft.common.util.ChatColors;
import net.minecraft.common.world.World;
import net.minecraft.common.world.WorldInfo;

public class WorldInfoCommand extends ModCommand {
	public WorldInfoCommand() {
		super("worldinfo", true, false);
	}

	@Override
	public void onExecute(String[] args, ICommandListener commandExecutor) throws IllegalCmdListenerOperation {
		// There must not any arguments
		if (args.length > 1) {
			CommandErrorHandler.commandUsageMessage(commandSyntax(), commandExecutor);
			return;
		}
		// Print title
		commandExecutor.log("command.extrareindevcommandsandgamerules.worldinfo.execute");
		// Print variables
		World world = commandExecutor.getWorld();
		WorldInfo worldInfo = world.worldInfo;
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.seed")                         + ": " + worldInfo.getRandomSeed());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.spawn")                        + ": " + formatCoordinates(world.getSpawnPoint()));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.worldTime")                    + ": " + worldInfo.getWorldTime());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.lastTimePlayed")               + ": " + worldInfo.getLastTimePlayed());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.sizeOnDisk")                   + ": " + worldInfo.getSizeOnDisk());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.dimension")                    + ": " + worldInfo.getDimension());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.worldName")                    + ": " + worldInfo.getWorldName());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.saveVersion")                  + ": " + worldInfo.getSaveVersion());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.isRaining")                    + ": " + formatBoolean(worldInfo.getRaining()));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.rainTime")                     + ": " + worldInfo.getRainTime());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.isThundering")                 + ": " + formatBoolean(worldInfo.getThundering()));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.thunderTime")                  + ": " + worldInfo.getThunderTime());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.gamemode")                     + ": " + worldInfo.getGameType());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.generatorType")                + ": " + worldInfo.getGenType());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.isHardcore")                   + ": " + formatBoolean(worldInfo.isHardcoreModeEnabled()));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.areMapFeaturesEnabled")        + ": " + formatBoolean(worldInfo.isMapFeaturesEnabled()));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.areCheatsEnabled")             + ": " + formatBoolean(worldInfo.isCheatsEnabled()));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.highscore")                    + ": " + worldInfo.getHighScore());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.highestChunkOverworld")        + ": " + worldInfo.getHighestChunkOW());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.lowestChunkOverworld")         + ": " + worldInfo.getLowestChunkOW());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.highestChunkNether")           + ": " + worldInfo.getHighestChunkNether());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.lowestChunkNether")            + ": " + worldInfo.getLowestChunkNether());
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.scheduledUpdatesAreImmediate") + ": " + formatBoolean(world.scheduledUpdatesAreImmediate));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.skylightSubtracted")           + ": " + world.skylightSubtracted);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.rainingStrength")              + ": " + world.rainingStrength);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.thunderingStrength")           + ": " + world.thunderingStrength);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.lightningFlash")               + ": " + world.lightningFlash);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.isEditingBlocks")              + ": " + formatBoolean(world.editingBlocks));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.difficulty")                   + ": " + world.difficultySetting);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.isNewWorld")                   + ": " + formatBoolean(world.isNewWorld));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.isFindingSpawnPoint")          + ": " + formatBoolean(world.findingSpawnPoint));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.doDelayTileEntityUpdate")      + ": " + formatBoolean(world.delayTileEntityUpdate));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.isRemote")                     + ": " + formatBoolean(world.isRemote));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.isServer")                     + ": " + formatBoolean(world.isServer));
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.lowestChunk")                  + ": " + world.lowestChunk);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.highestChunk")                 + ": " + world.highestChunk);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.lowestY")                      + ": " + world.lowestY);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.highestY")                     + ": " + world.highestY);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.minimumX")                     + ": " + world.minimumX);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.maximumX")                     + ": " + world.maximumX);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.minimumZ")                     + ": " + world.minimumZ);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.maximumZ")                     + ": " + world.maximumZ);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.worldFolderName")              + ": " + world.worldFolderName);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.floatingIslandHeight")         + ": " + world.floatingIslandHeight);
		commandExecutor.log(StatCollector.translateToLocal("worldinfovar.extrareindevcommandsandgamerules.ticksSinceLastSave")           + ": " + world.ticksSinceLastSave);
	}

	@Override
	public void printHelpInformation(ICommandListener commandExecutor) {
		commandExecutor.log("command.extrareindevcommandsandgamerules.worldinfo.info");
	}

	@Override
	public String commandSyntax() {
		return ChatColors.YELLOW + "/worldinfo";
	}
	
}
