package com.example.designpatternassignment;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AlertDialog;


import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    public static MainActivity singltonInstance; //singleton

    EditText editText;
    Button button;
    LinearLayout buttonsParentLayout;
    boolean uppercase;

    InputConnection inputConn;

    public ArrayList<View> allButtons = new ArrayList<View>();
    public ArrayList<String> allButtonsText = new ArrayList<String>();
    Button spaceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singltonInstance = this; //singleton

        buttonsParentLayout = findViewById(R.id.buttonsParentLayout);

        editText = findViewById(R.id.editTextTextPersonName);
        editText.setTextIsSelectable(true);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int _color = Color.GRAY;
                if(hasFocus)
                {
                    _color = Color.BLACK;

                    Toast.makeText(MainActivity.this, "Keyboard Enabled", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    _color = Color.GRAY;

                    Toast.makeText(MainActivity.this, "Keyboard Disabled", Toast.LENGTH_SHORT).show();
                }

                editText.setBackgroundColor(_color);
            }
        });

        inputConn = editText.onCreateInputConnection(new EditorInfo());

        GetAllButtons();
    }

    public void ButtonCharacter(View view) {
        button = (Button)findViewById(view.getId());
        String _string = (String) button.getText();

        CharSequence _text = (uppercase) ? _string.toUpperCase() : _string.toLowerCase();

        if(view.getId() == R.id.button_space)
        {
            _text = " ";
        }

        inputConn.commitText(_text, 1);
    }

    public void ButtonDel(View view) {
        if(editText.length() != 0)
        {
            inputConn.deleteSurroundingText(1, 0);
        }
        else
        {
            inputConn.commitText("", 1);
        }
    }

    public void ButtonCap(View view)
    {
        uppercase = !uppercase;
        int _color = (uppercase) ? Color.GRAY : Color.BLACK;
        view.setBackgroundColor(_color);
    }


    public void ButtonOk(View view) {
        //hide keyboard
        editText.setFocusableInTouchMode(false);
        editText.setFocusable(false);

        buttonsParentLayout.setBackgroundColor(Color.WHITE);

        for (int i = 0; i < allButtons.size(); i++)
        {
            Button _button = (Button) allButtons.get(i);
            _button.setBackgroundColor(Color.WHITE);
            _button.setText("");
            _button.setEnabled(false);
        }

        spaceButton.setBackgroundColor(Color.WHITE);
        spaceButton.setText("");
        spaceButton.setEnabled(false);

        ShowNotificationWithText("Keyboard Disabled");
        AlertDialogWithText("Keyboard Disabled");
    }
    public void EditText(View view) {
        editText.setFocusableInTouchMode(true);
        editText.setFocusable(true);

        buttonsParentLayout.setBackgroundColor(Color.BLACK);

        for (int i = 0; i < allButtons.size(); i++)
        {
            Button _button = (Button) allButtons.get(i);
            _button.setBackgroundColor(Color.BLACK);
            _button.setText(allButtonsText.get(i));
            _button.setEnabled(true);
        }

        spaceButton.setBackgroundColor(Color.GRAY);
        spaceButton.setText("Space");
        spaceButton.setEnabled(true);

        ShowNotificationWithText("Keyboard Enabled");
        AlertDialogWithText("Keyboard Enabled");
    }

    private void GetAllButtons()
    {
        spaceButton = (Button)findViewById(R.id.button_space);

        allButtons.add(findViewById(R.id.button_0));
        allButtons.add(findViewById(R.id.button_1));
        allButtons.add(findViewById(R.id.button_2));
        allButtons.add(findViewById(R.id.button_3));
        allButtons.add(findViewById(R.id.button_4));
        allButtons.add(findViewById(R.id.button_5));
        allButtons.add(findViewById(R.id.button_6));
        allButtons.add(findViewById(R.id.button_7));
        allButtons.add(findViewById(R.id.button_8));
        allButtons.add(findViewById(R.id.button_9));
        allButtons.add(findViewById(R.id.button_q));
        allButtons.add(findViewById(R.id.button_w));
        allButtons.add(findViewById(R.id.button_e));
        allButtons.add(findViewById(R.id.button_r));
        allButtons.add(findViewById(R.id.button_t));
        allButtons.add(findViewById(R.id.button_y));
        allButtons.add(findViewById(R.id.button_u));
        allButtons.add(findViewById(R.id.button_i));
        allButtons.add(findViewById(R.id.button_o));
        allButtons.add(findViewById(R.id.button_p));
        allButtons.add(findViewById(R.id.button_a));
        allButtons.add(findViewById(R.id.button_s));
        allButtons.add(findViewById(R.id.button_d));
        allButtons.add(findViewById(R.id.button_f));
        allButtons.add(findViewById(R.id.button_g));
        allButtons.add(findViewById(R.id.button_h));
        allButtons.add(findViewById(R.id.button_j));
        allButtons.add(findViewById(R.id.button_k));
        allButtons.add(findViewById(R.id.button_l));
        allButtons.add(findViewById(R.id.button_z));
        allButtons.add(findViewById(R.id.button_x));
        allButtons.add(findViewById(R.id.button_c));
        allButtons.add(findViewById(R.id.button_v));
        allButtons.add(findViewById(R.id.button_b));
        allButtons.add(findViewById(R.id.button_n));
        allButtons.add(findViewById(R.id.button_m));
        allButtons.add(findViewById(R.id.button_point));
        allButtons.add(findViewById(R.id.button_comma));
        allButtons.add(findViewById(R.id.button_slash));
        allButtons.add(findViewById(R.id.button_del));
        allButtons.add(findViewById(R.id.button_cap));
        allButtons.add(findViewById(R.id.button_ok));


        for (int i = 0; i < allButtons.size(); i++)
        {
            Button _button = (Button) allButtons.get(i);
            allButtonsText.add(_button.getText().toString());
        }
    }


    //----------Notifications------------

    public void ShowNotificationWithText(String _text)
    {
        NotificationCompat.Builder _notifier = new NotificationCompat.Builder(this);
        _notifier.setSmallIcon(R.drawable.ic_launcher_background);
        _notifier.setContentTitle("KEYBOARD_Notifier");
        _notifier.setContentText(_text);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, _notifier.build());
    }

    public void AlertDialogWithText(String _text)
    {

        AlertDialog.Builder _builder = new AlertDialog.Builder(this);
        _builder.setMessage(_text)
                .setTitle("KEYBOARD_Notifier")
                .setCancelable(true)
                .setIcon(R.drawable.ic_launcher_background)
                .create();

        _builder.show();
    }

    //----------END Notifications------------
}