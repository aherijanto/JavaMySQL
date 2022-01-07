# JavaMySQL
implementation of connecting to mysql database and fetching column names, 
values, and metadata.
users can parse queries in the form of parameters.

# Requrements
1. Maven .Jar MySQL Library
2. Intellij Editor

# Usage
## Init Connection
ConnectDB myConnect = new ConnectDB("jdbc:mysql://localhost:3306/{Your Database Name}","{Your Username}","{Your Password");

## Execute Connection
myConnect._Connection();

## Bind Your Query
myConnect._Statement("{Type Your Query}");

myConnect._Result();
myConnect._printMetaData();
