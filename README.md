### Title Bot  

Create a web form that allows a user to type in a url to any website and have it then output the Title of that website on the same page. For example, if I typed in CNN.COM into the text input of the web page, it would spit out:

> CNN - Breaking News, Latest News and Videos

The application should consist of a javscript/html/css front end, and a backend API that fetches the page title.

You may use your preferred language for developing. Our preferred languages at chatmeter are scala and javascript.

This task should take you somewhere around 4 hours. Make a git repository available online and send us the link. Make sure that the application can be run by us with minimal set up. You will present the application during your next interview.

**Bonus points:**
- Use React or any other front end web framework for the web form (Vue, Angular, Ember, etc.)
- Write the API server in scala or node.js
- Make it look great. Styling with Bootstrap is preferred
- Display a historical list of all urls entered by the user, along with their titles
- Dockerize the application


### Setup  

1. Install Docker Compose  
```
$ apt-get install docker-compose -y  
```

1. Install sbt  
```
$ sudo apt-get update
$ sudo apt-get install apt-transport-https curl gnupg -yqq
$ echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
$ echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list
$ curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo -H gpg --no-default-keyring --keyring gnupg-ring:/etc/apt/trusted.gpg.d/scalasbt-release.gpg --import
$ sudo chmod 644 /etc/apt/trusted.gpg.d/scalasbt-release.gpg
$ sudo apt-get update
$ sudo apt-get install sbt
```

### Utilization  
#### Docker  
1. Use Docker Compose to build and run the web page.  
```
$ docker-compose up  
```

2. View webpage in any browser.  
```
$ http://localhost:9000/  
```

#### Command Line  
1.  Run the sbt tool in the console of your choice.  
```
$ sbt  
```

2. Within the SBT Terminal use the following command.  
```
$ run  
```

3. View webpage in any browser.  
```
$ http://localhost:9000/  
```
