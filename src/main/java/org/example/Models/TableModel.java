package org.example.Models;

import org.example.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reserveDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(tableNo, reserveDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Неккореткный номер столика");
    }

    public int changeReservationTable(int oldReserve, Date reservetionDate, int tableNo, String name) {

        Reservation newReservation = null;
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReserve) {
                    newReservation = reservation;
                }
            }
            table.getReservations().removeIf(id -> id.getId() == oldReserve);
            if (table.getNo() == tableNo) {
                table.getReservations().add(newReservation);
                return newReservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика");
    }
}
