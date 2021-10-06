package com.example.instagram_clone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("8xP2qGCobVkpdE3VYbOVi02ySDgulDhXAOdoODsf")
                .clientKey("4TnJnGfLhDxCTa3d6v14FEgUEW4BPLyGZPcv6Thh")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}
