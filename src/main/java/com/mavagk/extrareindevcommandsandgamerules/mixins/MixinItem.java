package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mavagk.extrareindevcommandsandgamerules.ExtraReIndevCommandsAndGamerules;

import net.minecraft.client.Minecraft;
import net.minecraft.common.item.Item;
import net.minecraft.common.item.children.ItemFood;

@Mixin(Item.class)
public class MixinItem {
	@Inject(method = "getItemStackLimit", at = @At("HEAD"), cancellable = true)
	@SuppressWarnings("unused")
	private void getItemStackLimit(CallbackInfoReturnable<Integer> info) {
		if (!ExtraReIndevCommandsAndGamerules.allowFoodStacking.getBoolean(Minecraft.theMinecraft.theWorld.getSaveHandler()) && ((Item)(Object)this) instanceof ItemFood) {
			info.setReturnValue(1);
		}
	}
}
