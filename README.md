# Description
This project is to demo Java command line applications.
## CLI Usage

        java -cp ./target/lib -jar target/cli-1.0-SNAPSHOT.jar -h
                                [-a=<hostname>:<port>]
                                [-h]
                                [-l=<localhost>]
                                [-p <Proxy.Type>=<InetAddress>]
                -a, --addresses=<hostname>:<port>[,<hostname>:<port>...] [<hostname>:<port>
                      [<hostname>:<port>]]
                                        Optional comma-separated list of addresses in the
                                          format <hostname>:<port>. Max 3 addresses
                -h, --help              Show this help message and exit.
                -l, --localhost=<localhost>
                                        Localhost address
                -p, --proxyHost=<Type=InetAddress>
                                        Proxy can be DIRECT, HTTP or SOCKS
                -s, --silent=<silent>   Start in silent mode. Default: y
                -V, --version           Print version information and exit.
        
  ![help command](/images/help.png)
       
        java -cp ./target/lib -jar ./target/cli-1.0-SNAPSHOT.jar -a=127.0.0.1:8080,127.0.255.255:9000 -l=127.0.0.1:80 -p HTTP=127.0.0.255
                
                silent=y
                localhost=127.0.0.1:80
                proxies={HTTP=/127.0.0.255}
                addresses=[127.0.0.1:8080, 127.0.255.255:9000]
## Author

S