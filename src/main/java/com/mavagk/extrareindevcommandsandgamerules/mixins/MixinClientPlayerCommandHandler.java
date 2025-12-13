package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mavagk.extrareindevcommandsandgamerules.command.OriginCommand;

import net.minecraft.client.Minecraft;
import net.minecraft.client.command.ClientPlayerCommandHandler;
import net.minecraft.common.command.Command;

@Mixin(ClientPlayerCommandHandler.class)
public abstract class MixinClientPlayerCommandHandler {
	@Inject(method = "registerCommands", at = @At("TAIL"), cancellable = true)
	@SuppressWarnings("unused")
	private void registerCommands(Minecraft mc, CallbackInfo info) {
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new OriginCommand());
	}
}
