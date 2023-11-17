package org.example.Views;

import org.example.Models.Table;
import org.example.Models.TableModel;
import org.example.Presenters.View;
import org.example.Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер резерва #%d\n", reservationNo);
        } else
            System.out.println("Невозможно забронировать столик.\nПовторите попытку позже.");
    }

    @Override
    public void showChangeReservationTable(int reservationNo, int newTableNo) {
        if (reservationNo > 0) {
            System.out.printf("По номеру брони №%d изменен номер столика. Новый номер столика №%d\n",
                    reservationNo, newTableNo);
        }
        else System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
    }

    public void reservationTable(Date reserveDate, int tableNo, String name) {
        for (ViewObserver observer : observers) {
            observer.onReservationTable(reserveDate, tableNo, name);
        }
    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNumber, String nameClients) {
        for (ViewObserver observer : observers) {
            observer.onUpdateReservationTable(oldReservation, reservationDate, tableNumber, nameClients);
        }
    }

}
