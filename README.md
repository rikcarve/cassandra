# cassandra
Some tests with cassandra

```bash
docker run -p 9042:9042 --name cassandra cassandra
docker run -d -p 9042:9042 -e JVM_OPTS="-Xms1024M -Xmx1024M" --name cassandra cassandra
```

