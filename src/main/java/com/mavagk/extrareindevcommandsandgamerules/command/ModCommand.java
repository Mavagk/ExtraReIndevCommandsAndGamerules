package com.mavagk.extrareindevcommandsandgamerules.command;

import org.jetbrains.annotations.Nullable;

import net.minecraft.common.block.Block;
import net.minecraft.common.block.Blocks;
import net.minecraft.common.command.Command;
import net.minecraft.common.command.ICommandListener;
import net.minecraft.common.command.IllegalCmdListenerOperation;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.world.chunk.ChunkCoordinates;

public abstract class ModCommand extends Command {
	public ModCommand(String name, boolean opOnly, boolean isHidden) {
		super(name, opOnly, isHidden);
	}

	/// Returns `coordinateString` parsed to an integer. Allows `coordinateString` to start with a `~` char to make it relativeTo to `relativeTo` if it is not null. Returns null if there is an error.
	protected @Nullable Integer parseRelativeBlockCoordinate(@Nullable String coordinateString, @Nullable Integer relativeTo) {
		try {
			if (coordinateString == null && relativeTo == null) return null;
			if (coordinateString == null) return relativeTo;
			if (relativeTo == null || !coordinateString.startsWith("~")) return Integer.parseInt(coordinateString);
			if (coordinateString.length() == 1) return relativeTo;
			return Integer.parseInt(coordinateString.substring(1)) + relativeTo;
		}
		catch (NumberFormatException e) {
			return null;
		}
	}

	protected @Nullable Integer parseRelativeBlockCoordinateX(@Nullable String coordinateString, ICommandListener commandExecutor) {
		if (!(commandExecutor instanceof EntityPlayer)) parseRelativeBlockCoordinate(coordinateString, null);
		try {
			return parseRelativeBlockCoordinate(coordinateString, (int)(commandExecutor.getPosition().xCoord));
		}
		catch (IllegalCmdListenerOperation e) {
			return null;
		}
	}

	protected @Nullable Integer parseRelativeBlockCoordinateY(@Nullable String coordinateString, ICommandListener commandExecutor) {
		if (!(commandExecutor instanceof EntityPlayer)) parseRelativeBlockCoordinate(coordinateString, null);
		try {
			return parseRelativeBlockCoordinate(coordinateString, (int)(commandExecutor.getPosition().yCoord));
		}
		catch (IllegalCmdListenerOperation e) {
			return null;
		}
	}

	protected @Nullable Integer parseRelativeBlockCoordinateZ(@Nullable String coordinateString, ICommandListener commandExecutor) {
		if (!(commandExecutor instanceof EntityPlayer)) parseRelativeBlockCoordinate(coordinateString, null);
		try {
			return parseRelativeBlockCoordinate(coordinateString, (int)(commandExecutor.getPosition().zCoord));
		}
		catch (IllegalCmdListenerOperation e) {
			return null;
		}
	}

	protected @Nullable Integer parseBlockId(@Nullable String idString) {
		try {
			int parsedValue = Integer.parseInt(idString);
			if (parsedValue < 0 || parsedValue >= Blocks.BLOCK_LIMIT) return null;
			return parsedValue;
		}
		catch (NumberFormatException e) {
			for (int id = 0; id < Blocks.BLOCK_LIMIT; id++) {
				@Nullable Block block = Blocks.BLOCKS_LIST[id];
				if (block == null) continue;
				@Nullable String name = block.getBlockName();
				if (name == null) continue;
				if (name.equals(idString)) return block.blockID;
				if (name.startsWith("tile.") && name.substring(5).equals(idString)) return block.blockID;
			}
			return null;
		}
	}

	protected @Nullable Integer parseBlockMetadata(@Nullable String metadataString) {
		try {
			int parsedValue = Integer.parseInt(metadataString);
			if (parsedValue < 0 || parsedValue > 15) return null;
			return parsedValue;
		}
		catch (NumberFormatException e) {
			return null;
		}
	}

	protected String formatCoordinates(int x, int y, int z) {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	protected String formatCoordinates(ChunkCoordinates coordinates) {
		return formatCoordinates(coordinates.x, coordinates.y, coordinates.z);
	}
}
