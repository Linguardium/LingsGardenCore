package mod.linguardium.lingsgardencore.mixin;

import com.google.common.collect.Maps;
import mod.linguardium.lingsgardencore.events.AddFeaturePostLoadListener;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.ForestBiome;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Mixin(Biome.class)
public class FeatureAdderMixin {
    @Shadow
    @Final
    protected
    Map<GenerationStep.Feature, List<ConfiguredFeature<?, ?>>> features;

    @Inject(at=@At("RETURN"),method="generateFeatureStep", locals = LocalCapture.CAPTURE_FAILHARD)
   private void GenerateFeatures(GenerationStep.Feature step, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, IWorld world, long seed, ChunkRandom random, BlockPos pos, CallbackInfo ci, int i, Iterator var9) {
        List<ConfiguredFeature<?,?>>  features = AddFeaturePostLoadListener.EVENT.invoker().load(step, (Biome)(Object)this);
        for(ConfiguredFeature<?,?> feature: features) {
            random.setFeatureSeed(seed, i, step.ordinal());
            try {
                feature.generate(world, chunkGenerator, random, pos);
            } catch (Exception var13) {
                CrashReport crashReport = CrashReport.create(var13, "Feature placement");
                crashReport.addElement("Feature").add("Id", Registry.FEATURE.getId(feature.feature)).add("Description", feature.feature.toString());
                throw new CrashException(crashReport);
            }
        }
    }
}
