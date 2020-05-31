package mod.linguardium.lingsgardencore.item;

import mod.linguardium.recipestacks.api.RecipeRemainderProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CookingTool extends Item implements RecipeRemainderProvider {
    public CookingTool(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack itemStack) {
        return itemStack;
    }
}
