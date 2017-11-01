package com.example.pramod.samplemvp.main.di;

import com.example.pramod.samplemvp.di.PerActivity;
import com.example.pramod.samplemvp.di.component.AppComponent;
import com.example.pramod.samplemvp.main.ui.MainActivity;

import dagger.Component;

/**
 * Created by pramod on 12/10/17.
 */

@PerActivity
@Component(modules = MainModule.class, dependencies = {AppComponent.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
