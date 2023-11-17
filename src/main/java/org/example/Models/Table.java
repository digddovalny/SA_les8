package org.example.Models;

import java.util.ArrayList;
import java.util.Collection;

public class Table {
    private static int counter;
    private final int no;

    {
        no=++counter;
    }

    public int getNo() {
        return no;
    }

    private final Collection<Reservation> reservations = new ArrayList<>();

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return String.format("Столик #%d", no);
    }
}
