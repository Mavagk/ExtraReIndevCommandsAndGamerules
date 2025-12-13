package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mavagk.extrareindevcommandsandgamerules.ExtraReIndevCommandsAndGamerules;

import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.item.ItemStack;
import net.minecraft.common.item.children.ItemFood;
import net.minecraft.common.world.World;

@Mixin(ItemFood.class)
public class MixinItemFood {
	private boolean alwaysEdible;
	public int healAmount;

	@Inject(method = "onItemRightClick", at = @At("HEAD"), cancellable = true)
	@SuppressWarnings("unused")
	private void onItemRightClick(ItemStack item, World world, EntityPlayer player, CallbackInfoReturnable<ItemStack> info) {
		if (ExtraReIndevCommandsAndGamerules.allowInstantEating.getBoolean(world.getSaveHandler())) {
			if (player.canEat(this.alwaysEdible))
				((ItemFood)(Object)this).onEaten(item, world, player);
			info.setReturnValue(item);
		}
	}
}
