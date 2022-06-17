#include "bits/stdc++.h"
#include "sqlite_modern_cpp-master/hdr/sqlite_modern_cpp.h"
#include "header.h"
using namespace  sqlite;
using namespace std;

void write () {
    try {
        database db("studentDB.db");
        int _rollNumber, mark_A, mark_B, mark_Total;
        string name;
        cout << "Enter Name : "; cin >> name;
        cout << "Enter mark_A : "; cin >> mark_A;
        cout << "Enter mark_B : "; cin >> mark_B;
        mark_Total = mark_A + mark_B ;

        db << "INSERT INTO STUDENT (name, mark_A, mark_B, mark_Total) VALUES (?,?,?,?)"
           << name
           << mark_A
           << mark_B
           << mark_Total;
    } catch (exception& e) {
       cout << e.what() << endl;
    }
    return;
}
