
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.diemoney.item.init;

import com.diemoney.item.*;
import com.diemoney.main.Reference;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;


public class TextModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
	public static final RegistryObject<Item> MAGNET = REGISTRY.register("magnet", () -> new MagnetItem());
	public static final RegistryObject<Item> THUNDER = REGISTRY.register("thunder", () -> new ThunderItem());
	public static final RegistryObject<Item> DARK = REGISTRY.register("dark", () -> new DarkItem());
	public static final RegistryObject<Item> INFINITYTOTEM = REGISTRY.register("infinitytotem", () -> new InfinitytotemItem());
	public static final RegistryObject<Item> FRIENDLY = REGISTRY.register("friendly", () -> new FriendlyItem());
	public static final RegistryObject<Item> SNOWMAN = REGISTRY.register("snowman", () -> new SnowmanItem());
}
