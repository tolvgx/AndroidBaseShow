//package com.tolvgx.show.surface;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.PorterDuff;
//import android.graphics.PorterDuffXfermode;
//import android.graphics.Rect;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <pre>
// *     author: Tolvgx
// *     date  : 2019/5/5
// *     email : tolvgx@163.com
// *     github: https://github.com/tolvgx
// * </pre>
// */
//public class FrameSurfaceView extends BaseSurfaceView {
//
//    public static final int INVALID_BITMAP_INDEX = Integer.MAX_VALUE;
//    private List<Integer> bitmaps = new ArrayList<>();
//    private Bitmap frameBitmap;
//    private int bitmapIndex = INVALID_BITMAP_INDEX;
//    private Paint paint = new Paint();
//    private BitmapFactory.Options options;
//    private Rect srcRect;
//    private Rect dstRect = new Rect();
//
//    private int defaultWidth;
//    private int defaultHeight;
//
//    public void setDuration(int duration) {
//        int frameDuration = duration / bitmaps.size();
//        setFrameDuration(frameDuration);
//    }
//
//    public void setBitmaps(List<Integer> bitmaps) {
//        if (bitmaps == null || bitmaps.size() == 0) {
//            return;
//        }
//        this.bitmaps = bitmaps;
//        getBitmapDimension(bitmaps.get(0));
//    }
//
//    private void getBitmapDimension(Integer integer) {
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(this.getResources(), integer, options);
//        defaultWidth = options.outWidth;
//        defaultHeight = options.outHeight;
//        srcRect = new Rect(0, 0, defaultWidth, defaultHeight);
//    }
//
//    public FrameSurfaceView(Context context) {
//        super(context);
//    }
//
//    @Override
//    protected void init() {
//        super.init();
//        //定义解析Bitmap参数为可变类型，这样才能复用Bitmap
//        options = new BitmapFactory.Options();
//        options.inMutable = true;
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//        dstRect.set(0, 0, getWidth(), getHeight());
//    }
//
//    protected int getDefaultWidth() {
//        return defaultWidth;
//    }
//
//    protected int getDefaultHeight() {
//        return defaultHeight;
//    }
//
//    @Override
//    protected void onFrameDrawFinish() {
//        //每帧绘制完毕后不再回收
////        recycle();
//    }
//
//    public void recycle() {
//        if (frameBitmap != null) {
//            frameBitmap.recycle();
//            frameBitmap = null;
//        }
//    }
//
//    @Override
//    protected void onFrameDraw(Canvas canvas) {
//        clearCanvas(canvas);
//        if (!isStart()) {
//            return;
//        }
//        if (!isFinish()) {
//            drawOneFrame(canvas);
//        } else {
//            onFrameAnimationEnd();
//        }
//    }
//
//    private void drawOneFrame(Canvas canvas) {
//        frameBitmap = BitmapUtil.decodeOriginBitmap(getResources(),
//                //复用上一帧Bitmap的内存
//                bitmaps.get(bitmapIndex), options);
//        options.inBitmap = frameBitmap;
//        canvas.drawBitmap(frameBitmap, srcRect, dstRect, paint);
//        bitmapIndex++;
//    }
//
//    private void onFrameAnimationEnd() {
//        reset();
//    }
//
//    private void reset() {
//        bitmapIndex = INVALID_BITMAP_INDEX;
//    }
//
//    private boolean isFinish() {
//        return bitmapIndex >= bitmaps.size();
//    }
//
//    private boolean isStart() {
//        return bitmapIndex != INVALID_BITMAP_INDEX;
//    }
//
//    public void start() {
//        bitmapIndex = 0;
//    }
//
//    private void clearCanvas(Canvas canvas) {
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        canvas.drawPaint(paint);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
//    }
//}
