package fr.ex.demo_date_picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.time.LocalDate;
import fr.ex.projetdatepicker.R;

public class MainActivity extends AppCompatActivity implements  SelectionDateFragment.OnSelectionDateListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Fonction surchargée, exécutée une fois la date est séléctionnée.
     *
     * @param date
     */
    @Override
    public void onSelectionDate(LocalDate date) {
        Toast.makeText(this, "Date séléctionnée : " + date.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Permet d'afficher un date picker.
     *
     * @param view
     */
    public void afficherDatePicker(View view) {
        DialogFragment newFragment = new SelectionDateFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
