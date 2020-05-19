package mod.linguardium.lingsgardencore.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import static mod.linguardium.lingsgardencore.Tags.CHICKENS_BREEDING_ITEMS;

@Mixin(ChickenEntity.class)
public abstract class ChickenMixin extends AnimalEntity {
    @Shadow
    @Final
    @Mutable
    static Ingredient BREEDING_INGREDIENT;

    static {
        BREEDING_INGREDIENT = Ingredient.fromTag(CHICKENS_BREEDING_ITEMS);
    }
    protected ChickenMixin(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

}
