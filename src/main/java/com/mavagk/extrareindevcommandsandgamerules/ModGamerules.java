package com.mavagk.extrareindevcommandsandgamerules;

import net.minecraft.common.world.gamerules.Gamerule;
import net.minecraft.common.world.gamerules.Gamerules;

public class ModGamerules {
	public static final Gamerule allowSurvivalSprinting = Gamerules.registerBooleanGamerule("allowSurvivalSprinting", true);
	public static final Gamerule allowInstantEating = Gamerules.registerBooleanGamerule("allowInstantEating", false);
	public static final Gamerule allowFoodStacking = Gamerules.registerBooleanGamerule("allowFoodStacking", true);
}
