package com.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.net.InetAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "Demo",
        headerHeading = "@|bold,underline Project Demo|@:%n%n",
        header = {"@|green    _____                        |@",
                "@|green   |  __ \\                       |@",
                "@|green   | |  | | ___ _ __ ___   ___   |@",
                "@|yellow   | |  | |/ _ \\ '_ ` _ \\ / _ \\  |@",
                "@|blue   | |__| |  __/ | | | | | (_) | |@",
                "@|magenta   |_____/ \\___|_| |_| |_|\\___/  |@%n%n"},
        synopsisHeading = "@|bold,underline Usage:|@:%n%n",
        customSynopsis = {"  ln [OPTION]... [-T] TARGET LINK_NAME        (1st form)",
                "  or:  ln [OPTION]... TARGET                  (2nd form)",
                "  or:  ln [OPTION]... TARGET... DIRECTORY     (3rd form)",
                "  or:  ln [OPTION]... -t DIRECTORY TARGET...  (4th form)"},
        descriptionHeading = "%n@|bold,underline Description|@:%n%n",
        description = "This is the description for the Demo project",
        parameterListHeading = "%n@|bold,underline Parameters|@:%n",
        optionListHeading = "%n@|bold,underline Options|@:%n",
        mixinStandardHelpOptions = true,
        version = "Demo 1.0")
public class Cli implements Callable<Integer> {

    @Option(names = {"-p", "--proxyHost"},
            description = "Proxy can be DIRECT, HTTP or SOCKS")
    Map<Proxy.Type, InetAddress> proxies;

    @Option(names = {"-s", "--silent"},
            defaultValue = "y",
            description = "Start in silent mode. Default: ${DEFAULT-VALUE}")
    private String silent;

    @Option(names = {"-l", "--localhost"},
            required = true,
            description = "Localhost address")
    private String localhost;

    @Option(names = {"-a", "--addresses"},
            split = ",",
            arity = "1..3",
            paramLabel = "<hostname>:<port>",
            description = "Optional comma-separated list of addresses in the format <hostname>:<port>." +
                    " Max 3 addresses")
    private List<String> addresses;

    public static void main(String[] args) { // bootstrap the application
        int exitCode = new CommandLine(new Cli()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        // your business logic goes here...

        System.out.printf("silent=%s%n", silent);
        System.out.printf("localhost=%s%n", localhost);
        System.out.printf("proxies=%s%n", proxies.toString());
        System.out.printf("addresses=%s%n", addresses.toString());
        return 0; // exit code
    }
}