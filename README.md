# Java WebService SOAP
Application client-server.

## Client
The client sends a request to central server asking for the prediction of the horoscope and the weather.

## Server
There are 3 servers: central server, horoscope server and weather server.
A central server recive the request. If the server has the answer in the cache, it returns the answer, otherwise it consults the appropriate server.

## Run
build each each server and client with:
```sh
$ javac *.java
```

Proceed to the execution of the server of horoscope and weather:
```sh
java servidorclima.ServidorClima ipW portW
java servidorhoroscopo.ServidorHoroscopo ipH portH
```

Proceed to the execution of the central server:
```sh
java servidorcentral.ServidorCentral centralIp centralPort
ipW portW ipH portH
```
and the client:
```sh
java cliente.Cliente ipCentral puertoCentral (date, sign)```
```

Test:
```sh
$java -Djava.rmi.server.hostname=127.0.0.1 ServidorEco 54321
$java -Djava.security.policy=servidor.permisos ServidorEco 54321
```
