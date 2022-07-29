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

