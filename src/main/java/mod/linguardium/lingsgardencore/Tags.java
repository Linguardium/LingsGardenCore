package mod.linguardium.lingsgardencore;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class Tags {
    public static Tag<Item> CHICKENS_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/chickens"));
    public static Tag<Item> COWS_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/cows"));
    public static Tag<Item> MOOSHROOMS_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/mooshrooms"));
    public static Tag<Item> SHEEP_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/sheep"));
    public static Tag<Item> HORSES_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/horses"));
    public static Tag<Item> PIGS_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/pigs"));
    public static Tag<Item> DONKEYS_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/donkeys"));
    public static Tag<Item> MULES_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/mules"));
    public static Tag<Item> LLAMAS_BREEDING_ITEMS = TagRegistry.item(new Identifier("c","entities/breeding/llamas"));

    public static Tag<Item> PARROTS_TAMING_ITEMS = TagRegistry.item(new Identifier("c","entities/taming/parrots"));
    public static Tag<Item> HORSES_TAMING_ITEMS = TagRegistry.item(new Identifier("c","entities/taming/horses"));
    public static Tag<Item> DONKEYS_TAMING_ITEMS = TagRegistry.item(new Identifier("c","entities/taming/donkeys"));
    public static Tag<Item> MULES_TAMING_ITEMS = TagRegistry.item(new Identifier("c","entities/taming/mules"));
    public static Tag<Item> LLAMAS_TAMING_ITEMS = TagRegistry.item(new Identifier("c","entities/taming/llamas"));

}
