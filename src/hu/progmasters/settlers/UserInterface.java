package hu.progmasters.settlers;

import hu.progmasters.settlers.engine.SettlersEngine;

import java.util.Scanner;

public class UserInterface {
    Scanner scan = new Scanner(System.in);
    SettlersEngine settlersEngine = new SettlersEngine();

    public void start() {
        boolean isRunning = true;

        while (isRunning) {
            String cmd = scan.nextLine();
            switch (cmd) {
                case "status":
                    settlersEngine.status();
                    break;
                case "skip":
                    settlersEngine.skip();
                    break;
                case "quit":
                    isRunning = false;
                    break;
                default:
                    String[]  command = cmd.split(" ");
                    cmd = command[1];
                    settlersEngine.build(cmd);
            }
        }
    }
}
