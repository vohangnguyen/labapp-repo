package de.hhn.labapp.ln1.service;

import de.hhn.labapp.ln1.model.Event;
import de.hhn.labapp.ln1.model.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UsageService {
    private final Map<String, Long> customerUsage = new HashMap<>();
    private final Map<String, Long> startTimestamps = new HashMap<>();

    private final RestTemplate restTemplate;

    public UsageService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void processEvents(List<Event> events) {
        for (Event event : events) {
            if ("start".equals(event.getEventType())) {
                startTimestamps.put(event.getWorkloadId(), event.getTimestamp());
            } else if ("stop".equals(event.getEventType())) {
                Long startTime = startTimestamps.remove(event.getWorkloadId());
                if (startTime != null) {
                    long runtime = event.getTimestamp() - startTime;
                    customerUsage.merge(event.getCustomerId(), runtime, Long::sum);
                }
            }
        }
    }

    public List<Result> getResults() {
        List<Result> results = new ArrayList<>();
        for (Map.Entry<String, Long> entry : customerUsage.entrySet()) {
            Result result = new Result();
            result.setCustomerId(entry.getKey());
            result.setConsumption(entry.getValue());
            results.add(result);
        }

        // Sende die Ergebnisse an das Referenzsystem
        sendResultsToAssessment(results);
        return results;
    }

    private void sendResultsToAssessment(List<Result> results) {
        String assessmentUrl = "http://assessment:8080/assessment";
        try {
            restTemplate.postForObject(assessmentUrl, results, String.class);
            System.out.println("Ergebnisse erfolgreich gesendet.");
        } catch (Exception e) {
            System.err.println("Fehler beim Senden der Ergebnisse an das Assessment-System: " + e.getMessage());
        }
    }
}
