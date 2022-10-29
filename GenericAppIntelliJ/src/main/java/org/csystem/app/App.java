package org.csystem.app;

import org.csystem.util.console.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args)
    {
      var prompt = Console.read("Mesajı giriniz:");
      var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");

      new Timer().scheduleAtFixedRate(new TimerTask() {

          public void run() {
              Console.write("%s:%s\r",prompt,formatter.format(LocalDateTime.now()));
          }
      },0,1000);

      Console.writeLine("main ends!..");
    }
}