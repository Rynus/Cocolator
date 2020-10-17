package com.proto.cocolator.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;
import com.proto.cocolator.R;
import com.proto.cocolator.activities.MainActivity;

import java.util.List;

public class CoManager {
    Drawable res;
    int C;
    SingleSelectToggleGroup group;
    TextView ribbon1;
    TextView ribbon2;
    TextView ribbon3;
    TextView ribbon4;
    TextView ribbon5;
    TextView ribbon6;
    Button[] colorButton;
    List<TextView> ribbons;

    public CoManager(Drawable res, int c, SingleSelectToggleGroup group, TextView ribbon1, TextView ribbon2, TextView ribbon3, TextView ribbon4, TextView ribbon5, TextView ribbon6, Button[] colorButton, List<TextView> ribbons) {
        this.res = res;
        this.C = c;
        this.group = group;
        this.ribbon1 = ribbon1;
        this.ribbon2 = ribbon2;
        this.ribbon3 = ribbon3;
        this.ribbon4 = ribbon4;
        this.ribbon5 = ribbon5;
        this.ribbon6 = ribbon6;
        this.colorButton = colorButton;
        this.ribbons = ribbons;
    }

    public void buttonSetUp() {
        colorButton[0].setBackgroundColor(RiCol.BLACK);
        colorButton[1].setBackgroundColor(RiCol.BROWN);
        colorButton[2].setBackgroundColor(RiCol.RED);
        colorButton[3].setBackgroundColor(RiCol.ORANGE);
        colorButton[4].setBackgroundColor(RiCol.YELLOW);
        colorButton[5].setBackgroundColor(RiCol.GREEN);
        colorButton[6].setBackgroundColor(RiCol.BLUE);
        colorButton[7].setBackgroundColor(RiCol.PURPLE);
        colorButton[8].setBackgroundColor(RiCol.GRAY);
        colorButton[9].setBackgroundColor(RiCol.WHITE);
        colorButton[10].setBackgroundColor(RiCol.SILVER);
        colorButton[11].setBackgroundColor(RiCol.GOLD);
    }

    public void ribbonSetUp() {
        group.setOnCheckedChangeListener(new SingleSelectToggleGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SingleSelectToggleGroup group, int checkedId) {
                switch (group.getCheckedId()) {
                    case R.id.ribbon_mode_4:
                        ribbon1.setBackground(res);
                        ribbon2.setBackground(res);    // this is just for activity class :'
                        ribbon3.setBackground(res);
                        ribbon4.setBackground(res);
                        ribbon5.setVisibility(View.GONE);
                        ribbon6.setVisibility(View.GONE);
                        ribbons.remove(ribbon5);
                        ribbons.remove(ribbon6);
                        break;
                    case R.id.ribbon_mode_5:
                        ribbon1.setBackground(res);
                        ribbon2.setBackground(res);
                        ribbon3.setBackground(res);
                        ribbon4.setBackground(res);
                        ribbon5.setVisibility(View.VISIBLE);
                        ribbon5.setBackground(res);
                        ribbon6.setVisibility(View.GONE);
                        ribbons.remove(ribbon5);
                        ribbons.add(ribbon5);
                        ribbons.remove(ribbon6);
                        break;
                    case R.id.ribbon_mode_6:
                        ribbon1.setBackground(res);
                        ribbon2.setBackground(res);
                        ribbon3.setBackground(res);
                        ribbon4.setBackground(res);

                        ribbon5.setVisibility(View.VISIBLE);
                        ribbon6.setVisibility(View.VISIBLE);
                        ribbon5.setBackground(res);
                        ribbon6.setBackground(res);
                        ribbons.remove(ribbon5);
                        ribbons.add(ribbon5);
                        ribbons.add(ribbon6);
                        break;

                }
                MainActivity.C = 0;
            }
        });
    }
}