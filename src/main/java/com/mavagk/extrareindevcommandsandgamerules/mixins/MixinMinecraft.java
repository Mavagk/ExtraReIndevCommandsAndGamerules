package com.mavagk.extrareindevcommandsandgamerules.mixins;

import java.io.File;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mavagk.extrareindevcommandsandgamerules.ExtraReIndevCommandsAndGamerules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.sound.SoundManager;

@Mixin(Minecraft.class)
public class MixinMinecraft {
	public SoundManager sndManager;

	@Inject(method = "installResource", at = @At("HEAD"), cancellable = true)
	private void installResource(String path, File file, CallbackInfo info) {
		String resourcePackPath = "/sounds/" + path;
		int var3 = path.indexOf("/");
		String var4 = path.substring(0, var3);
		path = path.substring(var3 + 1);

		if (var4.equalsIgnoreCase("newmusic")) {
			if (ExtraReIndevCommandsAndGamerules.CONFIG.playNewmusicFolder)
				this.sndManager.addMusicOverworldDay(path, file, resourcePackPath);
		}
	}
}
