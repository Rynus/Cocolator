package com.proto.cocolator.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.StatusBarManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;
import com.proto.cocolator.R;
import com.proto.cocolator.util.Calculator;
import com.proto.cocolator.util.CoManager;
import com.proto.cocolator.util.RiCol;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    public static int C;
    SingleSelectToggleGroup ribbon_mode;

    TextView first_ribbon;
    TextView second_ribbon;
    TextView third_ribbon;
    TextView fourth_ribbon;
    TextView fifth_ribbon;
    TextView sixth_ribbon;

    List<TextView> ribbons;

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
    DrawerLayout drawer;
    boolean slideState;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        NavigationView nav = findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(this);


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


        res = ResourcesCompat.getDrawable(getResources(), R.drawable.view_frame_transparent, null);

        Button[] colButton = new Button[]{black, brown, red, orange, yellow, green, blue, purple, gray, white, silver, gold};
        manager = new CoManager(res, C, ribbon_mode, first_ribbon, second_ribbon, third_ribbon, fourth_ribbon, fifth_ribbon, sixth_ribbon, colButton, ribbons);
        manager.ribbonSetUp();

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
        silver.setClickable(false);
        silver.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        int ribbonColour = 0;
        final Animation bouncing = AnimationUtils.loadAnimation(this, R.anim.bounce);
        short code = 0;
        switch (v.getId()) {
            case R.id.black:
                black.startAnimation(bouncing);
                ribbonColour = RiCol.BLACK;
                code = 0;
                break;
            case R.id.brown:
                brown.startAnimation(bouncing);
                ribbonColour = RiCol.BROWN;
                code = 1;
                break;
            case R.id.red:
                red.startAnimation(bouncing);
                ribbonColour = RiCol.RED;
                code = 2;
                break;
            case R.id.orange:
                orange.startAnimation(bouncing);
                ribbonColour = RiCol.ORANGE;
                code = 3;
                break;
            case R.id.yellow:
                yellow.startAnimation(bouncing);
                code = 4;
                ribbonColour = RiCol.YELLOW;
                break;
            case R.id.green:
                green.startAnimation(bouncing);
                code = 5;
                ribbonColour = RiCol.GREEN;
                break;
            case R.id.blue:
                blue.startAnimation(bouncing);
                code = 6;
                ribbonColour = RiCol.BLUE;
                break;
            case R.id.purple:
                purple.startAnimation(bouncing);
                code = 7;
                ribbonColour = RiCol.PURPLE;
                break;
            case R.id.gray:
                gray.startAnimation(bouncing);
                code = 8;
                ribbonColour = RiCol.GRAY;
                break;
            case R.id.white:
                white.startAnimation(bouncing);
                code = 9;
                ribbonColour = RiCol.WHITE;
                break;
            case R.id.silver:
                silver.startAnimation(bouncing);
                code = 10;
                ribbonColour = RiCol.SILVER;
                break;
            case R.id.gold:
                gold.startAnimation(bouncing);
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

        boolean clickable = (C >= ribbons.size() - 1 || C > 3) ? true : false;


        silver.setClickable(clickable);
        gold.setClickable(clickable);


        Log.d("NUPIE", "onClick: \n"
                + "C = " + C + "\n"
                + "clickable = " + clickable + "\n"
                + "r size = " + ribbons.size()
                + "r size -2 = " + (ribbons.size() - 2));
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

    public void open(View view) {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.credit:
                Toast.makeText(this, "hei", Toast.LENGTH_SHORT).show();


                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(getLayoutInflater().inflate(R.layout.fragment_credit, null));
                builder.show();
        }

        drawer.closeDrawer(GravityCompat.START);

        return false;
    }
}