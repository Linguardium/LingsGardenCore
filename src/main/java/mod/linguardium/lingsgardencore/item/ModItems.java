package mod.linguardium.lingsgardencore.item;

import mod.linguardium.lingsgardencore.LingsGardenCore;
import mod.linguardium.lingsgardencore.rendering.BottleColorProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final CookingTool MORTAR = register("mortar_and_pestle",new CookingTool(new Item.Settings().group(ItemGroup.MISC).maxCount(1)));
    public static final CookingTool KNIFE = register("knife",new CookingTool(new Item.Settings().group(ItemGroup.MISC).maxCount(1)));
    public static final CookingTool JUICER = register("juicer",new CookingTool(new Item.Settings().group(ItemGroup.MISC).maxCount(1)));
    public static final JuiceItem FRUIT_JUICE = register("fruit_juice",new JuiceItem(new Item.Settings().group(ItemGroup.FOOD).maxCount(64).food(FoodComponents.HONEY_BOTTLE),0xFF9090));
    public static final BottleColorProvider BOTTLE_COLOR_PROVIDER = new BottleColorProvider();
    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM,new Identifier(LingsGardenCore.MOD_ID,name),item);
    }
    @Environment(EnvType.CLIENT)
    public static void clientInit() {
        ColorProviderRegistry.ITEM.register(BOTTLE_COLOR_PROVIDER,FRUIT_JUICE);
    }
}
