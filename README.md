# JavaMySQL
implementation of connecting to mysql database and fetching column names, 
values, and metadata.
users can parse queries in the form of parameters.

# Requirements
1. Maven .Jar MySQL Library
2. Intellij Editor

# Usage
## Init Connection
ConnectDB myConnect = new ConnectDB("jdbc:mysql://localhost:3306/{Your Database Name}","{Your Username}","{Your Password}");

## Execute Connection
myConnect._Connection();

## Bind Your Query
myConnect._Statement("{Type Your Query}");

## Get Result
myConnect._Result();

## Print Metadata
myConnect._printMetaData();
