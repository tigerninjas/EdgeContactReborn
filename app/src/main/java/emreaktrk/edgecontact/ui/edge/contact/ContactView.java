package emreaktrk.edgecontact.ui.edge.contact;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.AttributeSet;
import android.view.View;

import com.scalified.fab.ActionButton;
import com.scalified.uitools.convert.DensityConverter;

public final class ContactView extends ActionButton implements View.OnClickListener {

    private OnClickListener mListener;
    private Contact mContact;


    public ContactView(Context context) {
        super(context);

        init();
    }

    public ContactView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public ContactView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();
    }

    private void init() {
        setOnClickListener(this);
    }

    public void setOnClickListener(OnClickListener listener) {
        mListener = listener;
    }

    @Override public void onClick(View view) {
        if (mListener == null) {
            return;
        }

        if (hasContact()) {
            mListener.onCallClicked(mContact, this);
        } else {
            mListener.onAddClicked(this);
        }
    }

    public void setContact(@Nullable Contact contact) {
        mContact = contact;
        update();
    }

    private void update() {
        if (hasContact()) {
            apply();
            return;
        }

        clear();
    }

    public boolean hasContact() {
        return mContact != null;
    }

    @WorkerThread
    private void clear() {
        // TODO Clear state
    }

    @SuppressLint("WrongThread")
    @WorkerThread private void apply() {
        final float size = DensityConverter.pxToDp(getContext(), getSize());

        final Drawable drawable = mContact.hasPhoto() ? mContact.roundedPhoto(getContext()) : mContact.letterDrawable();

        post(new Runnable() {
            @Override public void run() {
                setImageSize(size);
                setImageDrawable(drawable);
            }
        });
    }

    public interface OnClickListener {

        void onCallClicked(Contact contact, View view);

        void onAddClicked(View view);
    }
}