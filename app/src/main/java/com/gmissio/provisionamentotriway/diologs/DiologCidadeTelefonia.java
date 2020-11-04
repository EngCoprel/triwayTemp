package com.gmissio.provisionamentotriway.diologs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DiologCidadeTelefonia extends AppCompatDialogFragment {

    public int vlan = 160;
    private TesteDiologListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle("CIDADE");
        // add a radio button list
        String[] animals = {"ARROIO GRANDE","BOA VISTA DO INCRA","CAMPOS BORGES","CARAZINHO","CONDOR","COTOVELO","CRUZ ALTA","ERNESTINA","ESPUMOSO","FORTALEZA DOS VALOS","GENTIL","IBIRUBA","MARAU","MATO CASTELHANO","NICOLAU VERGUEIRO","NAO ME TOQUE","PANAMBI","PASSO FUNDO","PEJUCARA","PONTAO","SANTA BARBARA DO SUL","SELBACH","TAPEJARA","TAPERA","TIO HUGO","VICTOR GRAEFF","XV DE NOVEMBRO","LAGOA DOS TRES CANTOS"};
        final int checkedItem = 0; // boa vista
        builder.setSingleChoiceItems(animals, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        //arroio grande
                        vlan = 240;
                        break;
                    case 1:
                        //boa vista
                        vlan = 283;
                        break;
                    case 2:
                        //campos borges
                        vlan = 292;
                        break;
                    case 3:
                        //carazinho
                        vlan = 265;
                        break;
                    case 4:
                        //condor
                        vlan = 271;
                        break;
                    case 5:
                        //cotovelo
                        vlan = 275;
                        break;
                    case 6:
                        //cruz alta
                        vlan = 241;
                        break;
                    case 7:
                        //ernestina
                        vlan = 259;
                        break;
                    case 8:
                        //espumoso
                        vlan = 277;
                        break;
                    case 9:
                        //fortaleza
                        vlan = 196;
                        break;
                    case 10:
                        //gentil
                        vlan = 218;
                        break;
                    case 11:
                        //ibiruba
                        vlan = 240;
                        break;
                    case 12:
                        //marau
                        vlan = 286;
                        break;
                    case 13:
                        //mato castelhano
                        vlan = 289;
                        break;
                    case 14:
                        //nicolau vergueiro
                        vlan = 222;
                        break;
                    case 15:
                        //nao me toque
                        vlan = 256;
                        break;
                    case 16:
                        //panambi
                        vlan = 244;
                        break;
                    case 17:
                        //passo fundo
                        vlan = 201;
                        break;
                    case 18:
                        //pejucara
                        vlan = 295;
                        break;
                    case 19:
                        //pontao
                        vlan = 280;
                        break;
                    case 20:
                        //santa barbara do sul
                        vlan = 247;
                        break;
                    case 21:
                        //selbach
                        vlan = 250;
                        break;
                    case 22:
                        //tapejara
                        vlan = 208;
                        break;
                    case 23:
                        //tapera
                        vlan = 253;
                        break;
                    case 24:
                        //tio hugo
                        vlan = 204;
                        break;
                    case 25:
                        //victor graeff
                        vlan = 262;
                        break;
                    case 26:
                        //xv de novembro
                        vlan = 268;
                        break;
                    case 27:
                        //lagoa
                        vlan = 100;
                        break;
                }
            }
        });

// add OK and Cancel buttons
        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.aplicarCidade(vlan);
            }
        });
        builder.setNegativeButton("CANCELAR", null);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (TesteDiologListener) context;

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  interface TesteDiologListener{
        void aplicarCidade(int vlan);

    }


}