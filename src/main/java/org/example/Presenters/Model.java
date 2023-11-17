package org.example.Presenters;

import org.example.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable (Date reserveDate, int tableNo, String name);

    int changeReservationTable(int oldReserve, Date reservetionDate, int tableNo, String name);

}
