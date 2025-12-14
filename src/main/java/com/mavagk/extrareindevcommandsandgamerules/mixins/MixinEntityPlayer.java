package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mavagk.extrareindevcommandsandgamerules.ModGamerules;

import net.minecraft.client.Minecraft;
import net.minecraft.common.entity.player.EntityPlayer;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {
	@Inject(method = "isExhausted", at = @At("HEAD"), cancellable = true)
	private void isExhausted(CallbackInfoReturnable<Boolean> info) {
		if (!ModGamerules.allowSurvivalSprinting.getBoolean(Minecraft.theMinecraft.theWorld.getSaveHandler())) {
			info.setReturnValue(true);
		}
	}
}
