package camdev.sokra.customalertdialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonShowCustomDialog);
        // add button listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // custom dialog
                showCustomDialog();

            }
        });

    }

    private void showCustomDialog() {
        LayoutInflater factory = LayoutInflater.from(this);
        final View updateDialogView = factory.inflate(R.layout.custom, null);
        final AlertDialog updateDialog = new AlertDialog.Builder(this).create();
        updateDialog.setView(updateDialogView);

        Button btnUpdate = updateDialogView.findViewById(R.id.dialogButtonOK);
        final EditText txtName = updateDialogView.findViewById(R.id.txtName);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //your business logic
                String getName = txtName.getText().toString();
                updateDialog.dismiss();
                updateData(getName);
            }
        });
        updateDialog.show();
    }

    private void updateData(String name){
        Toast.makeText(context, ""+name, Toast.LENGTH_SHORT).show();
    }
}
