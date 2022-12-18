Docker installation notwendig

-> commandline aufmachen und 'docker-compose up' nutzen. Sollte dann die Images von selber runterladen und starten

Könnte sein das Prometheus keine Verbindung zur spring-boot app aufbauen kann, dann muss in der /prometheus/prometheus.yml die target-ip angepasst werden. (Muss die system-ip sein)


Ports/Urls:

Prometheus:

http://localhost:9090


Grafana: (Derzeit noch auf 3000, da müssen wir noch einen anderen Port für suchen, aber alle anderen haben bei mir nicht funktioniert beim testen..)


http://localhost:3000