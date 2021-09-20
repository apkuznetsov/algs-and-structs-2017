#include <iostream>
#include <ext/rope>

using namespace std;
using namespace __gnu_cxx;

/* Структура данных Rope.
 * Данная структура данных хранит строку и позволяет эффективно вырезать кусок строки и переставить его в другое место.
 *
 * Формат входа.
 * Первая строка содержит исходную строку S, вторая — число запросов q.
 * Каждая из последующих q строк задаёт запрос тройкой чисел i, j, k и означает следующее:
 * вырезать подстроку S[i..j] (где i и j индексируются с нуля)
 * и вставить её после k-го символа оставшейся строки (где k индексируется с единицы),
 * при этом если k = 0, то вставить вырезанный кусок надо в начало.
 * Формат выхода.
 * Выведите полученную (после всех q запросов) строку. */

int main() {
    crope tree;

    string inputLine;
    getline(std::cin, inputLine);

    for (char const &symb: inputLine) {
        tree.push_back(symb);
    }

    int queriesCounter = 1;
    cin >> queriesCounter;

    int left, right, k, len;
    crope rope;
    for (int i = 0; i < queriesCounter; i++) {
        cin >> left;
        cin >> right;
        cin >> k;
        len = right - left + 1;

        rope = tree.substr(left, len);
        tree.erase(left, len);
        tree.insert(k, rope);
    }

    cout << tree << endl;
}