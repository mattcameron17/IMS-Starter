Test Coverage: 70%
# Inventory Management System

This project is an Inventory Management System (IMS) that is used to create and delete, customers, items, and orders. The system is controlled by text using the command line interface (CLI). 

## Getting Started

To get started on your own machine fork the project to your own repository, then use the command git clone, followed by the url of the forked repo.  This will get the project onto your machine for development and testing purposes.

### Prerequisites
The software required to run this project is as follows:

[Maven](https://maven.apache.org/) which is allows us to create an executable jar file.

[MySQLWorkbench](https://www.mysql.com/products/workbench/) which is used to set up the server and database.

[Java Development Kit](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) which allows us to code Java.

Also an Integrated Development environment is recommended such as [Eclipse](https://www.eclipse.org/downloads/)


### Installing
Instructions are for Windows Operating System.

- Download JDK, then install Java.
- Search for environment variables in windows search bar.
- Click Environment variables button in System Properties.
- Click New, underneath System variables window.
- Enter JAVA_HOME as Variable name
- For Variable value, click Browse and navigate to jdk file in Program Files.



- Download and install Maven.
- Search for environment variables in windows search bar.
- Click Environment variables button in System Properties.
- Click New, underneath System variables window.
- Enter M2_HOME as Variable name
- For Variable value click Browse and navigate to apache-maven-3.6.3 in Program Files.
- Repeat the steps but make a new Variable name called MAVEN_HOME.


## Running the tests

In order to run all of the tests currently present in the project go to the project tree and find the src/test/java folder in the IDE, then right click on it and select Coverage as --> JUnit Test.

### Unit Tests 

Unit testing is where individual units of source code are tested to see if they return what is expected of them. This particular test, tests the create() method in the ItemDAO class, which creates a new item that is recorded in the database. This test is ran to assert that the create() method does in fact create a new item in the database. To run, right click file in IDE and select Run As ---> JUnit test.

```
@Test
	public void testCreate() {
		final Item created = new Item(2L, "ps5", 359.99D);
		assertEquals(created, DAO.create(created));
	}

```

### Integration Tests 
Integration testing is where classes that depend on other classes are tested as a group.  The following test tests the update() method within the ItemController class.  This method depends on the util and DAO class and thus integration testing is required.  This test is ran to assert that the update() method collects the correct data using the util class methods to send to the update() method in the DAO class. To run, right click file in IDE and select Run As --> JUnit test.

```
@Test
	public void testUpdate() {
		Item updated = new Item(1L, "dreamcast", 50D);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getItemValue());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
```

## Deployment

To deploy project either:
- Open project in an IDE and run project
- Open the command line interface and navigate to the folder containing the jar file. Then input 'java -jar file.jar' Make sure to enter the filename in place of file.jar.

## Built With
* [Eclipse](https://www.eclipse.org/) - Java IDE

* [Maven](https://maven.apache.org/) - Dependency Management

* [MySQLWorkbench](https://www.mysql.com/products/workbench/) - SQL Database Management

## Versioning

Version 2.0

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Matthew Cameron** - *Continued work* - [matthewcameron](https://github.com/mattcameron17)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 


## Acknowledgments

* Piers Barber & Aswene Sivaraj for their patience.
