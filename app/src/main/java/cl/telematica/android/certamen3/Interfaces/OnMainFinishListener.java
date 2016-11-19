package cl.telematica.android.certamen3.Interfaces;


import java.util.List;

import cl.telematica.android.certamen3.Models.Feed;

public interface OnMainFinishListener {
    void succesful_conn();
    void get_succesful(List<Feed> lista);
}
