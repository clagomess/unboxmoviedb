FROM debian:9

RUN apt update
RUN apt install maven git openjdk-8-jdk -y

# só para montar a .m2
RUN cd /srv && git clone --progress https://github.com/clagomess/unboxmoviedb
RUN cd /srv/unboxmoviedb && mvn clean compile package