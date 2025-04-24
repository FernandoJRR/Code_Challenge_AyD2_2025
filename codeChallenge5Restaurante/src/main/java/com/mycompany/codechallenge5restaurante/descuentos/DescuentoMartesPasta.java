package com.mycompany.codechallenge5restaurante.descuentos;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DescuentoMartesPasta implements DescuentoStrategy{
    public double aplicarDescuento(double total) {
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.TUESDAY) {
            return total * 0.85;
        }
        return total;
    }
}
