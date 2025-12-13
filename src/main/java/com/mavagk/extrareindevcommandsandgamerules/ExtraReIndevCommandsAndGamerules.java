package com.mavagk.extrareindevcommandsandgamerules;

import com.fox2code.foxloader.loader.Mod;

import net.minecraft.common.world.gamerules.Gamerule;
import net.minecraft.common.world.gamerules.Gamerules;

public class ExtraReIndevCommandsAndGamerules extends Mod {
	public static final ExtraReIndevCommandsAndGamerulesConfig CONFIG = new ExtraReIndevCommandsAndGamerulesConfig();
	public static final Gamerule allowSurvivalSprinting = Gamerules.registerBooleanGamerule("allowSurvivalSprinting", true);

	@Override
	public void onPreInit() {
		this.setConfigObject(CONFIG);
	}

	public static class ExtraReIndevCommandsAndGamerulesConfig {
		
	}
}
