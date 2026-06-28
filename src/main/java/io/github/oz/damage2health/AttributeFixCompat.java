package io.github.oz.damage2health;

import net.fabricmc.loader.api.FabricLoader;

public final class AttributeFixCompat {

    private static final boolean ATTRIBUTE_FIX_INSTALLED =
            FabricLoader.getInstance().isModLoaded("attributefix");

    private AttributeFixCompat() {
    }

    public static boolean isInstalled() {
        return ATTRIBUTE_FIX_INSTALLED;
    }
}
