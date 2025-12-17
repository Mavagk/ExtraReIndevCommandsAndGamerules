package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mavagk.extrareindevcommandsandgamerules.ModGamerules;

import net.minecraft.common.entity.Entity;
import net.minecraft.common.entity.data.DamageType;
import net.minecraft.common.entity.monsters.EntityCreeper;

@Mixin(EntityCreeper.class)
public class MixinEntityCreeper {
	@Inject(method = "onDeath", at = @At("HEAD"), cancellable = true)
	private void onDeath(Entity source, DamageType damage_type, CallbackInfo info) {
		EntityCreeper patching = (EntityCreeper)(Object)this;
		if (ModGamerules.doCreeperDeathExplosions.getBoolean(patching.worldObj.getSaveHandler())) {
			patching.worldObj.createExplosion(patching, patching.posX, patching.posY, patching.posZ, 3.0F);
		}
	}
}
