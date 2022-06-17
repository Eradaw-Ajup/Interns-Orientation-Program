#include "bits/stdc++.h"
#include "sqlite_modern_cpp-master/hdr/sqlite_modern_cpp.h"
#include "header.h"
using namespace  sqlite;
using namespace std;

void deleteEntry () {
    try {
        database db("studentDB.db");
        int _rollNumber;
        cout << "Enter the Roll Number : "; cin >> _rollNumber;
        db << "DELETE FROM STUDENT WHERE _rollNumber = ?"
           << _rollNumber;
    } catch (exception& e) {
       cout << e.what() << endl;
    }
    return;
}
