package com.trojasviejas.models.utility;

import com.trojasviejas.component.main.event.*;
import com.trojasviejas.models.entity.InvoicesModel;
import com.trojasviejas.models.viewmodel.InvoicesVM;

public class InvoiceActionModel {

    public InvoicesModel getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoicesModel invoice) {
        this.invoice = invoice;
    }

    public IInvoicesEventAction getEvent() {
        return event;
    }

    public void setEvent(IInvoicesEventAction event) {
        this.event = event;
    }

    public InvoiceActionModel(InvoicesModel invoice, IInvoicesEventAction event) {
        this.invoice = invoice;
        this.event = event;
    }

    public InvoiceActionModel() {
    }

    private InvoicesModel invoice;
    private IInvoicesEventAction event;
}
