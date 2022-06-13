//
//  main.cpp
//  Week - 2
//
//  Created by Puja Wadare on 13/06/22.
//  Assignment:
// • Implement a program that reads and writes into student database with sqliteDB,
//   the Database contains the Names, Roll numbers, Marks and 5 subjects
// • Build above project as Makefile project, submit above project on github and share

#include <iostream>
#include <string>
#include <vector>
#include <sqlite3.h>
using namespace std;

static int callback(void *NotUsed, int argc, char **argv, char **azColName) {
    cout << "---------------------------\n";
    for(int i = 0; i < argc; ++i)
        cout<< "    " << azColName[i]<<" : " << (argv[i] ? argv[i] : "NULL")<<"\n";
    cout << "---------------------------\n";
    return 0;
}

int main(int argc, const char * argv[]) {
    sqlite3 *studentDB;
    char *zErrMsg = 0;

//  Opening the Database student.db
    int exit = sqlite3_open("student.db", &studentDB);
    if (exit) {
        cerr << "Error open DB " << sqlite3_errmsg(studentDB) << endl;
        return (-1);
    }
    else
        cout << "Opened Database Successfully!" << endl;

    const char * SQLQueries[8];
// Reading from the Database table (student_marks)
    cout << "Reading from the Database table (student_marks) (pre-existing contents ) \n";
    SQLQueries[0] = "SELECT * FROM student_marks ;";
    exit = sqlite3_exec(studentDB, SQLQueries[0], callback, 0, &zErrMsg);
    if (exit != SQLITE_OK) {
        cerr << "Error open DB " << sqlite3_errmsg(studentDB) << endl;
        return (-1);
    }
// Writing to the Database table (student_marks)
    cout << "Writing to the Database table (student_marks) (a new entry roll_number = 3)\n";
    SQLQueries[1] = "INSERT INTO student_marks ( roll_number, name, marks_A, marks_B, marks_C, marks_D, marks_E, total_marks ) VALUES (3, 'Sample Name', 60, 90, 70, 60, 50, 280); ";
    exit = sqlite3_exec(studentDB, SQLQueries[1], callback, 0, &zErrMsg);
    if (exit != SQLITE_OK) {
        cerr << "Error open DB " << sqlite3_errmsg(studentDB) << endl;
        return (-1);
    }
// Fetching a particular entry from the Database table (student_marks)
    cout << "Fetching a particular entry from the Database table (student_marks) (roll_number = 3) \n";
    SQLQueries[2] = "SELECT roll_number, name, total_marks FROM student_marks WHERE roll_number = 3 ";
    exit = sqlite3_exec(studentDB, SQLQueries[2], callback, 0, &zErrMsg);
    if (exit != SQLITE_OK) {
        cerr << "Error open DB " << sqlite3_errmsg(studentDB) << endl;
        return (-1);
    }
// Deleting a particular entry from the Database table (student_marks)
    cout << "Deleting a particular entry from the Database table (student_marks) (Deleting roll_number 3)\n";
    SQLQueries[3] = "DELETE FROM student_marks WHERE roll_number = 3;";
    exit = sqlite3_exec(studentDB, SQLQueries[3], callback, 0, &zErrMsg);
    if (exit != SQLITE_OK) {
        cerr << "Error open DB " << sqlite3_errmsg(studentDB) << endl;
        return (-1);
    }
    cout << "Reading from the Database table (student_marks) (after DELETE) \n";
    SQLQueries[0] = "SELECT * FROM student_marks ;";
    exit = sqlite3_exec(studentDB, SQLQueries[0], callback, 0, &zErrMsg);
    if (exit != SQLITE_OK) {
        cerr << "Error open DB " << sqlite3_errmsg(studentDB) << endl;
        return (-1);
    }
    sqlite3_close(studentDB);
    cout << "Closed Database Successfully!\n";
    return 0;
}
