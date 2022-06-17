#include "bits/stdc++.h"
#include "sqlite_modern_cpp-master/hdr/sqlite_modern_cpp.h"
#include "header.h"
using namespace  sqlite;
using namespace std;

void read () {
    try {
        database db("studentDB.db");

        int count ;
        db << "SELECT COUNT(*) FROM STUDENT" >> (count);
        cout << "Count : " << count << "\n";
        int i = 1;
        while (count){
            int _rollNumber = 0, mark_Total;
            string name;

            auto query = db << "SELECT _rollNumber, name, mark_Total FROM STUDENT WHERE _rollNumber = ?";
            query << i;
            try {

                query >> tie(_rollNumber, name, mark_Total);

                i++;
                count--;
                cout << "--------------------------------------\n";
                cout << "   Roll Number : " << _rollNumber << "\n";
                cout << "   Name  : " << name << "\n";
                cout << "   Total marks : " << mark_Total << "\n";
                cout << "--------------------------------------\n";
            } catch (exception& e) {
                i++;
            }
        }
    } catch (exception& e) {
       cout << e.what() << endl;
    }
    return;
}
