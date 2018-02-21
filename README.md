# Java By Beispiel


## strategy-pattern-predicate
Project strategy-pattern-predicate shows the Strategy Pattern using Predicate

s.a. https://dzone.com/articles/design-patterns-the-strategy-and-factory-patterns?edition=256684&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=dd%202016-12-20

Status: ok


## lambda-expression
Project lambda-expressions shows
- Method References to static Methods
- Method References to Instance Methods
- Method References with Generics
- Constructor References
- Predefined Functions 

s.a Java8TheCompleteReference-NinthEd-2014 / Chapter 15 Lambda Expresseion

Status: ok


## lambda-comparators
Project lambda-comparators shows
- the use of comparators with lambda (which is easier than implementing the classic Java-Comparator)
- Lombok

s.a. https://www.mkyong.com/java8/java-8-lambda-comparator-example/?utm_source=mkyong&utm_medium=sidebar&utm_campaign=100k-500k&utm_content=3

Status: ok


## streams
Project streams shows
- the use of stream, e.g. filter, maps, reduce and sort

Status: ok


## vert.x
Project vert.x show
- the use of Verticles

##### build it
cd vertx-angular1 \
mvn clean compile
##### run it
./redeploy.sh \
http://localhost:8080/

see https://github.com/vert-x3/vertx-guide-for-java-devs/tree/master/step-9

see also 
http://vertx.io/docs/guide-for-java-devs/ \
https://github.com/vert-x3/vertx-guide-for-java-devs \
http://vertx.io/blog/building-a-real-time-web-app-with-angular-ngrx-and-vert-x/ \
(https://github.com/benorama/ngrx-realtime-app https://github.com/vert-x3/vertx-examples)

Todos:
- wie wird der Web-Client eigentlich ganau an dem Bus registriert??
- Lombok funktioniert nicht?
- Dependency Management? in parent pom???
- einige Klassen sind deprecated z.B. in HttpServerVerticle

Status: to be finished 

## angular
Samples with Angular 5 shows:
- Concept of Components
- Routing
- HttpClient (and Mock for Server)
- a Search-Component while you type

#### nodejs
Simple sample using NodeJs
'$ node nodejs/simple-app.js'
then open http://localhost:3000/

#### quick-start
see https://angular.io/guide/quickstart
##### run it
'$ cd quick-start \
$ ng serve --open'
##### build it
ng build --prod

#### tutorial
see https://angular.io/tutorial
##### run it
'$ cd tutorial \
$ ng serve --open'
##### build it
ng build --prod

Todos:
- wie wird jshint (codechecker) verwendet? Es gibt eine Datei tslint?

Status: to be finished



## todos
- Reactive Programming
see Samples in http://www.javamagazine.mozaicreader.com/JanFeb2018#&pageSet=0&page=0&contentItem=0 
    start with Spring Boot Reactor Sample using MongoDB
    see CQRS Kafka Sample    
see https://dzone.com/articles/rxjava-part-1-a-quick-introduction 
oder https://dzone.com/articles/deal-with-hot-observables-in-a-web-ui?edition=337908&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202017-11-25
(das Beispiel evtl. mit Angular implementieren?)
see https://www.infoq.com/articles/Designing-Implementing-Using-Reactive-APIs?utm_source=notification_email&utm_campaign=notifications&utm_medium=link&utm_content=content_in_followed_topic&utm_term=daily

- Reactive and Java 9
https://dzone.com/articles/reactive-streams-in-java-9
https://aboullaite.me/reactive-streams-example-java-9/?elq_mid=102312&sh=17261316962220229152411102214&cmid=WWMK170418P00047    

- Java 9 u. Modules
implement a sample z.B. https://www.infoq.com/articles/CIWithJava9VertX

- Circut Breaker Pattern see https://spring.io/guides/gs/circuit-breaker/

- jdepend: or FitnessTest, in Tests the dependencies between packages should be verified!
  Maybe use static code analysis and find dependencies between packages by using the imports
  
- Javaslang bzw. das Projekt hat einen neuen Namen s. http://www.vavr.io/
  => Achtung! Vavr verwendet gleiche Klassennamen wie die in Java bereits bekannten, z.B. List, das kann zu Irritationen führen? 

- Spring Boot MicroServices with Consul (Registry)
https://www.infoq.com/articles/Microservices-SpringBoot?utm_source=notification_email&utm_campaign=notifications&utm_medium=link&utm_content=content_in_followed_topic&utm_term=daily

- Spring Boot und Prometheus
https://aboullaite.me/spring-boot-monitoring-prometheus-grafana/

- Streams and Splitter Sample, s. Mail 1.1.2018

- Enums & Validation: https://dzone.com/articles/validations-using-enum?edition=235182&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=dd%202016-10-25

- CoreJavaAdvancedFeatures-10thEd-2015 -> Optional

- Data Structures in Java
http://www.javaworld.com/article/3215112/learn-java/java-101-datastructures-and-algorithms-in-java-part-1.html?idg_eid=d59278da06accc91ade1688938e166a0&email_SHA1_lc=b6f9755e63b6a3098c23b74f35fa836d5cac85fd&cid=jw_nlt_javaworld_weekly_2017-08-24&utm_source=Sailthru&utm_medium=email&utm_campaign=Javaworld%20Update%202017-08-24&utm_term=javaworld_weekly

