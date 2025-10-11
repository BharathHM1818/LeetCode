class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        char[] stack = new char[s.length()];
        int top = -1;

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
            {
               stack[++top]= ch;
            }
            else
            {
                if(top == -1) return false;

                char topChar = stack[top];
                if((ch == ')' && topChar == '(') || (ch == '}' && topChar == '{') ||
                    (ch == ']' && topChar == '['))
                    {
                        top--;
                    }
                else
                {
                    return false;
                }
            }
        }
        return top == -1;
    }
}