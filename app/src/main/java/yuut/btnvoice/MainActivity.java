package yuut.btnvoice;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button shengyin;
    private Button liandu;
    private Button chongshuo;
    private Button bianwei;
    private Button suohe;

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shengyin = (Button) findViewById(R.id.shengyin);
        liandu = (Button) findViewById(R.id.liandu);
        chongshuo = (Button) findViewById(R.id.chongshuo);
        bianwei = (Button) findViewById(R.id.bianwei);
        suohe = (Button) findViewById(R.id.suohe);

        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.shengyin);

        MyListener listener = new MyListener();
        shengyin.setOnClickListener(listener);
        liandu.setOnClickListener(listener);
        chongshuo.setOnClickListener(listener);
        bianwei.setOnClickListener(listener);
        suohe.setOnClickListener(listener);

    }
    class MyListener implements View.OnClickListener{
        public void onClick(View view){
            switch (view.getId()){
                case R.id.shengyin:
                    play("shengyin");
                    break;
                case R.id.liandu:
                    play("liandu");
                    break;
                case R.id.chongshuo:
                    play("chongshuo");
                    break;
                case R.id.bianwei:
                    play("bianwei");
                    break;
                default:
                    play("suohe");
                    break;
            }
        }
    }

    private void play(String name){
        try {
            if (mediaPlayer.isPlaying()){
                mediaPlayer.reset();
            }
            //Toast.makeText(MainActivity.this,name, Toast.LENGTH_LONG).show();
            switch (name){
                case "shengyin":
                    mediaPlayer=MediaPlayer.create(this, R.raw.shengyin);
                    break;
                case "liandu":
                    mediaPlayer=MediaPlayer.create(this, R.raw.liandu);
                    break;
                case "bianwei":
                    mediaPlayer=MediaPlayer.create(this, R.raw.bianwei);
                    break;
                case "suohe":
                    mediaPlayer=MediaPlayer.create(this, R.raw.suohe);
                    break;
                default:
                    mediaPlayer=MediaPlayer.create(this, R.raw.chongshuo);
                    break;
            }
            mediaPlayer.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
    protected void onDestroy() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.release();//释放资源
        super.onDestroy();
    }
}
