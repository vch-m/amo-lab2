package com.example.lab2_last;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* generation of default arrays in editText */
        BinaryInsertionSort bIS = new BinaryInsertionSort ();
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5  = findViewById(R.id.editText5);
        EditText editText6= findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        EditText editText8 = findViewById(R.id.editText8);
        EditText editText9 = findViewById(R.id.editText9);
        EditText editText10 = findViewById (R.id.editText10);

        editText1.setText (BinaryInsertionSort.generation (10));
        editText2.setText (BinaryInsertionSort.generation (50));
        editText3.setText (BinaryInsertionSort.generation (100));
        editText4.setText (BinaryInsertionSort.generation (150));
        editText5.setText (BinaryInsertionSort.generation (200));
        editText6.setText (BinaryInsertionSort.generation (250));
        editText7.setText (BinaryInsertionSort.generation (300));
        editText8.setText (BinaryInsertionSort.generation (350));
        editText9.setText (BinaryInsertionSort.generation (400));
        editText10.setText (BinaryInsertionSort.generation (450));




        double y,x,f,count;
        x = 100.0;
        count = 0.0;
        LineGraphSeries<DataPoint> series, series2,series3;
        GraphView graph = findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        series2 = new LineGraphSeries<DataPoint>();
        series3 = new LineGraphSeries<DataPoint>();
        series3.setDrawDataPoints(true);
        series3.setDataPointsRadius(10);
        series3.setThickness(8);
        series3.setColor(Color.RED);
        series2.setColor(Color.BLACK);
        for(int i = 0; i<100; i++){
            x = x + 5;
            y = (Math.log(x) / Math.log(2));
            f = (Math.log(x) / Math.log(2));
            series.appendData(new DataPoint(x, y), true, 500);
            series2.appendData(new DataPoint(x,f), true, 500);

        }
        graph.addSeries(series);
               // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0.0);
        graph.getViewport().setMaxX(600.0);

        // set manual Y bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0.0);
        graph.getViewport().setMaxY(60.0);

    }
    public void file(View view) {

        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5  = findViewById(R.id.editText5);
        EditText editText6= findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        EditText editText8 = findViewById(R.id.editText8);
        EditText editText9 = findViewById(R.id.editText9);
        EditText editText10 = findViewById (R.id.editText10);

        String string = "";
        try {
            InputStream inputStream = getAssets().open("test.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);

            string = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] list = string.split("\n");
        editText1.setText (list[0]);
        editText2.setText (list[1]);
        editText3.setText (list[2]);
        editText4.setText (list[3]);
        editText5.setText (list[4]);
        editText6.setText (list[5]);
        editText7.setText (list[6]);
        editText8.setText (list[7]);
        editText9.setText (list[8]);
        editText10.setText (list[9]);
        }

    public void graph(View view){


        GraphView graph = findViewById(R.id.graph2);
        graph.removeAllSeries();
        List<Integer> nanoseconds1 = new ArrayList<>();
        BinaryInsertionSort bIS = new BinaryInsertionSort ();
        int[] ar1 = new int[50];BinaryInsertionSort.randomFill (ar1);
        int[] ar2 = new int[100];BinaryInsertionSort.randomFill (ar2);
        int[] ar3 = new int[150];BinaryInsertionSort.randomFill (ar3);
        int[] ar4 = new int[200];BinaryInsertionSort.randomFill (ar4);
        int[] ar5 = new int[250];BinaryInsertionSort.randomFill (ar5);
        int[] ar6 = new int[300];BinaryInsertionSort.randomFill (ar6);
        int[] ar7 = new int[350];BinaryInsertionSort.randomFill (ar7);
        int[] ar8 = new int[400];BinaryInsertionSort.randomFill (ar8);
        int[] ar9 = new int[450];BinaryInsertionSort.randomFill (ar9);
        int[] ar10 = new int[500];BinaryInsertionSort.randomFill (ar10);


        bIS.sort (ar1,nanoseconds1);bIS.sort (ar2,nanoseconds1);
        bIS.sort (ar3,nanoseconds1);bIS.sort (ar4,nanoseconds1);
        bIS.sort (ar5,nanoseconds1);bIS.sort (ar6,nanoseconds1);
        bIS.sort (ar7,nanoseconds1);bIS.sort (ar8,nanoseconds1);
        bIS.sort (ar9,nanoseconds1);bIS.sort (ar10,nanoseconds1);

        System.out.println (nanoseconds1.toString ());

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {

                new DataPoint(50,  nanoseconds1.get (0)),
                new DataPoint(100, nanoseconds1.get (1)),
                new DataPoint(150, nanoseconds1.get (2)),
                new DataPoint(200, nanoseconds1.get (3)),
                new DataPoint(250, nanoseconds1.get (4)),
                new DataPoint(300, nanoseconds1.get (5)),
                new DataPoint(350, nanoseconds1.get (6)),
                new DataPoint(400, nanoseconds1.get (7)),
                new DataPoint(450, nanoseconds1.get (8)),
                new DataPoint(500, nanoseconds1.get (9)),

        });
        graph.addSeries(series);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0.0);
        graph.getViewport().setMaxX(600.0);

        // set manual Y bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0.0);
        graph.getViewport().setMaxY(2000000.0);

    }

    public void generate(View view){
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5  = findViewById(R.id.editText5);
        EditText editText6= findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        EditText editText8 = findViewById(R.id.editText8);
        EditText editText9 = findViewById(R.id.editText9);
        EditText editText10 = findViewById (R.id.editText10);

        editText1.setText (BinaryInsertionSort.generation (10));
        editText2.setText (BinaryInsertionSort.generation (50));
        editText3.setText (BinaryInsertionSort.generation (200));
        editText4.setText (BinaryInsertionSort.generation (250));
        editText5.setText (BinaryInsertionSort.generation (300));
        editText6.setText (BinaryInsertionSort.generation (350));
        editText7.setText (BinaryInsertionSort.generation (400));
        editText8.setText (BinaryInsertionSort.generation (450));
        editText9.setText (BinaryInsertionSort.generation (500));
        editText10.setText (BinaryInsertionSort.generation (550));

    }


    public void sort1(View view){
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5  = findViewById(R.id.editText5);
        EditText editText6= findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        EditText editText8 = findViewById(R.id.editText8);
        EditText editText9 = findViewById(R.id.editText9);
        EditText editText10 = findViewById (R.id.editText10);

         List<Integer> nanoseconds = new ArrayList<>();


        BinaryInsertionSort bIS = new BinaryInsertionSort ();
        String[] et1 = editText1.getText ().toString ().split ("(,\\s)|(,)"); editText1.setText(Arrays.toString (bIS.sort(StringArrToIntArr (et1),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et2 = editText2.getText ().toString ().split ("(,\\s)|(,)"); editText2.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et2),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et3 = editText3.getText ().toString ().split ("(,\\s)|(,)"); editText3.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et3),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et4 = editText4.getText ().toString ().split ("(,\\s)|(,)"); editText4.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et4),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et5 = editText5.getText ().toString ().split ("(,\\s)|(,)"); editText5.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et5),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et6 = editText6.getText ().toString ().split ("(,\\s)|(,)"); editText6.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et6),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et7 = editText7.getText ().toString ().split ("(,\\s)|(,)"); editText7.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et7),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et8 = editText8.getText ().toString ().split ("(,\\s)|(,)"); editText8.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et8),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et9 = editText9.getText ().toString ().split ("(,\\s)|(,)"); editText9.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et9),nanoseconds)).replace ("[","").replace ("]",""));
        String[] et10 = editText10.getText ().toString ().split ("(,\\s)|(,)"); editText10.setText (Arrays.toString(bIS.sort(StringArrToIntArr (et10),nanoseconds)).replace ("[","").replace ("]",""));

        System.out.println (nanoseconds.toString ());
    }


    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }
}

