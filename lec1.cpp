#include <iostream>
#include <cmath>
#include <stack>
#include <cstring>

using namespace std;

int precedence(char op)
{

    if (op == '^')
    {
        return 3;
    }
    else if (op == '*' || op == '/')
    {
        return 2;
    }
    else if (op == '+' || op == '-')
    {
        return 1;
    }
    return 0;
}

string getString(char x)
{
    string s(1, x);
    return s;
}

string infixtopostfix(string input)
{
    stack<string> operand;
    stack<char> operators;
    string op;
    string pop1, pop2;
    // cout<<input<<endl;
    for (int i = 0; i < input.length(); i++)
    {
      
        if (input[i] >= '0' && input[i] <= '9')
        {
            operand.push(getString(input[i])); // to make input[i] of string type
        }
        else if (operators.empty())
        {
            operators.push(input[i]);
        }
        else if (precedence(input[i]) >= precedence(operators.top()))
        {
            operators.push(input[i]);
        }
        else if (precedence(input[i]) < precedence(operators.top()))
        {
            while (operators.size() > 0 && precedence(input[i]) <= precedence(operators.top()))
            {
                op = getString(operators.top());
                operators.pop();
                pop1 = operand.top();
                operand.pop();
                pop2 = operand.top();
                operand.pop();
                string temp = pop2 + pop1 + op;
                operand.push(temp);
            }
            operators.push(input[i]);
        }
    }

    while (operand.size() > 1)
    {
        op = getString(operators.top());
        operators.pop();
        pop1 = operand.top();
        operand.pop();
        pop2 = operand.top();
        operand.pop();
        string temp = pop2 + pop1 + op;
        operand.push(temp);
       }
    // cout << operand.top();
    return operand.top();
}

int main()
{
    string input;
    cin >> input;
    cout << infixtopostfix(input) << endl;
    return 0;
}