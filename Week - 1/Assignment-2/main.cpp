#include "rapidjson/include/rapidjson/document.h"
#include "rapidjson/include/rapidjson/writer.h"
#include "rapidjson/include/rapidjson/stringbuffer.h"
#include "rapidjson/include/rapidjson/rapidjson.h"
#include "rapidjson/include/rapidjson/prettywriter.h"
#include "bits/stdc++.h"

using namespace std;
using namespace rapidjson;

/*
 * @author pujawadare
 * @date 11th June 2022
 * @Assignment 2 :
    Find a JSON library from "C++ Libraries & Tools" and
    use it to demonstrate STL containers serialization & deserialization
    to JSON in a visual studio project

    Program :
        JSON Library = rapidjson
        STL Container serialized : std::vector<dataType> v;
            The vector contains Product class objects.
        The following program deserializes data from a JSON file and stores it in the vector;
        It the adds another object to the vector, and serializes it to the initial JSON file;
*/

class JSONFeatures {
    public :
        static string DeserializeFromFile(const string& filePath);
        static void SerializeToFile(const string& filePath, string& s);
        static bool InitDocument(const std::string & s, Document &doc);
};
void JSONFeatures::SerializeToFile(const string& filePath, string& s) {
	ofstream f(filePath);
	f << s;
	f.flush();
	f.close();
}
string JSONFeatures::DeserializeFromFile(const string& filePath) {
	ifstream f(filePath);
	stringstream buffer;
	buffer << f.rdbuf();
	f.close();
	return buffer.str();
}
bool JSONFeatures::InitDocument(const string& s, Document& doc) {
	if (s.empty())
		return false;
	string validJson(s);
	return !doc.Parse(validJson.c_str()).HasParseError() ? true : false;
}

class Product {
    private :
        string _name, _category;
        float _sales;
        int _id;
    public :
        Product () {}
        Product(int id, string name, string category, float sales) { Id(id); Name(name); Category(category); Sales(sales); }
        void Deserialize(const rapidjson::Value & obj) {
            Id(obj["id"].GetInt());
        	Name(obj["name"].GetString());
        	Category(obj["category"].GetString());
        	Sales(obj["sales"].GetFloat());
        }
        template <typename Writer>
        void Serialize(Writer &writer) const {
            writer.StartObject();

        	writer.String("id");
        	writer.Int(_id);

        	writer.String("name");
        	writer.String(_name.c_str());

        	writer.String("category");
        	writer.String(_category.c_str());

        	writer.String("sales");
        	writer.Double(_sales);

            writer.EndObject();
        }

// Getters and Setters
        const string& Name() { return _name; }
        void Name(const string &name) { _name = name; }

        const string& Category() { return _category; }
        void Category(const string &category) { _category = category; }

        float Sales() const { return _sales; }
        void Sales(float sales) { _sales = sales; }

        int Id() const { return _id; }
        void Id(int id) { _id = id; }

};


int main(int, char*[]) {

// Deserializing the contents of the json file
    string filepath = "DataSample.json";
    vector< Product > products;
    int numberOfEntries = 0;

    string buffer = JSONFeatures::DeserializeFromFile(filepath);
    Document parsedBuffer;
    if (JSONFeatures::InitDocument(buffer, parsedBuffer) == true){
        for (rapidjson::Value::ConstValueIterator itr = parsedBuffer.Begin(); itr != parsedBuffer.End(); ++itr) {
			Product p;
			p.Deserialize(*itr);
			products.push_back(p);
            numberOfEntries ++;
		}
    }
    StringBuffer sb ;
    PrettyWriter <StringBuffer> writer(sb);

// Displaying the contents of the file
    writer.StartArray();
    for (int i = 0; i < numberOfEntries; i++)
        products[i].Serialize(writer);
    writer.EndArray();

    string s = sb.GetString();
    cout << "Initial contents of the JSON file :\n";
    cout << s << "\n";

// Adding a new entry and serializing it into the file with other data
    Product newProduct( /* id */ 10, /* Name */ "Sunrise Cooker", /* Category */"Utensils", /* Sales */120.5);
    products.push_back(newProduct); numberOfEntries++;

    StringBuffer nsb ;
    PrettyWriter <StringBuffer> nwriter(nsb);
    nwriter.StartArray();
    for (int i = 0; i < numberOfEntries; i++)
        products[i].Serialize(nwriter);
    nwriter.EndArray();

    s = nsb.GetString();
    JSONFeatures::SerializeToFile(filepath, s);

    return 0;
}
