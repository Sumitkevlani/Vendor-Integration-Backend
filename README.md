# Vendor Integration Platform

This project is a Vendor Integration Platform designed for companies and salespersons to manage all their vendor information and transactions in one place. It allows users to perform CRUD (Create, Read, Update, Delete) operations on vendor details and manage their transactions efficiently.

## Project Structure

The project uses **Spring Boot** for the backend and **MongoDB** as the database. There are two main collections in the MongoDB database:

1. **Vendor Collection**: Stores details about the vendors.
2. **Transactions Collection**: Stores details about transactions. Each transaction is associated with a vendor through the `vendorId`.

### MongoDB Schema

**Vendor Collection:**  

- `id`: Unique identifier for the vendor (String).
- `name`: Name of the vendor (String).
- `address`: Address of the vendor (String).
- `contactNumber`: Contact number of the vendor (String).
- `logo`: Logo of the vendor (String).
- `type`: Type of vendor (String) (Buyer or Seller).
- `contractPeriod`: Contract period of the vendor (String).
- `contractEnding`: Contract ending date of the vendor (String).

**Transactions Collection:**

- `id`: Unique identifier for the transaction (String).
- `vendorId`: The ID of the vendor associated with the transaction (String).
- `transactionType`: Type of transaction (String).
- `amount`: Amount involved in the transaction (Double).
- `status`: Status of the transaction (String).
- `time`: Timestamp of the transaction (String).
- `type`: Type of transaction (String).
- `paymentMethod`: Payment method used for the transaction (String).
- `contactEmail`: Email contact associated with the transaction (String).
- `billingAddress`: Billing address related to the transaction (String).
- `notes`: Additional notes about the transaction (String).
- `attachments`: Array of objects containing attachment details (Array of Objects).
  - `name`: Name of the attachment (String).
  - `url`: URL or path to access the attachment (String).

## API Endpoints

### Vendor APIs

1. **Create a new vendor**
   - **Endpoint**: `/vendors`
   - **Request Type**: `POST`
   - **Request Body**:
     ```json
     {
       "name": "Vendor Name",
       "address": "Vendor Address",
       "contactNumber": "123-456-7890"
     }
     ```
   - **Description**: Adds a new vendor to the database.
   - **Response**: The created vendor object with `id`.

2. **Get all vendors**
   - **Endpoint**: `/vendors`
   - **Request Type**: `GET`
   - **Description**: Retrieves all vendors from the database.
   - **Response**: List of vendor objects.

3. **Get a vendor by ID**
   - **Endpoint**: `/vendors/{id}`
   - **Request Type**: `GET`
   - **Description**: Retrieves a specific vendor by its ID.
   - **Response**: The vendor object.

4. **Update a vendor's details**
   - **Endpoint**: `/vendors/{id}`
   - **Request Type**: `PUT`
   - **Request Body**:
     ```json
     {
       "name": "Updated Name",
       "address": "Updated Address",
       "contactNumber": "123-456-7890"
     }
     ```
   - **Description**: Updates the details of an existing vendor.
   - **Response**: The updated vendor object.

5. **Delete a vendor**
   - **Endpoint**: `/vendors/{id}`
   - **Request Type**: `DELETE`
   - **Description**: Deletes a vendor from the database.
   - **Response**: `204 No Content`

### Transaction APIs

1. **Create a new transaction**
   - **Endpoint**: `/transactions`
   - **Request Type**: `POST`
   - **Request Body**:
     ```json
     {
       "vendorId": "60c72b2f9f1b9c6d88f3c8b4",
       "transactionType": "Purchase",
       "amount": 1000.00,
       "status": "Completed",
       "date": "2024-07-06"
     }
     ```
   - **Description**: Adds a new transaction to the database.
   - **Response**: The created transaction object with `id`.

2. **Get all transactions**
   - **Endpoint**: `/transactions`
   - **Request Type**: `GET`
   - **Description**: Retrieves all transactions from the database.
   - **Response**: List of transaction objects.

3. **Get a transaction by ID**
   - **Endpoint**: `/transactions/{id}`
   - **Request Type**: `GET`
   - **Description**: Retrieves a specific transaction by its ID.
   - **Response**: The transaction object.

4. **Update a transaction's details**
   - **Endpoint**: `/transactions/{id}`
   - **Request Type**: `PUT`
   - **Request Body**:
     ```json
     {
       "vendorId": "60c72b2f9f1b9c6d88f3c8b4",
       "transactionType": "Sale",
       "amount": 1500.00,
       "status": "Pending",
       "date": "2024-07-07"
     }
     ```
   - **Description**: Updates the details of an existing transaction.
   - **Response**: The updated transaction object.

5. **Delete a transaction**
   - **Endpoint**: `/transactions/{id}`
   - **Request Type**: `DELETE`
   - **Description**: Deletes a transaction from the database.
   - **Response**: `204 No Content`

6. **Get all transactions by Vendor ID**
   - **Endpoint**: `/transactions/vendor/{vendorId}`
   - **Request Type**: `GET`
   - **Description**: Retrieves all transactions for a specific vendor.
   - **Response**: List of transaction objects for the specified vendor.

## Setting Up the Project

### Prerequisites
- Java 17 or higher
- Maven
- MongoDB Atlas account (or any other MongoDB instance)

### Steps to Run the Application

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd <repository-directory>

2. **Configure mongodb:** 
    Update the application.properties file with your MongoDB connection string:
   ```bash
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/<database-name>?retryWrites=true&w=majority

3. **Build the project**
    ```bash
    mvn clean install

4. **Run the project**
    ```bash
    mvn spring-boot:run

5. **Access the application**

- The application will be running on http://localhost:8080.

### Testing the APIs
- Use tools like Postman or cURL to test the APIs.
- Alternatively, navigate to http://localhost:8080/swagger-ui/ (once Swagger is configured) to interact with the API documentation and test the endpoints.

