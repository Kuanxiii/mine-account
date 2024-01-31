package me.account.account.server.dto;

public class RequestDTO< D > {
    private D data;

    public RequestDTO() {
    }

    public RequestDTO( D data ) {
        this.data = data;
    }

    public D getData() {
        return data;
    }

    public void setData( D data ) {
        this.data = data;
    }
}
