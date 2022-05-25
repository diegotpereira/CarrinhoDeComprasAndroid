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

public class RegistrarActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    public static boolean setCadastrarFragmento = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        frameLayout=findViewById(R.id.registrar_framelayout);

        setDefaultfragment(new CadastrarFragmento());
        //it's for make always stable this activity in portrait mode
//        if(RegistrarActivity.this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
//            RegistrarActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
//        }
//        if(setCadastrarFragmento){
//            setCadastrarFragmento=false;
//            setDefaultfragment(new CadastrarFragmento());
//        }
//        else {
//            setDefaultfragment(new SigninFragment());
//        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            CadastrarFragmento.disableCloseBtn=false;
            CadastrarFragmento.disableCloseBtn=false;
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