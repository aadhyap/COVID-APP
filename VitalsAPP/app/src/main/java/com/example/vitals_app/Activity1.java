package com.example.vitals_app;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;
import com.r0adkll.slidr.Slidr;


import java.util.ArrayList;
import java.util.List;



public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


        AnyChartView anyChartView = findViewById(R.id.any_chart_view);

        Cartesian cartesian = AnyChart.line();


        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);

        cartesian.title("Temperature Throughout the Day");

        cartesian.yAxis(0).title("Temperature (C)");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);

        List<DataEntry> seriesData = new ArrayList<>();
        seriesData.add(new CustomDataEntry("6 AM", 20));
        seriesData.add(new CustomDataEntry("6:30 AM", 7.1));
        seriesData.add(new CustomDataEntry("7 AM", 8.5));
        seriesData.add(new CustomDataEntry("7:30 AM", 9.2));
        seriesData.add(new CustomDataEntry("8 AM", 10.1));
        seriesData.add(new CustomDataEntry("8:30 AM", 11.6));
        seriesData.add(new CustomDataEntry("9 AM", 16.4));
        seriesData.add(new CustomDataEntry("9:30 AM", 18.0));
        seriesData.add(new CustomDataEntry("10 AM", 13.2));
        seriesData.add(new CustomDataEntry("10:30 AM", 12.0));
        seriesData.add(new CustomDataEntry("11 AM", 3.2));
        seriesData.add(new CustomDataEntry("11:30 AM", 4.1));
        seriesData.add(new CustomDataEntry("12 PM", 6.3));
        seriesData.add(new CustomDataEntry("12:30 PM", 9.4));
        seriesData.add(new CustomDataEntry("1 PM", 11.5));
        seriesData.add(new CustomDataEntry("1:30 PM", 13.5));
        seriesData.add(new CustomDataEntry("2 PM", 14.8));
        seriesData.add(new CustomDataEntry("2:30 PM", 16.6));
        seriesData.add(new CustomDataEntry("3 PM", 18.1));
        seriesData.add(new CustomDataEntry("3:30 PM", 17.0));
        seriesData.add(new CustomDataEntry("4 PM", 16.6));
        seriesData.add(new CustomDataEntry("4:30 PM", 14.1));
        seriesData.add(new CustomDataEntry("5:00 PM", 15.7));
        seriesData.add(new CustomDataEntry("5:30 PM", 12.0));


        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");


        Line series1 = cartesian.line(series1Mapping);
        series1.color("#1BB4BC");
        series1.name("Temperature");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);



        cartesian.legend().enabled(true);
        cartesian.legend().fontSize(13d);
        cartesian.legend().padding(0d, 0d, 10d, 0d);

        anyChartView.setChart(cartesian);




    }private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value) {
            super(x, value);

        }
    }

    public void openActivity2(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openSettingsActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    public void openGoogleMapsActivity(View view) {
        Intent intent = new Intent(this, GoogleMapsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}