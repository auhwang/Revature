package com.revature.day7.sql;

/*
 * SQL - Structured Query Language
 * -A language for interacting with databases
 * 	-creating, reading, updating, deleting data
 * 	-Inside of stacked discs are databases which contain tables
 * 	which contain colomns/fields and rows/records
 * 		-data/cell/attributes
 * 
 * DBMS - database management system
 * RDBMS - relational database management system
 * 	-Oracle PL/SQL (Oracle)
 * 	-SQLServer T/SQL (microsoft)
 * 	-Postgres (idunno)
 * 	-MySQL
 * 	-DB2 (IBM)
 * 	-Aurora (AWS)
 * 
 * SQL Sublanguages
 * 	-Data Definition Language
 * 		-CREATE
 * 		-DROP
 * 		-ALTER
 * 		-TRUNCATE
 * 	-Data Manipulation Language
 * 		-INSERT
 * 		-SELECT
 * 		-UPDATE
 * 		-DELETE
 * 	-Data Query Language
 * 		-SELECT
 * 	-Data Control Language
 * 		-GRANT
 * 		-REVOKE
 * 	-Transaction Control Language
 * 		-COMMIT
 * 		-ROLLBACK
 * 		-SAVEPOINT
 * 		-SET_TRANSACTION
 * 
 * ACID is the acronym for the properties of a transaction
 * 
 * ERD - Entity Relationship Diagram
 * 
 * 		-Employee 					1:many	-Company	-Primary key		-EMP_Contact	-PK,FK
 * 		-E_ID		-Primary Key	\		-C_ID				1:1			-E_ID
 * 		-F_Name					   -------	-Name			--------		-Phone
 * 		-L_Name						/		-Address						-Email
 * 		-Title_ID	-Foreign Key			-Phone							-Address
 * 		-C_ID		-Foreign Key
 * 
 * 		Projects					EMP_PRO
 * 		-P_ID	-Primary Key		-P_ID	-Foreign Key
 * 		-Name						-E_ID	-Foreign Key
 * 									-JoinID	-Primary key
 * 									1:many with both projects and employee, therefore it is many to many
 * 
 * Constraints
 * 	-Primary Key
 * 		-A unique, not null, identifier which aims to uniquely identify record of a table
 * 	-Foreign Key
 * 		-A reference to another table's unique constraint column, establishing a relationship
 * -Null/Not Null
 * 		-field must be filled or empty
 * 
 * Cardinality
 * -One to One
 * -One to Many
 * -Many to One
 * -Many to Many
 * 
 * Multiplicity
 * -Keeping track of min/max dependencies
 * 
 * LH:8080/apex=f?p=4950
 */
public class Driver {

}
