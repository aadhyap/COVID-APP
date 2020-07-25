
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



public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


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

        cartesian.title(" ");

        cartesian.yAxis(0).title("Turned ON");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);

        List<DataEntry> seriesData = new ArrayList<>();
        seriesData.add(new CustomDataEntry("6 AM", 0));
        seriesData.add(new CustomDataEntry("6:30 AM", 0));
        seriesData.add(new CustomDataEntry("7 AM", 0));
        seriesData.add(new CustomDataEntry("7:30 AM", 0));
        seriesData.add(new CustomDataEntry("8 AM", 0));
        seriesData.add(new CustomDataEntry("8:30 AM", 0));
        seriesData.add(new CustomDataEntry("9 AM", 0));
        seriesData.add(new CustomDataEntry("9:30 AM", 0));
        seriesData.add(new CustomDataEntry("10 AM", 0));
        seriesData.add(new CustomDataEntry("10:30 AM", 0));
        seriesData.add(new CustomDataEntry("11 AM", 0));
        seriesData.add(new CustomDataEntry("11:30 AM", 0));
        seriesData.add(new CustomDataEntry("12 PM", 100));
        seriesData.add(new CustomDataEntry("12:01 PM", 0));
        seriesData.add(new CustomDataEntry("12:30 PM", 0));
        seriesData.add(new CustomDataEntry("1 PM", 100));
        seriesData.add(new CustomDataEntry("1:01 PM", 0));
        seriesData.add(new CustomDataEntry("1:30 PM", 0));
        seriesData.add(new CustomDataEntry("2 PM", 100));
        seriesData.add(new CustomDataEntry("2:01 PM", 0));
        seriesData.add(new CustomDataEntry("2:30 PM", 0));
        seriesData.add(new CustomDataEntry("3 PM", 100));
        seriesData.add(new CustomDataEntry("3:01 PM", 0));
        seriesData.add(new CustomDataEntry("3:30 PM", 0));
        seriesData.add(new CustomDataEntry("4 PM", 0));
        seriesData.add(new CustomDataEntry("4:30 PM", 0));
        seriesData.add(new CustomDataEntry("5:00 PM", 0));
        seriesData.add(new CustomDataEntry("5:30 PM", 0));

        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");


        Line series1 = cartesian.line(series1Mapping);
        series1.name("UV Light");
        series1.color("#48C9B0");
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


    }

    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value) {
            super(x, value);

        }
    }
    public void openSettingsActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}