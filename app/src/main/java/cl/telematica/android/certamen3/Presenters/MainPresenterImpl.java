package cl.telematica.android.certamen3.Presenters;

import java.util.List;

import cl.telematica.android.certamen3.Interactors.MainInteractorImpl;
import cl.telematica.android.certamen3.Interfaces.MainInteractor;
import cl.telematica.android.certamen3.Interfaces.MainPresenter;
import cl.telematica.android.certamen3.Interfaces.MainView;
import cl.telematica.android.certamen3.Interfaces.OnMainFinishListener;
import cl.telematica.android.certamen3.Models.Feed;
import cl.telematica.android.certamen3.Views.Main;


public class MainPresenterImpl implements MainPresenter, OnMainFinishListener{

    private MainView view;
    private MainInteractor interactor;
    public MainPresenterImpl(MainView view){
        this.view = view;
        interactor = new MainInteractorImpl();

    }
    //del presenterinterface
    @Override
    public void Obtenerdatos() {
        if(view != null)
        {
            interactor.get_information(this);
        }
    }


    //del onlistener
    @Override
    public void succesful_conn() {
        if (view != null){
            view.conn_exitosa();
        }
    }

    @Override
    public void get_succesful(List<Feed> lista) {
        if (view != null){
            view.get_exitoso(lista);
        }
    }

}
