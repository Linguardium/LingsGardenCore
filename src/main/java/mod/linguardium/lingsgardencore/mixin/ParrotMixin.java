package mod.linguardium.lingsgardencore.mixin;

import com.google.common.collect.Sets;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;

import static mod.linguardium.lingsgardencore.Tags.CHICKENS_BREEDING_ITEMS;
import static mod.linguardium.lingsgardencore.Tags.PARROTS_TAMING_ITEMS;

@Mixin(ParrotEntity.class)
public abstract class ParrotMixin extends TameableShoulderEntity {
    protected ParrotMixin(EntityType<? extends TameableShoulderEntity> type, World world) {
        super(type, world);
    }

    @Shadow
    @Final
    @Mutable
    private static Set<Item> TAMING_INGREDIENTS;

    static {
        TAMING_INGREDIENTS = Sets.newHashSet(PARROTS_TAMING_ITEMS.values());
    }

}
