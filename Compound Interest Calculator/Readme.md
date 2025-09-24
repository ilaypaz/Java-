The Compound Interest Calculator is a JavaFX desktop application that calculates the final amount and total interest earned based on user-provided inputs for principal amount, interest rate, investment duration, and compounding frequency. The application provides a graphical user interface (GUI) for ease of use and displays results in a formatted text area.FeaturesInput Fields:Invested Amount (P): The principal amount invested.
Rate of Interest (r): The annual interest rate (as a percentage).
Investment Years (t): The duration of the investment in years.
Frequency of Interest: Options for compounding frequency (Yearly, Half-Yearly, or Quarterly).

Output:Displays the invested amount, total interest earned, and final amount after compounding.

Error Handling:Validates numerical inputs and prompts the user to enter valid values if incorrect data is provided.
Ensures a compounding frequency is selected before calculation.

User Interface:Clean and centered layout using JavaFX's BorderPane and GridPane.
Non-editable text area for displaying results with formatted output (two decimal places).
Radio buttons for selecting compounding frequency, grouped to allow only one selection.

FilesCompoundInterestCalculator.java:The main JavaFX application class.
Sets up the GUI, handles user input, and performs calculations using the Interest class.

Interest.java:A helper class that encapsulates the compound interest logic.
Calculates the final amount using the formula: A = P * (1 + r/n)^(n*t), where:A = Final amount
P = Principal amount
r = Annual interest rate (as a decimal)
n = Number of times interest is compounded per year
t = Number of years

Computes total interest earned as I = A - P.
Provides getter and setter methods for all fields.

PrerequisitesJava Development Kit (JDK): Version 8 or higher.
JavaFX: Ensure JavaFX is included in your JDK or configured in your IDE/project.
Integrated Development Environment (IDE): Recommended IDEs include IntelliJ IDEA, Eclipse, or NetBeans with JavaFX support.

Setup InstructionsClone or Download the Project:Copy the provided source files (CompoundInterestCalculator.java and Interest.java) into a Java project under the package com.example.lab4.

Configure JavaFX:If using JDK 11 or later, ensure JavaFX is added as a dependency (e.g., via Maven/Gradle or by downloading JavaFX SDK).
For IntelliJ IDEA:Go to File > Project Structure > Libraries, add the JavaFX SDK lib folder.
Add VM options: --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml.

For Eclipse:Add JavaFX libraries to the project build path.
Configure run settings with the above VM options.

Compile and Run:Compile the project using your IDE or command line.
Run the CompoundInterestCalculator class as a JavaFX application.

UsageLaunch the application to open the GUI window titled "Compound Interest Calculator".
Enter the following inputs:Invested Amount (P): The initial investment (e.g., 1000).
Rate of Interest (r): The annual interest rate in percent (e.g., 5 for 5%).
Investment Years (t): The number of years for the investment (e.g., 10).
Frequency of Interest: Select one of:Compounded Yearly (n = 1)
Compounded Half-Yearly (n = 2)
Compounded Quarterly (n = 4)

Click the Calculate button to compute and display:The invested amount.
The total interest earned.
The final amount after compounding.

If invalid inputs (e.g., non-numeric values) are provided, an error message will appear in the text area.

ExampleInput:Invested Amount: 1000
Rate of Interest: 5
Investment Years: 10
Frequency: Compounded Yearly

Output:

Invested Amount (P): $1000.00
Total Interest Earned (I): $628.89
Final Amount (A): $1628.89

NotesThe interest rate should be entered as a percentage (e.g., 5 for 5%). The application converts it to a decimal for calculations.
The application assumes valid integer input for years and does not handle fractional years.
The text area is non-editable to prevent users from modifying the output directly.
The GUI is fixed at 400x300 pixels for simplicity but can be resized by dragging the window.

TroubleshootingJavaFX Not Found: Ensure JavaFX is properly configured in your project. Refer to the JavaFX documentation for setup guidance.
Invalid Input Errors: Ensure all text fields contain valid numbers and a compounding frequency is selected.
Layout Issues: If the GUI appears misaligned, verify that the GridPane and HBox settings (padding, gaps, alignment) are unchanged.

LicenseThis project is provided for educational purposes. Feel free to use, modify, and distribute it as needed, respecting any applicable licensing for JavaFX or third-party libraries.

