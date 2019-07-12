package com.soliwork.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech mSpeak;
    private EditText mEditText;
    private Button mBtnSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cast ou instanciar
        mEditText = findViewById(R.id.edit_text);
        mBtnSpeak = findViewById(R.id.btn_speak);

        mSpeak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    // Pega locate que está setado no celular
                    mSpeak.setLanguage(Locale.getDefault());
                }
            }
        });

        mBtnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpeak.speak(mEditText.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public void onPause() {
        if (mEditText != null){
            //mEditText.stop();
            //mEditText.shutdown();
        }
        super.onPause();
    }
}
