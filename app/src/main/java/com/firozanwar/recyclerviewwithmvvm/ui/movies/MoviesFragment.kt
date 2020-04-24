package com.firozanwar.recyclerviewwithmvvm.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.firozanwar.recyclerviewwithmvvm.R
import com.firozanwar.recyclerviewwithmvvm.data.model.Movie
import com.firozanwar.recyclerviewwithmvvm.data.network.MoviesApi
import com.firozanwar.recyclerviewwithmvvm.data.repository.MoviesRepository
import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment(),RecyclerViewListener {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val api: MoviesApi =
            MoviesApi()
        val repository =
            MoviesRepository(
                api
            )
        factory =
            MoviesViewModelFactory(
                repository
            )
        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recyclerview.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    MoviesAdapter(
                        movies,
                        this
                    )
            }

        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when(view.id){
            R.id.button_book -> {
                Toast.makeText(requireContext(),"Book button clicked",Toast.LENGTH_LONG).show()
            }
            R.id.layout_like -> {
                Toast.makeText(requireContext(),"Like button clicked",Toast.LENGTH_LONG).show()
            }
        }
    }

}
