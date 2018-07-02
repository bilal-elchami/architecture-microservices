Method	| Path	| Description	| Available from UI
------------- | ------------------------- | ------------- |:----------------:|
GET	| /transactions	| Récupèrer toutes les transactions	| × | 	
GET	| /transactions/{transactionId}	| Récupèrer une transaction par identifiant	|  
POST	| /transactions	| Ajouter ou modifier une transaction	| × 
DELETE	| /transactions/{transactionId}	| Supprimer une transaction par identifiant	| × 
GET	| /transactions/exchange/from/{from}/to/{to}/amount/{amount}	| Faire une transaction entre deux devises	| × 


Method	| Path	| Description	| Available from UI
------------- | ------------------------- | ------------- |:----------------:|
GET	| /currency	| Récupèrer toutes les devises	| × | 	
GET	| /currency/{currencyId}	| Récupèrer une devise par identifiant	|  
POST	| /currency	| Ajouter ou modifier une devises	| × 
DELETE	| /currency/{currencyId}	| Supprimer une devise par identifiant	| × 

Method	| Path	| Description	| Available from UI
------------- | ------------------------- | ------------- |:----------------:|
GET	| /exchange-rate	|  Récupèrer tous les taux de change	| × | 	
GET	| /exchange-rate/{exchangeRateId}	| Récupèrer un taux spécifique par identifiant	|  
POST	| /exchange-rate	| Ajouter ou modifier un taux de change	| × 
DELETE	| /exchange-rate/{exchangeRateId}	| Supprimer un taux de change	| × 
GET	| /exchange-rate/exchange/from/{from}/to/{to}	| Trouver le dernier taux entre deux devises	| × 
GET	| /exchange-rate/exchange-rates/from/{from}/to/{to}	| Trouver tous les taux entre deux devises	| × 