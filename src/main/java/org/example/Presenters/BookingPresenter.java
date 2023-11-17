package org.example.Presenters;

import org.example.Models.TableModel;
import org.example.Views.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTables() {
        view.showTables(model.loadTables());
    }

    private void showReservationTableresult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    public void updateUIShowReservationTableResult(int reservationNumber) {
        view.showReservationTableResult(reservationNumber);
    }

    public void updateUIShowshowСhangeReservationTable(int reservationNumber, int numberTable) {
        view.showChangeReservationTable(reservationNumber, numberTable);
    }

    @Override
    public void onReservationTable(Date reserveDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(reserveDate, tableNo, name);
            showReservationTableresult(reservationNo);
        } catch (RuntimeException e) {
            showReservationTableresult(-1);
        }
    }

    @Override
    public void onUpdateReservationTable(int oldReserve, Date reserveDate, int tableNo, String name) {
        try {
            int newReservationNo = model.changeReservationTable(oldReserve, reserveDate, tableNo, name);
            updateUIShowshowСhangeReservationTable(newReservationNo, tableNo);
        } catch (RuntimeException e) {
            updateUIShowshowСhangeReservationTable(-1, -1);
        }
    }
}
