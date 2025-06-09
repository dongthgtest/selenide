package config;

import java.util.Map;

public class TestConfig {
    public String environment;
    public String browser;
    public boolean enableRetry;
    public boolean enableAllure;
    public boolean enableHtmlReport;
    public int retryCount;
    public String language;

    public static TestConfig fromMap(Map<String, Object> map) {
        TestConfig config = new TestConfig();
        config.environment = (String) map.get("environment");
        config.browser = (String) map.get("browser");
        config.enableRetry = (Boolean) map.get("enableRetry");
        config.enableAllure = (Boolean) map.get("enableAllure");
        config.enableHtmlReport = (Boolean) map.get("enableHtmlReport");
        config.retryCount = (Integer) map.get("retryCount");
        config.language = (String) map.get("language");
        return config;
    }
}
