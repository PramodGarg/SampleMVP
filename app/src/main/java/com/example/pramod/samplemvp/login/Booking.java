package com.example.pramod.samplemvp.login;

/**
 * Created by pramod on 27/10/17.
 */

public enum Booking {
    PENDING(1),
    APPROVED(2),
    COMPLETED(3),
    ONGOING(4);

    private int status;

    Booking(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
