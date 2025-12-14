package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mavagk.extrareindevcommandsandgamerules.command.DayCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.NightCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.NoonCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.OriginCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.SunsetCommand;

import net.minecraft.client.Minecraft;
import net.minecraft.client.command.ClientPlayerCommandHandler;
import net.minecraft.common.command.Command;

@Mixin(ClientPlayerCommandHandler.class)
public abstract class MixinClientPlayerCommandHandler {
	@Inject(method = "registerCommands", at = @At("TAIL"), cancellable = true)
	private void registerCommands(Minecraft mc, CallbackInfo info) {
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new OriginCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new DayCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new NoonCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new SunsetCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new NightCommand());
	}
}
