package com.money.moneytracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.money.moneytracker.api.Api;

import java.io.IOException;
import java.util.List;

import static com.money.moneytracker.item.TYPE_UNKNOWN;

public class itemsFragment extends Fragment {

    private static final int LOADER_ITEMS = 0;

    private static final String KEY_TYPE = "TYPE";

    private String type = item.TYPE_UNKNOWN;

    private itemsAdapter adapter;
    private Api api;

    public static itemsFragment createItemsFragment(String type){
        itemsFragment fragment = new itemsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(itemsFragment.KEY_TYPE, type);

        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        type = getArguments().getString(KEY_TYPE, TYPE_UNKNOWN);

        if (type.equals(TYPE_UNKNOWN)){
            throw new IllegalStateException("Unknown Fragment Type");
        }

        adapter = new itemsAdapter();
        api = ((App) getActivity().getApplication()).getApi();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_items, container, false);
       return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
       //        recycler.setAdapter(new itemsAdapter());

        recycler.setAdapter(adapter);

        loaditems();
    }


    private void loaditems(){
        getLoaderManager().initLoader(LOADER_ITEMS, null, new LoaderManager.LoaderCallbacks<List<item>>() {
            @Override
            public Loader<List<item>> onCreateLoader(int id, Bundle args) {
                return new AsyncTaskLoader<List<item>>(getContext()) {
                    @Override
                    public List<item> loadInBackground() {
                        try {
                            List<item> items = api.items(type ).execute().body();
                            return items;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                };
            }

            @Override
            public void onLoadFinished(Loader<List<item>> loader, List<item> items) {
                if (items == null){
                    showError("Произошла ошибка");
                }else {
                    adapter.setItems(items);
                }
            }

            @Override
            public void onLoaderReset(Loader<List<item>> loader) {

            }
        }).forceLoad();
    }

    private void showError(String error){
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
///////////////////////////////////////////////////////////////////////////
//                              ASYNC TASK
///////////////////////////////////////////////////////////////////////////
//    private void loaditems(){
//
//        new AsyncTask<Void, Void, List<item>>(){
//
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//            }
//
//            @Override
//            protected List<item> doInBackground(Void... voids) {
//                try {
//                    List<item> items = api.items(type ).execute().body();
//                    return items;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return null;
//                }
//            }
//
//            @Override
//            protected void onPostExecute(List<item> items) {
//                super.onPostExecute(items);
//                adapter.setItems(items);
//            }
//        }.execute();
//
//    }

///////////////////////////////////////////////////////////////////////////
//                              THREAD AND HANDLER
///////////////////////////////////////////////////////////////////////////
//    private void loaditems(){
//
//        new LoadItemsTask(new Handler(Looper.getMainLooper()){
//            @Override
//            public void handleMessage(Message msg){
//                switch (msg.what){
//                    case ITEMS_LOADED:
//                        //noinspection unchecked
//                        adapter.setItems((List<item>) msg.obj);
//                        break;
//
//
//                    case ITEMS_ERROR:
//                        showError((String) msg.obj);
//                        break;
//                }
//            }
//        }).start();
//
//    }
//
//
//    private  static final int ITEMS_LOADED = 0;
//    private  static final int ITEMS_ERROR = 1;
//
//    private class LoadItemsTask implements  Runnable{
//
//        private Thread thread;
//        private Handler handler;
//
//
//        public LoadItemsTask(Handler handler) {
//            thread = new Thread(this);
//            this.handler = handler;
//        }
//
//        public void start(){
//            thread.start();
//        }
//
//        @Override
//        public void run() {
//            try {
//                List<item> items = api.items(type ).execute().body();
//                handler.obtainMessage(ITEMS_LOADED, items).sendToTarget();
//            } catch (Exception e) {
//                e.printStackTrace();
//                handler.obtainMessage(ITEMS_ERROR, e.getMessage()).sendToTarget();
//            }
//        }
//    }






}
