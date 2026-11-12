# Java Swing 2D Space Game (Uzay Oyunu)

*Note: This project was developed as a practical application of concepts learned during a Udemy Java course to strengthen my skills in Java Swing GUI, game loops, event handling, and 2D graphics rendering.*

A classic 2D space shooter game built using Java Swing. The player controls a spaceship at the bottom of the screen, moving left and right, and fires bullets to destroy a moving target ball at the top to win the game.

## Features

* **Interactive Controls:** Move the spaceship smoothly using the Left and Right arrow keys, and fire lasers using the Spacebar or Control key.
* **Collision Detection:** Real-time boundary and intersection checks (`Rectangle.intersects`) to detect successful hits.
* **Resource Handling & Fallback:** Loads a custom spaceship graphic (`.png`) with a built-in safety fallback to a vector shape if the asset path requires alignment.
* **Game Statistics:** Calculates and displays total spent bullets and elapsed time via a victory popup message upon winning.
* **Smooth Animation:** Utilizes `javax.swing.Timer` for continuous frame updates and rendering (`paintComponent`).

## Tech Stack

* **Language:** Java (JDK 8+)
* **UI Framework:** Java Swing (`JFrame`, `JPanel`)
* **Graphics & Events:** `Graphics`, `KeyListener`, `ActionListener`, `ImageIO`
* **Collections:** `ArrayList`, `Iterator` (for safe bullet management)

## How to Run the Application

1. Clone this repository to your local machine.
2. Ensure you have the Java Development Kit (JDK) installed.
3. Open the project in your preferred Java IDE (such as NetBeans, IntelliJ IDEA, or Eclipse).
4. Run the `Ekran.java` file (which initializes the game window and game loop).
5. Use the **Left/Right Arrow keys** to move and **Space/Ctrl** to shoot!
