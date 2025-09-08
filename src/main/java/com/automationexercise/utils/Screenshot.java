package com.automationexercise.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Screenshot {

    public static void Capture(WebDriver driver, String name) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    
        String dest = System.getProperty("user.dir") 
                + "/src/test/resources/ScreenShots/" 
                + name +  ".png";

        File destFile = new File(dest);
        destFile.getParentFile().mkdirs();
        FileUtils.copyFile(src, destFile);
    }
}
