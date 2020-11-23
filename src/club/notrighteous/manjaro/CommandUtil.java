package club.notrighteous.manjaro;

import club.notrighteous.manjaro.ui.InfoUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.ArrayList;


/**
 * www.github.com/MigoToLearn
 * @author Migo
 */
public class CommandUtil {
    
    public static ArrayList<String> getJdkInstalled() {
        ArrayList<String> systemJdks = new ArrayList<>();
        try {
            Process proc = Runtime.getRuntime().exec("archlinux-java status");
            String[] jdks = readExec(proc.getInputStream()).split("\\r?\\n");
            for(String jdk : jdks) {
                if(jdk.contains("Available")) {
                    System.out.println("Skipping first line");
                } else {
                    systemJdks.add(jdk.replaceAll(" ", ""));
                }
            }
        } catch (Exception ex) {
            InfoUI.displayError(ex);
        }
        return systemJdks;
    }
    
    public static void setJdkDefault(String vers) {
        try {
            Process proc = Runtime.getRuntime().exec("gksu archlinux-java set " + vers);
            String debug = readExec(proc.getInputStream());
            System.out.println("Debug: " + debug);
        } catch (Exception ex) {
            InfoUI.displayError(ex);
        }
    }
    
    public static String readExec(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
}
