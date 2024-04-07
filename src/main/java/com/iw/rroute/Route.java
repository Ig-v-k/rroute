package com.iw.rroute;

public interface Route {
    void forward(final Facet facet);
    void back();
    void replace(final Facet facet);
}
