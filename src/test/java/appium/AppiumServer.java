package appium;

public class AppiumServer {

    private static Process process;
    private static String APPIUM_SERVER_START = "appium";

    public static void startServer() {
        try {
            process = Runtime.getRuntime().exec(APPIUM_SERVER_START);
            Thread.sleep(10000); // Wait for the server to start.
        } catch (Exception e) {
            System.out.println("Appium server could not be started.");
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        if (process != null) {
            process.destroy();
        }
    }
}

