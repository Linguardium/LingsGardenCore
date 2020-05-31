package mod.linguardium.lingsgardencore.rendering;

import mod.linguardium.lingsgardencore.api.ColoredBottle;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;

public class BottleColorProvider implements ItemColorProvider {

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if (tintIndex==0) {
            if (stack.getItem() instanceof ColoredBottle) {
                return ((ColoredBottle) stack.getItem()).getColor(stack);
            } else {
                return PotionUtil.getColor(Potions.WATER);
            }
        }else{
            return -1;
        }
    }
}
