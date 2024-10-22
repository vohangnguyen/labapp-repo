package de.hhn.labapp.ln1.service;

import de.hhn.labapp.ln1.model.Event;
import de.hhn.labapp.ln1.model.Result;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsageService {
    private final Map<String, Long> customerUsage = new HashMap<>();
    private final Map<String, Long> startTimestamps = new HashMap<>();

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
        return results;
    }
}
