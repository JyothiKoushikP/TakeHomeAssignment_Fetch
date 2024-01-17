package org.example;

import java.io.IOException;

// User Input is used to invoke the exit of the program
public class UserInputExit {
    /* Function to invoke program exit on user input */
    static void waitForUserExit() {
        System.out.println("Press Enter to exit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
