# Thread Driven vs Event Driven Showcase

In this project we will check the performance between *thread driven* and *event driven* servers whit a small thread pool size.

- *thread driven*: Node & Spring Webflux

- *event driven* Spring MVC

## Getting Started

You will deploy 4 services:

- Late-request: A node API that takes 5 seconds to resolve a request

- Late-request-node-consumer: A Node API that consume the **late-request** API

- Late-request-rest-consumer: A Spring MVC API that consume the **late-request** API

- Late-request-reactive-consumer: A Spring Webflux API that consume the **late-request** API

## Run

Up all services:

```sh
docker-compose up --b
```

Make requests to ours services

````sh
bash calls.bash
````

## Results

We will check that the request timed is very similar in the 3 cases:

```sh
NODE
Node: Late Request 5.056753
Node: Late Request 5.062122
Node: Late Request 5.067157
SPRING - REACTIVE
Spring Reactive: Late Request 5.696767
Spring Reactive: Late Request 5.782412
Spring Reactive: Late Request 5.758325
SPRING - MVC
Spring MVC: Late Request 5.711414
Spring MVC: Late Request 5.706524
Spring MVC: Late Request 5.714355
```

But if the `TOMCAT_MAX_THREADS`  in `.env` is setted to 1, the thread pool will be locked waiting for the **late-request** response and you can check the how longs it takes the **late-request-rest-consumer** service to respond.

```sh
NODE
Node: Late Request 5.054729
Node: Late Request 5.054304
Node: Late Request 5.062733
SPRING - REACTIVE
Spring Reactive: Late Request 5.456924
Spring Reactive: Late Request 5.480787
Spring Reactive: Late Request 5.472499
SPRING - MVC
Spring MVC: Late Request 5.249209
Spring MVC: Late Request 10.265285
Spring MVC: Late Request 15.271591
```
