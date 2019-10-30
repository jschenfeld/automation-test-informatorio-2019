package io.github.jschenfeld.automation.appium.utils;

import org.aeonbits.owner.Config;

public interface Configuration extends Config {

	@Key("appium.is.app")
	@DefaultValue("true")
	boolean isApp();

	@Key("android.web.url")
	@DefaultValue("")
	String webUrl();

	@Key("android.app.package")
	String appPackage();

	@Key("android.app.activity")
	String appActivity();

	@Key("device.name")
	@DefaultValue("${device.name}")
	String deviceName();

	@Key("device.fullreset")
	@DefaultValue("${device.fullreset}")
	String fullReset();

	@Key("device.clearSystemFiles")
	@DefaultValue("${clearSystemFiles}")
	String clearSystemFiles();

	@Key("appium.app")
	@DefaultValue("${appium.app}")
	String app();

	@Key("appium.server.ip")
	@DefaultValue("127.0.0.1")
	String appiumServerIp();

	@Key("appium.server.port")
	@DefaultValue("4444")
	int appiumServerPort();
}