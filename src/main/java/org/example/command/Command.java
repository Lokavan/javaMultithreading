
/*Why use Command?
 A command object can be stored, queued, logged, retried, or
  designed to support undo operations.
 */

 /*Real project use: Background jobs, task queues, undo/redo
  systems, and encapsulated business operations.
  */

  /*Command Pattern encapsulates an operation as an object,
  decoupling the sender from the receiver. It is useful for
  queuing requests, logging operations, and implementing
  undo functionality.
   */




package org.example.command;

interface Command {
    void execute();
}

class Light {

    void turnOn() {
        System.out.println("Light turned ON");
    }

    void turnOff() {
        System.out.println("Light turned OFF");
    }
}

class LightOnCommand implements Command {

    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class RemoteControl {

    private Command command;

    RemoteControl(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

class Main {
    public static void main(String[] args) {

        Light light = new Light();

        Command command = new LightOnCommand(light);

        RemoteControl remote =
                new RemoteControl(command);

        remote.pressButton();
    }
}