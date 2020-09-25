package es.unex.giiis.asee.activitylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {
    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";
    private static final String STOP_KEY = "stop";
    private static final String PAUSE_KEY = "pause";

    // tag para logcat
    private final static String TAG = "Lab-ActivityOne";

    // contadores
    private short mCreate, mRestart, mStart, mResume, mPause, mStop;

    // etiquetas de la IU para mostrar contadores
    private TextView mTvCreate, mTvRestart, mTvStart, mTvResume, mTvPause, mTvStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvPause = (TextView) findViewById(R.id.pause);
        mTvStop = (TextView) findViewById(R.id.stop);

        Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
        launchActivityTwoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(ActivityOne.this,ActivityTwo.class);
                startActivity(act2);
            }
        });

        // Comprobar si estado previo guardado
        if (savedInstanceState != null) {

            // TODO Restaurar estado anterior

        }

        Log.i(TAG,"onCreate");
        mCreate++;
        mostrarContadores();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
        mStart++;
        mostrarContadores();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
        mResume++;
        mostrarContadores();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
        mPause++;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
        mStop++;
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
        mRestart++;
        mostrarContadores();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // TODO Guardar estado actual antes de recreacion

        super.onSaveInstanceState(savedInstanceState);
    }

    // Actualizar IU con valor de contadores (estado Activity)
    public void mostrarContadores() {
        mTvCreate.setText("onCreate(): " + mCreate);
        mTvStart.setText("onStart(): " + mStart);
        mTvResume.setText("onResume(): " + mResume);
        mTvRestart.setText("onRestart(): " + mRestart);
        mTvPause.setText("onPause(): " + mPause);
        mTvStop.setText("onStop(): " + mStop);
    }
}