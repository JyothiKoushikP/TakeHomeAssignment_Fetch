package org.example;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.example.ParseYamlFileInput.convertToHttpRequests;
import static org.example.ParseYamlFileInput.loadYAMLConfig;
import static org.example.ServerAvailability.calculateAndLogAvailability;
import static org.example.TestEndpoint.testEndpoint;
import static org.example.UserInputExit.waitForUserExit;

/* This Class contains the main method for running the health test */
/* Pass a command line argument of the YAML FilePath */
/* Exits with User Input , continues cycles and calculates availability on every cycle run */
public class TestCycle {
    public static final String YAML_FILE_NAME = "Input.YAML";
    static List<Map<String, Object>> requestsData;
    static List<HttpRequests> requestsList = new ArrayList<>();
    static List<CompletableFuture<ResponseResult>> overallTestResults = new ArrayList<>();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static <Path> void main(String args[]) {
        String yamlFilePath = "";
        if (args.length != 1) {
            File currentDir = new File("");
            java.nio.file.Path currentFilePath = Paths.get(currentDir.getAbsolutePath());
            java.nio.file.Path filePath  = currentFilePath.resolve(YAML_FILE_NAME);
            yamlFilePath = filePath.toString();
        } else {
            yamlFilePath = args[0];
        }

        /* Scheduler is designed to run the endpoints every 15 seconds */
        requestsData = loadYAMLConfig(yamlFilePath);

        if (requestsData != null) {
            // Assuming you have a list of HttpRequests
            for (Map<String, Object> request : requestsData) {
                requestsList.add(convertToHttpRequests(request));
            }
        } else {
            System.exit(0);
        }

        startTestCycle(15);

        waitForUserExit();
        scheduler.shutdown();
    }

/* Function to run health tests -> send httpRequest, receive response and calculate availability on end of each cycle */
    public static void startTestCycle(int timeSeconds) {
        scheduler.scheduleAtFixedRate(TestCycle::runHealthChecks,0,timeSeconds,TimeUnit.SECONDS);
    }

    private static void runHealthChecks() {
            List<CompletableFuture<ResponseResult>> testResults = requestsList.stream()
                .map(request -> CompletableFuture.supplyAsync(() -> testEndpoint(request)))
                .toList();

            // Wait for all health checks to complete
            CompletableFuture<Void> allOf = CompletableFuture.allOf(testResults.toArray(new CompletableFuture[0]));
            allOf.join();

            overallTestResults.addAll(testResults);

            // Calculate and log availability after 1 cycle
            calculateAndLogAvailability(overallTestResults);
        }
    }




