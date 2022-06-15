package com.trojasviejas.models.utility;

import com.trojasviejas.component.main.event.*;
import com.trojasviejas.models.viewmodel.InvoicesVM;

public class InvoiceActionModel {

    public InvoicesVM getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoicesVM invoice) {
        this.invoice = invoice;
    }

    public IInvoicesEventAction getEvent() {
        return event;
    }

    public void setEvent(IInvoicesEventAction event) {
        this.event = event;
    }

    public InvoiceActionModel(InvoicesVM invoice, IInvoicesEventAction event) {
        this.invoice = invoice;
        this.event = event;
    }

    public InvoiceActionModel() {
    }

    private InvoicesVM invoice;
    private IInvoicesEventAction event;
}
