FROM openjdk:8
ADD target/currency-exchange_transaction.jar currency-exchange_transaction.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "currency-exchange_transaction.jar", "--env_host=docker"]