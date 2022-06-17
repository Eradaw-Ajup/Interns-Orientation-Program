#include "bits/stdc++.h"
#include "sqlite_modern_cpp-master/hdr/sqlite_modern_cpp.h"
#include "header.h"
using namespace  sqlite;
using namespace std;

/*
 * @author pujawadare
 * Implement a program that reads and writes into student database with sqliteDB,
 * the Database contains the Names, Roll numbers, Marks and 5 subjects
 *
 */

int main() {

   try {
      // creates a database file 'studentDB.db' if it does not exists.
      database db("studentDB.db");
      db <<
         "CREATE TABLE IF NOT EXISTS STUDENT ("
         "   _rollNumber integer primary key autoincrement not null,"
         "   name text,"
         "   mark_A int,"
         "   mark_B int,"
         "   mark_Total int"
         ");";

      int choice;
      while (true) {
          cout << "=================Menu=================\n     1. Read from database.\n     2. Write into database.\n     3. Update database.\n     4. Delete from database\n     5. Exitt\n";
          cout << "Enter choice : "; cin >> choice;
          switch (choice) {
              case 1:{
                  read();
                  break;
              }
              case 2:{
                  write();
                  break;
              }
              case 3:{
                  update();
                  break;
              }
              case 4:{
                  deleteEntry();
                  break;
              }
              case 5:{return 0; break;}
              default : {cout << "Wrong Option!\n"; break;}
          }
      }

   }
   catch (exception& e) {
      cout << e.what() << endl;
   }
}
