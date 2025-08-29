# DistributedCarManufacturingApp

This is a modified version of the original Car Manufacturing Java project, enhanced with Remote Method Invocation (RMI) to implement a distributed application. The focus is on managing defect reports using a client-server architecture.

## Overview

This sub-project adapts the QA Engineer's "Manage Defect Reports" feature into a distributed system, where a standalone RMI server handles data storage and retrieval, accessible via a JavaFX client.

## Prerequisites

- **Java Development Kit (JDK)**: Version 21 (e.g., Eclipse Adoptium JDK 21.0.6.7-hotspot).
- **JavaFX SDK**: Version 21.

**Apache Maven**: Version 3.8.5 or later.

- **IntelliJ IDEA**: Community Edition 2024.3.2.2 or later.

## Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/yourusername/DistributedCarManufacturingApp.git
   cd DistributedCarManufacturingApp
   ```

2. **Set Up Environment**:

   - Add `JAVA_HOME` (e.g., `C:\Program Files\Eclipse Adoptium\jdk-21.0.6.7-hotspot`) to your PATH.
   - Ensure Maven’s `bin` directory is in the PATH.

3. **Build the Project**:

   - Open in IntelliJ and use the Maven tab to run `clean` and `install`.

4. **Run the Application**:

   - Start the RMI server by running `supto_1930875.DefectReportServiceImpl`.
   - Run the client via `common.MainApplication`.

## Usage

- **Manage Defects**:
  - Navigate to "Manage Defect Reports".
  - Select a defect, team, and status, then update.
  - View reports to confirm server storage.


## Project Structure

- `src/main/java/common/`: Main application (`MainApplication`).
- `src/main/java/supto/`: RMI service and controllers (`DefectReportService`, `ManageDefectsController`).
- `src/main/resources/supto/`: FXML files (`manage_defects.fxml`, `defect_output.fxml`).
- `pom.xml`: Maven configuration.
