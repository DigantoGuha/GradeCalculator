Java Grade Calculator
Overview
The Java Grade Calculator is a menu-driven console application that calculates total marks, average percentage, and grades for multiple students.
It supports persistent storage using file handling, so results are saved and automatically loaded when the program starts.
This project demonstrates:

Core Java concepts (OOP, classes, objects, encapsulation)
File handling with serialization
Exception handling for clean error messages
Dynamic data storage using ArrayList
Formatted console output for better readability
Features
Menu System
Add Student
View All Results
Save & Exit
Persistent Storage – Saves student data to a file (results.dat) and reloads on startup
Validation – Ensures correct numeric input and marks within 0–100
Formatted Table Output – Displays results neatly in aligned columns
Scalable – Supports any number of students and subjects
Technologies Used
Java (Core)
Object-Oriented Programming (OOP)
Collections Framework (ArrayList)
File I/O (Serialization)
How to Run
Prerequisites
Install Java JDK 17 or later
Install VS Code with the Extension Pack for Java
Steps
Clone this repository:
git clone https://github.com/YOUR_USERNAME/Java-Grade-Calculator.git
Open the folder in VS Code.
Run the program:
Click the Run ▶ button in VS Code, or
Use terminal commands:
javac GradeCalculator.java
java GradeCalculator
Sample Output
=== Grade Calculator Menu ===
1. Add Student
2. View All Results
3. Save & Exit
Enter your choice: 1
Enter student name: Prakhar
Enter number of subjects: 3
Enter marks for subject 1: 85
Enter marks for subject 2: 90
Enter marks for subject 3: 88
Student added successfully!

=== Grade Calculator Menu ===
1. Add Student
2. View All Results
3. Save & Exit
Enter your choice: 2

Name                 Total      Average    Grade
--------------------------------------------------
Prakhar               263        87.67      B
