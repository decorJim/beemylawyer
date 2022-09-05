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

# host application with docker and google cloud
DOCKER
must have downloaded docker desktop and run docker desktop as admin
create a repo on dockerhub for remote image ex:decorjim/beemylawyer-docker
1-open a terminal and enter docker login with username and password
2-go to the location path containing dockerfile of the project
3-enter command $ docker build -t beemylawyer .
4-check the build with command $ docker images
5-map local docker image to remote docker image with command $ docker tag beemylawyer decorjim/beemylawyer-docker
6-upload image to dockerhub using command $ docker push decorjim/beemylawyer-docker
7-remove both images on pc with command $ docker rmi beemylawyer decorejim/beemylawyer-docker
8-check if no images left on pc with command $ docker images
9-make sure nothing is running on port 8080 with command $ ping 8080
10-pull and run remote image with command $ docker run -p 8080:8080 decorjim/beemylawyer-docker
(first port is local machine port for run)(second if remote image port)
