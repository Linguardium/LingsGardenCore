package mod.linguardium.lingsgardencore.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static mod.linguardium.lingsgardencore.Tags.*;

@Mixin(SheepEntity.class)
public abstract class SheepMixin extends AnimalEntity {
    protected SheepMixin(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

    @Redirect(at=@At(value="INVOKE", target="Lnet/minecraft/entity/ai/goal/GoalSelector;add(ILnet/minecraft/entity/ai/goal/Goal;)V"),method="initGoals")
    private void LingsGarden_addCowGoals(GoalSelector selector, int weight, Goal goal) {
        if (!(goal instanceof TemptGoal)) {
            selector.add(weight,goal);
        }else{
                selector.add(weight, new TemptGoal(this, 1.25D, false, Ingredient.fromTag(SHEEP_BREEDING_ITEMS)));
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return SHEEP_BREEDING_ITEMS.contains(stack.getItem());
    }

}
