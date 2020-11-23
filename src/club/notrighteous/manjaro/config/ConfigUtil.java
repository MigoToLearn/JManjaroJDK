package club.notrighteous.manjaro.config;

import club.notrighteous.manjaro.ui.InfoUI;
import java.io.File;

/**
 * www.github.com/MigoToLearn
 * @author Migo
 */
public class ConfigUtil {
    
    public static String gksuPath = "/usr/bin/gksu";
    public static String archJavaPath = "/usr/bin/archlinux-java";
    
    public static boolean dependancyCheck() {
        if(fileFound(gksuPath) && fileFound(archJavaPath)) {
            return true;
        } else {
            String filesNotFound = "";
            if(fileFound(gksuPath) == false) {
                filesNotFound = filesNotFound + "\\r?\\n" + "GKSU not found";
            }
            if(fileFound(archJavaPath) == false) {
                filesNotFound = filesNotFound + "\\r?\\n" + "Archlinux-java not found";
            }
            InfoUI.displayError(filesNotFound);
            return false;
        }
    }
    
    public static boolean fileFound(String path) {
        if(new File(path).exists()) {
            return true;
        } else {
            return false;
        }
    }
    
}
