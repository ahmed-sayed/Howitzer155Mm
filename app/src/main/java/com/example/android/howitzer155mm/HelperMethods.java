package com.example.android.howitzer155mm;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelperMethods {

    private HelperMethods() {
    }

    public static double Check_Fix_Value(String number) {
        double fix_value;
        if (number.length() == 0) { // no fix value
            fix_value = 0.0;
        } else {
            // check sign for fix value
            if (number.charAt(0) == '-') {
                // shot is right of target
                fix_value = Double.parseDouble(number.substring(1));
            } else {
                //shot is left of target
                fix_value = Double.parseDouble(number.substring(1)) * -1;
            }
        }
        return fix_value;
    }

    public static boolean check_valid_number(double number, int unit) {
        /*
         * units
         *  0: degree
         *  1: deci
         *  2: mils
         *  */

        if (unit == 0) {
            if (number < 0 || number > 360) {
                return false;
            }
            return true;
        } else if (unit == 1) {
            if (number < 0 || number > 6000) {
                return false;
            }
            return true;
        } else {
            if (number < 0 || number > 6400) {
                return false;
            }
            return true;
        }
    }

    public static double roundOff(double number) {
        return Math.round(number * 100.0) / 100.0;

    }

    public static double convert_to(double number, int from, int to) {
        if (from == 0) {
            if (to == 0) {
                return roundOff(number);
            } else if (to == 1) {
                return roundOff(number * 100 / 6);
            } else
                return roundOff(number * 160 / 9);
        } else if (from == 1) {
            if (to == 0) {
                return roundOff(number * 6 / 100);
            } else if (to == 1) {
                return roundOff(number);
            } else return roundOff(number * 16 / 15);
        } else {
            if (to == 0) {
                return roundOff(number * 9 / 160);
            } else if (to == 1) {
                return roundOff(number * 15 / 16);
            } else return roundOff(number);
        }
    }

    public static String load_text_file(Context context, String file_name) {
        file_name += ".txt";
        StringBuilder text = new StringBuilder();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(file_name)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
                text.append('\n');
            }
        } catch (IOException e) {
            Toast.makeText(context.getApplicationContext(), "Error reading file!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }

            //TextView output_TextView = (TextView);
            return text.toString();

        }
    }
}
