-- Currencies
INSERT INTO currency (id, name, symbol) VALUES (1, 'United States Dollar', 'USD');
INSERT INTO currency (id, name, symbol) VALUES (2, 'Euro', 'EUR');

-- Transactions
INSERT INTO transaction (currency_source_id, currency_destination_id, amount, transaction_date, rate)
  VALUES (1, 2, 10, '2018-04-03', 1.17);
INSERT INTO transaction (currency_source_id, currency_destination_id, amount, transaction_date, rate)
  VALUES (1, 2, 20, '2018-05-03', 1.15);
INSERT INTO transaction (currency_source_id, currency_destination_id, amount, transaction_date, rate)
  VALUES (1, 2, 20, '2018-06-03', 1.20);
