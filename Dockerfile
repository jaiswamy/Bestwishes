FROM tomcat:9.0.104-jdk8-temurin
LABEL "Project"="Bestwishes"
LABEL "Author"="Jai"

WORKDIR /usr/local/tomcat/webapps/
RUN rm -rf ROOT*
COPY ./greeting.war ROOT.war
RUN wget -q -O /tmp/mysql-connector.tar.gz https://downloads.mysql.com/archives/get/p/3/file/mysql-connector-java-5.1.29.tar.gz \
    && tar -xzf /tmp/mysql-connector.tar.gz -C /tmp \
    && mv /tmp/mysql-connector-java-5.1.29/mysql-connector-java-5.1.29-bin.jar /usr/local/tomcat/lib/ \
    && rm -rf /tmp/mysql-connector*
ENV DB_HOST=db \
    DB_PORT=3306 \
    DB_NAME=db_wishes \
    DB_USER=root \
    DB_PASSWORD=mysql123

EXPOSE 8080
CMD ["catalina.sh", "run"]
