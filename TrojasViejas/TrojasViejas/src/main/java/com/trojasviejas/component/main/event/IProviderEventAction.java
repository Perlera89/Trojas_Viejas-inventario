package com.trojasviejas.component.main.event;

import com.trojasviejas.models.entity.ProviderModel;

public interface IProviderEventAction {
    public void delete(ProviderModel entity);
    public void update(ProviderModel entity);
}
