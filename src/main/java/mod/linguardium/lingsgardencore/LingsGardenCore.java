package mod.linguardium.lingsgardencore;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LingsGardenCore implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "lingsgardencore";
    public static final String MOD_NAME = "Ling's Garden - Core";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Ling's Garden - Core loaded");
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}