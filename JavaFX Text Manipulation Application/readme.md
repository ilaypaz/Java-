# JavaFX Text Manipulation Application

## Overview
This is a JavaFX application developed as part of a lab exercise (Exercise_16_01) in the `com.example.lab4` package. The application creates a graphical user interface (GUI) that displays the text "Programming is fun" and allows users to:
- Change the text color using radio buttons (Red, Yellow, Black, Orange, Green).
- Move the text left or right using navigation buttons.

## Features
- **Text Display**: Displays the text "Programming is fun" in a centered pane with a black border.
- **Color Selection**: Five radio buttons at the top allow users to change the text color to Red, Yellow, Black, Orange, or Green. Only one color can be selected at a time (using a `ToggleGroup`).
- **Text Movement**: Two buttons at the bottom ("<=" and "=>") move the text 10 pixels left or right, respectively.
- **Layout**: Uses a `BorderPane` to organize components:
  - Top: Radio buttons for color selection.
  - Center: Text display area.
  - Bottom: Navigation buttons for moving the text.
- **Window Size**: The application window is 450x150 pixels.

## Prerequisites
To run this application, you need:
- **Java Development Kit (JDK)**: Version 8 or higher with JavaFX included (e.g., Oracle JDK 8 or OpenJDK with OpenJFX).
- **Integrated Development Environment (IDE)**: Recommended IDEs include IntelliJ IDEA, Eclipse, or NetBeans with JavaFX support.
- **JavaFX SDK**: If using a JDK version that does not bundle JavaFX (e.g., JDK 11+), ensure the JavaFX SDK is installed and configured.

## Setup Instructions
1. **Clone or Download the Project**:
   - Clone this repository or copy the provided source code (`prob2.java`) into a new project in your IDE.
   - Ensure the file is placed in the `src/com/example/lab4` directory to match the package structure (`com.example.lab4`).

2. **Configure JavaFX**:
   - If using JDK 8, JavaFX is included by default.
   - For JDK 11 or later:
     - Download the JavaFX SDK from [GluonHQ](https://gluonhq.com/products/javafx/).
     - Add the JavaFX libraries to your project (e.g., via module path or classpath in your IDE).
     - Configure your IDE or build tool (e.g., Maven, Gradle) to include JavaFX dependencies. Example for Maven:
       ```xml
       <dependency>
           <groupId>org.openjfx</groupId>
           <artifactId>javafx-controls</artifactId>
           <version>17</version>
       </dependency>
       <dependency>
           <groupId>org.openjfx</groupId>
           <artifactId>javafx-fxml</artifactId>
           <version>17</version>
       </dependency>
       ```

3. **Fix Known Issues**:
   - The provided code has a typo in the event handler for the `black` radio button: `black .isSelected()` should be corrected to `black.isSelected()` (remove the extra space before the dot).

4. **Compile and Run**:
   - Compile the `prob2.java` file.
   - Run the application using your IDE or the command line:
     ```bash
     java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls com.example.lab4.prob2
     ```
     Replace `/path/to/javafx-sdk/lib` with the actual path to your JavaFX SDK libraries.

## Usage
1. Launch the application to open a window titled "Exercise_16_01".
2. Select a radio button (Red, Yellow, Black, Orange, or Green) to change the color of the text "Programming is fun".
3. Click the "<=" button to move the text 10 pixels to the left or the "=>" button to move it 10 pixels to the right.

## Known Issues
- **Compilation Error**: The event handler for the `black` radio button contains a typo (`black .isSelected()`). Correct it to `black.isSelected()` to ensure the application compiles successfully.
- **Boundary Handling**: The text can move indefinitely left or right, potentially moving out of the visible pane. No boundary checks are implemented.

## Future Improvements
- Add boundary checks to prevent the text from moving outside the visible pane.
- Enhance the UI with additional styling (e.g., fonts, text size options).
- Add more interactive features, such as changing the text content or font via user input.

## License
This project is intended for educational purposes as part of a lab exercise. No specific license is applied unless otherwise specified.

## Contact
For questions or issues, please contact the project maintainer or refer to the lab instructor for Exercise_16_01.
