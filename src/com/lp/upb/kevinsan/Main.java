package com.lp.upb.kevinsan;

import com.lp.upb.kevinsan.Beans.Persona;
import com.lp.upb.kevinsan.Writers.JsonWriter;
import com.lp.upb.kevinsan.Writers.XmlWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Persona p = new Persona("Kevin","Viscafe","23","Irpavi");

        JsonWriter.get().write(p);
        XmlWriter.get().write(p);
    }
}
