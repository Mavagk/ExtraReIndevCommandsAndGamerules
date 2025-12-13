package com.mavagk.extrareindevcommandsandgamerules;

import com.fox2code.foxloader.loader.Mod;

public class ExtraReIndevCommandsAndGamerules extends Mod {
	public static final ExtraReIndevCommandsAndGamerulesConfig CONFIG = new ExtraReIndevCommandsAndGamerulesConfig();

	@Override
	public void onPreInit() {
		this.setConfigObject(CONFIG);
	}

	public static class ExtraReIndevCommandsAndGamerulesConfig {
		
	}
}
