(cd produtos && ./gradlew build --no-daemon) && (cd usuario && ./gradlew build --no-daemon) && (cd api-gateway && ./gradlew build --no-daemon) && docker-compose -f docker-compose.dev.yml up -d
