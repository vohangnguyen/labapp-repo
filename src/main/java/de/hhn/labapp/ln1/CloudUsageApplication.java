package de.hhn.labapp.ln1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class CloudUsageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudUsageApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

/* Example POST request
curl -X POST http://localhost:8080/v1/dataset \
-H "Content-Type: application/json" \
-d '[
  {
    "customerId": "342a55a3-b138-4665-8351-111b28833d34",
    "workloadId": "53ddf5cf-7a12-4b7f-8751-48757774c0c5",
    "timestamp": 1699872883000,
    "eventType": "start"
  },
  {
    "customerId": "342a55a3-b138-4665-8351-111b28833d34",
    "workloadId": "53ddf5cf-7a12-4b7f-8751-48757774c0c5",
    "timestamp": 1700401984000,
    "eventType": "stop"
  }
]'
*/