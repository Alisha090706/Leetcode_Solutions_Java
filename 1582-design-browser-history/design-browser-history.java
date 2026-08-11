class BrowserHistory {
    ArrayList<String> list;
    int currIdx;
    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
        currIdx = 0;
    }
    
    public void visit(String url) {
        while(list.size() - 1 != currIdx) {
            list.remove(list.size() - 1);
        }
        list.add(url);
        currIdx++;
    }
    
    public String back(int steps) {
        int diff = currIdx - steps;
        if(diff <= 0) {
            currIdx = 0;
            return list.get(0);
        }
        currIdx = diff;
        return list.get(diff);
    }
    
    public String forward(int steps) {
        int add = currIdx + steps;
        if(add >= list.size()) {
            currIdx = list.size() - 1;
            return list.get(currIdx);
        }
        currIdx = add;
        return list.get(add);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */