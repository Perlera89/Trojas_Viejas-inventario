package com.trojasviejas.component.main.event;

import com.trojasviejas.models.viewmodel.InvoicesVM;

abstract public interface IInvoicesEventAction {
    public void delete(InvoicesVM entity);
    public void view(InvoicesVM entity);
    public void image(InvoicesVM entity);
}
