package com.example.vitals_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;
import java.util.List;


public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        AnyChartView anyChartView2 = findViewById(R.id.any_chart_view);
        APIlib.getInstance().setActiveAnyChartView(anyChartView2);

        Cartesian cartesian2 = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("S", 80));
        data.add(new ValueDataEntry("M", 50));
        data.add(new ValueDataEntry("T", 72));
        data.add(new ValueDataEntry("W", 60));
        data.add(new ValueDataEntry("T", 60));
        data.add(new ValueDataEntry("F", 40));
        data.add(new ValueDataEntry("S", 50));

        Column column = cartesian2.column(data);

        column.color("#48C9B0");
        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("${%Value}{groupsSeparator: }");

        cartesian2.animation(true);
        cartesian2.title("Daily Average Temperature");

        cartesian2.yScale().minimum(0d);

        cartesian2.yAxis(0).labels().format("${%Value}{groupsSeparator: }");

        cartesian2.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian2.interactivity().hoverMode(HoverMode.BY_X);

        cartesian2.xAxis(0).title("Days");
        cartesian2.yAxis(0).title("Temperature (C)");

        anyChartView2.setChart(cartesian2);

        Slidr.attach(this);
    }
    public void openActivity3(View view) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
