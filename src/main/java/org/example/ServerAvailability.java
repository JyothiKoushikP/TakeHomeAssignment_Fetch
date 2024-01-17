package org.example;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/* To calculate the Availability of a domain after each cycle */
public class ServerAvailability {
    /* Function to calculate Availability -> Filter by Domain and calculate Availability for each domain (Rounded to nearest Integer) */
    static void calculateAndLogAvailability(List<CompletableFuture<ResponseResult>> testResults) {
        testResults.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.groupingBy(ResponseResult::getDomain))
                .forEach((domain, results) -> {
                    double upCount = results.stream().filter(ResponseResult::isUp).count();
                    double ratio = upCount / (results.size());
                    int availability = (int) (ratio * 100);
                    String message = String.format("%s has %d%% availability percentage", domain, availability);
                    LoggerInfo.logInfo(message);
                });
    }
}
