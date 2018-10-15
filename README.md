# Class-Routine-Management-System

Constraint based automatic course routine generation system. Only a limited number of constraints were considered like number of class rooms available, three continuous free slots between two classes. Implemented in Java, Mysql and PHP is used to see result in browser.

For the time being only two branches(CSE, ECE), two classrooms for theory and 2 for lab were considered. We can extend it in future.

Extraxt the database class_routine_management_system.sql which is the class routine for IIIT Manipur or you may create a new database with the following details.

The name of the database should be Routine and the tables in the database are:

i) info: 
To take information about the classes from the admin.
                        
ii) class_room1:
Will have the time table of all the classes in class_room1.
			
iii) class_room2
Will have the time table of all the classes in class_room2.

iv) cse_lab:
Will have all the cse labs time table.
			
v) ece_lab:
Will have all the ece labs  time table.

After filling the info table & initializing the other tables run the java file named:
	TimeTable.java.
