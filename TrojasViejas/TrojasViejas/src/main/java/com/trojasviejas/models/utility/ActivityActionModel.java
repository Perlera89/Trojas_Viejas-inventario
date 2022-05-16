package com.trojasviejas.models.utility;

import com.trojasviejas.component.main.event.*;
import com.trojasviejas.models.viewmodel.ActivityVM;

public class ActivityActionModel {

    public ActivityVM getActivity() {
        return activity;
    }

    public void setActivity(ActivityVM activity) {
        this.activity = activity;
    }

    public IActivityEventAction getEvent() {
        return event;
    }

    public void setEvent(IActivityEventAction event) {
        this.event = event;
    }

    public ActivityActionModel(ActivityVM activity, IActivityEventAction event) {
        this.activity = activity;
        this.event = event;
    }

    public ActivityActionModel() {
    }

    private ActivityVM activity;
    private IActivityEventAction event;
}
