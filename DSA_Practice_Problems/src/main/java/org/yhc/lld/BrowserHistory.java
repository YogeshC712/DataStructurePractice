package org.yhc.lld;

import java.util.ArrayList;
import java.util.List;

/**
 * “I’m using an ArrayList to store history”
 * 'curr' tracks current page
 * 'last' prevents going into invalid forward history
 * “When visiting after going back, I overwrite instead of deleting”
 */
public class BrowserHistory {
    private final List<String> history;
    private int curr;
    private int last;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);

        curr = 0;
        last = 0;
    }

    public void visit(String url) {
        curr++;

        if(curr == history.size()){
            history.add(url);
        }else{
            history.set(curr, url);
        }
        last = curr;
    }

    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(last, curr + steps);
        return history.get(curr);
    }
}
