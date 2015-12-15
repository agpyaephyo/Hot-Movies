package net.aung.popularmovies.views.viewholders;

import android.databinding.DataBindingUtil;
import android.view.View;

import net.aung.popularmovies.R;
import net.aung.popularmovies.controllers.MovieItemController;
import net.aung.popularmovies.data.vos.MovieVO;
import net.aung.popularmovies.databinding.ViewItemMovieBinding;
import net.aung.popularmovies.views.pods.ViewPodMoviePopularity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by aung on 12/12/15.
 */
public class MovieViewHolder extends BaseViewHolder {

    private ViewItemMovieBinding binding;
    private MovieItemController controller;

    @Bind(R.id.vp_movie_popularity)
    ViewPodMoviePopularity vpMoviePopularity;

    public MovieViewHolder(View itemView, MovieItemController controller) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        binding = DataBindingUtil.bind(itemView);
        this.controller = controller;
    }

    public void bind(MovieVO movie) {
        binding.setMovie(movie);
        vpMoviePopularity.drawPopularityIcons(movie.getPopularity());
    }

    @Override
    public void onClick(View view) {
        controller.onNavigateToDetail(binding.getMovie());
    }
}
