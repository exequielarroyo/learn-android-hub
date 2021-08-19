package com.example.group2sw5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ProfileActivity extends AppCompatActivity {
    ImageView profileImageView;
    TextView nameTextView, facebookLink, instagramLink;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProfileAdapter profileAdapter;
    String facebook, instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImageView = findViewById(R.id.profileImageView);
        nameTextView = findViewById(R.id.nameTextView);
        facebookLink = findViewById(R.id.facebookLink);
        instagramLink = findViewById(R.id.instagramLink);
        String name = getIntent().getStringExtra("name");
        switch (name) {
            case "Exequiel Arroyo":
                profileImageView.setImageResource(R.drawable.exe);
                nameTextView.setText("Exequiel Arroyo");
                facebookLink.setText("Exequiel");
                instagramLink.setText("@exequielarroyo1");
                facebook = "https://www.facebook.com/exequielarroyo2/";
                instagram = "https://www.instagram.com/exequielarroyo1/";
                break;
            case "Ella Jane Espiritu":
                profileImageView.setImageResource(R.drawable.ella);
                nameTextView.setText("Ella Jane Espiritu");
                facebookLink.setText("Ella Jane");
                instagramLink.setText("@espirituellajane");
                facebook = "https://www.facebook.com/ellajane.espiritu.7";
                instagram = "https://www.instagram.com/espirituellajane/";
                break;
            case "Mher Jazer Alabalate":
                profileImageView.setImageResource(R.drawable.jazer);
                nameTextView.setText("Mher Jazer Alabalate");
                facebookLink.setText("Mher Jazer");
                instagramLink.setText("@mr.albalate");
                facebook = "https://www.facebook.com/albalate.jazer/";
                instagram = "https://www.instagram.com/mr.albalate/";
                break;
            case "Jomar Apalat":
                profileImageView.setImageResource(R.drawable.jomar);
                nameTextView.setText("Jomar Apalat");
                facebookLink.setText("Jomar");
                instagramLink.setText("");
                facebook = "https://www.facebook.com/Luutherr/";
                instagram = "https://instagram.com";
                break;
            case "Michelle Arroyo":
                profileImageView.setImageResource(R.drawable.michelle);
                nameTextView.setText("Michelle Arroyo");
                facebookLink.setText("Michelle");
                instagramLink.setText("@michellepujjj");
                facebook = "https://www.facebook.com/michelle.arroyo.1800/";
                instagram = "https://www.instagram.com/michellepujjj/";
                break;
            case "Zyra Marie Ramos":
                profileImageView.setImageResource(R.drawable.zyra);
                nameTextView.setText("Zyra Marie Ramos");
                facebookLink.setText("Zyra");
                instagramLink.setText("@zyrarms");
                facebook = "https://www.facebook.com/zyrarms/";
                instagram = "https://www.instagram.com/zyrarms/";
                break;
        }

        recyclerView = findViewById(R.id.recyclerView3);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        String profileName = getIntent().getStringExtra("name");
        int images[] = new int[4];
        if (profileName.equals("Mher Jazer Alabalate")) {
            images[0] = R.drawable.jazer_3;
            images[1] = R.drawable.jazer_4;
            images[2] = R.drawable.jazer_5;
            images[3] = R.drawable.jazer_6;
        } else if (profileName.equals("Ella Jane Espiritu")) {
            images[0] = R.drawable.ella_2;
            images[1] = R.drawable.ella_3;
            images[2] = R.drawable.ella_4;
            images[3] = R.drawable.ella_5;
        } else if (profileName.equals("Jomar Apalat")) {
            images[0] = R.drawable.jomar_1;
            images[1] = R.drawable.jomar_2;
            images[2] = R.drawable.jomar_3;
            images[3] = R.drawable.jomar_4;
        } else if (profileName.equals("Michelle Arroyo")) {
            images[0] = R.drawable.michelle_2;
            images[1] = R.drawable.michelle_3;
            images[2] = R.drawable.michelle_4;
            images[3] = R.drawable.michelle_5;
        } else if (profileName.equals("Zyra Marie Ramos")) {
            images[0] = R.drawable.zyra_2;
            images[1] = R.drawable.zyra_3;
            images[2] = R.drawable.zyra_4;
            images[3] = R.drawable.zyra_5;
        } else if (profileName.equals("Exequiel Arroyo")) {
            images[0] = R.drawable.exe_2;
            images[1] = R.drawable.exe_3;
            images[2] = R.drawable.exe_1;
            images[3] = R.drawable.exe_5;
        }
        profileAdapter = new ProfileAdapter(images);
        recyclerView.setAdapter(profileAdapter);
        recyclerView.setHasFixedSize(true);

        findViewById(R.id.facebookLottieView).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebook));
                startActivity(intent);
                return true;
            }
        });
        findViewById(R.id.instagramLottieView).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagram));
                startActivity(intent);
                return true;
            }
        });
    }

    public void backClick(View view) {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private boolean isFacebook = false, isInstagram = false, isGmail = false;

    public void clickSocial(View view) {
        LottieAnimationView showSocial = (LottieAnimationView) view;
        if (!isFacebook && view.getId() == R.id.facebookLottieView) {
            showSocial.setMinAndMaxProgress(0, 0.5f);
            showSocial.playAnimation();
            isFacebook = true;
        } else if (isFacebook && view.getId() == R.id.facebookLottieView) {
            showSocial.setMinAndMaxProgress(0.5f, 1.0f);
            showSocial.playAnimation();
            isFacebook = false;
        } else if (!isInstagram && view.getId() == R.id.instagramLottieView) {
            showSocial.setMinAndMaxProgress(0f, 0.5f);
            showSocial.playAnimation();
            isInstagram = true;
        } else if (isInstagram && view.getId() == R.id.instagramLottieView) {
            showSocial.setMinAndMaxProgress(0.5f, 1.0f);
            showSocial.playAnimation();
            isInstagram = false;
        } else if (!isGmail && view.getId() == R.id.gmailLottieView) {
            showSocial.setMinAndMaxProgress(0f, 0.5f);
            showSocial.playAnimation();
            isGmail = true;
        } else if (isGmail && view.getId() == R.id.gmailLottieView) {
            showSocial.setMinAndMaxProgress(0.5f, 1.0f);
            showSocial.playAnimation();
            isGmail = false;
        }
    }
}