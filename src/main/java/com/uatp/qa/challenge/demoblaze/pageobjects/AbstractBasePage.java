package com.uatp.qa.challenge.demoblaze.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractBasePage {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration DEFAULT_POLLING = Duration.ofMillis(100);

    protected final WebDriver webDriver;
    protected final WebDriverWait webDriverWait;

    private final Duration timeout;
    private final Duration polling;

    protected AbstractBasePage(WebDriver webDriver, Duration timeout, Duration polling) {
        this.webDriver = webDriver;
        this.timeout = timeout;
        this.polling = polling;
        this.webDriverWait = new WebDriverWait(webDriver, timeout, polling);
    }

    protected AbstractBasePage(WebDriver webDriver) {
        this(webDriver, DEFAULT_TIMEOUT, DEFAULT_POLLING);
    }

    public Duration getTimeout() {
        return timeout;
    }

    public Duration getPolling() {
        return polling;
    }
}
