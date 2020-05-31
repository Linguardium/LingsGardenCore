package mod.linguardium.lingsgardencore;

import mod.linguardium.lingsgardencore.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class LingsGardenCoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModItems.clientInit();
    }
}
