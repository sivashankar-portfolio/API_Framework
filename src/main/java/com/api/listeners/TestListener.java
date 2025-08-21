package com.api.listeners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite started...");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Started!!!" + result.getMethod().getMethodName());
        logger.info("Description!!!" + result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Passed!!!" + result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Failed!!!" + result.getMethod().getMethodName());
        logger.error("Description!!!" + result.getMethod().getDescription());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
logger.info("Skipped...."+result.getMethod().getMethodName());
logger.info("Description...."+result.getMethod().getDescription());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Finished!!!" + context.getName());
    }
}
