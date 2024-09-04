ALL_SERVICES=("api-gateway" "produtos" "usuario")

if [ "$#" -eq 0 ]; then
  SERVICES_TO_BUILD=("${ALL_SERVICES[@]}")
else
  SERVICES_TO_BUILD=("$@")
fi

build_service() {
  SERVICE=$1
  echo "Building $SERVICE"
  (cd $SERVICE && ./gradlew build --no-daemon)
}

for SERVICE in "${SERVICES_TO_BUILD[@]}"; do
  if [[ " ${ALL_SERVICES[*]} " == *"$SERVICE"* ]]; then
    build_service "$SERVICE"
  else
    echo "$SERVICE não encontrado"
  fi
done