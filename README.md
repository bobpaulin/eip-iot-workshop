
# Enterprise Integration Patterns with IoT

Aka Karaf Camel Pi

1.  Install Karaf

	wget http://apache.petsads.us/karaf/3.0.3/apache-karaf-3.0.3.tar.gz
	tar -zxvf apache-karaf-3.0.3.tar.gz
	chmod -R 777 apache-karaf-3.0.3
2.  Update bin/karaf start script

	JAVA_MAX_MEM=256M
	
	Remove the -server option from script
	
3.  Update etc/custom.properties to ensure proper native Pi4J library gets loaded (hard float only)
	
	org.apache.felix.processor.feature=vfp
	
4.  Start karaf

	sudo ./karaf

5.  Install addition karaf feature repos

	feature:add-repo activemq
	feature:add-repo camel

6.  Install karaf features
    
	feature:install activemq-broker-noweb
	feature:install jms
	feature:install camel-core
	feature:install camel-blueprint
	feature:install camel-jms
	feature:install camel-restlet
	feature:install camel-websocket
	
7.  Create JMS Broker

	jms:create -t activemq --url tcp://localhost:61616 test

 