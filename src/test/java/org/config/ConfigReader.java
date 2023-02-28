package org.config;

import java.io.FileReader;
import java.util.Properties;

import org.constant.Constant;

public class ConfigReader extends Constant{

	public static void loadReader() {
		FileReader reader = null;
		try {
			reader = new FileReader("config.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Properties props = new Properties();
		try {
			props.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}

		LaunchURL = props.getProperty("LAUNCH_URL");
		Browser = props.getProperty("BROWSER");
		ChromeDriverLocation = props.getProperty("CHROME_DRIVER_LOCATION");
		EdgeDriverLocation = props.getProperty("EDGE_DRIVER_LOCATION");
		ExcelPath = props.getProperty("EXCEL_PATH");

	}

}
