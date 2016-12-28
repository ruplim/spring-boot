http://localhost:8080/rate

Use Bootstrap.properfties file to add below lines::
spring.profiles.active=default
spring.cloud.config.uri=http://localhost:8888


Otherwise profile value ( default/qa)  are not updated.

