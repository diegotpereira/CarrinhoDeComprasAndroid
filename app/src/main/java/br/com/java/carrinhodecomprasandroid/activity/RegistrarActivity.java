package br.com.java.carrinhodecomprasandroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import br.com.java.carrinhodecomprasandroid.R;
import br.com.java.carrinhodecomprasandroid.fragment.CadastrarFragmento;
import br.com.java.carrinhodecomprasandroid.fragment.EntrarFragmento;

public class RegistrarActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    public static boolean setCadastrarFragmento = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        frameLayout=findViewById(R.id.registrar_framelayout);


        //it's for make always stable this activity in portrait mode
        if(RegistrarActivity.this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            RegistrarActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        }
        if(setCadastrarFragmento){
            setCadastrarFragmento=false;
            setDefaultfragment(new CadastrarFragmento());
        }
        else {
            setDefaultfragment(new EntrarFragmento());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            CadastrarFragmento.desabilitarFecharBtn=false;
            CadastrarFragmento.desabilitarFecharBtn=false;
//            if(onResetPasswordFragment){
//                onResetPasswordFragment=false;
//                setFragment(new SigninFragment());
//                return false;
//            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void setDefaultfragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}