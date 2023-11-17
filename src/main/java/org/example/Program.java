package org.example;

import org.example.Models.TableModel;
import org.example.Presenters.BookingPresenter;
import org.example.Presenters.Model;
import org.example.Presenters.View;
import org.example.Views.BookingView;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();

        view.reservationTable(new Date(), 3, "игорь");

        view.changeReservationTable(1001, new Date(), 2, "игорь");
    }
}

