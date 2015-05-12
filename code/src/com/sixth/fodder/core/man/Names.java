/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.man;

import java.util.Random;

/**
 *
 * @author sixth
 */
public class Names {
    private static final Random random = new Random();
    private static final String [] maleNames = 
    {
        "Baldur",
        "Freyr",
        "Bragi",
        "Heimdal",
        "Thor",
        "Áli",
        "Ullr",
        "Forseti",
        "Þor",
        "Ullr",
        "Forseti",
        "Ygg",
        "Yngvi-Freyr",
        "Zombie",
        "Forsseih",
        "Odin",
        "Loki",
        "Sean",
        "Adol'f",
        "Max"
    };
    private static final String [] femaleNames =
    {
        "Eir",
        "Gefjon",
        "Fulla",
        "Hlín",
        "Snotra",
        "Bil",
        "Frigg",
        "Freyja",
        "Gefjon",
        "Gerd",
        "Sigyn",
        "Nanna",
        "Lofn",
        "Ilm",
        "Hnoss",
        "Rind",
        "Sol",
        "Sigyn",
        "Syn",
        "Lola"
    };
    private static final String surnames [] =
    {
        "Perri",
        "Moore",
        "Brooks",
        "Ryan",
        "Wilde",
        "King",
        "Michael",
        "Goldberg",
        "Hogan",
        "Crawford",
        "Douglas",
        "Donught",
        "Electra",
        "Capote",
        "Child",
        "Sheen",
        "Mars",
        "Mirren",
        "Twen",
        "Moore"
    };

    public static String getFemaleName() {
        return femaleNames[random.nextInt(femaleNames.length)];
    }
    
    public static String getSurname(){
        return surnames[random.nextInt(surnames.length)];
    }

    public static String getMaleName() {
        return maleNames[random.nextInt(maleNames.length)];
    }
}
