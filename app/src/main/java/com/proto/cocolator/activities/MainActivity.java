package com.proto.cocolator.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;
import com.proto.cocolator.R;
import com.proto.cocolator.util.Calculator;
import com.proto.cocolator.util.CoManager;
import com.proto.cocolator.util.RiCol;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static int C;
    SingleSelectToggleGroup ribbon_mode;

    TextView first_ribbon;
    TextView second_ribbon;
    TextView third_ribbon;
    TextView fourth_ribbon;
    TextView fifth_ribbon;
    TextView sixth_ribbon;

    List<TextView> ribbons;

    //    Button declaration
    Button black;
    Button brown;
    Button red;
    Button orange;
    Button yellow;
    Button green;
    Button blue;
    Button purple;
    Button gray;
    Button white;
    Button gold;
    Button silver;

    CoManager manager;
    TextView result;
    Drawable res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ribbon_mode = findViewById(R.id.ribbon_group);

        first_ribbon = findViewById(R.id.first_ribbon);
        second_ribbon = findViewById(R.id.second_ribbon);
        third_ribbon = findViewById(R.id.third_ribbon);
        fifth_ribbon = findViewById(R.id.fifth_ribbon);
        sixth_ribbon = findViewById(R.id.sixth_ribbon);
        fourth_ribbon = findViewById(R.id.fourth_ribbon);

        ribbons = new ArrayList<>();
        ribbons.add(first_ribbon);
        ribbons.add(second_ribbon);
        ribbons.add(third_ribbon);
        ribbons.add(fourth_ribbon);

        result = findViewById(R.id.result);

        black = findViewById(R.id.black);
        brown = findViewById(R.id.brown);
        red = findViewById(R.id.red);
        orange = findViewById(R.id.orange);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        purple = findViewById(R.id.purple);
        gray = findViewById(R.id.gray);
        white = findViewById(R.id.white);
        silver = findViewById(R.id.silver);
        gold = findViewById(R.id.gold);


        res = ResourcesCompat.getDrawable(getResources(), R.drawable.view_frame, null);

        Button[] colButton = new Button[]{black, brown, red, orange, yellow, green, blue, purple, gray, white, silver, gold};
        manager = new CoManager(res, C, ribbon_mode, first_ribbon, second_ribbon, third_ribbon, fourth_ribbon, fifth_ribbon, sixth_ribbon, colButton, ribbons);
        manager.ribbonSetUp();
        manager.buttonSetUp();

        black.setOnClickListener(this);
        brown.setOnClickListener(this);
        red.setOnClickListener(this);
        orange.setOnClickListener(this);
        yellow.setOnClickListener(this);
        green.setOnClickListener(this);
        blue.setOnClickListener(this);
        purple.setOnClickListener(this);
        gray.setOnClickListener(this);
        white.setOnClickListener(this);
        silver.setOnClickListener(this);
        gold.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int ribbonColour = 0;
        short code = 0;
        switch (v.getId()) {
            case R.id.black:
                ribbonColour = RiCol.BLACK;
                code = 0;
                break;
            case R.id.brown:
                ribbonColour = RiCol.BROWN;
                code = 1;
                break;
            case R.id.red:
                ribbonColour = RiCol.RED;
                code = 2;
                break;
            case R.id.orange:
                ribbonColour = RiCol.ORANGE;
                code = 3;
                break;
            case R.id.yellow:
                code = 4;
                ribbonColour = RiCol.YELLOW;
                break;
            case R.id.green:
                code = 5;
                ribbonColour = RiCol.GREEN;
                break;
            case R.id.blue:
                code = 6;
                ribbonColour = RiCol.BLUE;
                break;
            case R.id.purple:
                code = 7;
                ribbonColour = RiCol.PURPLE;
                break;
            case R.id.gray:
                code = 8;
                ribbonColour = RiCol.GRAY;
                break;
            case R.id.white:
                code = 9;
                ribbonColour = RiCol.WHITE;
                break;
            case R.id.silver:
                code = 10;
                ribbonColour = RiCol.SILVER;
                break;
            case R.id.gold:
                code = 11;
                ribbonColour = RiCol.GOLD;
                break;
            default:
                break;
        }
        C = (C == ribbons.size()) ? ribbons.size() - 1 : C;
        ribbons.get(C).setBackgroundColor(ribbonColour);
        ribbons.get(C).setText(String.valueOf(code));
        ribbons.get(C).setTextColor(View.GONE);
        if (C == ribbons.size() - 1) {
            switch (ribbons.size()) {
                case 4:
                    result.setText(new Calculator(first_ribbon.getText().toString(), second_ribbon.getText().toString(), third_ribbon.getText().toString(), fourth_ribbon.getText().toString()).getResult4());
                    break;
                case 5:
                    result.setText(new Calculator(first_ribbon.getText().toString(), second_ribbon.getText().toString(), third_ribbon.getText().toString(), fourth_ribbon.getText().toString(), fifth_ribbon.getText().toString()).getResult5());
                    break;
                case 6:
                    result.setText(new Calculator(first_ribbon.getText().toString(), second_ribbon.getText().toString(), third_ribbon.getText().toString(), fourth_ribbon.getText().toString(), fifth_ribbon.getText().toString(), sixth_ribbon.getText().toString()).getResult6());
                    break;
            }
        }
        C++;
    }

    public void clear(View view) {
        for (int i = 0; i < ribbons.size(); i++) {
            ribbons.get(i).setBackground(res);
        }
        C = 0;
        result.setText(" ");
    }

    public void delete(View view) {
        C = (C == 0) ? 0 : C - 1;
        C = Math.abs(C % ribbons.size());
        ribbons.get(C).setBackground(res);
    }
}