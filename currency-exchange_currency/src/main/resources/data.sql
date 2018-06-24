-- Currencies
INSERT INTO currency (id, name, symbol) VALUES (1, 'United States Dollar', 'USD');
INSERT INTO currency (id, name, symbol) VALUES (2, 'Euro', 'EUR');

-- Exchange Rate
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate)
 VALUES (1, 2, '2018-04-03', 1.17);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate)
 VALUES (1, 2, '2018-05-03', 1.15);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate)
 VALUES (1, 2, '2018-06-03', 1.14);
