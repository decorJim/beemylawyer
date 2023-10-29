# basic requirements
- make sure you have installed gradle somewhere
- make sure that it is a version compatible with your Java use https://docs.gradle.org/current/userguide/compatibility.html 
- In beemylawyer/gradle/wrapper/gradle-wrapper.properties make sure it is the same version as the one installed on your machine

# beemylawyer
backend code using spring boot main user data are stored in class Account.
- @Autowired used to automatically initialise objects.
- DTO objects are used for communication with the front end are the equivalent 
of an interface in other language.
- class are directly mapped to sql tables with @Column 
- repository class are used to communicate with sql database using built-in 
funtions ex:save(), findById()

# database
heroku postgre is used to have a remote database configurations are in the file
src/main/ressources/application.propreties can connect to it using sql editor
like postgresql 

# connect to database with sql editor (postgresql)
- right click on servers
- create a new server named heroku or another name
- enter host given on heroku, enter databse name, enter username
- chose yellow colored database in list of decoys

# Generate beemylawyer-0.0.1-SNAPSHOT.jar file
- enter command ./gradlew build

# host application with docker and google cloud
DOCKER
must have downloaded docker desktop and run docker desktop as admin
create a repo on dockerhub for remote image ex:decorjim/beemylawyer-docker
build project with command $ ./gradlew clean build
Make sure folder build/libs is created and open terminal at build/libs
check if generated jar file works with command $ java -jar beemylawyer-0.0.1-SNAPSHOT.jar
- open a terminal and enter docker login with username and password
- go to the location path containing dockerfile of the project
- enter command $ docker build -t beemylawyer .
- check the build with command $ docker images
- map local docker image to remote docker image with command $ docker tag beemylawyer decorjim/beemylawyer-docker
- upload image to dockerhub using command $ docker push decorjim/beemylawyer-docker
- remove both images on pc with command $ docker rmi beemylawyer decorjim/beemylawyer-docker
- check if no images left on pc with command $ docker images
- make sure nothing is running on port 8080 with command $ ping 8080
- pull and run remote image with command $ docker run -p 8080:8080 decorjim/beemylawyer-docker
(first port is local machine port for run)(second if remote image port)

https://www.youtube.com/watch?v=SzbeDqBSRkc&t=697s&ab_channel=PlayJava
KUBERNETES
- Go to kubernetes Clusters
- Create a cluster standard and give it a name (k8s-beemylawyer-docker) and wait for creation 
- Connect to cluster by clicking on the right (3 dots) and choose execute with cloud shell
- the default command will show so press enter to execute
- Make sure there is no old yaml file with command $ ls 
- If old yaml file exist, delete them with command $ rm beemylawyer-k8s-deployment.yaml
- Click on 3 dots and choose import, file is checked and pick beemylawyer-k8s-deployment.yaml in the project
- Click import 
- Execute yaml file with command $ kubectl apply -f beemylawyer-k8s-deployment.yaml
- Go to workloads and click on Last name (beemylawyer-deployment name)
- In Managed Pods section click on the last name in blue
- At the top click on EXPOSE
- put 8080 in Target port 1 and choose load balancer for service type
- Go back to workload and click on Last name (beemylawyer-deployment name)
- In Associated services click on Endpoints (blue IP adress)
- check if http request works by using postman and replacing http://localhost by generated IP in blue
