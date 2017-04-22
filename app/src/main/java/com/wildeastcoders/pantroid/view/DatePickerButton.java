package com.wildeastcoders.pantroid.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import static com.wildeastcoders.pantroid.view.fragment.EditItemActivityFragment.DATE_FORMAT_FOR_BUTTONS;

/**
 * Created by Majfrendmartin on 22.04.2017.
 */

public class DatePickerButton extends android.support.v7.widget.AppCompatButton implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private static final String SUPER_STATE = "SUPER_STATE";
    private static final String SELECTED_DATE = "SELECTED_DATE";
    private Date selectedDate = new Date();

    public DatePickerButton(Context context) {
        super(context);
        initialize();
    }

    public DatePickerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public DatePickerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
        displaySelectedDate();
    }

    private void initialize() {
        setOnClickListener(this);
        displaySelectedDate();
    }

    @Override
    public void onClick(View view) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);
        final DatePickerDialog datePickerDialog =
                new DatePickerDialog(getContext(), this,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        setSelectedDate(calendar.getTime());
    }

    private void displaySelectedDate() {
        setText(DATE_FORMAT_FOR_BUTTONS.format(selectedDate));
    }

    @Override
    public Parcelable onSaveInstanceState() {
        final Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE, super.onSaveInstanceState());
        bundle.putLong(SELECTED_DATE, selectedDate.getTime());
        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            final Bundle bundle = (Bundle) state;
            if (bundle.containsKey(SELECTED_DATE)) {
                selectedDate = new Date(bundle.getLong(SELECTED_DATE));
            }
            state = bundle.getParcelable(SUPER_STATE);
        }
        super.onRestoreInstanceState(state);
        displaySelectedDate();
    }

}
