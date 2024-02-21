//
//  ContentView.swift
//  MovieApp
//
//  Created by Bill Palmestedt on 2024-02-21.
//

import SwiftUI

struct ContentView: View {
    
    @State var title: String = "star wars"
    @State var description: String = "beskrivning"
    
    @ObservedObject var viewModel = MovieViewModel()
    
    var body: some View {
        VStack {
            TextField("skriv en titel", text: $title)
            Button("hämta film"){
                viewModel.fetchMovies(titel: title)
            }
            .padding()
            .background(.blue)
            .foregroundColor(.white)
            .cornerRadius(10)
            .padding()
            
            AsyncImage(url: URL(string: viewModel.imageUrl))
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text(viewModel.currentMovie?.title ?? "title")
                .fontWeight(/*@START_MENU_TOKEN@*/.bold/*@END_MENU_TOKEN@*/).padding()
            Text(viewModel.currentMovie?.overview ?? "")
            Spacer()
           
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
