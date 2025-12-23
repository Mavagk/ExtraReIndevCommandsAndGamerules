package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mavagk.extrareindevcommandsandgamerules.ModGamerules;

import net.minecraft.client.Minecraft;
import net.minecraft.common.block.container.SlotIncinerator;
import net.minecraft.common.item.ItemStack;

@Mixin(SlotIncinerator.class)
public class MixinSlotIncinerator {
	@Inject(method = "isItemValid", at = @At("HEAD"), cancellable = true)
	private void isItemValid(ItemStack is, CallbackInfoReturnable<Boolean> info) {
		if (!ModGamerules.doItemSlotRestrictions.getBoolean(Minecraft.theMinecraft.theWorld.getSaveHandler())) {
			info.setReturnValue(true);
		}
	}
}
