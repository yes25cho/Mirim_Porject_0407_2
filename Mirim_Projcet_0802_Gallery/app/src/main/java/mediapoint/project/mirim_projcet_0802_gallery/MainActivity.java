package mediapoint.project.mirim_projcet_0802_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.GatheringByteChannel;

public class MainActivity extends AppCompatActivity {
    int[] posterId = {R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,
            R.drawable.img08,R.drawable.img09,R.drawable.img10};
    String[] posterName = {"호텔델루나", "뷰티인사이드", "도깨비", "맬로가체질",
            "사랑의 불시착", "사이코지만 괜찮아", "스물다섯스물하나",
            "슬기로운 의사생활", "유미의 세포들", "이상한 변호사 우영우"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gallery gallery = findViewById(R.id.gallery);
        GalleryAdapter adapter = new GalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class GalleryAdapter extends BaseAdapter{
        Context context;
        public GalleryAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            Gallery.LayoutParams params = new Gallery.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView largeImgv = findViewById(R.id.imgv);
                    largeImgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    largeImgv.setImageResource(posterId[pos]);
                    Toast t = new Toast(context);
                    View toastView = View.inflate(context, R.layout.toast_layout,null);
                    TextView textTitle = toastView.findViewById(R.id.taxt_title);
                    textTitle.setText(posterName[pos]);
                    t.setView(toastView);
                    t.setDuration(Toast.LENGTH_SHORT);
                    t.show();
                    return false;
                }
            });
            return imgv;
        }
    }
}