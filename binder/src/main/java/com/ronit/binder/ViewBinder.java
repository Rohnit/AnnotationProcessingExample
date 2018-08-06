package com.ronit.binder;

import android.app.Activity;
import android.view.View;

import com.ronit.binder.lib.annotations.BindView;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author by Ronit on 2/8/18.
 */
public class ViewBinder {

    private ViewBinder() {
    }

    public static void bind(final Activity target){
        bindViews(target, target.getClass().getDeclaredFields(), target.getWindow().findViewById(android.R.id.content));
    }


    private static void bindViews(final Object obj, Field[] fields, View rootView){
        for (final Field field : fields){
            Annotation annotation = field.getAnnotation(BindView.class);
            if (annotation != null){
                BindView bindView = (BindView) annotation;
                int id = bindView.value();
                View view = rootView.findViewById(id);
                try {
                    field.setAccessible(true);
                    field.set(obj, view);
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
