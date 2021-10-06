package com.example.instagram_clone;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.security.Key;
@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String Key_USER = "user";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";

    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }
    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }
    public ParseUser getUser(){
        return getParseUser(Key_USER);
    }
    public void setUser(ParseUser user){
        put(Key_USER, user);
    }


}
