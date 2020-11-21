#ifdef _WIN32
#include <windows.h>
#else
#include <unistd.h>
#endif
#include <iostream>
#include <string.h>
#include <limits.h>

using namespace std;

string exename;
string args;

string getApplicationDirectory() 
{
    char result[ PATH_MAX ];
    ssize_t count = readlink( "/proc/self/exe", result, PATH_MAX );
    std::string appPath = std::string( result, (count > 0) ? count : 0 );

    std::size_t found = appPath.find_last_of("/\\");
    return appPath.substr(0,found);
}

int main(int argc,char* argv[]) 
{
    //args to std::string
    args= "";
    exename = argv[0];
    for (int i=1;i<argc;i++) args.append(std::string(argv[i]).append(" "));

    //print name
    cout << "Image Compressor v.1.0" << endl;

    //concat command and run
    string total(string("java -jar \"") + getApplicationDirectory() + "/" + exename + "\"" + args);
    system(total.c_str());

    return 0;
}
