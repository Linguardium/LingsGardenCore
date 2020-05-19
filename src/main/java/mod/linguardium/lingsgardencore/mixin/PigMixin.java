package mod.linguardium.lingsgardencore.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import static mod.linguardium.lingsgardencore.Tags.PIGS_BREEDING_ITEMS;

@Mixin(PigEntity.class)
public abstract class PigMixin extends AnimalEntity {
    protected PigMixin(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }
    @Shadow
    @Final
    @Mutable
    static Ingredient BREEDING_INGREDIENT;

    static {
        BREEDING_INGREDIENT = Ingredient.fromTag(PIGS_BREEDING_ITEMS);
    }
}
