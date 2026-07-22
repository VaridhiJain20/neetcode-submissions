class MedianFinder {

    PriorityQueue<Integer> f;
    PriorityQueue<Integer> s;
    public MedianFinder() {
        f= new PriorityQueue<>(Collections.reverseOrder());
        s= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(f.size()==0 && s.size()==0){
            f.offer(num);
            return;
        }
        if(f.peek()>=num){
            f.add(num);
        }
        else{
        s.add(num);
        }

        if((f.size()+ s.size())%2==0){
            if(f.size()>s.size()){
                int n= f.poll();
                s.add(n);
            }
            else if(f.size()<s.size()){
                int n= s.poll();
                f.add(n);
            }
        }
        else{
             if(f.size()>s.size()+1){
                int n= f.poll();
                s.add(n);
            }
            else if(f.size()<1+s.size()){
                int n= s.poll();
                f.add(n);
            }
        }
    }
    
    public double findMedian() {
        if((f.size()+ s.size())%2==0){
            return ((double)f.peek()+s.peek())/2;
        }
        else{
            return (double)f.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */