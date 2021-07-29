class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        ArrayList<String> res = new ArrayList<>();
        
        Queue<String> qu = new ArrayDeque<>();
        
        qu.add("1");
        
        for(int i=0; i<N; i++) {
            String rem = qu.remove();
            
            res.add(rem);
            qu.add(rem + "0");
            qu.add(rem + "1");
        }
        
        return res;
    }
    
}