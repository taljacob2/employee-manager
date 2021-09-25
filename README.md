# Deploy Springboot Gradle to Heroku

1. [Sign up](https://signup.heroku.com/) a new user in Heroku.

1. Download [HerokuCLI](https://devcenter.heroku.com/articles/heroku-cli).

1. `login` to heroku user via the command:
   ```sh
   heroku login -i
   ```

1. Create an app via the command:

   ```sh
   heroku create YOUR-APP-UNIQUE-NAME
   ```
1. Connect PostgreSQL database to your app:
   >  No credit card is required.

   To do so, run this command:

   ```sh
   heroku addons:create heroku-postgresql --app YOUR-APP-UNIQUE-NAME
   ```
   > Set `YOUR-APP-UNIQUE-NAME` to be the same as your definition in *[Step 4]*.

1. Set `application.properties` file to the PostgreSQL database:

	```properties
	#--------------------------------------------
	# Heroku configurations:
	#-----------------------
	# DB Settings
	spring.datasource.driverClassName=org.postgresql.Driver
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL95Dialect
	spring.jpa.properties.hibernate.globally_quoted_identifiers=true
	spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

	# Logging (THIS IS OPTIONAL)
	logging.level.org.hibernate.SQL=debug
	logging.level.org.hibernate.type.descriptor.sql=trace

	# DDL
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.generate-ddl=true

	# Port
	server.port=${PORT}

	#-----------------------
	# NOTES:
	#
	# Heroku automatically *creates and injects* the env-variables:
	# `SPRING_DATASOURCE_URL`
	# `SPRING_DATASOURCE_USERNAME`
	# `SPRING_DATASOURCE_PASSWORD`
	#
	# Heroku automatically *creates* the env-variable:
	# `${PORT}`
	#--------------------------------------------
	```

	> *Side Note:*
 Do *NOT* create any `schema` when using PostgreSQL. Because the database would not be able to `spring.jpa.hibernate.ddl-auto=` `update` / `create` it on boot.

1. We use the [Heroku Gradle Plugin](https://github.com/heroku/heroku-gradle) to deploy:

	1. #### Build a .jar file:
		> It is a *MUST* to do so with the **`bootJar`** command.

		To *name your .jar*, add this template to your `build.gradle`.

		```groovy
		nameArchive("app")

		private void nameArchive(String name) {
		    project.setArchivesBaseName(name)
		    project.setVersion("")
		}
		```
		> We chose in this example to set the .jar name to "`app.jar`"
	
		Then, build the .jar.
		To do so, run the command:
		```sh
		gradle bootJar
		```

	1. #### Deploy to Heroku:
		Add this template to your `build.gradle`.

		```groovy
		plugins {
		  id "com.heroku.sdk.heroku-gradle" version "2.0.0"
		}

		heroku {
		    appName = "YOUR-APP-UNIQUE-NAME"
		    includes = ["README.md"]
		    includes = ["build/libs/app.jar"]
		    includeBuildDir = false
		    jdkVersion = 8
		    processTypes(
		            web: "java -jar build/libs/app.jar"
		    )
		}
		```
		> Set `appName` to be the same as your definition in *[Step 4]*.

		To deploy, run the command:
		```sh
		gradlew build deployHeroku
		```

