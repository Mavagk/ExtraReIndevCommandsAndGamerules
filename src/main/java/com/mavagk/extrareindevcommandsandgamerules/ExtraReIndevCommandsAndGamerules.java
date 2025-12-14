package com.mavagk.extrareindevcommandsandgamerules;

import com.fox2code.foxloader.config.ConfigEntry;
import com.fox2code.foxloader.loader.Mod;

public class ExtraReIndevCommandsAndGamerules extends Mod {
	public static final ExtraReIndevCommandsAndGamerulesConfig CONFIG = new ExtraReIndevCommandsAndGamerulesConfig();

	@Override
	public void onPreInit() {
		this.setConfigObject(CONFIG);
		new ModGamerules();
	}

	public static class ExtraReIndevCommandsAndGamerulesConfig {
		@ConfigEntry(configName = "Play unused overworld songs", configComment = "Play now unused music files that exist in the newmusic folder including nocturne, droopy1, droopy2 and calm5 and many vanilla tracks.")
		public boolean playNewmusicFolder = false;
	}
}
