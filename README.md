# 🦁 JungBrutalGutaussehend3-5
## Ein Java-Projekt mit Maven
Ein kleines **Java-Maven-Projekt** zu Lernzwecken um auf eine Datenbank zuzugriefen und sich Bilder ausgeben zu lassen.  
Man soll sich im ersten Schritt ...
- **nächstes Bild anzeigen**
- **vorheriges Bild anzeigen**
- **zufälliges Bild anzeigen**

... lassen können

---

## 👤 Autor
Aileen, Lux, Jakob

---

## ⚙️ Verwendete Technologien

- **Java 23+**
- **Maven** (Build- und Dependency-Management)
- **JUnit 5** (für Unit-Tests)
- **IntelliJ IDEA** (IDE)
- **MariaDB**/**HeidiSQL** (Datenbank/ Verwaltungstool)
- **JBDC** (Konnektor für die Datenbank)

---

## 🧠 ToDos

### **Datenbank**
- weitere Beispieldatensätze anlegen
- Datensätze konkretisieren (bspw. Bilder als Blob hinterlegen)

### **Applikation**
- JDBC einrichten (Two-Tier-Architecture)
  - Packages importieren
  - Treiber (runter)laden
  - Treiber einrichten (registrieren)
  - Verbindung einrichten (bspw. 127.0.0.1:3306)
  - Statements erstellen (Query)
  - Statements ausführen (Einbindung in Applikation)
- Java
  - Klassen je table anlegen
  - CRUD-Klasse anlegen (Databasehandler, führt alle DB-Statements aus (Create/Update/...))
  - REST-Klasse anlegen (zur Anbindung der UI-Lösung (kleine html-Anwendung))
- HTML (oder irgendwas zur Visualisierung)
  - Visualisierungslösung erstellen (separates Projekt)
  - Verbindung via REST-API
