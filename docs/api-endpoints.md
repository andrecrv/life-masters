# API Endpoints  
  All API routes are prefixed with `/api/` to distinguish them from other application routes.

## 🚀 Users

- **GET** `/users`  
   Retrieve all users.  

- **GET** `/users/{id}`  
  Retrieve a user by ID.  

- **GET** `/users?username={username}`  
  Retrieve a user by username.  

- **POST** `/users`  
  Create a new user.  

- **PUT** `/users/{id}`  
  Update a user by ID.  

- **DELETE** `/users/{id}`  
  Delete a user by ID.  


## 📋 Tasks

- **GET** `/tasks`  
    Retrieve all tasks.  

- **GET** `/tasks/{id}`  
    Retrieve a task by ID.  

- **GET** `/tasks?status={status}`  
    Retrieve tasks filtered by status.  

- **GET** `/tasks?priority={priority}`  
    Retrieve tasks filtered by priority.  

- **GET** `/tasks?taskType={taskType}`  
    Retrieve tasks filtered by type.  


## 🎯 Goals

- **GET** `/goals`  
    Retrieve all goals.  

- **GET** `/goals/{id}`  
    Retrieve a goal by ID.  

- **GET** `/goals?status={status}`  
    Retrieve goals filtered by status.  

- **GET** `/goals?difficulty={difficulty}`  
    Retrieve goals filtered by difficulty.  

- **GET** `/goals?goalType={goalType}`  
    Retrieve goals filtered by type.  


## 🧑‍💻 User's Tasks

- **GET** `/users/{userId}/tasks`  
    Retrieve tasks for a specific user.  

- **GET** `/users/{userId}/tasks?status={status}`  
    Retrieve user tasks filtered by status.  

- **GET** `/users/{userId}/tasks?priority={priority}`  
    Retrieve user tasks filtered by priority.  

- **GET** `/users/{userId}/tasks?taskType={taskType}`  
    Retrieve user tasks filtered by type.  

- **POST** `/users/{userId}/tasks`  
    Create a new task for the user.  

- **PUT** `/users/{userId}/tasks/{taskId}`  
    Update a task for the user.  

- **DELETE** `/users/{userId}/tasks/{taskId}`  
    Delete a user's task.  


## 🎯 User's Goals

- **GET** `/users/{userId}/goals`  
    Retrieve goals for a specific user.  

- **GET** `/users/{userId}/goals?status={status}`  
    Retrieve user goals filtered by status.  

- **GET** `/users/{userId}/goals?difficulty={difficulty}`  
    Retrieve user goals filtered by difficulty.  

- **GET** `/users/{userId}/goals?goalType={goalType}`  
    Retrieve user goals filtered by type.  

- **POST** `/users/{userId}/goals`  
    Create a new goal for the user.  

- **PUT** `/users/{userId}/goals/{goalId}`  
    Update a goal for the user.  

- **DELETE** `/users/{userId}/goals/{goalId}`  
    Delete a user's goal.  
