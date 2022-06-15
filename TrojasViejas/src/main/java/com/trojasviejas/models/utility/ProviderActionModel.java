package com.trojasviejas.models.utility;

import com.trojasviejas.models.entity.ProviderModel;
import com.trojasviejas.component.main.event.IProviderEventAction;

public class ProviderActionModel {

    public ProviderModel getProvider() {
        return provider;
    }

    public void setProvider(ProviderModel provider) {
        this.provider = provider;
    }

    public IProviderEventAction getEvent() {
        return event;
    }

    public void setEvent(IProviderEventAction event) {
        this.event = event;
    }

    public ProviderActionModel(ProviderModel provider, IProviderEventAction event) {
        this.provider = provider;
        this.event = event;
    }

    public ProviderActionModel() {
    }

    private ProviderModel provider;
    private IProviderEventAction event;
}