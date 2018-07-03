# Projet Currency-Exchange

### Architecture microservices

La solution “currency-exchange” a été décomposé en deux microservices. Ce sont des applications déployables indépendamment, organisées autour de leurs propres domaines d'activité.

#### Diagramme des classes métiers
##### Avant le découpage de l’application en microservice

<p align="center">
  <img width="500" alt="Architecture Diagram" src="_doc/diagram/class_diagram.png?raw=true">
</p>

##### Après le découpage de l’application en microservice

<p align="center">
  <img width="500" alt="Architecture Diagram" src="_doc/diagram/class_diagram_decoupage.png?raw=true">
</p>

#### Diagramme d'architecture

<p align="center">
  <img width="500" alt="Architecture Diagram" src="_doc/Architecture Diagram.png?raw=true">
</p>

#### Transaction Service

Method	| Path	| Description	| Available from UI
------------- | ------------------------- | ------------- |:----------------:|
GET	| /transactions	| Récupèrer toutes les transactions	| × | 	
GET	| /transactions/{transactionId}	| Récupèrer une transaction par identifiant	|  | 	 
POST	| /transactions	| Ajouter ou modifier une transaction	|  |  
DELETE	| /transactions/{transactionId}	| Supprimer une transaction par identifiant	|  |  
GET	| /transactions/exchange/from/{from}/to/{to}/amount/{amount}	| Faire une transaction entre deux devises	| × |  

#### Currency Service

##### API Currency

Method	| Path	| Description	| Available from UI
------------- | ------------------------- | ------------- |:----------------:|
GET	| /currency	| Récupèrer toutes les devises	| × | 	
GET	| /currency/{currencyId} | Récupèrer une devise par identifiant	| × 
POST	| /currency	| Ajouter ou modifier une devises	| × |  
DELETE	| /currency/{currencyId}	| Supprimer une devise par identifiant	| × | 

##### API ExchangeRate

Method	| Path	| Description	| Available from UI
------------- | ------------------------- | ------------- |:----------------:|
GET	| /exchange-rate	|  Récupèrer tous les taux de change	| × | 	
GET	| /exchange-rate/{exchangeRateId}	| Récupèrer un taux spécifique par identifiant	|  
POST	| /exchange-rate	| Ajouter ou modifier un taux de change	| × | 
DELETE	| /exchange-rate/{exchangeRateId}	| Supprimer un taux de change	| × | 
GET	| /exchange-rate/latest/from/{from}/to/{to}	| Trouver le dernier taux entre deux devises	| × | 
GET	| /exchange-rate/from/{from}/to/{to}	| Trouver tous les taux entre deux devises	| × | 

### Compilation et execution

#### Local

```shell
$ mvn clean
$ mvn install
$ cd target
# L'application currency-exchange_transaction
$ java -jar currency-exchange_transaction.jar --currency_app_hostname=localhost
# L'application currency-exchange_currency
$ java -jar currency-exchange_currency.jar
```

#### Docker

##### L’application “Currency”

```shell
# Build a docker image
$ docker build -f Dockerfile -t currency-exchange_currency .
# Check if the image is created
$ docker images
# Run image
$ docker run -p 8000:8000 --name AppCurrency currency-exchange_currency
```

##### L’application “Transaction”

```shell
# Build a docker image
$ docker build -f Dockerfile -t currency-exchange_transaction .
# Check if the image is created
$ docker images
# Run image and link it to the currency app 
# to enable http communication between the two containers
$ docker run -p 8080:8080 --link AppCurrency --name AppTransaction currency-exchange_transaction
```
