# Exercise: JDBC Transactions

## 1. Setup the database
(in Postgresql)

Create a new Database with name **bookstore**

## 2. Create Books table
Use this only as a tempalte! Add a Check Constraint to guarantee that the stock
can never fall below 0.
```
-- Create the 'books' table
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    stock INT NOT NULL
);
```

## 3. Create the Sales table
Use this only as a tempalte! Add a Check Constraint to guarantee that the quantity is above 0.
```
CREATE TABLE sales (
    sale_id SERIAL PRIMARY KEY,
    book_id INT REFERENCES books(book_id),
    quantity INT NOT NULL,
    sale_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 4. Add test data to the book stock

```
INSERT INTO books (title, stock) VALUES
('Java Programming', 10),
('Database Systems', 5),
('Software Engineering', 7);
```

## 5. Write code to add a sale and decrease stock

Add your code "buy" a book.
This should add a new entry to "sales" for one book, but with a higher quantity (e.g. 3).
This should also decrease the stock for that book by X.

## 6. Test your code
Let the code run a couple of times to see what happen in a successful run as well as in the case when the stock is too low.

```
mvn compile
export DB_USER="username" DB_PASS="pass" && mvn exec:java
```
