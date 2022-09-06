# beemylawyer
backend code using spring boot main user data are stored in class Account.
-@Autowired used to automatically initialise objects.
-DTO objects are used for communication with the front end are the equivalent 
of an interface in other language.
-class are directly mapped to sql tables with @Column 
-repository class are used to communicate with sql database using built-in 
funtions ex:save(), findById()

# database
heroku postgre is used to have a remote database configurations are in the file
src/main/ressources/application.propreties can connect to it using sql editor
like postgresql 

# connect to database with sql editor (postgresql)
1-right click on servers
2-create a new server named heroku or another name
3-enter host given on heroku, enter databse name, enter username
4-chose yellow colored database in list of decoys

# Generate beemylawyer-0.0.1-SNAPSHOT.jar file
1-enter command ./gradlew build

# host application with docker and google cloud
DOCKER
must have downloaded docker desktop and run docker desktop as admin
create a repo on dockerhub for remote image ex:decorjim/beemylawyer-docker
build project with command $ ./gradlew clean build
Make sure folder build/libs is created and open terminal at build/libs
check if generated jar file works with command $ java -jar beemylawyer-0.0.1-SNAPSHOT.jar
1-open a terminal and enter docker login with username and password
2-go to the location path containing dockerfile of the project
3-enter command $ docker build -t beemylawyer .
4-check the build with command $ docker images
5-map local docker image to remote docker image with command $ docker tag beemylawyer decorjim/beemylawyer-docker
6-upload image to dockerhub using command $ docker push decorjim/beemylawyer-docker
7-remove both images on pc with command $ docker rmi beemylawyer decorjim/beemylawyer-docker
8-check if no images left on pc with command $ docker images
9-make sure nothing is running on port 8080 with command $ ping 8080
10-pull and run remote image with command $ docker run -p 8080:8080 decorjim/beemylawyer-docker
(first port is local machine port for run)(second if remote image port)

https://www.youtube.com/watch?v=SzbeDqBSRkc&t=697s&ab_channel=PlayJava
KUBERNETES
1-Go to kubernetes Clusters
2-Create a cluster standard and give it a name (k8s-beemylawyer-docker) and wait for creation 
3-Connect to cluster by clicking on the right (3 dots) and choose execute with cloud shell
4-the default command will show so press enter to execute
5-Make sure there is no old yaml file with command $ ls 
6-If old yaml file exist, delete them with command $ rm beemylawyer-k8s-deployment.yaml
7-Click on 3 dots and choose import, file is checked and pick beemylawyer-k8s-deployment.yaml in the project
8-Click import 
9-Execute yaml file with command $ kubectl apply -f beemylawyer-k8s-deployment.yaml
10-Go to workloads and click on Last name (beemylawyer-deployment name)
11-In Managed Pods section click on the last name in blue
12-At the top click on EXPOSE
11-put 8080 in Target port 1 and choose load balancer for service type
12-Go back to workload and click on Last name (beemylawyer-deployment name)
13-In Associated services click on Endpoints (blue IP adress)
14-check if http request works by using postman and replacing http://localhost by generated IP in blue
