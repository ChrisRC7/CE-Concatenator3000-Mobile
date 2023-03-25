package com.ceconcatenator3000;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ceconcatenator3000.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'ceconcatenator3000' library on application startup.
    static {
        System.loadLibrary("ceconcatenator3000");
    }

    private EditText editText1;
    private EditText editText2;
    private TextView textViewResult;
    private Button buttonConcatenate;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editText1= findViewById(R.id.editText1);
        editText2= findViewById(R.id.editText2);
        textViewResult= findViewById(R.id.textResult);
        buttonConcatenate= findViewById(R.id.button);

        // Example of a call to a native method
        /*TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());*/

        buttonConcatenate.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view) {
                String palabra1 = editText1.getText().toString();
                String palabra2 = editText2.getText().toString();

                String resultado = stringFromJNI(palabra1, palabra2);

                //Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_SHORT).show();
                textViewResult.setText(resultado);
            }
        });
    }

    /**
     * A native method that is implemented by the 'ceconcatenator3000' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(String palabra1, String palabra2);
}