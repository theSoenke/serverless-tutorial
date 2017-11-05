## Vorraussetzungen
Für dieses Tutorial empfehlen wir die Poolrechner mit Linux zu verwenden. Auf diesen Rechner ist bereits alle notwendige Software und der richtigen Version vorinstalliert.

Es ist ebenfalls möglich das Tutorial auf dem eigenen Rechner durchzuführen.
Dafür gibt es folgende Vorraussetzungen an Software, die installiert sein muss:
- Docker >= 17.04
- Docker Compose >= 1.13

## OpenFaaS Einleitung

## Aufgabe 1: Setup
Als erster Schritt muss eine lokale OpenFaaS Instanz vor allen weiteren Schritten gestartet werden. Dafür müssen folgende Schritte ausgeführt werden:

### OpenFaaS
1. Ein Terminal öffnen und in ein Verzeichnis navigieren z.b.

    `cd ~/Downloads`
2. OpenFaaS Repository klonen

    `git clone https://github.com/openfaas/faas`
3. In das erstelle Verzeichnis navigieren

     `cd faas`
4. Richtige Version in Git auschecken

    `git checkout 0.6.8`
4. Docker Swarm initialisieren

    `docker swarm init`
5. OpenFaaS Start Script ausführen

    `./deploy_stack.sh`

Wenn das OpenFaaS Setup erfolgreich gestartet wurde lässt sich nun [http://localhost:8080](http://localhost:8080) im Browser öffnen. Auf mehr Details in dem Webinterface soll in der nächsten Aufgabe eingegangen werden.

## Aufgabe 2: Funktionen ausführen
Nachdem in Aufgabe 1 eine lokale OpenFaaS Instanz gestartet wurde sollen in dieser Aufgabe nun erste Funktionen ausgeführt werden.

### Webinterface
Der einfachste Weg Funktionen in OpenFaaS auszuführen ist über das Webinterface auf [http://localhost:8080](http://localhost:8080) im Browser.

![openfaas ui](images/openfaas-ui.png)

Als erstes soll nun die Funktion `func_wordcount` ausgeführt werden. Die Funktion liefert die Anzahl an Zeilenumbrüchen, Wörtern und Zeichen für den Text im Request Body zurück. Zunächst muss etwas als Inhalt im Request Body im Webinterface angegeben werden. Anschließend ruft ein Klick auf "Invoke" die Funktion auf und gibt den Response Body, sowie einen HTTP Status Code zurück. Ebenfalls können weitere Funktionen wie `func_markdown` ausgeführt werden, die Markdown in HTML konvertiert.

### API
Das Webinterface eignet sich sehr gut, um sich Funktionen anzeigen zu lassen und zu testen, was die Eingabe und Ausgabe ist.

Für komplexerer Funktionen oder den praktischen Einsatz in Kombination mit anderen Systemen ist jedoch die REST API von OpenFaaS sehr viel nützlicher.

Funktionen können in OpenFaaS durch einen HTTP POST Request aufgerufen werden. Die URL für den Request setzt sich aus dem Host auf dem OpenFaaS läuft, dem Port und dem Funktionsnamen zusammen. Eine URL könnte Beispielsweise folgendermaßen aussehen:

    http://localhost:8080/function/hello-world

POST Request können in cURL mit folgendem Befehl geschickt werden:

    curl -X POST <URL>

Nun sollt ihr die Funktion `func_nodeinfo` mit einem cURL ausführen, die Informationen zum System zurückliefert. Wenn alles erfolgreich funktioniert hat wird cURL das Betriebssystem, Anzahl der verfügbaren CPU Kernen und Laufzeit des System zurückliefern.

Auch über cURL lassen sich Daten mit im Request Body übergeben, die für Funktionen benötigt werden. Hierfür soll nun die die Funktion `func_wordcount` ausgeführt werden. Daten im Request Body lassen sich in cURL folgendermaßen übergeben:

    curl -X POST <URL> -d "content"

Wenn dieser Funktion ausgeführt wird nun die Anzahl der Wörter zurückgeliefert.


## Aufgabe 3: Funktionen erstellen
In dem nächsten Schritt sollen nicht mehr länger nur bestehende Funktionen ausgeführt werden, sondern die erste eigene Serverless Function in Java geschrieben werden.

### OpenFaaS CLI
Es ist möglich OpenFaaS komplett über die REST API zu steuern. Einige Aufgaben werden durch den Kommandozeilen Client jedoch deutlich erleichtert. Beispielsweise das Hochladen neuer Funktionen. Deshalb soll im nächsten Schritt der OpenFaaS CLI client installiert werden. Dafür muss folgender Befehl im Terminal ausgeführt werden:

    curl -sSL https://cli.openfaas.com | sh #

*Don't try this at home*

## Aufgabe 4: Funktionen kombinieren

## Aufgabe 5: Funktionen konsumineren

[Tutorial starten](/setup)