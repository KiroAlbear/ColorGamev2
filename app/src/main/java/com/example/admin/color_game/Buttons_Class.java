package com.example.admin.color_game;

import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Admin on 15/07/2017.
 */

public class Buttons_Class {
//    Button RightButton;
ImageButton ButtonObject;

    public Buttons_Class(ImageButton ButtonObject) {
      this. ButtonObject = ButtonObject;

    }
    public void LeftButtonColor(){
        ButtonObject.setBackgroundColor(Color.parseColor("#f44e42"));
    }

    public void RightButtonColor(){
        ButtonObject.setBackgroundColor(Color.parseColor("#41f44a"));
    }
    public void ColorClean(){
        ButtonObject.setBackgroundColor(Color.parseColor("#9ea8ba"));
    }
}
