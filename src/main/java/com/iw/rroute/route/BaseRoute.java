package com.iw.rroute.route;

import androidx.fragment.app.FragmentManager;
import com.iw.rroute.Facet;
import com.iw.rroute.Route;

public final class BaseRoute implements Route {
    private final FragmentManager manager;
    private final int container;

    public BaseRoute(FragmentManager manager, int container) {
        this.manager = manager;
        this.container = container;
    }

    @Override
    public void forward(Facet facet) {
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .addToBackStack(facet.tag())
                .add(container, facet.fragment(), facet.tag())
                .commit();
    }

    @Override
    public void back() {
        manager.popBackStack();
    }

    @Override
    public void replace(Facet facet) {
        manager.popBackStack();
        manager.beginTransaction()
                .setReorderingAllowed(false)
                .replace(container, facet.fragment(), facet.tag())
                .commit();
    }
}
