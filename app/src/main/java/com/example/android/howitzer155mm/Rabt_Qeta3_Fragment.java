package com.example.android.howitzer155mm;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rabt_Qeta3_Fragment extends Fragment {

    private double A_R_D_value_degree = 0.0;
    private double A_R_D_value_deci = 0.0;
    private double A_R_D_value_mils = 0.0;

    private double input_distance_value;
    private double input_distance_fix_value;
    private double input_direction_value;
    private double input_direction_fix_value;

    private double output_En7raf_value;
    private double output_height_value;
    private double output_A5r_Marbotaah_value;


    public Rabt_Qeta3_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_rabt__qeta3_, container, false);

        final TextView A_R_D_degree_textview = (TextView) rootview.findViewById(R.id.A_R_D_Value_degree);
        final TextView A_R_D_mils_textview = (TextView) rootview.findViewById(R.id.A_R_D_Value_mils);


        // User Input Values
        // User Input Values

        final EditText input_Qeta3_number_EditText = (EditText) rootview.findViewById(R.id.input_raqm_elQeta3);

        final EditText input_distance_value_EditText = (EditText) rootview.findViewById(R.id.input_distance);
        final EditText input_distance_Fix_value_EditText = (EditText) rootview.findViewById(R.id.input_distance_fix);

        final EditText input_direction_value_EditText = (EditText) rootview.findViewById(R.id.input_direction);
        final EditText input_direction_Fix_value_EditText = (EditText) rootview.findViewById(R.id.input_direction_fix);


        // output Results
        // output Results

        final TextView output_height_textview = (TextView) rootview.findViewById(R.id.output_hieght);
        final TextView output_En7raf_textview = (TextView) rootview.findViewById(R.id.output_En7raf);
        final TextView output_A5r_Marbotaah_textview = (TextView) rootview.findViewById(R.id.output_A5r_marbotaah);

        // get the entered A.R.D from user
        final EditText A_R_D_EditText = (EditText) rootview.findViewById(R.id.A_R_D_Value);
        A_R_D_EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // set A_R_D_value_degree
                A_R_D_degree_textview.setText("0.0");

                // set A_R_D_value_mils
                A_R_D_mils_textview.setText("00-00");

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {

                    // check is a valid number
                    double number = Double.parseDouble(charSequence.toString());
                    if (HelperMethods.check_valid_number(number, 1)) {
                        A_R_D_value_deci = number;
                        A_R_D_value_degree = HelperMethods.convert_to(number, 1, 0);
                        A_R_D_value_mils = HelperMethods.convert_to(number, 1, 2);


                        // set A_R_D_value_degree
                        A_R_D_degree_textview.setText(Double.toString(A_R_D_value_degree));

                        // set A_R_D_value_mils
                        TextView A_R_D_mils_textview = (TextView) rootview.findViewById(R.id.A_R_D_Value_mils);
                        A_R_D_mils_textview.setText(Double.toString(A_R_D_value_mils));

                    } else {
                        Toast.makeText(getContext(), " Please enter a valid number ", Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(getContext(), " Please enter a real number ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button solve_btn = (Button) rootview.findViewById(R.id.solve_btn);
        solve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String direction_Text = input_direction_value_EditText.getText().toString();
                if (direction_Text.length() != 0) {
                    input_direction_value = Double.parseDouble(direction_Text);
                    if (input_direction_value > 0.0 && input_direction_value < 360.0) {

                        String direction_fix_Text = input_direction_Fix_value_EditText.getText().toString();
                        double fix_value = HelperMethods.Check_Fix_Value(direction_fix_Text);

                        // Calculate En7raf & A5r_Marbotaah
                        double diffrence = A_R_D_value_degree - input_direction_value;
                        output_En7raf_value = diffrence * 160 / 9;
                        output_A5r_Marbotaah_value = 3200 + output_En7raf_value + fix_value;


                        // Print Results
                        output_En7raf_textview.setText(Double.toString(output_En7raf_value));
                        output_A5r_Marbotaah_textview.setText(Double.toString(output_A5r_Marbotaah_value));
                    } else {
                        Toast.makeText(getContext(), " Wrong Direction Value ", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getContext(), " Enter Direction Value ", Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootview;
    }

}
