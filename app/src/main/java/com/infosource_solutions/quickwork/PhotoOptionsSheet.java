package com.infosource_solutions.quickwork;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class PhotoOptionsSheet extends BottomSheetDialogFragment {

    private BottomSheetListener mListner;

    private ImageButton cameraBtn, galleryBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.reg_photo_options, container, false);

        cameraBtn = v.findViewById(R.id.camera_btn);
        galleryBtn = v.findViewById(R.id.gallery_btn);

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                mListner.onButtonClicked(0);
            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                mListner.onButtonClicked(1);
            }
        });

        return v;
    }

    public interface BottomSheetListener {
        void onButtonClicked(int button);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListner = (BottomSheetListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement BottomSheetListener");
        }
    }
}
