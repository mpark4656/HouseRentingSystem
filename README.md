# Build
mvn clean package && docker build -t com.app/HouseRentingSystem .

# RUN

docker rm -f HouseRentingSystem || true && docker run -d -p 8080:8080 -p 4848:4848 --name HouseRentingSystem com.app/HouseRentingSystem 