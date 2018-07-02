-- Currencies
INSERT INTO currency (id, name, symbol) VALUES (1, 'United States Dollar', 'USD');
INSERT INTO currency (id, name, symbol) VALUES (2, 'Euro', 'EUR');

-- Exchange Rate
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-06-23', 0.85);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-06-24', 0.86);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-06-25', 0.87);;
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-06-26', 0.85);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-06-27', 0.84);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-06-28', 0.83);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-06-29', 0.84);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-06-30', 0.85);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-07-01', 0.86);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (1, 2, '2018-07-02', 0.86);

INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-06-23', 1.14);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-06-24', 1.15);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-06-25', 1.16);;
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-06-26', 1.17);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-06-27', 1.16);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-06-28', 1.15);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-06-29', 1.14);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-06-30', 1.13);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-07-01', 1.14);
INSERT INTO exchange_rate (currency_source_id, currency_destination_id, exchange_date, rate) VALUES (2, 1, '2018-07-02', 1.16);