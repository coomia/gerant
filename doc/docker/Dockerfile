FROM ubuntu

COPY sources.list /etc/apt/
#RUN ls /etc/apt/; cat /etc/apt/sources.list
RUN apt-get update;
RUN apt-get install unzip;
RUN apt-get install -y vim;
RUN apt-get install -y redis-server;

COPY jdk1.8.0_211.zip /usr/local/
RUN cd /usr/local/;ls;unzip jdk1.8.0_211.zip
ENV JAVA_HOME /usr/local/jdk1.8.0_211
ENV PATH $PATH:$JAVA_HOME/bin
RUN java -version