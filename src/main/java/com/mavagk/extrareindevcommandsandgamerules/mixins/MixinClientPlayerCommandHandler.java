package com.mavagk.extrareindevcommandsandgamerules.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mavagk.extrareindevcommandsandgamerules.command.AscendCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.BottomCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.CreativeCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.DayCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.DescendCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.EasyCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.FairCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.HardCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.HealCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.NightCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.NoonCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.NormalCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.OriginCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.PeacefulCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.RainCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.SetblockCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.SunsetCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.SurvivalCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.ThunderCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.ToggledownfallCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.TopCommand;
import com.mavagk.extrareindevcommandsandgamerules.command.WorldInfoCommand;

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
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new SurvivalCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new CreativeCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new PeacefulCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new EasyCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new NormalCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new HardCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new FairCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new RainCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new ThunderCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new ToggledownfallCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new HealCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new SetblockCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new WorldInfoCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new AscendCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new DescendCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new TopCommand());
		((ClientPlayerCommandHandler)(Object)this).addCommand((Command)new BottomCommand());
	}
}
