## Run

```
mvn spring-boot:run
```

# Open graphiql
http://localhost:8080/

```
{
  serverTime
  products(name:"płatki"){
    name
    store{
      name
    }
  }
}

```