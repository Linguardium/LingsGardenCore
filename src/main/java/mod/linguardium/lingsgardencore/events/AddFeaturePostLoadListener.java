package mod.linguardium.lingsgardencore.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.List;

public interface AddFeaturePostLoadListener {
    Event<AddFeaturePostLoadListener> EVENT = EventFactory.createArrayBacked(AddFeaturePostLoadListener.class,
            (listeners) -> (step, biome) -> {
                List<ConfiguredFeature<?,?>> features = new ArrayList<>();
                for (AddFeaturePostLoadListener listener : listeners) {
                    List<ConfiguredFeature<?,?>>  result = listener.load(step, biome);
                    features.addAll(result);
                }
                return features;
            });

    List<ConfiguredFeature<?,?>> load(GenerationStep.Feature step, Biome biome);
}
