package no.westerdals.pg4600.autocompletelivedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class CountrySelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_selection);

        AutoCompleteTextView countrySelector = (AutoCompleteTextView) findViewById(R.id.countryAutoCompleteTextView);

        String[] countries = getResources().getStringArray(R.array.countries);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        assert countrySelector != null;
        countrySelector.setAdapter(adapter);

        countrySelector.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent,
                                    final View view,
                                    final int position, final long id) {
                TextView clickedTextView = (TextView) view;
                final String country = clickedTextView.getText().toString();

                Toast.makeText(
                        CountrySelectionActivity.this,
                        MessageGenerator.countrySelectedMessage(country),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
