package com.divyesh.medanon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CreateFragment extends Fragment {

    private static final String TAG = "CreateFragment";
    private static final int REQUEST_CODE_SELECT_MEDIA = 1001;

    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button buttonSelectMedia;
    private Button buttonPost;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create, container, false);

        // Initialize views
        editTextTitle = root.findViewById(R.id.editTextTitle);
        editTextDescription = root.findViewById(R.id.editTextDescription);
        buttonSelectMedia = root.findViewById(R.id.buttonSelectMedia);
        buttonPost = root.findViewById(R.id.buttonPost);

        // Handle button click events
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Post button clicked");

                // Validate input fields (optional)
                String title = editTextTitle.getText().toString().trim();
                String description = editTextDescription.getText().toString().trim();

                if (title.isEmpty() || description.isEmpty()) {
                    Log.d(TAG, "Title or description is empty");
                    Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Post the message (for now, just display a toast message)
                Log.d(TAG, "Message posted: " + title + ", " + description);
                Toast.makeText(getContext(), "Message posted", Toast.LENGTH_SHORT).show();

                // Reset input fields
                editTextTitle.setText("");
                editTextDescription.setText("");
            }
        });

        buttonSelectMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        return root;
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/* video/*"); // Allow both images and videos to be selected
        startActivityForResult(intent, REQUEST_CODE_SELECT_MEDIA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SELECT_MEDIA && resultCode == Activity.RESULT_OK && data != null) {
            List<Uri> selectedMediaUris = new ArrayList<>();

            // Handle selected media files
            Uri selectedMediaUri = data.getData();
            selectedMediaUris.add(selectedMediaUri);

            // Handle the selected media files (e.g., display, upload, etc.)
            Log.d(TAG, "Selected media file: " + selectedMediaUri);
            Toast.makeText(getContext(), "Selected media file: " + selectedMediaUri, Toast.LENGTH_SHORT).show();
        }
    }
}








