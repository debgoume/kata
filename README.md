# kata
kata SG for interview

## Database settings

Project comes with a H2 database 

Go to http://localhost:<port>/kata/h2-console/ to connect to database if needed

# JMX Monitoring 
To moniror account service methods launch jconsole on your terminal, select your server (catalina if Tomcat)
and open com.sk.kata.service.monitor 

There you can forbid and allow access to a method and watch its performance indicators

# Unit tests
Unit tests have been voluntarily limited to AccountController only, they should extended to AccountService and repositories for a live production application
