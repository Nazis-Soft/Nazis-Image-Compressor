#ifdef _WIN32
#include <windows.h>
#else
#include <unistd.h>
#endif
#include <iostream>
#include <string.h>

using namespace std;

int main(int argc,char* argv[]) 
{
    //args to std::string
    std::string args= "";
    for (int i=0;i<argc;i++) args.append(std::string(argv[i]).append(" "));
    //print name
    cout << "Image Compressor v.1.0" << endl;
    //concat command and run
    string total(string("java -jar ") + args);
    system(total.c_str());
    return 0;
}
