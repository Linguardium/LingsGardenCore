package mod.linguardium.lingsgardencore.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import static mod.linguardium.lingsgardencore.Tags.COWS_BREEDING_ITEMS;
import static mod.linguardium.lingsgardencore.Tags.MOOSHROOMS_BREEDING_ITEMS;

@Mixin(MooshroomEntity.class)
public abstract class MooshroomMixin extends AnimalEntity {
    protected MooshroomMixin(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return MOOSHROOMS_BREEDING_ITEMS.contains(stack.getItem());
    }

}
