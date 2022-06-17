#include "bits/stdc++.h"
#include "sqlite_modern_cpp-master/hdr/sqlite_modern_cpp.h"
#include "header.h"
using namespace  sqlite;
using namespace std;

void update () {
    try {
        database db("studentDB.db");
        int _rollNumber, mark_A, mark_B, mark_Total;
        string name;
        cout << "Enter the Roll Number : "; cin >> _rollNumber;
        cout << "Enter Updated values\n ";
        cout << " Name : "; cin >> name;
        cout << " mark_A : "; cin >> mark_A;
        cout << " mark_B : "; cin >> mark_B;
        mark_Total = mark_A + mark_B ;

        auto query = db << "UPDATE STUDENT SET name = ? , mark_A = ?, mark_B = ?, mark_Total = ? WHERE _rollNumber = ?;";
        query << name;
        query << mark_A;
        query << mark_B;
        query << mark_Total;
        query << _rollNumber;
    } catch (exception& e) {
       cout << e.what() << endl;
    }
    return;
}
