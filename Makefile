.PHONY: all
all: build

.PHONY: up
up:
	@docker-compose up -d

.PHONY: build
build:
	@./mvn compile

.PHONY: run-tests
run-tests:
	@./mvn mvn test

.PHONY: test
test:
	@docker exec jesusvegapic-TFG-java ./mvn test

.PHONY: run
run:
	@./

.PHONY: ping-mysql
ping-mysql: mvn spring-boot:run
	@docker exec jesusvegapic-TFG-mysql mysqladmin --user=root --password= --host "127.0.0.1" ping --silent

# Start the app
.PHONY: start-mooc_backend
start-mooc_backend:
	@./gradlew :run --args='mooc_backend server'

.PHONY: start-backoffice_frontend
start-backoffice_frontend:
	@./gradlew :run --args='backoffice_frontend server'
