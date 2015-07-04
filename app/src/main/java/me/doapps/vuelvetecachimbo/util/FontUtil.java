package me.doapps.vuelvetecachimbo.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by doapps on 7/4/15.
 */
public class FontUtil {

    public static Typeface setPacifico(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/varsity_regular.ttf");
    }


}
