package it.filieri.app.dto;

import android.graphics.Typeface;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Feeds {
    private String field1;

    private String created_at;

    private String field3;

    private String entry_id;

    private String field2;

    private String field4;

    public String getField1 ()
    {
        return field1;
    }

    public void setField1 (String field1)
    {
        this.field1 = field1;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getField3 ()
    {
        return field3;
    }

    public void setField3 (String field3)
    {
        this.field3 = field3;
    }

    public String getEntry_id ()
    {
        return entry_id;
    }

    public void setEntry_id (String entry_id)
    {
        this.entry_id = entry_id;
    }

    public String getField2 ()
    {
        return field2;
    }

    public void setField2 (String field2)
    {
        this.field2 = field2;
    }

    public String getField4 ()
    {
        return field4;
    }

    public void setField4 (String field4)
    {
        this.field4 = field4;
    }

    private void convertData(String dateString) throws Exception {
        Date date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS'Z'");
        date = format.parse(dateString);
        format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        created_at = format.format(date);
    }

    @Override
    public String toString()
    {
        try{
            convertData(created_at);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PM10: "+field1+"\n\nPM2.5: "+field2+"\n\nTemp: "+field3+"\n\nUmidità: "+field4+"\n\nData rilevazione: "+created_at;
    }
}
