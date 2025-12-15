package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mavagk.extrareindevcommandsandgamerules.ModGamerules;

import net.minecraft.common.block.children.BlockBed;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.world.World;

@Mixin(BlockBed.class)
public class MixinBlockBed {
	@Inject(method = "blockActivated", at = @At("HEAD"), cancellable = true)
	private void blockActivated(World world, int x, int y, int z, EntityPlayer player, CallbackInfoReturnable<Boolean> info) {
		if (!ModGamerules.allowSleeping.getBoolean(world.getSaveHandler())) {
			player.addChatMessage("tile.extrareindevcommandsandgamerules.bed.sleepDisabled");
			info.setReturnValue(true);
		}
	}
}
