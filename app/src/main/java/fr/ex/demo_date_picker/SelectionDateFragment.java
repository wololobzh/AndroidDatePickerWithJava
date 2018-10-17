package fr.ex.demo_date_picker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import java.time.LocalDate;

/**
 * Classe permettant de créer un datePicker
 */
public class SelectionDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
{
    /**
     * Représente l'activité utilisant l'objet SelectionDateFragment courant.
     */
    private OnSelectionDateListener mListener;

    /**
     * Constructeur.
     */
    public SelectionDateFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LocalDate now = LocalDate.now();
        return new DatePickerDialog(getActivity(), this,now.getYear(),now.getMonth().getValue()-1,now.getDayOfMonth());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSelectionDateListener) {
            mListener = (OnSelectionDateListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        if (mListener != null) {
            mListener.onSelectionDate(LocalDate.of(year,month+1,dayOfMonth));
        }
    }

    /**
     * Permet de définir la fonction qui sera executé dans l'activité au moment du choix d'une date
     * Pour utiliser la classe SelectionDateFragment, une activité devra donc obligatoirement implémenter DatePickerDialog.OnDateSetListener
     */
    public interface OnSelectionDateListener {
        void onSelectionDate(LocalDate date);
    }
}
