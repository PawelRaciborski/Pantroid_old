package com.wildeastcoders.pantroid.presenter;

import android.os.Bundle;

import com.wildeastcoders.pantroid.view.MainActivityView;

/**
 * Created by Majfrendmartin on 2016-11-11.
 */
public class MainActivityPresenterImpl extends AbstractPresenter<MainActivityView> implements MainActivityPresenter {
    @Override
    public void onManageTypesMenuOptionSelected() {
        if (isViewBounded()) {
            getView().navigateToManageTypesActivity();
        }
    }

    @Override
    public void onAddNewItemSelected() {
        if (isViewBounded()) {
            getView().navigateToNewItemActivity();
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onSaveInstanceState(final Bundle bundle) {

    }
}
