package com.gmissio.provisionamentotriway.diologs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.gmissio.provisionamentotriway.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DiologProvisionamentoTelefonia extends AppCompatDialogFragment {

    private DiologProvisionamentoListener listener;
    private EditText editTextIp;
    private EditText editTextMask;
    private EditText editTextGateway;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_diolog_telefonia, null);

        editTextIp = view.findViewById(R.id.edit_ip);
        editTextMask = view.findViewById(R.id.edit_mask);
        editTextGateway = view.findViewById(R.id.edit_gateway);

        builder.setView(view)
                .setTitle("INFORMAÇÕES IPoE")
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ip = editTextIp.getText().toString();
                        String mask = editTextMask.getText().toString();
                        String gateway = editTextGateway.getText().toString();
                        Boolean option = true;
                        listener.aplicarTexts(option, ip, mask, gateway);
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (DiologProvisionamentoListener) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public interface DiologProvisionamentoListener {
        void aplicarTexts(Boolean option, String ip, String mask, String gateway);
    }
}
