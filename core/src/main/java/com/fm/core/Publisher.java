package com.fm.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangli on 2017/10/20.
 */
public class Publisher {

    private List<Subscriber> subscribers;

    public Publisher() {
        subscribers = new ArrayList<>();
    }

    public void send(final String word){
        subscribers.forEach((subscriber) ->{
            subscriber.receive(word);
        });
    }

}
