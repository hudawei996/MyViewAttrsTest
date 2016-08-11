package huyongqiang.com.myviewattrstest;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by huyongqiang on 16/8/11.
 */
public class EditTextExt extends LinearLayout {

    public EditTextExt(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    public EditTextExt(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        int resouceId = -1;
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.EditTextExt);

        TextView tv = new TextView(context);
        EditText et = new EditText(context);

        int N = typeArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = typeArray.getIndex(i);
            switch (attr) {
                case R.styleable.EditTextExt_Oriental:
                    resouceId = typeArray.getInt(R.styleable.EditTextExt_Oriental, 0);
                    this.setOrientation(resouceId == 1 ? LinearLayout.HORIZONTAL : LinearLayout.VERTICAL);
                    break;
                case R.styleable.EditTextExt_Text:
                    resouceId = typeArray.getResourceId(R.styleable.EditTextExt_Text, 0);
                    tv.setText(resouceId > 0 ? typeArray.getResources().getText(resouceId) : typeArray.getString(R.styleable.EditTextExt_Text));
                    break;
            }
        }
        addView(tv);
        addView(et);
        typeArray.recycle();

    }

}