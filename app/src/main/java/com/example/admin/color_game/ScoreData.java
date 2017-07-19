package com.example.admin.color_game;

import android.content.Context;
import android.content.res.Resources;
import android.provider.OpenableColumns;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 17/07/2017.
 */

public class ScoreData {
    String score;
    Context context;
    public ScoreData(Context context) {
        this.context= context;
    }

    public ScoreData(String score,Context context) {
        this.score = score;
    }

    public void WriteScore(String score)
    {
        try {
            FileOutputStream save = context.openFileOutput("ScoreFile.txt", Context.MODE_PRIVATE);

          save.write(score.getBytes());
            save.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String ReadeScore(){
        String line=null;

        //final String Name="ScoreFile.txt";
        try {
            FileInputStream Load = context.openFileInput("ScoreFile.txt");

            BufferedReader buffer = new BufferedReader(new InputStreamReader(new DataInputStream(Load)));
            line= buffer.readLine();
            Load.close();
            return line;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
