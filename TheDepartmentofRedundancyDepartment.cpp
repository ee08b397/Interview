#include <iostream>
#include <hash_map>
#include <cstdio>
#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <set>
#include <map>
#include <sstream>
#include <complex>
#include <ctime>
#include <cassert>
#include <functional>

using namespace std;

struct eqstr {
    bool operator()(const char* s1, const char* s2) const {
        return strcmp(s1, s2) == 0;
    }
};
struct eqint {
    bool operator()(const int i1, const int i2) const {
        return i1 == i2;
    }
};
int N, x[1000];
int main() {
hash_map<const int, int, hash<const int>, eqstr> hm;
    for (int i = 0; i < N; i++) {
        scanf("%d", x + i);
        cout << x[i] << " " << i << endl;
    }
    
    return 0;
}

hash_map <string, int> months;
int main(void) {
    months["january"] = 31;
    months["february"] = 28;
    return 0;
}
