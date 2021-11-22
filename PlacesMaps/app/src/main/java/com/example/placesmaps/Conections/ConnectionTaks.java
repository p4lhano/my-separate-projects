package com.example.placesmaps.Conections;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class  ConnectionTaks extends AsyncTask<String,Integer,String> {
    private onRequestListener listener;

    public ConnectionTaks(onRequestListener listener){ this.listener = listener; }

    //  AsyncTask<{Paramento que vai ser recebido pela task},{Parametro que será sincronizado com o usuario (publishProgres()) Atualização para o user sobre o andamente da task assincrona},{Parametro que vai ser retornado a task principal}>
    @Override
    protected String doInBackground(String... strings) {
        String urlString = strings[0];
        URL url = null;
        Log.v("CONEXÃO", "Solicitando: " + strings[0]);
        try {
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                return IOUtils.toString(inputStream,"UTF-8");
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            Log.v("CONEXÃO","Resposta : "+s);
            JSONObject jsonObject = new JSONObject(s);
            listener.onRequestFinish( jsonObject );

            //atualização da tela
            //recycleViewPokeList.getAdapter().notifyDataSetChanged();
        } catch (Exception e) {
            Log.v("CONEXÃO","Não possivel iniciar. Erro: ",e);
            listener.onRequestFinish(null);
        }
    }

    public interface onRequestListener {
        void onRequestFinish(JSONObject resultObject);
    }
}
