# Sử dụng một image chứa JDK 21
FROM adoptopenjdk:21-jdk-hotspot

# Đặt thư mục làm việc trong container là /app
WORKDIR /app

ADD target/