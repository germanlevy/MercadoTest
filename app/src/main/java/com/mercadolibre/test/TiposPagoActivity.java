package com.mercadolibre.test;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.TextHttpResponseHandler;
import com.mercadolibre.test.model.PaymentMethod;
import com.mercadolibre.test.model.PaymentMethodList;
import com.mercadolibre.test.model.PaymentType;
import com.mercadolibre.test.util.MercadoLibreAPIClient;
import com.mercadolibre.testmercadolibre.R;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Vector;

import cz.msebera.android.httpclient.Header;

public class TiposPagoActivity extends ActionBarActivity {

    ListView mMethodsList;
    ArrayAdapter mAdapter;
    List<PaymentMethod> mFilteredList;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_pago);
        mMethodsList = (ListView)findViewById(R.id.listView);
        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Se omite base_url, ya que se encuentra en MercadoLibreAPIClient
        getMediosDePago(null, getString(R.string.uri_medios_pago),
                getString(R.string.key_medios_pago));
        setLoading(true);
    }

    private void setLoading(boolean loading) {
        if(loading) {
            mMethodsList.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mMethodsList.setVisibility(View.VISIBLE);
        }
    }

    private void getMediosDePago(String base_url, String uri, String public_key) {
        String url = uri + public_key;

        TextHttpResponseHandler handler = new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                if (statusCode == 200) {
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<PaymentMethod>>(){}.getType();
                    try {
                        List<PaymentMethod> methods = (List<PaymentMethod>)gson.fromJson(response, listType);
                        initList(methods);
                    } catch (Exception e) {
                        showError(e.getMessage());
                    }
                } else {
                    showError(getString(R.string.connection_error));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                showError(throwable.getMessage());
            }
        };
        MercadoLibreAPIClient.get(url, null, handler);
    }

    private void initList(List<PaymentMethod> methods) {
        mFilteredList = new Vector<PaymentMethod>();
        for(PaymentMethod m : methods) {
            if(m.getPayment_type_id().equals(PaymentType.CC.id)) {
                mFilteredList.add(m);
            }
        }
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mFilteredList);
        mMethodsList.setAdapter(mAdapter);
        setLoading(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tipos_pago, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.about_text)
                    .setTitle(R.string.action_about);
            builder.create().show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showError(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(error).setTitle("Error");
        builder.create().show();
    }

}
