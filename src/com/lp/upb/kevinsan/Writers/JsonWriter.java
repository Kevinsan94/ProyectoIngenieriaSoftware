package com.lp.upb.kevinsan.Writers;

import com.lp.upb.kevinsan.Beans.Persona;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {

    private static JsonWriter jsw;

    public static JsonWriter get(){
        if (jsw == null){
            jsw = new JsonWriter();
        }
        return jsw;
    }

    public void write(Persona p) throws IOException {
        JSONObject obj = new JSONObject();

        obj.put("nombre", p.nombre);
        obj.put("apellido", p.apellido);
        obj.put("direccion", p.direccion);
        obj.put("edad", p.edad);

        FileWriter file = new FileWriter("test.json");

        try {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.flush();
            file.close();
        }

        System.out.println("Archivo Json guardado correctamente...");
    }
}
