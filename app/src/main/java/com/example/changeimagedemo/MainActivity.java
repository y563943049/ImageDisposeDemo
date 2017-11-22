package com.example.changeimagedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    private float dx = 0;

    private int degress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
    }

    public void turnBig(View view) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.leimur);
        Matrix matrix = new Matrix();
        matrix.setScale(2, 2);
        //买一张纸
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth() * 2, bitmap.getHeight() * 2, bitmap.getConfig());
        //买一个画板
        Canvas canvas = new Canvas(newBitmap);
        //绘画
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bitmap, matrix, paint);
        iv.setImageBitmap(newBitmap);
    }

    public void turnSmall(View view) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.leimur);
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        //买一张纸
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getConfig());
        //买一个画板
        Canvas canvas = new Canvas(newBitmap);
        //绘画
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bitmap, matrix, paint);
        iv.setImageBitmap(newBitmap);
    }
    public void turnLeft(View view) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.leimur);
        Matrix matrix = new Matrix();
        dx--;
        matrix.setTranslate(dx,0);
        //买一张纸
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //买一个画板
        Canvas canvas = new Canvas(newBitmap);
        //绘画
        Paint paint = new Paint();
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bitmap, matrix, paint);
        iv.setImageBitmap(newBitmap);
    }
    public void turnRight(View view) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.leimur);
        Matrix matrix = new Matrix();
        dx++;
        matrix.setTranslate(dx,0);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bitmap,matrix,paint);
        iv.setImageBitmap(newBitmap);
    }
    public void turnCircleLeft(View view){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.leimur);
        Matrix matrix = new Matrix();
        matrix.setRotate(--degress,bitmap.getWidth(),bitmap.getHeight());
        matrix.postTranslate(100,100);

        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth() * 2,bitmap.getHeight() * 2,bitmap.getConfig());

        Canvas canvas = new Canvas(newBitmap);

        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap,matrix,paint);
        iv.setImageBitmap(newBitmap);
    }

    public void turnCircleRight(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.leimur);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(++degress, bitmap.getWidth(), bitmap.getHeight());
                    matrix.postTranslate(20, 20);

                    final Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

                    Canvas canvas = new Canvas(newBitmap);

                    canvas.drawColor(Color.WHITE);
                    Paint paint = new Paint();
                    paint.setColor(Color.WHITE);
                    paint.setAntiAlias(true);
                    canvas.drawBitmap(bitmap, matrix, paint);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(newBitmap);
                        }
                    });
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
