package org.example.Presenters;

import org.example.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    void registerObserver(ViewObserver observer);
    void showTables(Collection<Table> tables);
    void reservationTable(Date orderDate, int tableNumber, String nameClients);
    void showReservationTableResult(int reservationNo);
    void showChangeReservationTable(int reservationNo, int newTableNo);
    void changeReservationTable(int oldReserve, Date reservationDate, int tableNumber, String nameClients);
}
