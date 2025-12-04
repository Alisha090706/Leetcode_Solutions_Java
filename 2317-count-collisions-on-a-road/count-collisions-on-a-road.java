class Solution {
    public int countCollisions(String directions) {
        int n=directions.length();
        int collisions=0;
        Stack<Character> st=new Stack<>();
        st.push(directions.charAt(0));
        for(int i=1;i<n;i++){
            char c=directions.charAt(i);
            if(c=='L'){

                if(!st.isEmpty() && st.peek()=='R'){
                    collisions+=2;
                    st.pop();

                    //remaining right cars keep crashing
                    while(!st.isEmpty() && st.peek()=='R'){
                        collisions++;
                        st.pop();
                    }

                    st.push('S');
                }
                else if(!st.isEmpty() && st.peek()=='S'){
                    collisions++;
                    st.push('S');
                }
                //safe left
                else st.push('L');
            }
            else if(c=='S'){
                while(!st.isEmpty() && st.peek()=='R'){
                    collisions++;
                    st.pop();
                }
                st.push('S');
            }
            else{
                st.push('R');
            }
        }
        return collisions;
        
    }
}