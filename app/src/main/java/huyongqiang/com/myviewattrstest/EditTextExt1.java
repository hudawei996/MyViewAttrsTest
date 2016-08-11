package huyongqiang.com.myviewattrstest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by huyongqiang on 16/8/11.
 */
public class EditTextExt1 extends LinearLayout {

    private String Text = "";

    public EditTextExt1(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    public EditTextExt1(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        int resouceId = -1;

        TextView tv = new TextView(context);
        EditText et = new EditText(context);

        resouceId = attrs.getAttributeResourceValue(null, "Text", 0);
        if (resouceId > 0) {
            Text = context.getResources().getText(resouceId).toString();
        } else {
            Text = "";
        }
        tv.setText(Text);

        addView(tv);
        addView(et, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        this.setGravity(LinearLayout.VERTICAL);
    }

}