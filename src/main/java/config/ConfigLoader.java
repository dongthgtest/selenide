package config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigLoader {
    private static TestConfig config;

    public static TestConfig getConfig() {
        if (config == null) {
            loadConfig();
        }
        return config;
    }

    private static void loadConfig() {
        try (InputStream in = ConfigLoader.class.getClassLoader().getResourceAsStream("config.yml")) {
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(in);
            config = TestConfig.fromMap(map);

            // CLI override
            String cliBrowser = System.getProperty("browser");
            String cliRetry = System.getProperty("retryCount");

            if (cliBrowser != null) config.browser = cliBrowser;
            if (cliRetry != null) config.retryCount = Integer.parseInt(cliRetry);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.yml", e);
        }
    }
}
