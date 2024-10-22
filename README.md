# Cloud Usage Calculator

## Beschreibung
Diese Anwendung berechnet die Gesamtnutzungszeit von Cloud-Kunden basierend auf Ereignisdaten.

## Voraussetzungen
- Docker
- Docker Compose
- Maven

## Projektstruktur
- `src/main/java/com/example`: Java-Quellcode
- `Dockerfile`: Docker-Image für die Anwendung
- `docker-compose.yml`: Docker Compose-Konfiguration
- `pom.xml`: Maven-Projektdatei

## Ausführung
1. Klone das Repository.
2. Baue und starte die Container:
   ```bash
   docker-compose up --build
