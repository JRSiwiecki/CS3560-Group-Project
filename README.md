# CS3560-Group-Project
Course group project for CS 3560.03. Group members are Joseph Siwiecki, David Vo, Abdiel Mendez, Jonathan Thieu, and Ysmael Kamgaing.

# Setup
1. Clone repo
2. Add project folder to Eclipse workspace.
3. Create the library_db database in pgAdmin.
4. In the hibernate.cfg.xml file, uncomment line 27. This will auto-create the tables for you.
5. Run the program, once, verify that it created the tables and test if data can be added to the tables.
6. Once verified that the tables have been created and work, change line 27 to "<property name="hibernate.hbm2ddl.auto">update</property>" without the quotes. This will not re-create the tables and allow you to work with your existing data and tables.
