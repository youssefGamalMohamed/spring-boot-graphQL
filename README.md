# Spring Boot GraphQL Example

This project demonstrates how to integrate GraphQL with Spring Boot, utilizing MySQL for data persistence. It features basic CRUD operations for users and posts, along with a follow functionality between users.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **GraphQL**: Query language and runtime for your API.
- **MySQL**: Relational database management system.
- **Hibernate**: ORM (Object-Relational Mapping) framework for JPA.
- **Maven**: Dependency management and build automation tool.

## Getting Started

To run this project locally, follow these steps:

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK), preferably JDK 8 or higher
- Maven
- MySQL (running locally)

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/youssefGamalMohamed/spring-boot-graphQL.git
   cd spring-boot-graphQL
   ```

2. **Configure MySQL**:

    - Create a MySQL database named `blogs_db`.
    - Update `application.yml` with your MySQL username and password if different.

   ![Database Schema](src/docs/blog-app-db-schema.png)

3. **Run the Application**:

   ```bash
   mvn spring-boot:run
   ```

4. **Explore GraphQL APIs**:

   Open your browser and go to `http://localhost:9091/blogs/graphql` to access the GraphQL playground. Here, you can execute queries and mutations defined in the schema.

### GraphQL Operations

#### Queries

- **`findAllUsers`**: Retrieves all users and their details.

#### Mutations

- **`createUser`**: Creates a new user.
- **`deleteUser`**: Deletes a user by ID.
- **`updateUser`**: Updates user details.
- **`followUser`**: Enables one user to follow another.

### Example GraphQL Query

To fetch all users and their posts, followers, and following relationships:

```graphql
query {
    findAllUsers {
        id
        name
        userName
        age
        posts {
            id
            contentText
            likes
            imageUrl
        }
        followers {
            id
            name
            userName
        }
        following {
            id
            name
            userName
        }
    }
}
```

### Example GraphQL Mutation

To create a new user:

```graphql
mutation {
    createUser(name: "John Doe", userName: "johndoe", password: "password123", age: "30") {
        id
        name
        userName
        age
    }
}
```
