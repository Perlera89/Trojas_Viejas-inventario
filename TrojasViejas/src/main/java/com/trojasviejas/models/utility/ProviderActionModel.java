package com.trojasviejas.models.utility;

import com.trojasviejas.component.main.event.IEventAction;
import com.trojasviejas.models.entity.ProviderModel;

public class ProviderActionModel {

    public ProviderModel getProvider() {
        return provider;
    }

    public void setProvider(ProviderModel provider) {
        this.provider = provider;
    }

    public IEventAction getEvent() {
        return event;
    }

    public void setEvent(IEventAction event) {
        this.event = event;
    }

    public ProviderActionModel(ProviderModel provider, IEventAction event) {
        this.provider = provider;
        this.event = event;
    }

    public ProviderActionModel() {
    }

    private ProviderModel provider;
    private IEventAction event;
}