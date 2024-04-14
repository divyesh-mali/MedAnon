package com.divyesh.medanon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FeedbackFragment extends Fragment {

    private EditText feedbackEditText;
    private Button sendButton;

    public FeedbackFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        // Initialize views
        feedbackEditText = view.findViewById(R.id.feedbackEditText);
        sendButton = view.findViewById(R.id.sendButton);

        // Set click listener for the send button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedback();
            }
        });

        return view;
    }

    private void sendFeedback() {
        // Get the feedback text from the EditText
        String feedbackText = feedbackEditText.getText().toString().trim();

        // Check if feedback is empty
        if (feedbackText.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter your feedback", Toast.LENGTH_SHORT).show();
            return;
        }

        // Here you can implement code to send the feedback to your database or server
        // For now, let's just display a toast message indicating that feedback has been sent
        Toast.makeText(getActivity(), "Feedback sent ", Toast.LENGTH_SHORT).show();

        // Clear the EditText after sending feedback
        feedbackEditText.setText("");
    }
}

