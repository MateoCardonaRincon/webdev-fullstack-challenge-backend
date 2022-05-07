# webdev-fullstack-challenge-backend

### Steps to enjoy this to-do manager app:
You need to be sure that your backend is running before start the client side of the application, so lets follow the next steps
#### 1. Clone this backend repository (either in git bash or using your favorite terminal) by typing:
    git clone https://github.com/MateoCardonaRincon/webdev-fullstack-challenge-backend.git
#### 2. Open your MySQL Workbench (or use a terminal if you prefer) to create a new Schema with the name todo_app
(this is the name of the schema that I set on the application.properties file, if you want to change it feel free of doing it).
#### 3. Open the cloned repository in your favorite Java IDE and let the dependencies get installed (this is a Maven project).
#### 4. Go to the application.properties file, located in /src/main/resources, and set the MySQL credentials of your local instance (password, username, url).
Please let the port as it is, the well-known 8081 port, since the frontend is set to retrieve and send data using the base URI http://localhost:8081/api/...
#### 5. Now, run the ChallengeBackendApplication located in the folder /src/main/java
This step will start the backend application, and now you are ready to test the API through postman,
or even better, to try the fullstack application from the frontend following the steps in the readme of the frontend repository
https://github.com/MateoCardonaRincon/webdev-fullstack-challenge-frontend

## Use Case:

  - This is an app about a To-Do task manager, and is just great!

  - Create your custom to-dos with descriptive title and message, and organize them by categories.

  - You can manage the state of your notes as you want. Check a note as done when you finish it, or update the title and message of the ones that are still pending to be completed.

  - If you want to take a note out of your sight, just delete it with a click! Did you finish all the notes of a category? You can also delete the category if you want,
but be careful because all the notes will go with it.

#### What are you waiting for to create your notes?!

### Taking a look at the code:

If you want to take a look at the code of this project you will find a spring boot application with four different layers
 - repository layer (also known as DAO layer): that connects directly with the database
 - service layer: that contains the business logic (all the validations are there)
 - controller layer: that defines the API endpoints that will be consumed by the client
 - entity layer: contains the model of the entities, their attributes and relations (OneToMany in our case)

Also two DTOs were created, one for the Note entity and other for the Category entity. These are the objects that are sent to the client.
Here, the Category entity maps only two of its attributes to the CategoryDTO, id and description.
The attribute 'notes', that stored the list of all the related notes, is ommited.
The entity Note maps all its attributes to the NoteDTO, nothing too impresive, but the concept is applied.

Let me know any advice that let me improve. Thank you!

#### Developed by Mateo Cardona Rincón as a challenge for the Web Development course
