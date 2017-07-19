package com.example.admin.color_game;

import android.graphics.Color;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Admin on 16/07/2017.
 */

public class Colors_Textview {


    TextView Colorview;
    int number1, number2;
    String[] TextColors = new String[]{"Green", "Purple", "Blue", "Yellow", "Gray", "Brown", "Red", "Black", "White"};


    int[] Colors = {Color.rgb(34, 232, 16), Color.rgb(118, 128, 242), Color.rgb(33, 136, 255), Color.rgb(236, 255, 114)
            , Color.rgb(155, 155, 155), Color.rgb(153, 111, 73), Color.rgb(247, 61, 24), Color.rgb(0, 0, 0)};

    public Colors_Textview(TextView Colorview) {

        this.Colorview = Colorview;
    }

    public boolean IsMatchedColors() {
        if (number1 == number2)
            return true;
        else
            return false;
    }


    public void ShowRandom() {

        Random rand = new Random();

        number1 = rand.nextInt(8) ;
        number2 = rand.nextInt(5) ;
        int i = rand.nextInt(2);
        if (i ==1)
            number1 = number2;


        Colorview.setText(TextColors[number1]);

        Colorview.setTextColor(Colors[number2]);

    }
}
