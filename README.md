# spring-soap-producer-consumer

## VIDEO
producer
https://www.youtube.com/watch?v=qf3SiOZajBY

consumer
https://youtu.be/f2bg78y43Y8

## Producer build and run

```
(cd producer && mvn jaxb2:xjc)
(cd producer && mvn spring-boot:run)
```

## Consumer build and run

```
(cd consumer && mvn jaxb2:generate)
(cd consumer && mvn spring-boot:run)
```

