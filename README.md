# ap

Start mongo db
Windows :
cd C:\Program Files\MongoDB\Server\3.6\bin>
mongod

restore Mongo ap-db
Windows:
C:\Program Files\MongoDB\Server\3.6\bin>>mongorestore <project root>\ap\data

backup Mongo ap-db
Windows:
C:\Program Files\MongoDB\Server\3.6\bin>mongodump -d ap-db -o <project root>\ap\data
