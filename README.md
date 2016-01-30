# Go
## Generate

```
protoc --go_out=plugins=grpc:go/proto awesome_service.proto
```

## Execute
### Server
```
cd go/server
go run main.go
```
### Client
```
cd go/client
go run main.go
```

# Java
## Generate

```
protoc --java_out=java/src/main/java awesome_service.proto
protoc --plugin=protoc-gen-grpc-java=/usr/local/bin/protoc-gen-grpc-java --grpc-java_out=java/src/main/java  awesome_service.proto
```

## Execute
Use NetBeans IDE
