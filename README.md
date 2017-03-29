# couchdb-docker-pcf

Steps:

cf push couchdb -o mwrightpivotal/couchdb:latest

cf cups cf-env-test -p "url, username, password, database"

    Note: set the URL to the one generated from pushing couchdb.  SSL validation is on.  Use http if possible or a valid cert would be needed
    
cd couchdb-sample

mvn package -DskipTests=true

cf push myclient -p target/couchdb-sample-0.0.1-SNAPSHOT.jar --no-start

cf bs myclient couchdb

cf start myclient
