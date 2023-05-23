package byr.samples.application.commandprompt;

public final class CommandPromptApp {
    private CommandPromptApp()
    {
    }
    public static void run()
    {
        CommandPrompt commandPrompt = new CommandPrompt("CSD");

        commandPrompt.run();
    }
}