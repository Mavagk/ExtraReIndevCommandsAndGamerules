package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mavagk.extrareindevcommandsandgamerules.ExtraReIndevCommandsAndGamerules;

import net.minecraft.client.Minecraft;
import net.minecraft.common.entity.player.EntityPlayer;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {
	@Inject(method = "isExhausted", at = @At("HEAD"), cancellable = true)
	@SuppressWarnings("unused")
	private void isExhausted(CallbackInfoReturnable<Boolean> info) {
		if (!ExtraReIndevCommandsAndGamerules.allowSurvivalSprinting.getBoolean(Minecraft.theMinecraft.theWorld.getSaveHandler())) {
			info.setReturnValue(true);
		}
	}
}
