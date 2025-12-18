package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mavagk.extrareindevcommandsandgamerules.ModGamerules;

import net.minecraft.client.Minecraft;
import net.minecraft.common.entity.EntityLiving;
import net.minecraft.common.entity.player.EntityPlayer;

@Mixin(EntityLiving.class)
public class MixinEntityLiving {
	@Inject(method = "drown", at = @At("HEAD"), cancellable = true)
	private void drown(CallbackInfo info) {
		if ((((Object)this) instanceof EntityPlayer) && !ModGamerules.doPlayerDrowningDamage.getBoolean(Minecraft.theMinecraft.theWorld.getSaveHandler())) {
			info.cancel();
		}
	}
}
