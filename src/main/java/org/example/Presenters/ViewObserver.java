package org.example.Presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date reserveDate, int tableNo, String name);

    void onUpdateReservationTable(int oldReserve, Date reserveDate, int tableNo, String name);
}
