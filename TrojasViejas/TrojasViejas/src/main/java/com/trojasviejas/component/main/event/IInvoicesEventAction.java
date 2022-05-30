package com.trojasviejas.component.main.event;

import com.trojasviejas.models.entity.InvoicesModel;
import com.trojasviejas.models.viewmodel.InvoicesVM;

public interface IInvoicesEventAction {
    public void delete(InvoicesModel entity);
    public void update(InvoicesModel entity);
    public void view(InvoicesModel entity);
    public void image(InvoicesModel entity);
}
