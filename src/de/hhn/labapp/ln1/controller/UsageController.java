package de.hhn.labapp.ln1.controller;

import de.hhn.labapp.ln1.model.Event;
import de.hhn.labapp.ln1.model.Result;
import de.hhn.labapp.ln1.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UsageController {

    @Autowired
    private UsageService usageService;

    @PostMapping("/dataset")
    public void addEvents(@RequestBody List<Event> events) {
        usageService.processEvents(events);
    }

    @GetMapping("/result")
    public List<Result> getResults() {
        return usageService.getResults();
    }
}
