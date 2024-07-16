# Spring Boot GraphQL Example

This project demonstrates how to integrate GraphQL with Spring Boot, using MySQL for data persistence. It includes basic CRUD operations for users and posts, along with a follow functionality between users.

## Technologies Used

- **Spring Boot**: for building the application.
- **GraphQL**: as a query language for your API.
- **MySQL**: for data storage.
- **Hibernate**: as the JPA implementation.
- **Maven**: for managing dependencies and building the project.

## Getting Started

To get this project up and running on your local machine, follow these steps:

### Prerequisites

- Java Development Kit (JDK) installed (preferably JDK 8 or higher)
- Maven installed
- MySQL installed and running locally

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/youssefGamalMohamed/spring-boot-graphQL.git
   cd spring-boot-graphQL
   ```

2. **Configure MySQL**:

   - Create a MySQL database named `blogs_db`.
   - Update `application.yml` with your MySQL username and password if different.

3. **Run the Application**:

   ```bash
   mvn spring-boot:run
   ```

4. **Explore GraphQL APIs**:

   Open your browser and navigate to `http://localhost:9091/blogs/graphql` to access the GraphQL playground. Here you can test the defined queries and mutations.

### GraphQL Operations

- **Queries**:
  - `findAllUsers`: Fetch all users and their details.

- **Mutations**:
  - `createUser`: Create a new user.
  - `deleteUser`: Delete a user by ID.
  - `updateUser`: Update user details.
  - `followUser`: Allow one user to follow another.

### Example GraphQL Query

To fetch all users:

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
