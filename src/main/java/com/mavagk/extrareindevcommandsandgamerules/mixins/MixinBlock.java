package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mavagk.extrareindevcommandsandgamerules.ModGamerules;

import net.minecraft.common.block.Block;
import net.minecraft.common.world.World;

@Mixin(Block.class)
public class MixinBlock {
	@Inject(method = "dropBlockAsItemWithChance", at = @At("HEAD"), cancellable = true)
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float chance, CallbackInfo info) {
		if (!ModGamerules.doTileDrops.getBoolean(world.getSaveHandler())) {
			info.cancel();
		}
	}
}
