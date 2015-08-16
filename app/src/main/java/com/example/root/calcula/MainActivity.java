package com.example.root.calcula;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.MathContext;

public class MainActivity extends AppCompatActivity {


    private EditText _edit;
    private Button _b1;
    private Button _b2;
    private Button _b3;
    private Button _b4;
    private Button _b5;
    private Button _b6;
    private Button _b7;
    private Button _b8;
    private Button _b9;
    private Button _b0;
    private Button _bMas;
    private Button _bMenos;
    private Button _bMultiplicar;
    private Button _bDividir;
    private Button _bIgual;
    private Button _bC,_bcos,_btan,_bsen,_braizc,_bexpo,_bloga;


    private double _valor;
    private int _operacion;

    private boolean _nuevoValor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        _valor = 0;

        _edit = (EditText)findViewById(R.id.editTextos);
        _b0 = (Button)findViewById(R.id.button0);
        _b1 = (Button)findViewById(R.id.button1);
        _b2 = (Button)findViewById(R.id.button2);
        _b3 = (Button)findViewById(R.id.button3);
        _b4 = (Button)findViewById(R.id.button4);
        _b5 = (Button)findViewById(R.id.button5);
        _b6 = (Button)findViewById(R.id.button6);
        _b7 = (Button)findViewById(R.id.button7);
        _b8 = (Button)findViewById(R.id.button8);
        _b9 = (Button)findViewById(R.id.button9);
        _bMas = (Button)findViewById(R.id.buttonMas);
        _bMenos = (Button)findViewById(R.id.buttonResta);
        _bMultiplicar = (Button)findViewById(R.id.buttonMultiplicar);
        _bDividir = (Button)findViewById(R.id.buttonDividir);
        _bIgual = (Button)findViewById(R.id.buttonIgual);
        _bC = (Button)findViewById(R.id.buttonC);
        _bcos=(Button)findViewById(R.id.buttoncos);
        _btan=(Button)findViewById(R.id.buttontan);
        _bsen=(Button)findViewById(R.id.buttonsen);
        _braizc=(Button)findViewById(R.id.buttonraizc);
        _bexpo=(Button)findViewById(R.id.buttonexpo);
        _bloga=(Button)findViewById(R.id.buttonlog);
        _edit.setText("0");

        View.OnClickListener lsBoton = new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                _edit.setTextColor(Color.GREEN);
                cambiaValor();
                _edit.setText(_edit.getText()+((Button)arg0).getText().toString());
            }
        };

        View.OnClickListener lsBotonOperacion = new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                opera();
                _operacion = 0;
                _nuevoValor = true;
                String text = ((Button)arg0).getText().toString();
                if (text.equals("+")) _operacion = 0;
                if (text.equals("-")) _operacion = 1;
                if (text.equals("*")) _operacion = 2;
                if (text.equals("/")) _operacion = 3;
                if (text.equals("=")) _operacion = -1;
                if(text.equals("Cos")) _operacion= 4;
                if(text.equals("Tan")) _operacion= 5;
                if(text.equals("Sen")) _operacion= 6;
                if(text.equals("√²"))_operacion= 7;
                if(text.equals("F. Exponencial"))_operacion= 8;
                if(text.equals("FF. Logarítmica"))_operacion= 9;
            }
        };

        _b1.setOnClickListener(lsBoton);
        _b2.setOnClickListener(lsBoton);
        _b3.setOnClickListener(lsBoton);
        _b4.setOnClickListener(lsBoton);
        _b5.setOnClickListener(lsBoton);
        _b6.setOnClickListener(lsBoton);
        _b7.setOnClickListener(lsBoton);
        _b8.setOnClickListener(lsBoton);
        _b9.setOnClickListener(lsBoton);
        _b0.setOnClickListener(lsBoton);

        _bMas.setOnClickListener(lsBotonOperacion);
        _bMenos.setOnClickListener(lsBotonOperacion);
        _bMultiplicar.setOnClickListener(lsBotonOperacion);
        _bDividir.setOnClickListener(lsBotonOperacion);
        _bIgual.setOnClickListener(lsBotonOperacion);
        _bcos.setOnClickListener(lsBotonOperacion);
        _btan.setOnClickListener(lsBotonOperacion);
        _bsen.setOnClickListener(lsBotonOperacion);
        _braizc.setOnClickListener(lsBotonOperacion);
        _bloga.setOnClickListener(lsBotonOperacion);
        _bexpo.setOnClickListener(lsBotonOperacion);

        _bC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                _edit.setText("0");
                _nuevoValor = true;
                _operacion = -1;
            }
        });

    }

    private void cambiaValor()
    {
        if (_nuevoValor == true)
        {
            _edit.setText("");
            _nuevoValor = false;
        }
    }

    private void opera()
    {
        switch (_operacion)
        {
            case -1:
                _valor = Double.parseDouble(_edit.getText().toString());
                break;
            case 0:	// suma
                try
                {
                    _valor = _valor + Double.parseDouble(_edit.getText().toString());
                    _edit.setText(String.valueOf(_valor));
                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("NO PUEDE EJECUTAR ESTA OPERACION");

                }
                break;

            case 1:	// resta
                try
                {
                    _valor = _valor - Double.parseDouble(_edit.getText().toString());
                    _edit.setText(String.valueOf(_valor));
                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("NO PUEDE EJECUTAR ESTA OPERACION");

                }
                break;
            case 2:	// multiplicar
                try
                {
                    _valor = _valor * Double.parseDouble(_edit.getText().toString());
                    _edit.setText(String.valueOf(_valor));
                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("NO PUEDE EJECUTAR ESTA OPERACION");

                }
                break;

            case 3:	// dividir
                try
                {
                    _valor = _valor / Double.parseDouble(_edit.getText().toString());
                    _edit.setText(String.valueOf(_valor));
                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("NO PUEDE EJECUTAR ESTA OPERACION");
                }
            case 4: //
                try {
                    _valor=Double.parseDouble((_edit.getText().toString()))*Math.PI/180;
                    _valor=Math.cos(_valor);
                    _edit.setText(String.valueOf(_valor));

                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("Err");
                }
            case 5: //
                try {
                    _valor=Double.parseDouble((_edit.getText().toString()))*Math.PI/180;
                    _valor=Math.tan(_valor);
                    _edit.setText(String.valueOf(_valor));

                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("Err");
                }
            case 6: //
                try {
                    _valor=Double.parseDouble((_edit.getText().toString()))*Math.PI/180;
                    _valor=Math.sin(_valor);
                    _edit.setText(String.valueOf(_valor));

                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("Err");
                }
            case 7: //
                try {
                    _valor=Double.parseDouble((_edit.getText().toString()));
                    _valor=Math.sqrt(_valor);
                    _edit.setText(String.valueOf(_valor));

                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("Err");
                }
            case 8: //
                try {
                    _valor=Double.parseDouble((_edit.getText().toString()));
                    _valor=Math.exp(_valor);
                    _edit.setText(String.valueOf(_valor));

                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("Err");
                }
            case 9: //
                try {
                    _valor=Double.parseDouble((_edit.getText().toString()));
                    _valor=Math.log(_valor);
                    _edit.setText(String.valueOf(_valor));

                }
                catch (Exception e)
                {
                    _edit.setTextColor(Color.RED);
                    _edit.setText("Err");
                }
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
