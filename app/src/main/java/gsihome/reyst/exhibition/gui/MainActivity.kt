package gsihome.reyst.exhibition.gui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import gsihome.reyst.exhibition.App
import gsihome.reyst.exhibition.R
import gsihome.reyst.exhibition.gui.adapter.ExhibitAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: ExhibitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ExhibitAdapter((application as App).imageLoader)

        val recyclerView: RecyclerView = findViewById(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.initData()

        subscribeViewModel()

    }

    private fun subscribeViewModel() {
        viewModel.getObservableExhibits().observe(this, Observer { data ->
            if (data != null) {
                adapter.setItems(data)
            }
        })
    }
}
