package com.example.myapplication.ui;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.data.GetUserRepositoryImpl;
import com.example.myapplication.domain.GetUserRepository;
import com.example.myapplication.model.BeerModel;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends ViewModel {
    private GetUserRepository getUserRepository;
    private CompositeDisposable disposable = new CompositeDisposable();

    @ViewModelInject
    public MainViewModel(GetUserRepository getUserRepository) {
        this.getUserRepository = getUserRepository;
    }

    void getBeerList() {
        disposable.add(getUserRepository.getUser().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<BeerModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<BeerModel> beerModels) {
                        Log.d("debug555", beerModels.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("debug555-1", e.toString());
                    }
                }));
    }
}
