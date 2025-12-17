package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mavagk.extrareindevcommandsandgamerules.ModGamerules;

import net.minecraft.common.world.World;

@Mixin(World.class)
public class MixinWorld {
	@Inject(method = "tick", at = @At("TAIL"), cancellable = true)
	private void tick(CallbackInfo info) {
		if (!ModGamerules.doDaylightCycle.getBoolean(((World)(Object)this).getSaveHandler())) {
			long worldTime = ((World)(Object)this).getWorldTime() - 1L;
			((World)(Object)this).setWorldTime(worldTime);
		}
	}
}
