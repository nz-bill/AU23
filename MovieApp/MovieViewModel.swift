//
//  MovieViewModel.swift
//  MovieApp
//
//  Created by Bill Palmestedt on 2024-02-21.
//

import Foundation

class MovieViewModel: ObservableObject{
    @Published var movies = [Movie]()
    @Published var currentMovie: Movie?
    @Published var imageUrl: String = ""
    var ImageBaseUrl = "https://image.tmdb.org/t/p/w200"
    
    func fetchMovies(titel: String){
        ApiService.shared.getMovie(query: titel) { result in
            switch result {
            case .success(let movies):
                DispatchQueue.main.async{
                    self.movies = movies
                    self.currentMovie = movies.first
                    self.imageUrl = self.ImageBaseUrl+(self.currentMovie?.poster_path ?? "")
                }
            
            case .failure(let error):
                print(error)
            
                
            }
        }
    }
}
